package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.MedicineParser;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.DoseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.FormEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PackageEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class MedicineEntityMapper {

  private String name;
  private String form;
  private String dose;

  public MedicineEntity map(Medicine medicine, DiseaseEntity diseaseEntity) {

    moveNameAndFormAndDoseToSeparateVariables(medicine);

    DoseEntity doseEntity = DoseEntityMapper.map(dose);
    IngredientEntity ingredientEntity = IngredientEntityMapper.map(medicine.getIngredient());
    FormEntity formEntity = FormEntityMapper.map(form);
    PackageEntity packageEntity = PackageEntityMapper.map(medicine.getPack());

    PricingEntity pricingEntity = buildPricingEntityMapper(medicine).map();

    // todo
    return MedicineEntity.builder()
        .ean(medicine.getEan())
        .name(name)
//        .dose(doseEntity)
//        .ingredient(ingredientEntity)
        .form(formEntity)
        .disease(diseaseEntity)
        .pack(packageEntity)
        .pricing(pricingEntity)
        .build();
  }

  private void moveNameAndFormAndDoseToSeparateVariables(Medicine medicine) {
    MedicineParser medicineParser = new MedicineParser();

    medicineParser.parseMedicine(medicine);
    name = medicineParser.getName();
    form = medicineParser.getForm();
    dose = medicineParser.getDose();
  }

  private PricingEntityMapper buildPricingEntityMapper(Medicine medicine) {
    return PricingEntityMapper.builder()
        .salePrice(medicine.getSalePrice())
        .tradePrice(medicine.getTradePrice())
        .retailPrice(medicine.getRetailPrice())
        .totalFunding(medicine.getTotalFunding())
        .chargeFactor(medicine.getChargeFactor())
        .refund(medicine.getRefund())
        .build();
  }
}
