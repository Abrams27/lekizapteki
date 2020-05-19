package pl.io.lekizapteki.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JSONConverter<T> {
//  ObjectMapper mapper;

  @SneakyThrows
  public String convertObjectsToJsonString(T objects) {
    // tutaj też na razie przywróciłem
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "";

    jsonString = mapper.writeValueAsString(objects);

    return jsonString;
  }

  public T convertJsonStringToObjects(String jsonString) {
    // TODO
    T objects = null;
    return objects;
  }

}
