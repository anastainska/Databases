package com.kainska;

import com.kainska.controller.Controller;
import com.kainska.model.User;
import com.kainska.model.*;
import com.sun.source.tree.BinaryTree;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class View {
    private Controller controller = new Controller();

    public void interactMenu() throws SQLException, ParseException {
        showMenu();
        System.out.println("\n");
        int point = new Scanner(System.in).nextInt();
        switch (point) {
            case 1:
                userSubMenu();
                break;
            default:
                System.out.println("Exiting");
        }
    }

    public void showMenu() {
        System.out.println("\n");
        System.out.println("Choose what to edit: ");
        System.out.println("1: User");
        System.out.println("0: Exit");
    }

    public void userSubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all users:");
        System.out.println("2:  Find user by ID:");
        System.out.println("3:  Create new user:");
        System.out.println("4:  Update user:");
        System.out.println("5:  Delete user by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All users:");
                for (User user : controller.findAllUser()) {
                    System.out.println(user);
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter user id:");
                System.out.println(controller.findUserById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                User user;

                interactMenu();
                break;
            case 4:
                user = new User();
                controller.updateUser(user);
                interactMenu();
                break;
            case 5:
                user = new User();
                System.out.print("Enter id: ");
                user.setId(new Scanner(System.in).nextInt());
                controller.deleteUser(user);
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
}