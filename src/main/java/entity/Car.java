package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Car {
    private final String carId = UUID.randomUUID().toString();
    private String brand;
    private String year;
    private Integer priceDay;
    private Status carStatus;
    private String color;


}