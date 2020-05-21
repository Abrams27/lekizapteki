package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import java.math.BigDecimal;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class PricingEntityMapper {

  // TODO: co zrobic z chargeFactor? to moze byc wartosc w procentach lub napis
  public PricingEntity map(String salePrice, String retailPrice, String totalFunding, String chargeFactor, String refund) {

    return PricingEntity.builder()
        .salePrice(BigDecimal.valueOf(Long.parseLong(salePrice)))
        .retailPrice(BigDecimal.valueOf(Long.parseLong(retailPrice)))
        .totalFunding(BigDecimal.valueOf(Long.parseLong(totalFunding)))
        .chargeFactor(BigDecimal.valueOf(Long.parseLong(chargeFactor)))
        .refund(BigDecimal.valueOf(Long.parseLong(refund)))
        .build();
  }
}
