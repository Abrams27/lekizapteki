package pl.io.lekizapteki.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JSONConverter<T> {

  @SneakyThrows
  public String convertObjectsToJsonString(T objects) {
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
