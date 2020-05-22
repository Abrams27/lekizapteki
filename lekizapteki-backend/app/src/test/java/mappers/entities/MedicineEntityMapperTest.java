package mappers.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.MedicinePropertyUtils;

public class MedicineEntityMapperTest {

  Map<String, List<String>> correctSplitsOfNameAndFormAndDose = Map.of(
      "Tritace 2,5 Comb, tabl., 2,5+12,5 mg", List.of("Tritace 2,5 Comb", "tabl.", "2,5+12,5 mg"),
      "Ampril HD, tabl., 5+25 mg", List.of("Ampril HD", "tabl.", "5+25 mg"),
      "Delmuno 2,5, tabl. powl., 2,5+2,5 mg", List.of("Delmuno 2,5", "tabl. powl.", "2,5+2,5 mg"),
      "Astrium, tabletki powlekane, 10 mg", List.of("Astrium", "tabletki powlekane", "10 mg"),
      "Oprymea, tabl. o przedł. uwalnianiu, 0,26+0,52+1,05 mg", List.of("Oprymea", "tabl. o przedł. uwalnianiu", "0,26+0,52+1,05 mg"),
      "Madopar 62,5 mg, tabl. do sporządzania zawiesiny doustnej, 50+12,5 mg", List.of("Madopar 62,5 mg", "tabl. do sporządzania zawiesiny doustnej", "50+12,5 mg"),
      "Co-Prenessa 4 mg/1,25 mg tabletki, tabl., 4+1,25 mg", List.of("Co-Prenessa 4 mg/1,25 mg tabletki", "tabl.", "4+1,25 mg")
  );

  @Test
  public void shouldSplitNameAndFormAndDose() {

    for (Map.Entry<String, List<String>> entry : correctSplitsOfNameAndFormAndDose.entrySet()) {
      String nameAndFormAndDose = entry.getKey();
      List<String> correctSplit = entry.getValue();

      List<String> split = MedicinePropertyUtils.splitNameAndFormAndDose(nameAndFormAndDose);
//
//      System.out.println("split = " + split);
//      System.out.println("correct = " + correctSplit);

      assertEquals(correctSplit.size(), split.size());
      for (int i = 0; i < correctSplit.size(); i++) {
        assertEquals(split.get(i), correctSplit.get(i));
      }
    }
  }
}
