public abstract class TravelService {
    
    private String serviceId;
    private String destination;

    
    public TravelService(String serviceId, String destination) {
        this.serviceId = serviceId;
        this.destination = destination;
    }

    
    public String getServiceId() { 
        return serviceId; 
    }
    
    public String getDestination() { 
        return destination; 
    }

    
    public abstract void showServiceInfo();
}