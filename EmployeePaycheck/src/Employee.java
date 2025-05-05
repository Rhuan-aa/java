import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Employee {
    private final UUID id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;
    private final List<Paycheck> paychecks = new ArrayList<>();

    public Employee(String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public UUID getId() {
        return id;
    }

    public List<Paycheck> getPaychecks() {
        return paychecks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getYearsOfService(){
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    public void addPaycheck(LocalDate payday) {
        paychecks.add(new Paycheck(payday, salary));
    }

    public void removePaycheck(Paycheck paycheck) {
        paychecks.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaychecks() {
        return paychecks.iterator();
    }
}
