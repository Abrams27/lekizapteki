package pl.io.lekizapteki.repositories.excelDatatypes;

import lombok.Data;

@Data
public class Medicine {

  private String ingredient;
  private String nameAndFormAndDose;
  private String pack;
  private String ean;
  private String salePrice;
  private String retailPrice;
  private String totalFunding;
  private String chargeFactor;
  private String refund;
}
