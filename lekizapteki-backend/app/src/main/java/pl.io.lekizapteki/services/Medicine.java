package pl.io.lekizapteki.services;

import lombok.Setter;

public class Medicine {
  @Setter private String ingredient;
  @Setter private String nameAndFormAndDose;
  @Setter private String pack;
  @Setter private String ean;
  @Setter private String salePrice;
  @Setter private String retailPrice;
  @Setter private String totalFunding;
  @Setter private String chargeFactor;
  @Setter private String refund;
}
