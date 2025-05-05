import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Repository<String, Employee> repo = new FakeEmployeeRepository();

        RegisterEmployeeService registerService = new RegisterEmployeeService(repo);
        FindEmployeeService findService = new FindEmployeeService(repo);

        Employee emp1 = new Employee("001", "Maria", "Developer", 8000.00, LocalDate.parse("2018-01-10"));
        Employee emp2 = new Employee("002", "João", "Manager", 12000.00, LocalDate.parse("2015-03-05"));

        registerService.register(emp1);
        registerService.register(emp2);
        registerService.register(emp1); // Tenta registrar de novo (não deve deixar)

        Employee found = findService.findById("001");
        if (found != null) {
            System.out.println("Employee found: " + found.getYearsOfService() + " years of service.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
