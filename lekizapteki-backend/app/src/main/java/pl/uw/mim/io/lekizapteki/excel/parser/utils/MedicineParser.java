package pl.uw.mim.io.lekizapteki.excel.parser.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;

public class MedicineParser {
  private final String NAME_FORM_DOSE_PATTERN = "^(.+), (tabl[^,]+), (.+)$";
  private final int NAME_CAPTURE_GROUP_NUMBER = 1;
  private final int FORM_CAPTURE_GROUP_NUMBER = 2;
  private final int DOSE_CAPTURE_GROUP_NUMBER = 3;

  @Getter
  private String name;
  @Getter
  private String form;
  @Getter
  private String dose;

  public void parseMedicine(Medicine medicine) {
    String nameAndFormAndDose = medicine.getNameAndFormAndDose();

    Pattern pattern = Pattern.compile(NAME_FORM_DOSE_PATTERN);
    Matcher matcher = pattern.matcher(nameAndFormAndDose);

    executeMatcher(matcher);
    mapCapturedGroupsToClassProperties(matcher);
  }

  private void executeMatcher(Matcher matcher) {
    matcher.find(); // Ignore the check, always works
  }

  private void mapCapturedGroupsToClassProperties(Matcher matcher) {
    this.name = matcher.group(NAME_CAPTURE_GROUP_NUMBER);
    this.form = matcher.group(FORM_CAPTURE_GROUP_NUMBER);
    this.dose = matcher.group(DOSE_CAPTURE_GROUP_NUMBER);
  }

}
