package pl.uw.mim.io.lekizapteki.mappers.dto;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.models.medicine.detailed.PricingDto;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class PricingDtoMapper {

  public PricingDto map(PricingEntity pricingEntity) {
    return PricingDto.builder()
        .tradePrice(pricingEntity.getTradePrice())
        .salePrice(pricingEntity.getSalePrice())
        .retailPrice(pricingEntity.getRetailPrice())
        .totalFunding(pricingEntity.getTotalFunding())
        .chargeFactor(pricingEntity.getChargeFactor())
        .refund(pricingEntity.getRefund())
        .isLumpSum(pricingEntity.isLumpSum())
        .isFree(pricingEntity.isFree())
        .profitabilityRate(pricingEntity.getProfitabilityRate())
        .build();
  }
}
