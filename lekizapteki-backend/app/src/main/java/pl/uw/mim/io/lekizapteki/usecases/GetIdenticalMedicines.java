package pl.uw.mim.io.lekizapteki.usecases;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.models.medicine.IdenticalMedicinesDto;
import pl.uw.mim.io.lekizapteki.models.medicine.detailed.MedicineDetailsDto;
import pl.uw.mim.io.lekizapteki.models.medicine.detailed.PricingDto;

@Component
@AllArgsConstructor
public class GetIdenticalMedicines {

  public List<IdenticalMedicinesDto> execute(String ean, String diseaseId) {
    return List.of(mockIdenticalMedicines());
  }

  private IdenticalMedicinesDto mockIdenticalMedicines() {
    return IdenticalMedicinesDto.builder()
        .medicine(mockMedicineDetails())
        .identicalMedicines(List.of(mockMedicineDetails()))
        .build();
  }

  private MedicineDetailsDto mockMedicineDetails() {
    return MedicineDetailsDto.builder()
        .name("Nervosol")
        .ean("2134567890")
        .dose("12345")
        .activeIngredient("mock")
        .form("mock")
        .pricing(mockPricing())
        .build();
  }

  private PricingDto mockPricing() {
    return PricingDto.builder()
        .tradePrice(BigDecimal.valueOf(1))
        .salePrice(BigDecimal.valueOf(1))
        .retailPrice(BigDecimal.valueOf(1))
        .totalFunding(BigDecimal.valueOf(1))
        .chargeFactor(BigDecimal.valueOf(1))
        .refund(BigDecimal.valueOf(1))
        .build();
  }
}
