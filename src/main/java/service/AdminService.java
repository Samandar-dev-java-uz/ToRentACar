package service;

import entity.Car;
import entity.Status;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static data.DataSource.*;

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
        cars.stream()
                .forEach(car ->{
                    System.out.println(car);
                });
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
                return;
            }
        }
        System.out.println(" not found car ");

    }

    private void editCar() {
        showCar();
        System.out.println(" enter id  select car ");
        String carId  = scannerStr.nextLine();

        Optional<Car> CarEdit = cars.stream()
                .filter(car ->Objects.equals(carId,car.getCarId()))
                .findFirst();

        CarEdit.ifPresentOrElse(car ->{

            System.out.println("Enter car name: ");
            car.setBrand(scannerStr.nextLine());

            System.out.println("Enter car year: ");
            car.setYear(String.valueOf(scannerInt.nextInt()));
            scannerStr.nextLine(); // buffer clean

            System.out.println("Enter one day price: ");
            car.setPriceDay((int) scannerInt.nextDouble());
            scannerInt.nextLine(); // buffer clean

            System.out.println("Enter car color: ");
            car.setColor(scannerStr.nextLine());

            car.setCarStatus(Status.ACTIVE);

            System.out.println("✅ Car updated successfully.");
        }, () -> {
            System.out.println("❌ Car with ID " + carId + " not found.");
        });
    }

    private void MageCar() {

    }

    private void showCar() {
        cars.stream()
                .forEach(Car -> {
                    System.out.println(Car);
                });
    }

    private void addCar() {
        System.out.println("Enter car brand: ");
        String brand = scannerStr.nextLine();

        System.out.println("Enter car year: ");
        int year = number();

        System.out.println("Enter car color: ");
        String color = scannerStr.nextLine();

        System.out.println("Enter one day price: ");
        Integer price = number();


        Car car = Car.builder()
                .brand(brand)
                .year(String.valueOf(year))
                .color(color)
                .priceDay( price)
                .carStatus(Status.ACTIVE)
                .build();

        cars.add(car);

    }

}
