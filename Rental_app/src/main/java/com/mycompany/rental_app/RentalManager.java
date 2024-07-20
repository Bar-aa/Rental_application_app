/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rental_app;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baraa
 */
public class RentalManager {
    private List<Building> buildings;
    private List<Owner> owners;
    private List<Customer> customers;
    
    public RentalManager() {
        this.buildings = new ArrayList<>();
        this.owners = new ArrayList<>();
        this.customers = new ArrayList<>();
    }
    
    public void addBuilding(Building building) {
        buildings.add(building);
    }
    
    public List<Building> getAllBuildings() {
        return buildings;
    }
    
    public List<Building> getRentedBuildings() {
        List<Building> rentedBuildings = new ArrayList<>();
        for (Building building : buildings) {
            if (building.isRented()) {
                rentedBuildings.add(building);
            }
        }
        return rentedBuildings;
    }
    
    public List<Building> getAvailableBuildings() {
        List<Building> availableBuildings = new ArrayList<>();
        for (Building building : buildings) {
            if (!building.isRented()) {
                availableBuildings.add(building);
            }
        }
        return availableBuildings;
    }

    public Building findBuildingByName(String buildingName) {
        for (Building building : buildings) {
            if (building.getName().equalsIgnoreCase(buildingName)) {
                return building;
            }
        }
        return null;
    }
    
    public Owner findOrCreateOwner(String name, String contactInfo, String password) {
        for (Owner owner : owners) {
            if (owner.getName().equalsIgnoreCase(name) && owner.getPassword().equals(password)) {
                return owner;
            }
        }
        Owner newOwner = new Owner(name, contactInfo, password);
        owners.add(newOwner);
        return newOwner;
    }
    
    public Owner findOwnerByName(String name) {
        for (Owner owner : owners) {
            if (owner.getName().equalsIgnoreCase(name)) {
                return owner;
            }
        }
        System.out.println("There is no owner with the name: " + name);
        return null;
    }
    
    public Customer findOrCreateCustomer(String name, String contactInfo, String password) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        Customer newCustomer = new Customer(name, contactInfo, password);
        customers.add(newCustomer);
        return newCustomer;
    }
}
