# ***Renting Application***
# Overview
This application allows users to rent various types of buildings such as apartments, separate houses, and shops. Each building has an address, name, size, and other necessary characteristics. Customers can rent multiple buildings, and a contract is generated for each rental, detailing the rental period, price, and other important information. Payments can be made using PayPal, Visa, or MasterCard.
# Features
Building Types: Rent apartments, separate houses, and shops.
Contracts: Automatically generate contracts for rentals.
Payments: Pay using PayPal, Visa, or MasterCard.
# Design Principles
The application uses key object-oriented principles such as inheritance, abstraction, polymorphism, aggregation, and composition.
Inheritance: Different building types inherit from a common base class.
Abstraction: Abstract classes and interfaces are used to define common behaviors and properties.
Polymorphism: Allows different building types to be handled through a common interface.
Aggregation: Customers have a list of rented buildings, which is an example of aggregation.
Composition: Contracts are composed of various details like rental period, price, etc.
