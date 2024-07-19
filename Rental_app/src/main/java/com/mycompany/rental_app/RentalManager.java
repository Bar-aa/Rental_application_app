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
    private List <Building> buildings;
    
    public RentalManager(){
        this.buildings=new ArrayList<>();
    }
    
    public void addBuilding(Building building){
        buildings.add(building);
    }
    public List<Building> getAllBuildings(){
        return buildings;
    }
 
    
    public List<Building> getRentedBuildings(){
        List<Building> rentedBuildings =new ArrayList<>();
        for (Building building:buildings){
            if (building.isRented()){
                rentedBuildings.add(building);
            }
        }
        return rentedBuildings;
    }
    
    public List <Building> getAvailableBuildings(){
        List<Building> availableBuildings =new ArrayList<>();
        for (Building building:buildings){
            if (!building.isRented()){
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
}
