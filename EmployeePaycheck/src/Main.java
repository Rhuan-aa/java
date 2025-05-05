import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var ada = new Employee("Ada Lovelace", "Computer Programmer", 10_000.0,
                LocalDate.of(2012, 3, 15));
        var alan = new Employee("Alan Turing", "Math Specialist", 20_000.0,
                LocalDate.of(2016, 7, 4));
        var charles = new Employee("Charles Babbage", "Math Specialist", 21_000.0,
                LocalDate.of(2011, 11, 21));
        var john = new Employee("John von Neumann", "Computer Programmer", 100_000.0,
                LocalDate.of(2019, 2, 9));
        var hopper = new Employee("Grace Hopper", "Computer Programmer", 14_000.0,
                LocalDate.of(2014, 6, 30));

        final Iterator<Paycheck> paycheckIterator = ada.iteratorPaychecks();
        while (paycheckIterator.hasNext()) {
            final Paycheck paycheck = paycheckIterator.next();
            System.out.println(paycheck.getPayday() + " " + paycheck.getSalary());
        }

        Company company = new Company();

        company.hire(ada);
        company.hire(alan);
        company.hire(charles);
        company.hire(john);
        company.hire(hopper);

        List<Employee> employeeList = company.getEmployees();
        List<Employee> employeeMSList = company.getEmployees("Math Specialist");

        for (Employee employee : employeeList) System.out.println(employee.getName());
        for (Employee employee : employeeMSList) System.out.println(employee.getName());

        System.out.println(company.averageSalary("Math Specialist"));
    }
}