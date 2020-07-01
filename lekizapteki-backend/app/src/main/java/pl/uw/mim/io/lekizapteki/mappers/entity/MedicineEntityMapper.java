package pl.uw.mim.io.lekizapteki.mappers.entity;

import java.util.Set;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.MedicineParser;
import pl.uw.mim.io.lekizapteki.repositories.entities.DiseaseEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.FormEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PackageEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class MedicineEntityMapper {

  public MedicineEntity map(Medicine medicine, DiseaseEntity diseaseEntity) {
    MedicineParser medicineParser = new MedicineParser();

    IngredientEntity ingredientEntity = IngredientEntityMapper.map(medicine.getIngredient(), medicineParser.getDose());
    FormEntity formEntity = FormEntityMapper.map(medicineParser.getForm());

    // TODO MATEUSZ MAPOWANIE Z PACZKI NA QUANTITY
    PackageEntity packageEntity = PackageEntityMapper.map(0L);

    PricingEntity pricingEntity = buildPricingEntityMapper(medicine).map();

    return MedicineEntity.builder()
        .ean(medicine.getEan())
        .name(medicineParser.getName())
        // todo MATEUSZ pewnie inaczej to mapowac jak juz wiecej bd mogl miec
        .ingredients(Set.of(ingredientEntity))
        .form(formEntity)
        .disease(diseaseEntity)
        .pack(packageEntity)
        .pricing(pricingEntity)
        .build();
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
