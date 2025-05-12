package model;

import exception.EntityAlreadyExistsException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Consultant extends Employee {
    private final Set<Employee> subordinates;

    public Consultant(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        super(id, name, birthDate, soldValue, consultantInCharge);
        subordinates = new LinkedHashSet<>();
    }

    @Override
    public double getCommission() {
        return subordinates.stream()
                .mapToDouble(Employee::getCommission)
                .map(value -> value * 0.3)
                .reduce(getSoldValue() * 0.15, Double::sum);
    }

    public void addEmployee(Employee employee) {
        subordinates.removeIf(e -> e.getId().equals(employee.getId()));
        subordinates.add(employee);
    }

    public Set<Employee> getSubordinates() {
        return new HashSet<>();
    }

}
