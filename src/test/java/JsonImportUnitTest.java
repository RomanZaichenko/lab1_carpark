import kpi.lab1.Car;
import kpi.lab1.CarPark;
import kpi.lab1.JsonImport;
import kpi.lab1.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonImportUnitTest {

    private JsonImport jsonImport;
    private Car car1;
    private Car car2;
    private CarPark carPark;
    private Manufacturer mercedes;
    private Manufacturer bmw;

    @BeforeEach
    public void testSetup() {
        mercedes = new Manufacturer("Mercedes Benz", "Germany");
        bmw = new Manufacturer("BMW", "Germany");
        car1 = new Car("S-Class", mercedes, 76, 0.114, 0);
        car2 = new Car("M8", bmw, 68, 0.89, 1200);

        carPark = new CarPark();
        carPark.addCar(car1);
        carPark.addCar(car2);

        jsonImport = new JsonImport();
    }

    @Test
    public void testImportCarsFromJson() throws IOException {

        JsonImport mockJsonImport = mock(JsonImport.class);

        List<Car> mockCarsList = new ArrayList<>();
        mockCarsList.add(car1);
        mockCarsList.add(car2);

        when(mockJsonImport.importCarsFromJson("cars.json")).thenReturn(mockCarsList);

        List<Car> importedCars = mockJsonImport.importCarsFromJson("cars.json");

        assertNotNull(importedCars);
        assertEquals(2, importedCars.size());
        assertEquals("S-Class", importedCars.get(0).getModel());
    }
}
