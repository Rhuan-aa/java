import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    public long durationInMinutes(){
        if (startTime == null ||  endTime == null) return 0;
        return (long) Duration.between(startTime, endTime).toMinutes();
    }

    public Meeting(String description, String startTime, String endTime) {
        this.description = description;
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }
}
