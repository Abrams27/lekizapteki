package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.BigDecimalConverter;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class PricingEntityMapper {

  public PricingEntity map(String salePrice, String tradePrice, String retailPrice, String totalFunding, String chargeFactor, String refund) {

    return PricingEntity.builder()
        .salePrice(BigDecimalConverter.priceToBigDecimal(salePrice))
        .tradePrice(BigDecimalConverter.priceToBigDecimal(tradePrice))
        .retailPrice(BigDecimalConverter.priceToBigDecimal(retailPrice))
        .totalFunding(BigDecimalConverter.priceToBigDecimal(totalFunding))
        .chargeFactor(BigDecimalConverter.chargeFactorToBigDecimal(chargeFactor))
        .refund(BigDecimalConverter.priceToBigDecimal(refund))
        .build();
  }
}
