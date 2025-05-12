package persistence;

import exception.EntityAlreadyExistsException;
import model.Consultant;
import model.Employee;

import java.util.*;

public class InMemoryEmployeeRepository implements EmployeeRepository{
    private final Map<String, Employee> db = new LinkedHashMap<>();


    @Override
    public void save(Employee employee) {
        if(db.containsKey(employee.getId()))
            throw new EntityAlreadyExistsException("Entity with id is already registered: " + employee.getId());
        db.put(employee.getId(), employee);
    }

    @Override
    public void update(Employee employee) {
        if (db.replace(employee.getId(), employee) == null)
            throw new NoSuchElementException("Entity not found: " + employee.getId());
    }

    @Override
    public Optional<Employee> findById(String id) {
        Collection<Employee> children = db.values().stream()
                .filter(e -> Objects.nonNull(e.getConsultantInCharge()))
                .filter(e -> e.getConsultantInCharge().getId().equals(id))
                .toList();
        final Employee employee = db.get(id);

        if (children.isEmpty()) return Optional.ofNullable(employee);

        final Consultant consultant = (Consultant) employee;
        children.forEach(e -> consultant.addEmployee(findById(e.getId()).orElseThrow()));

        return Optional.ofNullable(consultant);
    }
}
