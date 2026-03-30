/**
 * Interface applied to travel services that require capacity management.
 */
public interface Reservable {
    boolean checkAvailability();
    void reserveSeat();
}