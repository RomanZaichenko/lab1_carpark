import kpi.lab1.Car;
import kpi.lab1.CarPark;
import kpi.lab1.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CarUnitTest {
    private Car car;
    private Manufacturer mercedes;

    @BeforeEach
    void testSetup() {
        mercedes = new Manufacturer("Mercedes Benz", "Germany");
        car = new Car("S-Class", mercedes, 76, 0.114, 0);
    }

    @Test
    public void testCreateEmptyModel () {
        assertThrows(IllegalArgumentException.class, () -> {new Car("", mercedes, 76,
                0.114, 0);});
    }

    @Test
    public void testNoManufacturer () {
        assertThrows(IllegalArgumentException.class, () -> {new Car("S-Class", null, 76,
                0.114, 0);});
    }

    @Test public void testNegativeFuelTankCapacity () {
        assertThrows(IllegalArgumentException.class, () -> {new Car("S-Class", null, -76,
                0.114, 0);});
    }

    @Test
    public void testDrive (){
        car.drive(100);
        assertEquals(100, car.getKilometrage());
        assertEquals((double) (76/2)-(100*0.114), car.getCurrentFuel());
    }

    @Test
    public void testDrive_notEnoughFuel () {
        car.drive(1000);
        assertEquals(100, car.getKilometrage());
        assertThrows(IllegalArgumentException.class, () -> {car.drive(1000);});
    }

    @Test
    public void testRefuel () {
        car.refuel(100);
        assertEquals(car.getCurrentFuel(), car.getFuelTankCapacity());
    }

    @Test
    public void testRefuel_NotToFull () {
        car.refuel(1);
        assertEquals((double)(76/2) + 1, car.getCurrentFuel());
    }

    @Test
    public void testRefuel_NegativeFuel () {
        car.refuel(-1);
        assertThrows(IllegalArgumentException.class, () -> {car.refuel(-1);});
    }

    @Test
    public void testRefuel_ToFull () {
        car.refuelToFull();
        assertEquals(car.getCurrentFuel(), car.getFuelTankCapacity());
    }

    @Test
    public void testEquals() {
        Car car2 = new Car("S-Class", mercedes, 76, 0.114, 0);
        assertTrue(car.equals(car2));
    }

    @Test
    public void testEquals_Different() {
        Car car2 = new Car("E-Class", mercedes, 55, 0.06, 111);
        assertFalse(car.equals(car2));
    }

    @Test
    public void testHashCode_IsConsistent() {
        int hash1 = car.hashCode();
        int hash2 = car.hashCode();
        assertEquals(hash1, hash2);
    }
}
