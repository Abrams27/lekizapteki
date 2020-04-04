package pl.io.lekizapteki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WrongMedicineForDiseaseException extends RuntimeException {

  public WrongMedicineForDiseaseException() {
    super("Lek o podanym numerze EAN nie jest przepisywany na wybraną jednostkę chorobową");
  }
}
