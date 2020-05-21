package pl.uw.mim.io.lekizapteki.mappers.dto;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.mappers.string.FormStringMapper;
import pl.uw.mim.io.lekizapteki.mappers.string.IngredientStringMapper;
import pl.uw.mim.io.lekizapteki.models.medicine.detailed.MedicineDetailsDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@UtilityClass
public class MedicineDetailsDtoMapper {

//  private String ean;
//  private String name;
//  private String activeIngredient;
//  private String dose;
//  private String form;
//  private PricingDto pricing;

  public MedicineDetailsDto map(MedicineEntity medicineEntity) {
    return MedicineDetailsDto.builder()
        .ean(medicineEntity.getEan())
        .dose(medicineEntity.getDose().getDose())
        .name(medicineEntity.getName())
        .activeIngredient(IngredientStringMapper.map(medicineEntity.getIngredient()))
        .pricing(PricingDtoMapper.map(medicineEntity.getPricing()))
        .form(FormStringMapper.map(medicineEntity.getForm()))
        .build();
  }
}
