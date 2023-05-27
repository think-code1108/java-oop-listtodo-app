package todolist.views;

import java.util.Scanner;

import javax.swing.InputMap;

import todolist.usecases.UserUsecase;

public class UserView {
    
    public static void ShowUserMain() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("=======================");
        System.out.println("List users");
        System.out.println("====");
        System.out.println("MENU");
        System.out.println("====");
        System.out.println("[1] - Add New Account");
        System.out.println("[2] - Change Password");
        System.out.println("[0] - Back to Welcome Page");
        System.out.println();
        System.out.println("Input Menu (number):");
        Integer menu = inputScanner.nextInt();

        switch (menu) {
            case 1:
                ShowAddUser();
                break;
            case 2:
                ShowChangePassword();
                break;
            case 0:
                WelcomeViews.ShowWelcomeView();
                break;
        }        

        inputScanner.close();
    }

    public static void ShowAddUser() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("==================");
        System.out.println("userid :");
        String sUserid = inputScanner.nextLine();
        System.out.println("password :");
        String sPassword = inputScanner.nextLine();

        UserUsecase userUsecase = new UserUsecase();
        userUsecase.AddUser(sUserid, sPassword);

        ShowUserMain();
        inputScanner.close();
    }

    public static void ShowChangePassword() {}

}
