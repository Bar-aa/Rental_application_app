/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rental_app;

/**
 *
 * @author baraa
 */
abstract class Building {
    private String name;
    private Address address;
    private float size;
    private boolean rented;
    
    public Building(String name,Address address,float size){
        this.name=name;
        this.address=address;
        this.size=size;
        this.rented=false;
    }
    
    public abstract void rent(Customer customer, int rentalPeriod, float price ,String paymentType);
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
    
    protected Payment determinePaymentMethod(String paymentType ){
        if(paymentType == null){
            return new CashPayment();
        } 
        return switch (paymentType) {
            case "Cash" -> new CashPayment();
            case "Credit" -> new CreditCardPayment();
            default -> new CashPayment();
        };
    }
    
}
