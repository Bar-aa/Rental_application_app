/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rental_app;

/**
 *
 * @author baraa
 */
public class House extends Building{
    private int floors;
    private float yardsize;
    
    public House(String name, Address address, float size, int floors, float yardSize, RentalManager rentalManager, float price, Owner owner) {
        super(name, address, size, price, owner);
        this.floors = floors;
        this.yardsize = yardSize;
        rentalManager.addBuilding(this);
        owner.addOwnedBuilding(this);
    }
    
    @Override
    public void rent(Customer customer, int rentalPeriod,  String paymentType){
        if (isRented()){
            System.err.println("House is already rented.");
            return;
        }
        Payment paymentMethod = determinePaymentMethod(paymentType);
        
        Contract contract = new Contract (customer, this,rentalPeriod ,paymentMethod);
        customer.addRentedBuilding(this);
        contract.processPayment();
        setRented(true);
        System.out.println("House rented to "+customer. getName());
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public float getYardsize() {
        return yardsize;
    }

    public void setYardsize(float yardsize) {
        this.yardsize = yardsize;
    }
    
    
}
