package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Rental {
    private final String rentalId = UUID.randomUUID().toString();
    private Car car;
    private User user;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private LocalDate actualReturnDate;
    private Integer summa;

}
