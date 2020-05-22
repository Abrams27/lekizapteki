package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import lombok.Builder;
import pl.uw.mim.io.lekizapteki.excel.parser.utils.BigDecimalConverter;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@Builder
public class PricingEntityMapper {

  String salePrice;
  String tradePrice;
  String retailPrice;
  String totalFunding;
  String chargeFactor;
  String refund;

  public PricingEntity map() {

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
