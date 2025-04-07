import kpi.lab1.Manufacturer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManufacturerUnitTest {
    Manufacturer manufacturer = new Manufacturer("BMW", "Germany");

    @Test
    public void testEmptyName () {
        assertThrows(IllegalArgumentException.class, () -> {new Manufacturer("", "Germany");});
    }

    @Test
    public void testEmptyCountry () {
        assertThrows(IllegalArgumentException.class, () -> {new Manufacturer("BMW", "");});
    }

    @Test
    public void testEquals() {
        Manufacturer manufacturer2 = new Manufacturer("BMW", "Germany");
        assertTrue(manufacturer.equals(manufacturer2));
    }

    @Test
    public void testEquals_Different() {
        Manufacturer manufacturer2 = new Manufacturer("Mercedes Benz", "Germany");
        assertFalse(manufacturer.equals(manufacturer2));
    }

    @Test
    public void testHashCode_IsConsistent() {
        int hash1 = manufacturer.hashCode();
        int hash2 = manufacturer.hashCode();
        assertEquals(hash1, hash2);
    }
}
