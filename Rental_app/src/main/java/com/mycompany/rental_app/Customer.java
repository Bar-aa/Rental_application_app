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
public class Customer {
    private String name;
    private String contactInfo;// i can chang it to be class by itself//
    private List<Building> rentedBuildings = new ArrayList<>();
    
    public Customer(String name,String contactInfo){
        this.name=name;
        this.contactInfo=contactInfo;
    }
    
    public void addRentedBuilding(Building building){
        rentedBuildings.add(building);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Building> getRentedBuildings() {
        return rentedBuildings;
    }

    public void setRentedBuildings(List<Building> rentedBuildings) {
        this.rentedBuildings = rentedBuildings;
    }
}
