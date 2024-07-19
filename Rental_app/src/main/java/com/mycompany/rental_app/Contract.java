/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rental_app;

/**
 *
 * @author baraa
 */
public class Contract {
    private Customer customer;
    private Building building;
    private int rentalPeriod;
    
    private Payment paymentMethod;
    
    
    
    public Contract (Customer customer ,Building building, int rentalPeriod, Payment paymentMethod){
        this.building=building;
        this.customer=customer;
        this.rentalPeriod=rentalPeriod;
        this.paymentMethod=paymentMethod;
        
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getRentalPeriod() {
        return rentalPeriod;
    }

    public void setRentalPeriod(int rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }



    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    
    public void processPayment(){
        paymentMethod.processPayment(building.getPrice());
    }
    
    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Contract{\n");
        sb.append("  Customer: ").append(customer.getName()).append(",\n");
        sb.append("  Building: ").append(building.getName()).append(",\n");
        sb.append("  Renta Period: ").append(rentalPeriod).append(",\n");
        sb.append("  Price: ").append(building.getPrice()).append(",\n");
        sb.append("}");
        return sb.toString();
    }
    
}
