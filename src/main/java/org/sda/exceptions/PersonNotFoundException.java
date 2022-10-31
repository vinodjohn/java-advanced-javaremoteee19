package org.sda.exceptions;

/**
 * Exception to handle if the person is not found
 *
 * @author Vinod John
 */
public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String firstName) {
        super(String.format("The person (First name: %s) is not found!", firstName));
    }

    public PersonNotFoundException(int age) {
        super(String.format("The person (age: %d) is not found!", age));
    }
}
