import java.time.*;
import java.util.ArrayList;

public class Schedule {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;
    private ArrayList<Meeting> meetings = new ArrayList<>(24);

    public Schedule(String day, String startTime, String endTime) {
        this.day = LocalDate.parse(day);
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
    }

    public void addMeeting(Meeting meeting){
        if (isOutsideWorkingTime(meeting)) return;
        if (isMeetingOverlapping(meeting)) return;

        meetings.add(meeting);
    }

    private boolean isMeetingOverlapping(Meeting meeting) {
        for (Meeting meet : meetings){
            if ((meeting.getStartTime().isBefore(meet.getEndTime()) && meeting.getEndTime().isAfter(meet.getStartTime()))
                    || meeting.getStartTime().equals(meet.getStartTime())
                    || meeting.getEndTime().equals(meet.getEndTime())) {
                return true;
            }
        }
        return false;
    }

    private boolean isOutsideWorkingTime(Meeting meeting) {
        return !meeting.getStartTime().isBefore(startTime) && !meeting.getEndTime().isAfter(endTime);
    }

    public void removeMeeting(Meeting meeting){
        if (!meetings.isEmpty()) meetings.remove(meeting);
    }

    public double percentageSpentInMeetings(){
        if (!meetings.isEmpty()){
            long meetingsTime = 0L;
            long totalTimeInMinutes = Duration.ofDays(1).toMinutes();

            for (Meeting meet : meetings) {
                meetingsTime += meet.durationInMinutes();
            }

            return (double) (meetingsTime * 100) / totalTimeInMinutes;
        }

        return 0;
    }

    public String scheduleAsString(){
        StringBuilder schedule = new StringBuilder();

        schedule.append(String.format("Horário de Funcionamento das %s às %s\n", startTime, endTime));

        for (Meeting meet : meetings){
            schedule.append(String.format("%s\n", meet.getDescription()));
        }

        return schedule.toString();
    }

    public LocalDate getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}