import kpi.lab1.Car;
import kpi.lab1.CarPark;
import kpi.lab1.JsonExport;
import kpi.lab1.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonExportUnitTest {
    private JsonExport jsonExport;
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

        jsonExport = new JsonExport();
    }

    @Test
    public void testExportCarsToJson() throws IOException {
        JsonExport mockJsonExport = mock(JsonExport.class);

        mockJsonExport.exportCarsToJson(new ArrayList<>(), "cars.json");

        verify(mockJsonExport).exportCarsToJson(any(), eq("cars.json"));
    }

}
