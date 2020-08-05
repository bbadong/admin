package hrs.external;

public class Reservation {

    private Long id;
    //private Long reservationId;
    private String customerName;
    private Integer nights;
    private String checkinDate;
    private String status;
    private String hotelId;
    private Float price;
    private String updateGubun;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    //public Long getReservationId() { return reservationId; }
    //public void setReservationId(Long reservationId) {
    //    this.reservationId = reservationId;
    //}
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Integer getNights() {
        return nights;
    }
    public void setNights(Integer nights) {
        this.nights = nights;
    }
    public String getCheckinDate() {
        return checkinDate;
    }
    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getHotelId() {
        return hotelId;
    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getUpdateGubun() {
        return updateGubun;
    }
    public void setUpdateGubun(String updateGubun) {
        this.updateGubun = updateGubun;
    }

}
