/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rental_app;
import java.util.List;

/**
 *
 * @author baraa
 */
public class Shop extends Building{
    private float storefrontSize;
    private List<String> amenities;
    
    public Shop(String name, Address address ,float size,float storefrontSize,List<String> amenities,RentalManager rentalManager){
        super (name ,address, size);
        this.amenities=amenities;
        this.storefrontSize=storefrontSize;
        rentalManager.addBuilding(this);
    }
    
    @Override
    public void rent(Customer customer, int rentalPeriod, float price , String paymentType){
        if (isRented()){
            System.err.println("Shop is already rented.");
            return;
        }
        Payment paymentMethod = determinePaymentMethod(paymentType);
        
        Contract contract = new Contract (customer, this,rentalPeriod ,price ,paymentMethod);
        customer.addRentedBuilding(this);
        contract.processPayment();
        setRented(true);
        System.out.println("Shop rented to "+customer. getName());
    }

    public float getStorefrontSize() {
        return storefrontSize;
    }

    public void setStorefrontSize(float storefrontSize) {
        this.storefrontSize = storefrontSize;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}
