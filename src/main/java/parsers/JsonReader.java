package parsers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Users;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonReader {
    public List<Users> getPersons (File json){
        ObjectMapper mapper = new ObjectMapper();
        List<Users> methodList = new ArrayList<>();
        try{
            methodList = Arrays.asList(mapper.readValue(new File("src/main/java/parsers/webshop.json"), Users[].class));
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return methodList;
    }
}
