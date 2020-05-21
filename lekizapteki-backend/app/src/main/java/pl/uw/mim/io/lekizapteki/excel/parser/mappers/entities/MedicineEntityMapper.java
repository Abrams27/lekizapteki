package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.FormEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PackageEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class MedicineEntityMapper {

  public MedicineEntity map(Medicine medicine) {
    List<String> nameAndFormAndDose = splitNameAndFormAndDose(medicine.getNameAndFormAndDose());

    String name = nameAndFormAndDose.get(0);
    String form = nameAndFormAndDose.get(1);
    String dose = nameAndFormAndDose.get(2);

    DoseEntity doseEntity = DoseEntityMapper.map(dose);
    IngredientEntity ingredientEntity = IngredientEntityMapper.map(medicine.getIngredient());
    FormEntity formEntity = FormEntityMapper.map(form);
    DiseaseEntity diseaseEntity = DiseaseEntityMapper.map(medicine.getDisease());
    PackageEntity packageEntity = PackageEntityMapper.map(medicine.getPack());

    PricingEntity pricingEntity = PricingEntityMapper.map(
        medicine.getSalePrice(), medicine.getRetailPrice(),
        medicine.getTotalFunding(), medicine.getChargeFactor(),
        medicine.getRefund()
    );

    return MedicineEntity.builder()
        .ean(medicine.getEan())
        .name(name)
        .dose(doseEntity)
        .ingredient(ingredientEntity)
        .form(formEntity)
        .disease(diseaseEntity)
        .pack(packageEntity)
        .pricing(pricingEntity)
        .build();
  }

  // TODO Zmienić na private (public do testowania jedynie)
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
