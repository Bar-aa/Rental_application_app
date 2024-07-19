/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rental_app;

/**
 *
 * @author baraa
 */
public class Apartment extends Building {
    private int bedrooms;
    private int bathrooms;
    
    public Apartment (String name, Address address ,float size,int bedrooms,int bathrooms,RentalManager rentalManager , float price ){
        super (name ,address, size, price);
        this.bathrooms=bathrooms;
        this.bedrooms=bedrooms;
        rentalManager.addBuilding(this);
    }
    
    @Override
    public void rent(Customer customer, int rentalPeriod,String paymentType){
        if (isRented()){
            System.err.println("Apartment is already rented.");
            return;
        }
        Payment paymentMethod = determinePaymentMethod(paymentType);
        
        Contract contract = new Contract (customer, this,rentalPeriod ,paymentMethod);
        customer.addRentedBuilding(this);
        contract.processPayment();
        setRented(true);
        System.out.println("Apartment rented to "+customer. getName());
    }

    
  

}
