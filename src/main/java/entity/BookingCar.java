package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookingCar {
    private  String  CarName;
    private final String BokingId = UUID.randomUUID().toString();
    private  String CarId;
    private LocalDate Bigin;
    private LocalDate End;
    private String Numberi;
    private Integer Summa;
    private String  UserName;
    private Integer UserAge;
    private  String Email;


}
