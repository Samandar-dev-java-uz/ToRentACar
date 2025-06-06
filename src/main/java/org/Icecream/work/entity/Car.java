package org.Icecream.work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private String name;
    private String  year;
    private  Integer price;
    private Status carStatus;
    private LocalDate beginDate;
    private LocalDate endDate;
}
