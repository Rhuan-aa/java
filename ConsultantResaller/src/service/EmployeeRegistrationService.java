package service;

import model.Consultant;
import model.Employee;
import model.Reseller;
import persistence.EmployeeRepository;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private final EmployeeRepository repo;

    public EmployeeRegistrationService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public void register(String id, String name, LocalDate birthDate, double soldValue, String inCharge){
        Employee maybeInCharge = repo.findById(inCharge).orElse(null);

        if (maybeInCharge == null) {
            repo.save(new Reseller(id, name, birthDate, soldValue, null));
            return;
        }

        Consultant consultant = maybeInCharge instanceof Reseller
                ? ((Reseller) maybeInCharge).promote()
                : (Consultant) maybeInCharge;

        final Reseller newEmployee = new Reseller(id, name, birthDate, soldValue, consultant);
        consultant.addEmployee(newEmployee);

        repo.update(consultant);
        repo.save(newEmployee);
    }
}
