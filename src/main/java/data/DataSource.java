package data;

import entity.Car;
import entity.Rental;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DataSource
{
    public static Scanner scannerStr = new Scanner(System.in);
    public static Scanner scannerInt = new Scanner(System.in);
    public static List<User> users =  new ArrayList<>();
    public  static   List<Car> cars = new ArrayList<>();
    public  static   List<Rental> rentals = new ArrayList<>();
    public static User CurrentUser = null;
    public  static   Integer number(){
        Integer number = 0;
        while (true){
            try {
                number  = scannerInt.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(" please enter number try again  ");
              scannerInt.next();
            }
        }
        return number;
    }
    public static String code() {
        int number =0;
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            number  = number*10   +random.nextInt(1,8);
        }
        return String.valueOf(number);
    }


}
