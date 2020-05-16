package pl.uw.mim.io.lekizapteki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchMedicineException extends RuntimeException {

  private final static String MESSAGE = "Nieprawidłowa jednostka chorobowa";

  public NoSuchMedicineException() {
    super(MESSAGE);
  }
}
