package kpi.lab1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarPark {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
       if (cars.contains(car)) {
           cars.remove(car);
       } else {
           throw new ArrayStoreException("Car does not exist");
       }
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    public int getAmountOfCars() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarPark carParkToCompare)) return false;

        return Objects.equals(this.getAllCars(), carParkToCompare.getAllCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
