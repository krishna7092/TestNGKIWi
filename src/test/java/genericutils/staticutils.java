package genericutils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class staticutils {

    public static List<HashMap<String, String>> jsonreader() throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        List<HashMap<String, String>> userData= mapper.readValue(new FileInputStream("src/main/resources/testdata/Testdata.json"), new TypeReference<List<HashMap<String, String>>>() {
        });
        return userData;
    }
}
