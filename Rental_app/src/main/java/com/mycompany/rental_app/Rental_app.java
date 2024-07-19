/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rental_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author baraa
 */
public class Rental_app {
    private static Scanner scanner = new Scanner(System.in);
    private static RentalManager rentalManager = new RentalManager();
    private static Customer currentCustomer = null;
    private static boolean isAdmin = false;

    public static void main(String[] args) {
        while (true) {
            mainMenu();
        }
    }

    public static void mainMenu() {
        System.out.println("                      |*******************************************|");
        System.out.println("                      |*******Welcome to Rental Application*******|");
        System.out.println("                      |*******************************************|\n\n");

        System.out.println("|************************|");
        System.out.println("|*******Main Menu********|");
        System.out.println("|************************|");

        System.out.println("    1- Admin Menu");
        System.out.println("    2- Customer Menu");
        System.out.println("    0- Exit");
        System.out.print("Choose an option: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                adminLogin();
                break;
            case 2:
                customerMenu();
                break;
            case 0:
                System.out.println("                      |*******************************************|");
                System.out.println("                      |*********Thanks for using this App*********|");
                System.out.println("                      |*******************************************|\n\n");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input, please try again.");
        }
    }

    private static void adminLogin() {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();
        if (password.equals("admin123")) {
            isAdmin = true;
            adminMenu();
        } else {
            System.out.println("Invalid password. Returning to main menu.");
        }
    }

    private static void adminMenu() {
        while (isAdmin) {
            System.out.println("|************************|");
            System.out.println("|*******Admin Menu*******|");
            System.out.println("|************************|\n\n");
            System.out.println("    1- Add New Building");
            System.out.println("    2- View All Buildings");
            System.out.println("    3- View Rented Buildings");
            System.out.println("    4- View Available Buildings");
            System.out.println("    0- Log Out");
            System.out.print("Choose an option: ");
            
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addNewBuilding();
                    break;
                case 2:
                    viewAllBuildings();
                    break;
                case 3:
                    viewRentedBuildings();
                    break;
                case 4:
                    viewAvailableBuildings();
                    break;
                case 0:
                    isAdmin = false;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewBuilding() {
        System.out.println("|************************|");
        System.out.println("|****Add New Building****|");
        System.out.println("|************************|");
        System.out.println("    1. Add House");
        System.out.println("    2. Add Shop");
        System.out.println("    3. Add Apartment");
        System.out.print("Choose an option: ");
        
        int choice = getIntInput();

        switch (choice) {
            case 1:
                addHouse();
                break;
            case 2:
                addShop();
                break;
            case 3:
                addApartment();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addHouse() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter size: ");
        float size = getFloatInput();
        System.out.print("Enter rental price: ");
        float price = getFloatInput();
        System.out.print("Enter number of floors: ");
        int floors = getIntInput();
        System.out.print("Enter yard size: ");
        float yardSize = getFloatInput();
        
        Address address = new Address(street, city, state);
        House house = new House(name, address, size, floors, yardSize, rentalManager, price);
        rentalManager.addBuilding(house);
        System.out.println("House added successfully.");
    }

    private static void addShop() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter size: ");
        float size = getFloatInput();
        System.out.print("Enter rental price: ");
        float price = getFloatInput();
        System.out.print("Enter storefront size: ");
        float storefrontSize = getFloatInput();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter amenities (comma separated): ");
        String amenitiesInput = scanner.nextLine();
        List<String> amenities = Arrays.asList(amenitiesInput.split(","));

        Address address = new Address(street, city, state);
        Shop shop = new Shop(name, address, size, storefrontSize, amenities, rentalManager, price);
        rentalManager.addBuilding(shop);
        System.out.println("Shop added successfully.");
    }

    private static void addApartment() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter size: ");
        float size = getFloatInput();
        System.out.print("Enter rental price: ");
        float price = getFloatInput();
        System.out.print("Enter number of bedrooms: ");
        int bedrooms = getIntInput();
        System.out.print("Enter number of bathrooms: ");
        int bathrooms = getIntInput();
        
        Address address = new Address(street, city, state);
        Apartment apartment = new Apartment(name, address, size, bedrooms, bathrooms, rentalManager, price);
        rentalManager.addBuilding(apartment);
        System.out.println("Apartment added successfully.");
    }

    private static void viewAllBuildings() {
        System.out.println("All Buildings:");
        for (Building building : rentalManager.getAllBuildings()) {
            System.out.println(building.getName() + " - Rented: " + building.isRented());
        }
    }

    private static void viewRentedBuildings() {
        System.out.println("Rented Buildings:");
        for (Building building : rentalManager.getRentedBuildings()) {
            System.out.println(building.getName());
        }
    }

    private static void viewAvailableBuildings() {
        System.out.println("Available Buildings:");
        for (Building building : rentalManager.getAvailableBuildings()) {
            System.out.println(building.getName());
        }
    }

    private static void customerMenu() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();
        currentCustomer = new Customer(name, contactInfo);

        while (true) {
            System.out.println("|************************|");
            System.out.println("|*****Customer Menu******|");
            System.out.println("|************************|\n\n");
            System.out.println("    1- View Available Buildings");
            System.out.println("    2- Rent a Building");
            System.out.println("    3- View Rented Buildings");
            System.out.println("    0- Log Out");
            System.out.print("Choose an option: ");
            
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    viewAvailableBuildings();
                    break;
                case 2:
                    rentBuilding();
                    break;
                case 3:
                    viewCustomerRentedBuildings();
                    break;
                case 0:
                    currentCustomer = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void rentBuilding() {
        System.out.print("Enter the name of the building to rent: ");
        String buildingName = scanner.nextLine();
        Building building = rentalManager.findBuildingByName(buildingName);

        if (building == null) {
            System.out.println("Building not found.");
            return;
        }

        if (building.isRented()) {
            System.out.println("Building is already rented.");
            return;
        }

        System.out.print("Enter rental period (months): ");
        int rentalPeriod = getIntInput();
        System.out.print("Enter payment type (Cash/Credit): ");
        String paymentType = scanner.nextLine();

        building.rent(currentCustomer, rentalPeriod, paymentType);
        System.out.println("Building rented successfully.");
    }

    private static void viewCustomerRentedBuildings() {
        System.out.println("Rented Buildings:");
        for (Building building : currentCustomer.getRentedBuildings()) {
            System.out.println(building.getName());
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();  // Clear invalid input
            }
        }
    }

    private static float getFloatInput() {
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // Clear invalid input
            }
        }
    }
}
