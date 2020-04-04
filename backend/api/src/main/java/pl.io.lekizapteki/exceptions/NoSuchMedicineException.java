package pl.io.lekizapteki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchMedicineException extends RuntimeException {

  public NoSuchMedicineException() {
    super("Nieprawidłowa jednostka chorobowa");
  }
}
