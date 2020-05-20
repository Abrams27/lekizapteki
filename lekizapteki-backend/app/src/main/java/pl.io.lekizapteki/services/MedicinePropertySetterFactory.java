package pl.io.lekizapteki.services;

import java.util.Map;
import pl.io.lekizapteki.enums.ColumnType;
import pl.io.lekizapteki.repositories.columnTypes.ChargeFactorSetter;
import pl.io.lekizapteki.repositories.columnTypes.EanSetter;
import pl.io.lekizapteki.repositories.columnTypes.IngredientSetter;
import pl.io.lekizapteki.repositories.columnTypes.MedicinePropertySetter;
import pl.io.lekizapteki.repositories.columnTypes.NameFormDoseSetter;
import pl.io.lekizapteki.repositories.columnTypes.PackageSetter;
import pl.io.lekizapteki.repositories.columnTypes.RefundSetter;
import pl.io.lekizapteki.repositories.columnTypes.RetailPriceSetter;
import pl.io.lekizapteki.repositories.columnTypes.SalePriceSetter;
import pl.io.lekizapteki.repositories.columnTypes.TotalRefundingSetter;

public class MedicinePropertySetterFactory {

  private MedicinePropertySetterFactory() {}

  public static MedicinePropertySetter forMedicineAndColumnType(Medicine medicine, ColumnType columnType) {
    final Map<ColumnType, MedicinePropertySetter> columnTypeToMedicinePropertySetter = Map.of(
        ColumnType.INGREDIENT, IngredientSetter.builder().medicine(medicine).build(),
        ColumnType.NAME_FORM_DOSE, NameFormDoseSetter.builder().medicine(medicine).build(),
        ColumnType.PACKAGE, PackageSetter.builder().medicine(medicine).build(),
        ColumnType.EAN, EanSetter.builder().medicine(medicine).build(),
        ColumnType.SALE_PRICE, SalePriceSetter.builder().medicine(medicine).build(),
        ColumnType.RETAIL_PRICE, RetailPriceSetter.builder().medicine(medicine).build(),
        ColumnType.TOTAL_REFUNDING, TotalRefundingSetter.builder().medicine(medicine).build(),
        ColumnType.CHARGE_FACTOR, ChargeFactorSetter.builder().medicine(medicine).build(),
        ColumnType.REFUND, RefundSetter.builder().medicine(medicine).build()
    );

    return columnTypeToMedicinePropertySetter.get(columnType);
  }
}
