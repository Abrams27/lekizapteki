package pl.io.lekizapteki.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConverter<T> {

  public String convertObjectsToJsonString(T objects) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonString = "";

    try {
      jsonString = mapper.writeValueAsString(objects);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return jsonString;
  }

  public T convertJsonStringToObjects(String jsonString) {
    // TODO
    T objects = null;
    return objects;
  }

}
