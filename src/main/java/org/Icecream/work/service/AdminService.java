package org.Icecream.work.service;

import org.Icecream.work.entity.BookingCar;
import org.Icecream.work.entity.Car;
import org.Icecream.work.entity.Status;

import static org.Icecream.work.data.DataSource.*;

public class AdminService {

    public void service(){

        while(true) {
            System.out.println("""
                    0 exit
                    1 add car
                    2 show cars
                    3 mange car
                    4 show report
                   """);

            switch (number()){

                case 0 ->{return;}
                case 1 -> addCar();
                case 2 -> showCar();
                case 3 -> MageCar();
                case 4 ->{return;}
            }
        }
    }

    private void MageCar() {
        for (BookingCar bookingCar : bookingCars) {
            System.out.println(bookingCar );
        }
    }

    private void showCar() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private void addCar() {
        Car car = new Car();
        System.out.println(" enter car name ");
        car.setName(scannerStr.nextLine());
        System.out.println(" enter car year");
        car.setYear(scannerStr.nextLine());
        System.out.println(" enter one day  price ");
        car.setPrice(scannerInt.nextInt());
        car.setCarStatus(Status.ACTIVE);
        cars.add(car);
    }

}
