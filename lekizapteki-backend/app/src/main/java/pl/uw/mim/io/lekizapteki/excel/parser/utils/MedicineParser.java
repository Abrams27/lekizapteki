package pl.uw.mim.io.lekizapteki.excel.parser.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;

@Getter
public class MedicineParser {

  private final static String NAME_FORM_DOSE_PATTERN = "^(.+),\\s+(tabl[^,]+), (.+)$";
  private final static int NAME_CAPTURE_GROUP_NUMBER = 1;
  private final static int FORM_CAPTURE_GROUP_NUMBER = 2;
  private final static int DOSE_CAPTURE_GROUP_NUMBER = 3;

  private String name;
  private String form;
  private String dose; // Long

  public void parseMedicine(Medicine medicine) {
    String nameAndFormAndDose = medicine.getNameAndFormAndDose();

    String[] splitted = nameAndFormAndDose.split(", ");

    if (splitted.length < 4) {
      this.name = splitted[0];
      this.form = splitted[1];
      this.dose = splitted[2];
    } else if (splitted.length == 4) {
      this.name = splitted[0];
      this.form = splitted[1] + splitted[2];
      this.dose = splitted[3];
    } else if (splitted.length == 5) {
      this.name = splitted[0] + splitted[1];
      this.form = splitted[2] + splitted[3];
      this.dose = splitted[4];
    } else if (splitted.length == 6) {
      this.name = splitted[0] + splitted[1] + splitted[2];
      this.form = splitted[3] + splitted[4];
      this.dose = splitted[5];
    } else {
      assert (false);
    }
  }
}
//  private void mapCapturedGroupsToClassProperties(Matcher matcher) {
//    this.name = matcher.group(NAME_CAPTURE_GROUP_NUMBER);
//    this.form = matcher.group(FORM_CAPTURE_GROUP_NUMBER);
//    // TODO MATEUSZ
//    this.dose = 0L;
////    this.dose = matcher.group(DOSE_CAPTURE_GROUP_NUMBER);
//  }
