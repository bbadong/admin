package hrs;

import hrs.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AdminpageViewHandler {


    @Autowired
    private AdminpageRepository adminpageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                Adminpage adminpage = new Adminpage();
                // view 객체에 이벤트의 Value 를 set 함
                adminpage.setReservationId(reserved.getId());
                adminpage.setCustomerName(reserved.getCustomerName());
                adminpage.setStatus(reserved.getStatus());
                // view 레파지 토리에 save
                adminpageRepository.save(adminpage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationConfirmed_then_UPDATE_1(@Payload ReservationConfirmed reservationConfirmed) {
        try {
            if (reservationConfirmed.isMe()) {
                // view 객체 조회
                List<Adminpage> adminpageList = adminpageRepository.findByReservationId(reservationConfirmed.getReservationId());
                for(Adminpage adminpage : adminpageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    adminpage.setStatus(reservationConfirmed.getStatus());
                    // view 레파지 토리에 save
                    adminpageRepository.save(adminpage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}