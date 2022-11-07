package org.sda;

import org.sda.model.Person;

import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        //LAMBDA EXPRESSION
        //Predicate
        Person person = new Person("Vinod", "John", 20);
        Predicate<Person> personTest = test -> test.getAge() > 20; //lambda expression
        System.out.println(personTest.test(person));

        System.out.println(getLengthOfString("Java is not easy. Joke ;)"));

        // New way of writing method : Functional Interface
        Function<String, Integer> getStringLen = s -> {
            int increment = 10;
            return s.length() + increment;
        };

        System.out.println(getStringLen.apply("Java is not easy. Joke ;)"));


        //Method reference
        Predicate<Person> personTest2 = Person::isAdult; //Method reference ->  ClassName::MethodName
        System.out.println(personTest2.test(person));

        //Supplier: Doesn't take any arguments but returns/supplies only the value
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(); // No argument but returns random value
        System.out.println(randomNumberSupplier.get()); //get() should be called always

        //Consumer: It takes an argument, do the operations and returns nothing
        Consumer<Person> printPerson = p -> System.out.println("Person first name:" + p.getFirstName() + " last name:" + p.getLastName());
        printPerson.accept(person); //accept() should be called always

        //Operator
        UnaryOperator<Integer> toSquare = i -> i * i;
        System.out.println(toSquare.apply(4)); // apply() should be called always
    }

    //Old-school way of method definition
    private static Integer getLengthOfString(String inputString) {
        int increment = 10;
        return inputString.length() + increment;
    }


}