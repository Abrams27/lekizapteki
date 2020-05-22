package pl.uw.mim.io.lekizapteki.excel.parser.utils;

import java.math.BigDecimal;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitConverter {

  private final int GRAMS_FACTOR = 1000;
  private final double MICROGRAMS_FACTOR = 0.001;
  private final double INTERNATIONAL_UNITS_FACTOR = 0.67; // TODO w sumie to nie wiadomo ile, różne są dane

  public String gramsToMilligrams(String grams) {
    BigDecimal decimal = new BigDecimal(grams.replace(",", "."));
    decimal = decimal.multiply(BigDecimal.valueOf(GRAMS_FACTOR));

    return decimal.toString();
  }

  public String microgramsToMilligrams(String micrograms) {
    BigDecimal decimal = new BigDecimal(micrograms.replace(",", "."));
    decimal = decimal.multiply(BigDecimal.valueOf(MICROGRAMS_FACTOR));

    return decimal.toString();
  }

  public String internationalUnitsToMilligrams(String internationalUnits) {
    BigDecimal decimal = new BigDecimal(internationalUnits.replace(",", "."));
    decimal = decimal.multiply(BigDecimal.valueOf(INTERNATIONAL_UNITS_FACTOR));

    return decimal.toString();
  }
}
