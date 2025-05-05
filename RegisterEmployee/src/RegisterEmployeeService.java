public class RegisterEmployeeService {
    private final Repository<String, Employee> repository;

    public RegisterEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void register(Employee employee) {
        if (repository.findById(employee.getId()) != null) {
            System.out.println("Employee already exists");
            return;
        }

        repository.save(employee);
        System.out.println("Employee registered successfully");
    }
}
