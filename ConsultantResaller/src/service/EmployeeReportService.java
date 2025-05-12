package service;

import model.Consultant;
import model.Employee;
import persistence.EmployeeRepository;

import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeReportService {
    private final EmployeeRepository repo;

    public EmployeeReportService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public String reportOf(String id) {
        final Optional<Employee> optionalRoot = repo.findById(id);

        if (optionalRoot.isEmpty()) return "Report is full of Emptiness";

        final Employee rootEmployee = optionalRoot.get();
        final StringBuilder builder = new StringBuilder(rootEmployee.toString());

        if (rootEmployee instanceof Consultant) {
            ((Consultant) rootEmployee).getSubordinates().forEach(e -> buildString(e, builder, 1));
        }

        return builder.toString();
    }

    private void buildString(Employee employee, StringBuilder builder, int level) {
        builder.append("\n").append("\t".repeat(level));

        builder.append(employee.toString());

        if (employee instanceof Consultant) {
            ((Consultant) employee).getSubordinates().forEach(e -> buildString(e, builder, level + 1));
        }
    }
}
