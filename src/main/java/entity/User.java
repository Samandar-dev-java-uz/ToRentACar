package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class User {
    private final  String id = UUID.randomUUID().toString();
    private String name ;
    private String surname;
    private String email;
    private String password;
    private Integer age;
    private Status statusUser;
    private List<Car> UsersCar;
    private Boolean isConfirm ;
    private  Confirm confirm;

}
