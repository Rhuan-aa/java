import java.time.LocalTime;

public class ReservationIdGenerator {
    private static int numZ = 10_000;

    private ReservationIdGenerator() {
    }

    public static String generateId(){
        StringBuilder id = new StringBuilder();
        final LocalTime now = LocalTime.now();

        id.append("HT")
                .append(now.getSecond() + "-")
                .append(now.getMinute() + "-")
                .append(numZ++);

        return id.toString();
    }
}
