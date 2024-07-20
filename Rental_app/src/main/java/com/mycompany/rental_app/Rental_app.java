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
        System.out.println("    2- Owner Menu");
        System.out.println("    0- Exit");
        System.out.print("Choose an option: ");
        
        int choice = getIntInput();
        scanner.nextLine(); 
        
        switch (choice) {
            case 1:
                adminLogin();
                break;
            case 2:
                customerLogin();
            case 3:
                ownerLogin();
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
    
    private static void customerLogin() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer contact info: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Enter customer password: ");
        String password = scanner.nextLine();

        currentCustomer = rentalManager.findOrCreateCustomer(name, contactInfo, password);
        customerMenu();
    }

    private static void ownerLogin() {
        System.out.print("Enter owner name: ");
        String name = scanner.nextLine();
        System.out.print("Enter owner contact info: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Enter owner password: ");
        String password = scanner.nextLine();

        Owner owner = rentalManager.findOrCreateOwner(name, contactInfo, password);
        ownerMenu(owner);
    }
    
    
    private static void adminMenu() {
        while (isAdmin) {
            System.out.println("|************************|");
            System.out.println("|*******Admin Menu*******|");
            System.out.println("|************************|");
            System.out.println("    1- Add New Building");
            System.out.println("    2- View All Buildings");
            System.out.println("    3- View Rented Buildings");
            System.out.println("    4- View Available Buildings");
            System.out.println("    0- Log Out");
            System.out.print("Choose an option: ");
            
            int choice = getIntInput();
            scanner.nextLine(); 

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
        scanner.nextLine();

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
        System.out.print("Enter the Building information : ");
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
        
        System.out.print("Enter the Owner information : ");
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        Owner owner = rentalManager.findOwnerbyname(ownerName);
        
        Address address = new Address(street, city, state);
        House house = new House(name, address, size, floors, yardSize, rentalManager, price,owner);
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
        
        System.out.print("Enter the Owner information : ");
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        Owner owner = rentalManager.findOwnerbyname(ownerName);

        Address address = new Address(street, city, state);
        Shop shop = new Shop(name, address, size, storefrontSize, amenities, rentalManager, price,owner);
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
        
        System.out.print("Enter the Owner information : ");
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        Owner owner = rentalManager.findOwnerbyname(ownerName);
        Address address = new Address(street, city, state);
        
        Apartment apartment = new Apartment(name, address, size, bedrooms, bathrooms, rentalManager, price,owner);
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
        System.out.print("Enter owner password: ");
        String password = scanner.nextLine();
        currentCustomer = new Customer(name, contactInfo, password);

        while (true) {
            System.out.println("|************************|");
            System.out.println("|*****Customer Menu******|");
            System.out.println("|************************|");
            System.out.println("    1- View Available Buildings");
            System.out.println("    2- Rent a Building");
            System.out.println("    3- View Rented Buildings");
            System.out.println("    0- Log Out");
            System.out.print("Choose an option: ");
            
            int choice = getIntInput();
            scanner.nextLine();

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

   private static void ownerMenu(Owner owner) {
    while (true) {
        System.out.println("|************************|");
        System.out.println("|******Owner Menu*********|");
        System.out.println("|************************|");
        System.out.println("    1- View Owned Buildings");
        System.out.println("    2- Add New Building");
        System.out.println("    3- View Building Details");
        System.out.println("    0- Log Out");
        System.out.print("Choose an option: ");
        
        int choice = getIntInput();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewOwnedBuildings(owner);
                break;
            case 2:
                addBuildingByOwner(owner);
                break;
            case 3:
                viewBuildingDetails();
                break;
            case 0:
                System.out.println("Logged out successfully.");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

private static void viewOwnedBuildings(Owner owner) {
    System.out.println("Owned Buildings:");
    for (Building building : owner.getOwnedBuildings()) {
        System.out.println(building.getName() + " - Rented: " + building.isRented());
    }
}

private static void addBuildingByOwner(Owner owner) {
    System.out.println("|************************|");
    System.out.println("|****Add New Building****|");
    System.out.println("|************************|");
    System.out.println("    1. Add House");
    System.out.println("    2. Add Shop");
    System.out.println("    3. Add Apartment");
    System.out.print("Choose an option: ");
    
    int choice = getIntInput();
    scanner.nextLine();

    switch (choice) {
        case 1:
            addHouseByOwner(owner);
            break;
        case 2:
            addShopByOwner(owner);
            break;
        case 3:
            addApartmentByOwner(owner);
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
    }
}

private static void addHouseByOwner(Owner owner) {
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
    House house = new House(name, address, size, floors, yardSize, rentalManager, price,owner);
    rentalManager.addBuilding(house);
    owner.addOwnedBuilding(house);
    System.out.println("House added successfully.");
}

private static void addShopByOwner(Owner owner) {
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
    Shop shop = new Shop(name, address, size, storefrontSize, amenities, rentalManager, price,owner);
    rentalManager.addBuilding(shop);
    owner.addOwnedBuilding(shop);
    System.out.println("Shop added successfully.");
}

private static void addApartmentByOwner(Owner owner) {
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
    Apartment apartment = new Apartment(name, address, size, bedrooms, bathrooms, rentalManager, price,owner);
    rentalManager.addBuilding(apartment);
    owner.addOwnedBuilding(apartment);
    System.out.println("Apartment added successfully.");
}

private static void viewBuildingDetails() {
    System.out.print("Enter the name of the building to view details: ");
    String buildingName = scanner.nextLine();
    Building building = rentalManager.findBuildingByName(buildingName);

    if (building == null) {
        System.out.println("Building not found.");
        return;
    }

    System.out.println("Building Details:");
    System.out.println("Name: " + building.getName());
    System.out.println("Address: " + building.getAddress().getStreet() + ", " +
        building.getAddress().getCity() + ", " + building.getAddress().getState());
    System.out.println("Size: " + building.getSize() + " sq. ft.");
    System.out.println("Rental Price: $" + building.getPrice());
    System.out.println("Rented: " + (building.isRented() ? "Yes" : "No"));

    if (building instanceof House) {
        House house = (House) building;
        System.out.println("Floors: " + house.getFloors());
        System.out.println("Yard Size: " + house.getYardsize() + " sq. ft.");
    } else if (building instanceof Shop) {
        Shop shop = (Shop) building;
        System.out.println("Storefront Size: " + shop.getStorefrontSize() + " sq. ft.");
        System.out.println("Amenities: " + String.join(", ", shop.getAmenities()));
    } else if (building instanceof Apartment) {
        Apartment apartment = (Apartment) building;
        System.out.println("Bedrooms: " + apartment.getBedrooms());
        System.out.println("Bathrooms: " + apartment.getBathrooms());
    }
}




}
