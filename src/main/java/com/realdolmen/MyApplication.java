package com.realdolmen;

//TODO: EXTRA add a createTiger, removeTiger, updateTiger methode in TigerRepository + the whole implementation

import com.realdolmen.domain.Food;
import com.realdolmen.domain.Tiger;
import com.realdolmen.repositories.util.PropertiesLoader;
import com.realdolmen.services.FoodService;
import com.realdolmen.services.TigerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class);

//        System.out.println("Welcome to my humble world of programming\n");
////        System.out.println(PropertiesLoader.loadPropertiesFile().getProperty("db.url"));
////        System.out.println(PropertiesLoader.loadPropertiesFile().getProperty("db.user"));
////        System.out.println(PropertiesLoader.loadPropertiesFile().getProperty("db.password"));
////        while (true) { //keeps running until you manually stop the application.
////            /* You don't see 'new MyApplication()' anywhere, so no object is created out of MyApplication.
////             * But you still can call static methods or static fields without creating an object out of a class.
////             * Remember statics are class bounded not object bounded.
////             * You can access them through an object, but that doesn't mean they are inside the object 😉
////             * This also means that static methods cannot call non-static fields or methods, because non-static fields or methods belong to an object !
////             * But non-statics can call statics, because again statics doesn't belong to an object.
////             * */
//            showAndChooseInitialOptions();
////        }
//    }
//
//    private static void showAndChooseInitialOptions() { //this method is static because we didn't create an object out of MyApplication class.
//        System.out.println("Please select an option :");
//        System.out.println("\t 1. Fetch Tiger list" +
//                "\n\t 2. Add a new Tiger" );
////                "\n\t 3. Delete food by id" +
////                "\n\t 4. Update food name"
////        //TODO: add a new option to delete food by its id
////        //TODO: add a new option to update a foodName by its id
//        int choiceNumber = scanner.nextInt();
//        switch (choiceNumber) {
//            case 1:
//                showListOfTiger();
//                break;
//            case 2:
//                addNewTiger();
//                break;
////            case 3:
////                System.out.println("Which food do you want to delete?");
////                showListOfFoods();
////                deleteFood();
////                break;
////            case 4:
////                System.out.println("Which food do you want to update?");
////                showListOfFoods();
////                updateFoodName();
////                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + choiceNumber);
//        }
//    }
//
//    private static void showListOfTiger() {
//        System.out.println("----------------------");
//        System.out.println("List of Tigers:");
//        List<Tiger> tigerList = tigerService.getTigers();
//        tigerList.stream().forEach(tiger -> {
//            System.out.println("\t🐯" + tiger + " "); // I use the method print() to print the animal data values without adding a new line (enter) after each animal.
//        });
//        System.out.println("----------------------");
//    }
//
//    private static void showListOfFoods() {
//        System.out.println("----------------------");
//        System.out.println("List of Foods:");
//        for (Food food : foodService.getAllFood()) {
//            System.out.println("\t" + food);
//        }
//        System.out.println("----------------------");
//    }
//
//    private static void addNewTiger() {
//        System.out.println("What's the name of the new Tiger?");
//        scanner.nextLine(); //little trick to ignore the previous enter
//        String name = scanner.nextLine(); //scans tiger name
//        Tiger tiger = new Tiger(name); // creates a new tiger with scanned name
//        tigerService.addATiger(tiger); // adds new tiger to tigerService
//    }
//
//    private static void deleteFood() {
//        System.out.println("Type in the id of the food you want to delete");
//        /*sometimes it might be more readable to directly call a method inside the argument list (the round () )
//        But only if that method is not void, nextInt() is not void !! It has a return type of int, read the documentation */
//        foodService.deleteFoodById(scanner.nextInt());
//    }
//
//    private static void updateFoodName() {
//        System.out.println("Type in the id you want to update");
//        int id = scanner.nextInt(); //scans id
//        System.out.println("What's the new Food name ?");
//        scanner.nextLine(); //little trick to ignore the previous enter, (it's only if you use nextLine)
//        String foodName = scanner.nextLine(); //scans food Name
//        foodService.updateFoodName(id, foodName); //passes id and foodName to the method updateFoodName that is located in foodService
//    }
//

    }
}
