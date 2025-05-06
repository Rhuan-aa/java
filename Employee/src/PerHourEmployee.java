import java.time.LocalDate;
import java.util.UUID;

public final class PerHourEmployee extends Employee {
    private double hourlyRate;
    private int workedHour;

    public PerHourEmployee(UUID id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, 
                           int workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getWorkedHour() {
        return workedHour;
    }

    public void setWorkedHour(int workedHour) {
        this.workedHour = workedHour;
    }

    @Override
    public double salary() {
        return hourlyRate * workedHour;
    }
}
