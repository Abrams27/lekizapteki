package pl.io.lekizapteki.services;

public class Medicine {

  public void setIngredient(String ingredient) {
    this.ingredient = ingredient;
  }

  public void setNameAndFormAndDose(String nameAndFormAndDose) {
    this.nameAndFormAndDose = nameAndFormAndDose;
  }

  public void setPack(String pack) {
    this.pack = pack;
  }

  public void setEan(String ean) {
    this.ean = ean;
  }

  public void setSalePrice(String salePrice) {
    this.salePrice = salePrice;
  }

  public void setRetailPrice(String retailPrice) {
    this.retailPrice = retailPrice;
  }

  public void setTotalFunding(String totalFunding) {
    this.totalFunding = totalFunding;
  }

  public void setChargeFactor(String chargeFactor) {
    this.chargeFactor = chargeFactor;
  }

  public void setRefund(String refund) {
    this.refund = refund;
  }

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
