public interface Reservable {
    // Abstract methods by default
    boolean checkAvailability();
    void reserveSeat();
}