/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rental_app;

/**
 *
 * @author baraa
 */
public class CashPayment extends Payment {
    @Override 
    public void processPayment(float amount){
        System.out.println("Processing cash payment of "+amount);
    }
}
