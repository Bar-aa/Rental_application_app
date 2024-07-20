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
public class Owner {
    private String name;
    private String contactInfo;
    private String password;
    private List<Building> ownedBuildings;

    public Owner(String name, String contactInfo, String password) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.password = password;
        this.ownedBuildings = new ArrayList<>();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Building> getOwnedBuildings() {
        return ownedBuildings;
    }

    public void addOwnedBuilding(Building building) {
        this.ownedBuildings.add(building);
    }
}
