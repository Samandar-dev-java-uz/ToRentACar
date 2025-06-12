package service;

import entity.Car;

import java.util.Optional;

import static data.DataSource.cars;
import static data.DataSource.number;

public class UserService {
    public void service(){
        while(true){
            System.out.println("""
                    0 exit
                    1 show cars
                    2 rental car
                    3 history
                    """);
            switch (number()){
                case 0 ->{return;}
                case 1 ->ShowCar();
            }
        }
    }

    private void ShowCar() {
        Optional.ofNullable(cars)
                .filter(list -> !list.isEmpty())
                .ifPresentOrElse(
                        list ->list.stream()
                                .forEach(System.out::println),
                        () -> System.out.println("🚫 Car list is empty or null")


                );
    }


}
