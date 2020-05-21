package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import java.math.BigDecimal;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.PricingEntity;

@UtilityClass
public class PricingEntityMapper {

  private final String LUMP_SUM = "ryczałt";
  private final String FREE_UP_TO_THE_LIMIT = "bezpłatny do limitu";

  public PricingEntity map(String salePrice, String tradePrice, String retailPrice, String totalFunding, String chargeFactor, String refund) {

    return PricingEntity.builder()
        .salePrice(priceToBigDecimal(salePrice))
        .tradePrice(priceToBigDecimal(tradePrice))
        .retailPrice(priceToBigDecimal(retailPrice))
        .totalFunding(priceToBigDecimal(totalFunding))
        .chargeFactor(chargeFactorToBigDecimal(chargeFactor))
        .refund(priceToBigDecimal(refund))
        .build();
  }

  private BigDecimal priceToBigDecimal(String price) {
    return new BigDecimal(price.replace(",", "."));
  }

  // TODO: co zrobić z chargeFactor? to może byc wartość w procentach lub jeden z dwóch napisów
  private BigDecimal chargeFactorToBigDecimal(String chargeFactor) {
    BigDecimal equivalentDecimal;
    switch (chargeFactor) {
      case LUMP_SUM:
          equivalentDecimal = new BigDecimal(0); // TODO nwm czy 0 (0.00?) czy co tam innego
        break;
      case FREE_UP_TO_THE_LIMIT:
        equivalentDecimal = new BigDecimal(100); // TODO nwm czy 100 (1.00?) czy co tam innego
        break;
      default:
        // TODO: 30% chcemy przechowywać jako 0.30 czy jako 30? (na razie jest 30)
        equivalentDecimal = new BigDecimal(chargeFactor.replace("%", ""));
    }
    return equivalentDecimal;
  }
}
