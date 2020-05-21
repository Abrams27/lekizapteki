package pl.uw.mim.io.lekizapteki.excel.parser.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MedicinePropertyUtils {

  public List<String> splitNameAndFormAndDose(String nameAndFormAndDose) {
    final String PATTERN = "^(.+), (tabl[^,]+), (.+)$";

    Pattern r = Pattern.compile(PATTERN);
    Matcher m = r.matcher(nameAndFormAndDose);

    List<String> groups = new ArrayList<>();

    if (m.find()) {
      for (int i = 1; i <= m.groupCount(); i++) {
        groups.add(m.group(i));
      }
    } else {
      System.out.println("COS BARDZO ZLE");
    }

    return groups;
  }
}
