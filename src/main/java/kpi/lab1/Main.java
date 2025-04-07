package kpi.lab1;

import kpi.lab1.Car;
import kpi.lab1.Manufacturer;
import kpi.lab1.JsonExport;
import kpi.lab1.JsonImport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Car> cars = new ArrayList<>();
    private static final JsonExport jsonExport = new JsonExport();
    private static final JsonImport jsonImport = new JsonImport();

    public static void main(String[] args) {
        System.out.println("Welcome to the Car Application!");

        while (true) {
            showMenu();
            int choice = getUserChoice();
            handleChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Add a Car");
        System.out.println("2. Remove a Car");
        System.out.println("3. Show all Cars");
        System.out.println("4. Export Cars to JSON");
        System.out.println("5. Import Cars from JSON");
        System.out.println("6. Drive a Car");
        System.out.println("7. Refuel a Car");
        System.out.println("8. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addCar();
                break;
            case 2:
                removeCar();
                break;
            case 3:
                showCars();
                break;
            case 4:
                exportCarsToJson();
                break;
            case 5:
                importCarsFromJson();
                break;
            case 6:
                driveCar();
                break;
            case 7:
                refuelCar();
                break;
            case 8:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addCar() {
        System.out.print("Enter car model: ");
        String model = scanner.next();
        System.out.print("Enter manufacturer name: ");
        String manufacturerName = scanner.next();
        System.out.print("Enter manufacturer country: ");
        String country = scanner.next();
        System.out.print("Enter fuel tank capacity: ");
        double fuelTankCapacity = scanner.nextDouble();
        System.out.print("Enter fuel consumption per kilometer: ");
        double fuelConsumption = scanner.nextDouble();
        System.out.print("Enter kilometrage: ");
        int kilometrage = scanner.nextInt();

        Manufacturer manufacturer = new Manufacturer(manufacturerName, country);
        Car car = new Car(model, manufacturer, fuelTankCapacity, fuelConsumption, kilometrage);

        cars.add(car);  // Додаємо автомобіль до списку
        System.out.println("Car added successfully!");
    }

    private static void removeCar() {
        System.out.print("Enter car model to remove: ");
        String model = scanner.next();
        Car carToRemove = null;

        // Перевіряємо, чи є машина з таким моделью
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                carToRemove = car;
                break;
            }
        }

        if (carToRemove != null) {
            cars.remove(carToRemove);  // Видаляємо машину з колекції
            System.out.println("Car removed successfully!");
        } else {
            System.out.println("Car not found!");
        }
    }

    private static void showCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars in the list.");
        } else {
            for (Car car : cars) {
                System.out.println(car.getInfo());
            }
        }
    }

    private static void exportCarsToJson() {
        try {
            jsonExport.exportCarsToJson(cars, "cars.json");
            System.out.println("Cars exported to JSON successfully!");
        } catch (IOException e) {
            System.out.println("Error exporting cars to JSON: " + e.getMessage());
        }
    }

    private static void importCarsFromJson() {
        try {
            List<Car> importedCars = jsonImport.importCarsFromJson("cars.json");
            cars.clear();
            cars.addAll(importedCars);
            System.out.println("Cars imported from JSON successfully!");
        } catch (IOException e) {
            System.out.println("Error importing cars from JSON: " + e.getMessage());
        }
    }

    private static void driveCar() {
        System.out.print("Enter the model of the car you want to drive: ");
        String model = scanner.next();
        Car carToDrive = null;

        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                carToDrive = car;
                break;
            }
        }

        if (carToDrive != null) {
            System.out.print("Enter the number of kilometers to drive: ");
            int kilometers = scanner.nextInt();
            try {
                carToDrive.drive(kilometers);
                System.out.println("You have driven " + kilometers + " kilometers.");
            } catch (IllegalArgumentException e) {
                System.out.println("Not enough fuel to drive that distance.");
            }
        } else {
            System.out.println("Car not found!");
        }
    }

    private static void refuelCar() {
        System.out.print("Enter the model of the car you want to refuel: ");
        String model = scanner.next();
        Car carToRefuel = null;

        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                carToRefuel = car;
                break;
            }
        }

        if (carToRefuel != null) {
            System.out.print("Enter the amount of fuel to add: ");
            double fuelAmount = scanner.nextDouble();
            try {
                carToRefuel.refuel(fuelAmount);
                System.out.println("You have successfully refueled the car.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid fuel amount.");
            }
        } else {
            System.out.println("Car not found!");
        }
    }
}
