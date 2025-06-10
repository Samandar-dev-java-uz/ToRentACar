package org.Icecream.work.service;

import org.Icecream.work.entity.BookingCar;
import org.Icecream.work.entity.Car;
import org.Icecream.work.entity.Status;

import java.util.Iterator;
import java.util.Objects;

import static org.Icecream.work.data.DataSource.*;

public class AdminService {

    public void service(){

        while(true) {
            System.out.println("""
                    0 exit
                    1 add car
                    2 show cars
                    3 mange car
                    4 show repository
                   """);

            switch (number()){

                case 0 ->{return;}
                case 1 -> addCar();
                case 2 -> showCar();
                case 3 -> mageCar();
                case 4 -> ShowRepository();
            }
        }
    }

    private void ShowRepository() {
        showCar();
        System.out.println(" enter id  select car ");
        String carId = scannerStr.nextLine();
        for (Car car : cars) {
            if (Objects.equals(car.getCarId(), carId)) {
                System.out.println(car.getCount());
            }
        }
    }

    private void mageCar() {
        while(true){
            System.out.println("""
                    0 exit
                    1 edit car
                    2 delete car
                    """);
            switch (number()){
                case 0 -> {
                    return;
                }
                case 1 -> {
                    editCar();

                }
                case 2 ->{
                    deleteCar();
                }
            }

        }
    }

    private void deleteCar() {
        showCar();
        System.out.println(" enter id  select car ");
        String carId  = scannerStr.nextLine();
        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()){
            Car car = iterator.next();
            if (Objects.equals(car.getCarId(),carId)){
                iterator.remove();
                System.out.println( "  can remove ");
            }
        }
        System.out.println(" not found car ");

    }

    private void editCar() {
        showCar();
        System.out.println(" enter id  select car ");
        String carId  = scannerStr.nextLine();
        for (Car car : cars) {
            if (Objects.equals(car.getCarId(),carId)){

                System.out.println(" enter car name ");
                car.setName(scannerStr.nextLine());
                System.out.println(" enter car year");
                car.setYear(scannerStr.nextLine());
                System.out.println(" enter one day  price ");
                car.setPrice(scannerInt.nextInt());
                car.setCarStatus(Status.ACTIVE);
                return;

            }

        }
        System.out.println(" not fount car ");
    }

    private void MageCar() {

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
