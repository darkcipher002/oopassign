public abstract class TravelService {
    // Encapsulation: Private attributes
    private String serviceId;
    private String destination;

    // Constructor with parameters using 'this'
    public TravelService(String serviceId, String destination) {
        this.serviceId = serviceId;
        this.destination = destination;
    }

    // Getters
    public String getServiceId() { 
        return serviceId; 
    }
    
    public String getDestination() { 
        return destination; 
    }

    // Abstract method
    public abstract void showServiceInfo();
}