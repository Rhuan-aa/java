package service;

import model.Consultant;
import model.Employee;
import model.Reseller;
import persistence.EmployeeRepository;

import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeReportService {
    private final EmployeeRepository employeeRepository;

    public EmployeeReportService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String reportOf(String id) {
        final Optional<Employee> optionalRoot = employeeRepository.findById(id);

        if (optionalRoot.isEmpty()) return "Report is full of Emptiness";

        final Employee rootEmployee = optionalRoot.get();
        final StringBuilder builder = new StringBuilder(rootEmployee.toString());

        if (rootEmployee instanceof Consultant) {
            ((Consultant) rootEmployee).getEmployees().forEach(e -> buildString(e, builder, 1));
        }

        return builder.toString();
    }

    private void buildString(Employee employee, StringBuilder builder, int level){
        builder.append("\n").append("\t".repeat(level));

        builder.append(employee.toString());

        if (employee instanceof Consultant) {
            ((Consultant) employee).getEmployees().forEach(e -> buildString(e, builder, level + 1));
        }
    }
}

