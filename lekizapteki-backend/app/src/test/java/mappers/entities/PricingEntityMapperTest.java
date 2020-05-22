package mappers.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Map;
import org.junit.jupiter.api.Test;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.BigDecimalConverter;

public class PricingEntityMapperTest {

  Map<String, String> priceToDecimalCorrectParsing = Map.of(
      "12,30", "12.30",
      "0,01", "0.01",
      "1", "1",
      "219,89", "219.89",
      "2137,69", "2137.69",
      "7312,00", "7312.00",
      "123", "123"
  );

  // TODO zobaczymy czy 30 czy 0.3 bd jako procent
  Map<String, String> chargeFactorToDecimalCorrectParsing = Map.of(
      "30%", "30",
      "50%", "50",
      "ryczałt", "0", // moze bedziemy zmieniac
      "bezpłatny do limitu", "-1" // moze bedziemy zmieniac
  );

  @Test
  public void shouldParsePriceToDecimal() {

    for (Map.Entry<String, String> entry : priceToDecimalCorrectParsing.entrySet()) {
      String price = entry.getKey();
      String correctDecimal = entry.getValue();

      BigDecimal converted = BigDecimalConverter.priceToBigDecimal(price);

      assertEquals(correctDecimal, converted.toString());
    }
  }

  @Test
  public void shouldParseChargeFactorToDecimal() {

    for (Map.Entry<String, String> entry : chargeFactorToDecimalCorrectParsing.entrySet()) {
      String chargeFactor = entry.getKey();
      String correctDecimal = entry.getValue();

      BigDecimal converted = BigDecimalConverter.chargeFactorToBigDecimal(chargeFactor);

      assertEquals(correctDecimal, converted.toString());
    }
  }
}
