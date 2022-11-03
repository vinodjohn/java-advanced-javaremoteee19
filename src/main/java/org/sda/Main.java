package org.sda;

import org.sda.generics.*;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // GENERIC TYPE
        Fruit fruit = new Fruit();
        fruit.setName("Apple");
        fruit.setColor("Green");
        fruit.setPrice(BigDecimal.valueOf(1.99)); //converting a double to BigDecimal

        GenericFood<Fruit> genericFoodWithFruit = new GenericFood<>(fruit);
        System.out.println(genericFoodWithFruit.getItem());

        String str = "I'm a great developer!";
        GenericFood<String> genericFoodWithString = new GenericFood<>(str);
        System.out.println(genericFoodWithString.getItem());

        genericFoodWithString.setItem("I'm a good person!");
        System.out.println(genericFoodWithString.getItem());

        //Generic type - extends
        Vegetable vegetable = new Vegetable();
        GenericExtendFood<Vegetable> vegetableGenericExtendFood = new GenericExtendFood<>(vegetable);
        System.out.println(vegetableGenericExtendFood.getRating());


        //Generic type - interface
        Snack snack1 = new Snack(5);
        Snack snack2 = new Snack(3);
        System.out.println("Snack 1 is better than Snack 2: " + snack1.isBetter(snack2));

        //LIST
        List<String> animalList = new ArrayList<>();
        animalList.add("Lion"); // 0
        animalList.add("Tiger"); // 1
        animalList.add("Dog"); // 2
        animalList.add("Cat");
        animalList.add("Bear");
        animalList.add("Panda");

        System.out.println(animalList.get(1)); // prints tiger

        animalList.remove(1); // tiger will be deleted
        animalList.remove("Dog");

        for (String animal : animalList) {
            System.out.println(animal);
        }

        Iterator<String> stringIterator = animalList.listIterator();

        while(stringIterator.hasNext()) {
            System.out.println(stringIterator.next() + " ,");
        }

        // List of items to be removed
        List<String> removeAnimalList = new ArrayList<>();
        removeAnimalList.add("Cat");
        removeAnimalList.add("Panda");

        animalList.removeAll(removeAnimalList);

        //Final Removed list
        for (String animal : animalList) {
            System.out.println(animal);
        }


        //SET
        Set<String> countrySet = new HashSet<>(); // Non-sorted, randomly stored
        countrySet.add("Eesti");    // 525632
        countrySet.add("Saksmaa");  // 152635
        countrySet.add("Poola");
        countrySet.add("Rootsi");
        // countrySet.add("Eesti"); -> Duplicates not allowed!

        for (String country: countrySet) {
            System.out.println(country);
        }

        System.out.println("Before sorting: " + countrySet);
        TreeSet<String> countryTreeSet = new TreeSet<>(countrySet); // Stored as Sorted
        System.out.println("After sorting: " + countryTreeSet);


        //MAP
        Map<String,String> fullName = new HashMap<>(); // Not stored as sorted
        fullName.put("Vinod", "John");
        fullName.put("Martti", "Triksberg");
        fullName.put("Marko", "Piir");
        System.out.println(fullName);

        System.out.println(fullName.get("Vinod"));
        System.out.println(fullName.remove("Marko"));
        System.out.println(fullName);


        Map<String, Integer> ageMap = new HashMap<>();

        Map<String, List<String>> friendsMap = new HashMap<>();

        Map<String, Map<String, String>> detailsMap = new HashMap<>();
    }




}