package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import java.util.List;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.MedicinePropertyUtils;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.FormEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PackageEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class MedicineEntityMapper {

  String name, form, dose;

  public MedicineEntity map(Medicine medicine) {
    moveNameAndFormAndDoseToSeperateVariables(medicine);

    DoseEntity doseEntity = DoseEntityMapper.map(dose);
    IngredientEntity ingredientEntity = IngredientEntityMapper.map(medicine.getIngredient());
    FormEntity formEntity = FormEntityMapper.map(form);
    DiseaseEntity diseaseEntity = DiseaseEntityMapper.map(medicine.getDisease());
    PackageEntity packageEntity = PackageEntityMapper.map(medicine.getPack());

    PricingEntity pricingEntity = PricingEntityMapper.builder()
        .salePrice(medicine.getSalePrice())
        .tradePrice(medicine.getTradePrice())
        .retailPrice(medicine.getRetailPrice())
        .totalFunding(medicine.getTotalFunding())
        .chargeFactor(medicine.getChargeFactor())
        .refund(medicine.getRefund())
        .build()
        .map();

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

  private void moveNameAndFormAndDoseToSeperateVariables(Medicine medicine) {
    List<String> nameAndFormAndDoseSplit = MedicinePropertyUtils.splitNameAndFormAndDose(medicine.getNameAndFormAndDose());

    name = nameAndFormAndDoseSplit.get(0);
    form = nameAndFormAndDoseSplit.get(1);
    dose = nameAndFormAndDoseSplit.get(2);
  }
}
