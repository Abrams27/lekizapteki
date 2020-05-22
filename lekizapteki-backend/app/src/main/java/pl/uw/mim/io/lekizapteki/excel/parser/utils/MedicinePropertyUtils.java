package pl.uw.mim.io.lekizapteki.excel.parser.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MedicinePropertyUtils {
  final String PATTERN = "^(.+), (tabl[^,]+), (.+)$";

  public List<String> splitNameAndFormAndDose(String nameAndFormAndDose) {

    Pattern pattern = Pattern.compile(PATTERN);
    Matcher matcher = pattern.matcher(nameAndFormAndDose);

    executeMatcher(matcher);
    return getOnlyCapturedGropus(matcher);
  }

  private void executeMatcher(Matcher matcher) {
    boolean foundAny = matcher.find();
    if (!foundAny) {
      // nie może się zdarzyć, co tutaj dać?
      System.err.println("ups");
    }
  }

  private List<String> getOnlyCapturedGropus(Matcher matcher) {
    List<String> capturedGroups = new ArrayList<>();
    for (int i = 1; i <= matcher.groupCount(); i++) {
      capturedGroups.add(matcher.group(i));
    }
    return capturedGroups;
  }
}
