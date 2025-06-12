package service;
import entity.Confirm;
import entity.Status;
import entity.User;

import java.time.LocalTime;
import java.util.Objects;

import static data.DataSource.*;

public class AuthService {
    public void service(){

        while(true){

            System.out.println("""
                    0 exit
                    1 sign up
                    2 sign in
                    3 confirm user
                    """);

            switch (number()){

                case 0 ->{ return;}
                case 1 -> signUp();
                case 2 -> signIn();
                case 3 -> confirm();

            }
        }
    }

    private void confirm() {

        System.out.println(" enter email");
        String Email = (scannerStr.nextLine());
        System.out.println(" enter password");
        String Password = (scannerStr.nextLine());
        System.out.println(" enter code ");
        String code = scannerStr.nextLine();

        for (User user : users) {

            if (Objects.equals(Email,user.getEmail())&&Objects.equals(user.getPassword(),Password)){

                if (LocalTime.now().isBefore(user.getConfirm().getTime())&&Objects.equals(code,user.getConfirm().getCode())){

                    user.setIsConfirm(true);
                    System.out.println(" successfully !");
                    return;

                }
                String codee  = code();
                System.out.printf("your code  %s",codee);
                user.setConfirm(new Confirm(codee,LocalTime.now().plusMinutes(2)));
                System.out.println();
                return;



            }


        }

        System.out.println( " user not found ");
        return;

    }

    private void signIn() {

        System.out.println(" enter email");
        String Email = (scannerStr.nextLine());
        System.out.println(" enter password");
        String Password = (scannerStr.nextLine());

        for (User user : users) {

            if (Objects.equals(Email,user.getEmail())&&Objects.equals(user.getPassword(),Password)){

                if (Objects.equals(user.getIsConfirm(),true)){

                    if (Objects.equals(user.getStatusUser(),Status.ADMIN)){
                        System.out.println(" admin");
                        new AdminService().service();
                        return;
                    }
                    if (Objects.equals(user.getStatusUser(),Status.USER)){
                        System.out.println(" user ");
                        return;

                    }
                }
                System.out.println(" Please  can you doing confirm try again");
                return;
            }
        }

        System.out.println(" user not fount ");



    }

    private void signUp() {

        User user  = new User();

        System.out.println(" enter name ");
        user.setName(scannerStr.nextLine());
        System.out.println(" enter surname ");
        user.setSurname(scannerStr.nextLine());
        System.out.println(" enter ega ");
        user.setAge(number());
        System.out.println(" enter password");
        user.setPassword(scannerStr.nextLine());
        System.out.println(" enter email");
        user.setEmail(scannerStr.nextLine());
        user.setStatusUser(Status.ADMIN);
        user.setIsConfirm(false);
        String code = code();
        user.setConfirm(new Confirm(code, LocalTime.now().plusMinutes(2)));

        System.out.printf("your code  %s",code);
        System.out.println();

        users.add(user);

    }


}
