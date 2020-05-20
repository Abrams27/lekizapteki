package pl.io.lekizapteki.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JSONConverter<T> {
  ObjectMapper mapper;

  @SneakyThrows
  public String convertObjectsToJsonString(T objects) {
    return mapper.writeValueAsString(objects);
  }
}
