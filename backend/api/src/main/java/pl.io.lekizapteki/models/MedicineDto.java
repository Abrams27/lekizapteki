package pl.io.lekizapteki.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicineDto {

  private Long id;
  private String name;
  //Może zmienimy ean na id jesli jest unikatowy
  private String ean;
  private String dose;
}
