package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.UnitConverter;

public class UnitConverterTest {

  private static final Map<String, String> gramsToMilligramsCorrectParsing = Map.of(
      "0.5", "500.00",
      "5", "5000.00",
      "12.4", "12400.00",
      "1", "1000.00",
      "0,5", "500.00",
      "0.11", "110.00",
      "0,69", "690.00",
      "0,01", "10.00"
  );

  private static final Map<String, String> gramsToMilligramsWithUnitsCorrectParsing = Map.of(
      "0.5 g", "500.00 mg",
      "5 g", "5000.00 mg",
      "12.4 g", "12400.00 mg",
      "1 g", "1000.00 mg",
      "0,5 g", "500.00 mg",
      "0.11 g", "110.00 mg",
      "0,69 g", "690.00 mg",
      "0,01 g", "10.00 mg"
  );

  private static final Map<String, String> microgramsToMilligramsCorrectParsing = Map.of(
      "100", "30",
      "50", "50",
      "75 μg", "0,075"
  );

//  Map<String, String> microgramsToMilligramsCorrectParsing = Map.of(
//      // pierwsze µg
//      "100 µg ", "30",
//      "50 µg", "50",
//      // drugie μg
//      "100 μg ", "30",
//      "50 μg", "50",
        // nie wiem jakie:
//  "75 μg"
//  );

//  Map<String, String> internationalUnitsToMilligramsCorrectParsing = Map.of(
//      "1000000 j.m.", "30",
//      "1500000 j.m.", "50",
//      "3 mln j.m.", "0", // moze bedziemy zmieniac
//      "1.5 mln j.m.", "-1" // moze bedziemy zmieniac
//  );

  @Test
  public void shouldParseGramsToMilligrams() {

    for (Map.Entry<String, String> entry : gramsToMilligramsCorrectParsing.entrySet()) {
      String grams = entry.getKey();
      String correctMilligrams = entry.getValue();

      String converted = UnitConverter.gramsToMilligrams(grams);

      assertEquals(correctMilligrams, converted);
    }
  }
}
