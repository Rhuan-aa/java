package model;

import java.time.LocalDate;
import java.util.Objects;

public sealed abstract class Employee permits Consultant, Reseller {
    protected String id;
    protected String name;
    protected LocalDate birthDate;
    protected double soldValue;
    protected Consultant consultantInCharge;

    public Employee(String id, String name, LocalDate birthDate, double soldValue, Consultant consultantInCharge) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
        this.consultantInCharge = consultantInCharge;
    }

    public abstract double getCommission();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("""
                [%s] %s | Birthday: %s | Amount in sales: US$%.2f | Commission: US$%.2f
                """, id, name, birthDate, soldValue, getCommission());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getSoldValue() {
        return soldValue;
    }

    public void setSoldValue(double soldValue) {
        this.soldValue = soldValue;
    }

    public Consultant getConsultantInCharge() {
        return consultantInCharge;
    }

    public void setConsultantInCharge(Consultant consultantInCharge) {
        this.consultantInCharge = consultantInCharge;
    }
}
