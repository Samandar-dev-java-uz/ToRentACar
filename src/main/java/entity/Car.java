package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private final String carId = UUID.randomUUID().toString();
    private String name;
    private String year;
    private Integer price;
    private Status carStatus;

}