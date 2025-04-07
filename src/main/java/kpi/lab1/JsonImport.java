package kpi.lab1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonImport {

    private ObjectMapper objectMapper;

    public JsonImport() {
        objectMapper = new ObjectMapper();
    }

    public List<Car> importCarsFromJson(String fileName) throws IOException {
        return objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructCollectionType(List.class, Car.class));
    }
}
