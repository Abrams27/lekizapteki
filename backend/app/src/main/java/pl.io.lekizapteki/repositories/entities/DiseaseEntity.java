package pl.io.lekizapteki.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "DISEASE")
public class DiseaseEntity {

  @Id
  // TODO musze sprawdzic jaka strategia dla postresa powinna byc,
  //  dodatkowo jesli przy leku zdecydujemy sie na EAN to wszedzie trzeba bedzie zmienic id na Longa
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

}
