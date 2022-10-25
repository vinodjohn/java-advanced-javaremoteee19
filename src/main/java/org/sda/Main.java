package org.sda;

import org.sda.model.Dog;
import org.sda.model.Passenger;
import org.sda.model.Person;
import org.sda.model.PrivatePassenger;

public class Main {
    public static void main(String[] args) {
        //ENCAPSULATION
        //No-arg constructor call
        Person person = new Person();
        System.out.println(person.toString());
        System.out.println(person.getId());

        //All-argument constructor call
        Person person1 = new Person(12345L, "Vinod", "John", "abc@gmail.com", "+37258964253", "Tartu tee, Tallinn");
        System.out.println(person1.toString());
        System.out.println(person1.getEmail());

        Person person2 = new Person();
        person2.setFirstName("Tony");
        person2.setLastName("Stark");
        System.out.println(person2.getFirstName());
        System.out.println(person2.getLastName());


        Dog dog = new Dog(true, "GERMAN SHEPPERD");
        System.out.println(dog.toString());
        System.out.println(dog.getAge());
        System.out.println(dog.getWeight());



        //INHERITANCE
        Passenger passenger  = new Passenger("CARD", "Parnu");
        passenger.setEmail("passenger@gmail.com"); // Access Person fields using Passenger object

        PrivatePassenger privatePassenger = new PrivatePassenger("CARD", "Viljandi");
        privatePassenger.setPersonalIDCode("238746521873"); //Access PrivatePassenger's field
        privatePassenger.setDestinationAddress("tartu"); //Access Passenger's field
        privatePassenger.setPhoneNumber("+3722387647654"); //Access Person's field


        //Overriding
        Person personOverride = new Person();
        personOverride.setEmail("vinodjohn@gmail.com");
        System.out.println(personOverride.getEmail());

        Passenger passengerOverride = new Passenger();
        passengerOverride.setEmail("vinodjohn@gmail.com");
        System.out.println(passengerOverride.getEmail());


        //Polymorphism
        Person person3 = new Person(12345L, "Parnu");
        Person person4 = new Passenger("CARD", "Viljandi");
        System.out.println(person3.toString());
        System.out.println(person4.toString());

        // Calling parent methods
        Passenger passenger1 = new Passenger();
        passenger1.setAddress("Tallinn"); // Person.address
        passenger1.setDestinationAddress("Tartu"); // Passenger.destinationAddress
        System.out.println(passenger1.getAddresses());
    }
}