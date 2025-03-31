import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private final String id;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final Guest guest;
    private final Room room;

    public Reservation(LocalDate checkin, LocalDate checkout, Guest guest, Room room) {
        this.checkIn = checkin;
        this.checkOut = checkout;
        this.guest = guest;
        this.room = room;
        this.id = ReservationIdGenerator.generateId();
    }

    public double getPrice() {
        return room.getPrice() * getDays();
    }

    public String getId() {
        return id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public String getGuest() {
        return guest.getName();
    }

    public int getRoom() {
        return room.getNumber();
    }

    public int getDays() {
        return (Period.between(checkIn, checkOut)).getDays();
    }

    public boolean isReservedAt(LocalDate date, Room room) {
        if (room.getNumber() != this.room.getNumber()) return false;
        return !date.isBefore(checkIn) && date.isBefore(checkOut);
    }

    public String asString() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
                """
                        _______________________________________________________________
                        Reservation: %s Room number: %d
                        Guest name: %s SSN: %s E-mail: %s
                        Check-in: %s Check-out: %s
                        Number of days: %d Room price: U$%.2f
                        TOTAL: U$%.2f;
                        _______________________________________________________________
                       \s
               \s""", getId(), room.getNumber(),guest.getName(),guest.getSsn(),guest.getEmail(),
                formatter.format(getCheckIn()),formatter.format(getCheckOut()),getDays(),room.getPrice(),getPrice()
        );
    }
}
