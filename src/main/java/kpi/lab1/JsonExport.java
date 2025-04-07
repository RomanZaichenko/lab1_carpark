package kpi.lab1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonExport {

    private final ObjectMapper objectMapper;

    public JsonExport() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void exportCarsToJson(List<Car> cars, String fileName) throws IOException {
        objectMapper.writeValue(new File(fileName), cars);
    }
}
