package hrs;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Admin_table")
public class Admin {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reservationId;
    private String ststus;

    @PostPersist
    public void onPostPersist(){
        ForcedCanceled forcedCanceled = new ForcedCanceled();
        BeanUtils.copyProperties(this, forcedCanceled);
        forcedCanceled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        hrs.external.Reservation reservation = new hrs.external.Reservation();
        // mappings goes here
        reservation.setId(forcedCanceled.getReservationId());
        reservation.setUpdateGubun("delete");


        AdminApplication.applicationContext.getBean(hrs.external.ReservationService.class)
            .reservation(reservation);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public String getStstus() {
        return ststus;
    }

    public void setStstus(String ststus) {
        this.ststus = ststus;
    }




}
