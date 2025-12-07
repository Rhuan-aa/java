package singleton;

public class MyLog {
    private static PriorityLevel lastMessagePriorityLevel = PriorityLevel.INFORMATION;

    private MyLog(){}

    public static void log(String message, PriorityLevel priorityLevel) {
        if (priorityLevel.getValue() >= lastMessagePriorityLevel.getValue()){
            System.out.println(message);
            lastMessagePriorityLevel = priorityLevel;
        }
    }

}
