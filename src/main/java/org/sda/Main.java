package org.sda;

import org.sda.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //LAMBDA EXPRESSION
        //Predicate
        Person person = new Person("Vinod", "John", "vinod", 20);
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







        //OPTIONAL
        Person person3 = new Person("Tony", "Stark", "tony", 54);

        Optional<Person> optionalPerson = Optional.of(person3);


        if(optionalPerson.isEmpty()) {
            System.out.println("Person cannot be printed");
        } else {
            System.out.println(optionalPerson.get().toString());
        }

        optionalPerson.ifPresent(System.out::println);

        System.out.println(getRandomPerson().toString());





        //STREAMS
        List<String> carList = List.of("BMW", "Audi", "Skoda", "Toyota", "Ford");

        carList.stream()
                .findFirst()
                .ifPresent(System.out::println); //findFirst() -> Optional<T>

        carList.stream()
                .findAny()
                .ifPresent(System.out::println);//findAny() -> Optional<T>  -> Find random element in the list

        //Filter: Used to apply a condition to the list and filter the list
        List<String> filteredCars = carList.stream()
                .filter(s -> s.length() >= 5)   // Filter returns Stream<T>
                .collect(Collectors.toList()); // Convert Stream<T> to List<T>

        filteredCars.forEach(s -> {
            String prefixed = "Car: " + s;
            System.out.println(prefixed);
        });

        //Map: Used to apply an operation to all the elements in the list
        List<Integer> carLengths = carList.stream()
                .map(String::length)
                .collect(Collectors.toList());

        carLengths.forEach(System.out::println);

        //allMatch(): Used to check if all the elements in the list matching a given condition
        boolean isAllCarsGreaterThanFive = carList.stream()
                .allMatch(s -> s.length() >= 5);     // s = Each element in the array
        System.out.println(isAllCarsGreaterThanFive);

        //anyMatch(): Used to check if at least one element in the list matches the given condition
        boolean isAnyCarStartingWithB = carList.stream()
                .anyMatch(s -> s.startsWith("B"));
        System.out.println(isAnyCarStartingWithB);

        //reduce(): Used to condense/reduce the list to String / other type
        String cars = carList.stream()
                .reduce("", ((s, s2) -> (s.equals("") ? "" : s + ", ") + s2 ));
        System.out.println(cars);


        //sorted(): Used to sort the list in the ascending order
        carList.stream()
                .sorted()
                .forEach(System.out::println);

        //descending order sorting
        carList.stream()
                .sorted((car1, car2) -> car2.compareTo(car1))
                .forEach(System.out::println);

        //alternative descending sort using Comparator
        carList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);





        //NESTED CLASS
        //Non-static
        Person person4 = new Person("Helar Marek", "Rangooski", "helar", 85);
        System.out.println(person4.getUsername()); //outer class method call

        Person.Employee employee = person4.new Employee();
        employee.username(); // inner class method call
        System.out.println(person4.getUsername());

        //Static
        Person person5 = new Person("Ivo", "Kukk", "ivo", 37);
        System.out.println(person5.getUsername()); // outer class method call

        Person.Customer customer = new Person.Customer(); // Difference in the object instantiation
        customer.username(person5);
        System.out.println(person5.getUsername());
    }

    //Old-school way of method definition
    private static Integer getLengthOfString(String inputString) {
        int increment = 10;
        return inputString.length() + increment;
    }

    //orElse example
    private static Person getRandomPerson() {
        // Optional<Person> optionalPerson = Optional.empty();
        Optional<Person> optionalPerson = Optional.of(new Person("Captain", "Estonia", "captain", 35));
        Person person2 = new Person("Marek", "Austin", "marek" ,33); //Backup subst.

        return optionalPerson.orElse(person2);
    }
}