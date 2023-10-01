package com.attilapalfi.mdschedule.mdschedulebackend.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class ShiftDistributor {

    private final Set<Doctor> doctors;
    private final TreeMap<Integer, Set<Doctor>> busyDoctorMap = new TreeMap<>();
    private final Map<Integer, Doctor> workdayOnClinic1 = new HashMap<>();
    private final Map<Integer, Doctor> workdayOnClinic2 = new HashMap<>();
    private final Map<Integer, Doctor> workdayOnClinic3 = new HashMap<>();
    private final Map<Integer, Doctor> dayShiftOnWard = new HashMap<>();
    private final Map<Integer, Doctor> nightShiftOnWard = new HashMap<>();

    // rest of the doctors go here
    private final Map<Integer, Doctor> workdayOnWard = new HashMap<>();

    private final List<DayInHospital> daysInHospital = new ArrayList<>();

    public ShiftDistributor(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void calculateShifts(YearMonth month) {
        int days = month.lengthOfMonth();
        int year = month.getYear();
        for (int day = 1; day < days; day++) {
            DayInHospital dayInHospital = new DayInHospital();
            LocalDate date = LocalDate.of(year, month.getMonth(), day);
            dayInHospital.day = day;
            dayInHospital.dayName = date.getDayOfWeek();
            Doctor doctor;
            if (date.getDayOfWeek() != SATURDAY && date.getDayOfWeek() != SUNDAY) {
                doctor = initDoctorForDayShiftOnClinic(day);
                workdayOnClinic1.put(day, doctor);
                dayInHospital.workdayOnClinic1 = doctor;

                doctor = initDoctorForDayShiftOnClinic(day);
                workdayOnClinic2.put(day, doctor);
                dayInHospital.workdayOnClinic2 = doctor;

                doctor = initDoctorForDayShiftOnClinic(day);
                workdayOnClinic3.put(day, doctor);
                dayInHospital.workdayOnClinic3 = doctor;

                doctor = initDoctorWorkdayOnWard(day);
                workdayOnWard.put(day, doctor);
                dayInHospital.workdayOnWard.add(doctor);
            }

            doctor = initDoctorForDayShiftOnWard(day);
            dayShiftOnWard.put(day, doctor);
            dayInHospital.dayShiftOnWard = doctor;

            doctor = initDoctorForNightShiftOnWard(day);
            nightShiftOnWard.put(day, doctor);
            dayInHospital.nightShiftOnWard = doctor;
            daysInHospital.add(dayInHospital);
        }
    }

    private Doctor initDoctorForDayShiftOnClinic(int day) {
        final Set<Doctor> busyDoctors = busyDoctorMap.getOrDefault(day, new HashSet<>());
        Optional<Doctor> optionalDoctor = doctors.stream()
                .filter(d -> !busyDoctors.contains(d))
                .filter(d -> !d.isResident)
                .filter(d -> !d.offDays.contains(day))
                .filter(d -> d.shiftHours >= 8)
                .min(Comparator.comparingInt(o -> o.shiftHours));
        Doctor doctor = optionalDoctor.orElseThrow(() -> {
            throw new IllegalStateException("No available doctor for Day Shift On Clinic.");
        });
        updateShiftHoursAndMarkBusyForTheDay(doctor, 8, busyDoctors, day);
        return doctor;
    }

    private Doctor initDoctorForDayShiftOnWard(int day) {
        final Set<Doctor> busyDoctors = busyDoctorMap.getOrDefault(day, new HashSet<>());
        Optional<Doctor> optionalDoctor = doctors.stream()
                .filter(d -> !busyDoctors.contains(d))
                .filter(d -> !d.offDays.contains(day))
                .filter(d -> d.shiftHours >= 12)
                .max((o1, o2) -> Boolean.compare(o1.isResident, o2.isResident));
        Doctor doctor = optionalDoctor.orElseThrow(() -> {
            throw new IllegalStateException("No available doctor for 12-hour Shift On Ward.");
        });
        updateShiftHoursAndMarkBusyForTheDay(doctor, 12, busyDoctors, day);
        return doctor;
    }

    private Doctor initDoctorForNightShiftOnWard(int day) {
        Doctor doctor = initDoctorForDayShiftOnWard(day);
        Set<Doctor> busyDoctors = busyDoctorMap.getOrDefault(day + 1, new HashSet<>());
        busyDoctors.add(doctor);
        busyDoctorMap.put(day + 1, busyDoctors);
        return doctor;
    }

    private Doctor initDoctorWorkdayOnWard(int day) {
        final Set<Doctor> busyDoctors = busyDoctorMap.getOrDefault(day, new HashSet<>());
        Optional<Doctor> optionalDoctor = doctors.stream()
                .filter(d -> !busyDoctors.contains(d))
                .filter(d -> !d.offDays.contains(day))
                .filter(d -> d.shiftHours >= 8)
                .min(Comparator.comparingInt(o -> o.shiftHours));
        Doctor doctor = optionalDoctor.orElseThrow(() -> {
            throw new IllegalStateException("No available doctor for Day Shift On Clinic.");
        });
        updateShiftHoursAndMarkBusyForTheDay(doctor, 8, busyDoctors, day);
        return doctor;
    }

    private void updateShiftHoursAndMarkBusyForTheDay(Doctor doctor, int shiftHours, Set<Doctor> busyDoctors, int day) {
        doctor.shiftHours -= shiftHours;
        updateDoctorsSet(doctor);
        busyDoctors.add(doctor);
        busyDoctorMap.put(day, busyDoctors);
    }

    private void updateDoctorsSet(Doctor doctor) {
        doctors.remove(doctor);
        doctors.add(doctor);
    }

    public Doctor getDoctorForWorkdayOnClinic1(int day) {
        return workdayOnClinic1.get(day);
    }

    public Doctor getDoctorForWorkdayOnClinic2(int day) {
        return workdayOnClinic2.get(day);
    }

    public Doctor getDoctorForWorkdayOnClinic3(int day) {
        return workdayOnClinic3.get(day);
    }

    public Doctor getDoctorForWorkdayOnWard(int day) {
        return workdayOnWard.get(day);
    }

    public Doctor getDoctorForDayShiftOnWard(int day) {
        return dayShiftOnWard.get(day);
    }

    public Doctor getDoctorForNightShiftOnWard(int day) {
        return nightShiftOnWard.get(day);
    }

    public List<DayInHospital> getDaysInHospital() {
        return daysInHospital;
    }

    public static class Doctor {
        final String name;
        final boolean isResident;
        final Set<Integer> offDays;
        int shiftHours = 160;

        public Doctor(String name, boolean isResident, Set<Integer> offDays) {
            this.name = name;
            this.isResident = isResident;
            this.offDays = offDays;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Doctor doctor = (Doctor) o;
            return isResident == doctor.isResident && name.equals(doctor.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, isResident);
        }

        @Override
        public String toString() {
            return "Doctor{" +
                    "name='" + name + '\'' +
                    ", isResident=" + isResident +
                    ", offDays=" + Arrays.toString(offDays.toArray()) +
                    ", shiftHours=" + shiftHours +
                    '}';
        }
    }

    static class DayInHospital {
        public int day;
        public DayOfWeek dayName;
        public Doctor workdayOnClinic1;
        public Doctor workdayOnClinic2;
        public Doctor workdayOnClinic3;
        public Doctor dayShiftOnWard;
        public Doctor nightShiftOnWard;
        public final Set<Doctor> workdayOnWard = new HashSet<>();

        @Override
        public String toString() {
            return "DayInHospital{" +
                    "day=" + day +
                    ", dayName=" + dayName +
                    ", workdayOnClinic1=" + workdayOnClinic1 +
                    ", workdayOnClinic2=" + workdayOnClinic2 +
                    ", workdayOnClinic3=" + workdayOnClinic3 +
                    ", dayShiftOnWard=" + dayShiftOnWard +
                    ", nightShiftOnWard=" + nightShiftOnWard +
                    ", workdayOnWard=" + Arrays.toString(workdayOnWard.toArray()) +
                    "}\n";
        }
    }
}
