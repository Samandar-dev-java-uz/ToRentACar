package service;
import entity.Confirm;
import entity.Status;
import entity.User;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

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

        Optional<User> SignUser = users.stream()
                .filter(user ->Objects.equals(user.getEmail(),Email)&&Objects.equals(user.getPassword(),Password))
                .findFirst();


        SignUser.ifPresentOrElse(user ->{

            if (Boolean.TRUE.equals(user.getIsConfirm())) {
                if (user.getStatusUser() == Status.ADMIN) {
                    System.out.println("✅ Admin login");
                    new AdminService().service();
                } else if (user.getStatusUser() == Status.USER) {
                    System.out.println("✅ User login");
                     new UserService().service();
                }
            } else {
                System.out.println("❗ Please confirm your account first.");
            }

        }, () -> {
            System.out.println("❌ User not found or incorrect credentials.");

        });





    }

    private void signUp() {
        String code = code();
        System.out.println(" enter name ");
        String userName = scannerStr.nextLine();
        System.out.println(" enter surname ");
        String userSurname = scannerStr.nextLine();
        System.out.println(" enter ega ");
        Integer userAge =number();
        System.out.println(" enter password");
        String userPassword = scannerStr.nextLine();
        System.out.println(" enter email");
        String UserEmail = scannerStr.nextLine();

        User user  = User.builder()
                .name(userName)
                .surname(userSurname)
                .age(userAge)
                .email(UserEmail)
                .password(userPassword)
                .confirm(new Confirm(code,LocalTime.now().plusMinutes(1)))
                .isConfirm(false)
                .statusUser(Status.USER)
                .build();

        users.add(user);
        System.out.printf("your code  %s",code);
        System.out.println();

    }


}
