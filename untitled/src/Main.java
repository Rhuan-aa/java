public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule("2016-06-12", "07:00", "18:00");
        Meeting meeting1 = new Meeting("AAAAAAAAAAAA", "07:00", "10:00");
        Meeting meeting2 = new Meeting("BBBBBBBBBBBB", "09:00", "11:00");
        Meeting meeting3 = new Meeting("CCCCCCCCCCCC", "11:00", "18:00");

        schedule.addMeeting(meeting1);
        schedule.addMeeting(meeting2);
        schedule.addMeeting(meeting3);
        schedule.removeMeeting(meeting3);

        System.out.println(schedule.scheduleAsString());
    }
}