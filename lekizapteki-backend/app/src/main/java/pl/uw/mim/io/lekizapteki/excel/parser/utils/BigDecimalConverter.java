package pl.uw.mim.io.lekizapteki.excel.parser.utils;

import java.math.BigDecimal;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BigDecimalConverter {

  private final String LUMP_SUM = "ryczałt";
  private final String FREE_UP_TO_THE_LIMIT = "bezpłatny do limitu";

  public BigDecimal priceToBigDecimal(String price) {
    return new BigDecimal(price.replace(",", "."));
  }

  public BigDecimal chargeFactorToBigDecimal(String chargeFactor) {
    BigDecimal equivalentDecimal;
    switch (chargeFactor) {
      case LUMP_SUM:
        equivalentDecimal = new BigDecimal(0);
        break;
      case FREE_UP_TO_THE_LIMIT:
        equivalentDecimal = new BigDecimal(-1);
        break;
      default:
        equivalentDecimal = new BigDecimal(chargeFactor.replace("%", "")); // na razie 30% -> 30
    }
    return equivalentDecimal;
  }
}
