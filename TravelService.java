public abstract class TravelService {
    private String serviceId;
    private String destination;

    public TravelService(String serviceId, String destination) throws Exception {
        setServiceId(serviceId);
        setDestination(destination);
    }

    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) throws Exception {
        InputValidator.checkNotEmpty(serviceId, "Service ID");
        this.serviceId = serviceId;
    }
    
    public String getDestination() { return destination; }
    public void setDestination(String destination) throws Exception {
        InputValidator.checkNotEmpty(destination, "Destination");
        this.destination = destination;
    }

    public abstract void showServiceInfo();
}