package org.sda;

import org.sda.exceptions.PersonNotFoundException;
import org.sda.models.Person;
import org.sda.services.PersonService;
import org.sda.services.implementations.PersonServiceImpl;

public class Main {
    public static void main(String[] args) throws PersonNotFoundException {
        //INTERFACE
        Person person = new Person();
        person.setFirstName("Vinod");
        person.setLastName("John");
        person.setAge(10);

        // Left side should be interface name and Right side should be interface's implementation class name
        PersonService personService = new PersonServiceImpl();

        // Implementation method calls
        System.out.println("Person's birth year: " + personService.getPersonBirthYear(person.getAge()));
        System.out.println("Person's full name: " + personService.getPersonFullName(person));

        System.out.println("Person's last name: " + person.getLastName());


        //EXCEPTION
        //Exception handling
        try {
            int[] intArray = {1, 4, 56, 7};

            for (int i = 0; i < intArray.length; i++) {
                System.out.println(intArray[i]);
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("The number cannot be printed because its unavailable in the array!");
        } catch (Exception exception) {
            System.out.println("Exception being caught");
        } finally { // This blocked will be executed irrespective of catch blocks
            int a = 15;
            System.out.println("Finally executed, a: " + a);
        }

        // Combining multiple exceptions
        try {
            int y = 10 / 0; // This line should throw an exception
        } catch(ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("The value of y is not determined, Error:" + e.getLocalizedMessage());
        }


        //Custom / user-defined exceptions
        System.out.println(personService.findPersonByFirstName("Vinod").toString());


    }
}