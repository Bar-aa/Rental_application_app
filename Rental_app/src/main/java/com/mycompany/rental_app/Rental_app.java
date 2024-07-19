/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rental_app;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author baraa
 */
public class Rental_app {

    public static void main(String[] args) {
        RentalManager rentalManager = new RentalManager();

        Address address1 = new Address("123 Main St", "Springfield", "IL");
        House house = new House("My House", address1, 2000.0f, 2, 500.0f, rentalManager);

        Address address2 = new Address("456 Elm St", "Springfield", "IL");
        Shop shop = new Shop("My Shop", address2, 1500.0f, 300.0f, List.of("WiFi", "Parking"), rentalManager);

        Customer customer = new Customer("John Doe", "john.doe@example.com");
        house.rent(customer, 12, 1200.0f, "Cash");

        // Attempting to rent the same house again should print an error message
        house.rent(customer, 12, 1200.0f, "Credit");

        // Rent the shop
        shop.rent(customer, 6, 800.0f, "Credit");

        // Print all buildings
        System.out.println("All buildings:");
        for (Building b : rentalManager.getAllBuilding()) {
            System.out.println(b.getName() + " - Rented: " + b.isRented());
        }

        // Print all rented buildings
        System.out.println("\nRented buildings:");
        for (Building b : rentalManager.getRentedBuildings()) {
            System.out.println(b.getName());
        }

        // Print all available buildings
        System.out.println("\nAvailable buildings:");
        for (Building b : rentalManager.getAvailableBuildings()) {
            System.out.println(b.getName());
        }
    }
}
