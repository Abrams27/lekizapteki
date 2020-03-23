package pl.io.lekizapteki.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiseaseDto {

  private Long id;
  private String name;

}
