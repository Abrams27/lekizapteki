package pl.io.lekizapteki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WrongMedicineForDiseaseException extends RuntimeException {

  private final static String message = "Lek o podanym numerze EAN nie jest przepisywany na wybraną jednostkę chorobową";

  public WrongMedicineForDiseaseException() {
    super(message);
  }
}
