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

  // TODO: co zrobić z chargeFactor? to może byc wartość w procentach (30% lub 50%) lub jeden z dwóch napisów
  public BigDecimal chargeFactorToBigDecimal(String chargeFactor) {
    BigDecimal equivalentDecimal;
    switch (chargeFactor) {
      case LUMP_SUM:
        equivalentDecimal = new BigDecimal(0); // TODO nwm czy 0 (0.00?) czy co tam innego
        break;
      case FREE_UP_TO_THE_LIMIT:
        equivalentDecimal = new BigDecimal(100); // TODO nwm czy 100 (1.00?) czy co tam innego
        break;
      default:
        // TODO: 30% chcemy przechowywać jako 0.30 czy jako 30? (na razie jest 30)
        equivalentDecimal = new BigDecimal(chargeFactor.replace("%", ""));
    }
    return equivalentDecimal;
  }
}
