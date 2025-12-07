package singleton;

public enum PriorityLevel {
    INFORMATION(1),
    WARNING(2),
    ERROR(3);

    private final int value;

    PriorityLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
