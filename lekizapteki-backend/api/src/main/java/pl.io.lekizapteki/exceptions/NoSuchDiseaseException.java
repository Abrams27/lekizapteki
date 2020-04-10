package pl.io.lekizapteki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchDiseaseException extends RuntimeException {

  private final static String message = "Nieprawidłowy numer EAN";

  public NoSuchDiseaseException() {
    super(message);
  }
}

