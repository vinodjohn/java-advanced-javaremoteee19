package org.sda.services;

import org.sda.models.Person;

/**
 * PersonService interface to handle Person related operations
 *
 * @author Vinod John
 */
public interface PersonService {
    // static field is allowed but not the normal field
    static final int AVERAGE_AGE = 20;

    /**
     * To get the birth year of the Person
     *
     * @param age Age of the person
     * @return Birth year
     */
    int getPersonBirthYear(int age);

    /**
     * To get the full name of the person
     *
     * @param person Person model
     * @return Full name as String
     */
    String getPersonFullName(Person person);


    //static method definition is allowed
    static int getAverageAge() {
        return AVERAGE_AGE;
    }
}
