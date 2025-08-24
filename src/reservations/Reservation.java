package reservations;

public interface Reservation {
    void showDetails();
    void reserve();
    void extraServiceCharge(float charge, String description);
    void setClientName(String clientName);
    void setClientDui(String clientDui);
    void setState(String state);
    void setDate(String date);
    void setPrice(double price);
    void addExtraService(String extraService);

    double getPrice();
}
