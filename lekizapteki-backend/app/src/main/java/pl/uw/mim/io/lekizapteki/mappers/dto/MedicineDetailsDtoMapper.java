package pl.uw.mim.io.lekizapteki.mappers.dto;

import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.mappers.string.FormStringMapper;
import pl.uw.mim.io.lekizapteki.mappers.string.IngredientStringMapper;
import pl.uw.mim.io.lekizapteki.models.medicine.detailed.MedicineDetailsDto;
import pl.uw.mim.io.lekizapteki.models.medicine.detailed.PricingDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.FormEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.IngredientEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class MedicineDetailsDtoMapper {

  private PricingDto MapPricing(PricingEntity pricingEntity) {
    return PricingDtoMapper.map(pricingEntity);
  }

  private String MapForm(FormEntity formEntity) {
    return FormStringMapper.map(formEntity);
  }

  private String MapIngredient(IngredientEntity ingredientEntity) {
    return IngredientStringMapper.map(ingredientEntity);
  }

  public MedicineDetailsDto map(MedicineEntity medicineEntity) {
    return MedicineDetailsDto.builder()
        .ean(medicineEntity.getEan())
        .dose(medicineEntity.getDose().getDose())
        .name(medicineEntity.getName())
        .activeIngredient(MapIngredient(medicineEntity.getIngredient()))
        .pricing(MapPricing(medicineEntity.getPricing()))
        .form(MapForm(medicineEntity.getForm()))
        .build();
  }
}
