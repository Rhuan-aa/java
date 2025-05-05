import Exceptions.EntityAlreadyExistsException;

import java.time.LocalDate;
import java.util.*;

public class Company {
    private final Map<UUID, Employee> employees = new LinkedHashMap<>();

    public void hire(Employee employee){
        Objects.requireNonNull(employee, "Employee cannot be null");
        if (employees.containsKey(employee.getId()))
            throw new EntityAlreadyExistsException("Employee is already hired.");
        employees.put(employee.getId(), employee);
    }

    public void fire(UUID id){
        Objects.requireNonNull(id, "ID cannot be null");
        if (!employees.containsKey(id)) throw new NoSuchElementException("Employee isn't hired");
        employees.remove(id);
    }

    public List<Employee> getEmployees(){
        return new ArrayList<>(employees.values());
    }

    public List<Employee> getEmployees(String jobTitle){
        Objects.requireNonNull(jobTitle, "Job title cannot be null");
        return employees.values()
                .stream()
                .filter(e -> jobTitle.equals(e.getJobTitle()))
                .toList();
    }

    public void pay(UUID id){
        Employee employee = employees.get(id);
        if (employee == null) throw new NoSuchElementException("Employee isn't hired");
        employee.addPaycheck(LocalDate.now());
    }

    public void increaseSalary(UUID id, double newSalary) {
        Employee employee = employees.get(id);
        if (employee == null) throw new NoSuchElementException("Employee isn't hired");
        if (newSalary <= employee.getSalary()) throw new IllegalArgumentException("Salary must be greater than zero");

        employee.setSalary(newSalary);
    }

    public OptionalDouble averageSalary(String jobTitle) {
        Objects.requireNonNull(jobTitle, "Job title cannot be null");

        double[] salaries = getEmployees(jobTitle)
                .stream()
                .mapToDouble(Employee::getSalary)
                .toArray();

        if (salaries.length == 0) return OptionalDouble.empty();
        return OptionalDouble.of(SalaryUtils.averageSalary(salaries));
    }

    private boolean isBetween(LocalDate date, LocalDate start, LocalDate end){
        return  !date.isBefore(start) && !date.isAfter(end);
    }

    public OptionalDouble averageSalary(LocalDate initialDate, LocalDate finalDate) {
        Objects.requireNonNull(initialDate, "Initial date cannot be null");
        Objects.requireNonNull(finalDate, "Final date cannot be null");

        double[] salaries = getEmployees()
                .stream()
                .filter(e -> isBetween(e.getDateOfEmployment(), initialDate, finalDate))
                .mapToDouble(Employee::getSalary)
                .toArray();

        if (salaries.length == 0) return OptionalDouble.empty();
        return OptionalDouble.of(SalaryUtils.averageSalary(salaries));
    }
}
