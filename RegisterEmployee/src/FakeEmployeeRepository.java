
public class FakeEmployeeRepository implements Repository<String, Employee> {
    private Employee[] employees = new Employee[10];
    private int size = 0;

    @Override
    public void save(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        }
    }

    @Override
    public Employee findById(String id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
}
