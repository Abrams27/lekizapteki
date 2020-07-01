package pl.uw.mim.io.lekizapteki.profitability;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.MedicineEntity;

@UtilityClass
public class MedicineProfitabilityRateResolver {

  private final static String SPACE = " ";
  private final static int DIVIDE_SCALE = 4;

  private BigDecimal getRate(MedicineEntity medicine) {
    BigDecimal price = getRetailPrice(medicine);
    BigDecimal ingredientQuantity = getIngredientQuantity(medicine);

    return price.divide(ingredientQuantity, DIVIDE_SCALE, RoundingMode.HALF_DOWN);
  }

  private BigDecimal getRetailPrice(MedicineEntity secondMedicine) {
    return secondMedicine
        .getPricing()
        .getRetailPrice();
  }

  private BigDecimal getIngredientQuantity(MedicineEntity medicine) {
    BigDecimal dose = getDose(medicine);
    BigDecimal quantity = getQuantity(medicine);

    return dose.multiply(quantity);
  }

  private BigDecimal getDose(MedicineEntity medicineEntity) {
    return new BigDecimal(getDoseValue(medicineEntity));
  }

  private String getDoseValue(MedicineEntity medicineEntity) {
    return medicineEntity
        .getDose()
        .getDose()
        .split(SPACE)[0];
  }

  private BigDecimal getQuantity(MedicineEntity medicineEntity) {
    return new BigDecimal(getQuantityValue(medicineEntity));
  }

  private String getQuantityValue(MedicineEntity medicineEntity) {
    return medicineEntity
        .getPack()
        .getContent()
        .split(SPACE)[0];
  }
}
