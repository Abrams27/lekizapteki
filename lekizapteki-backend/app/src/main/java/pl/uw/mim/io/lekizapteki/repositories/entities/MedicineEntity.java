package pl.uw.mim.io.lekizapteki.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "MEDICINE")
public class MedicineEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String ean;
  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "dose_id")
  private DoseEntity dose;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ingredient_id")
  private IngredientEntity ingredient;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "form_id")
  private FormEntity form;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "disease_id")
  private DiseaseEntity disease;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "pack_id")
  private PackageEntity pack;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "pricing_id")
  private PricingEntity pricing;
}
