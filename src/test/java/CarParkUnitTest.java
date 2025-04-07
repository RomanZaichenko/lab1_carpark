import kpi.lab1.Car;
import kpi.lab1.CarPark;
import kpi.lab1.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CarParkUnitTest {
    private CarPark carPark;
    private Car car1;
    private Car car2;

    private Manufacturer mercedes = new Manufacturer("Mercedes Benz", "Germany");
    private Manufacturer bmw = new Manufacturer("BMW", "Germany");

    @BeforeEach
    public void testSetup() {
        carPark = new CarPark();
        car1 = new Car("S-Class", mercedes, 76, 0.114, 0);
        car2 = new Car("M8", bmw, 68, 0.89, 1200);
    }

    @Test
    public void testAddCar() {
        carPark.addCar(car1);
        carPark.addCar(car2);
        assertEquals(2, carPark.getAmountOfCars());
        assertTrue(carPark.getAllCars().contains(car1));
    }

    @Test
    public void testRemoveCar() {
        carPark.addCar(car1);
        carPark.addCar(car2);
        carPark.removeCar(car1);
        assertEquals(1, carPark.getAmountOfCars());
        assertFalse(carPark.getAllCars().contains(car1));
    }

    @Test
    public void testRemoveCar_NoCar() {
        assertThrows(IllegalArgumentException.class, () -> carPark.removeCar(car1));
    }

    @Test
    public void testGetAmountOfCars() {
        carPark.addCar(car1);
        carPark.addCar(car2);
        assertEquals(2, carPark.getAmountOfCars());
    }

    @Test
    public void testEquals() {
        carPark.addCar(car1);
        CarPark carPark2 = new CarPark();
        carPark2.addCar(car1);
        assertTrue(carPark.equals(carPark2));
    }

    @Test
    public void testEquals_Different() {
        carPark.addCar(car1);
        CarPark carPark2 = new CarPark();
        carPark2.addCar(car2);
        assertFalse(carPark.equals(carPark2));
    }

    @Test
    public void testHashCode_IsConsistent() {
        carPark.addCar(car1);
        int hash1 = carPark.hashCode();
        int hash2 = carPark.hashCode();
        assertEquals(hash1, hash2);
    }

}
