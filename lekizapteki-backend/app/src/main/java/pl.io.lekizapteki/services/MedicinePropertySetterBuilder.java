package pl.io.lekizapteki.services;

import static java.util.Map.entry;

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

public class MedicinePropertySetterBuilder {

  private Map<ColumnType, MedicinePropertySetter> columnTypeToMedicinePropertySetter;

  public MedicinePropertySetterBuilder(Medicine medicine) {
    this.columnTypeToMedicinePropertySetter = Map.ofEntries(
        entry(ColumnType.INGREDIENT, IngredientSetter.builder().medicine(medicine).build()),
        entry(ColumnType.NAME_FORM_DOSE, NameFormDoseSetter.builder().medicine(medicine).build()),
        entry(ColumnType.PACKAGE, PackageSetter.builder().medicine(medicine).build()),
        entry(ColumnType.EAN, EanSetter.builder().medicine(medicine).build()),
        entry(ColumnType.SALE_PRICE, SalePriceSetter.builder().medicine(medicine).build()),
        entry(ColumnType.RETAIL_PRICE, RetailPriceSetter.builder().medicine(medicine).build()),
        entry(ColumnType.TOTAL_REFUNDING, TotalRefundingSetter.builder().medicine(medicine).build()),
        entry(ColumnType.CHARGE_FACTOR, ChargeFactorSetter.builder().medicine(medicine).build()),
        entry(ColumnType.REFUND, RefundSetter.builder().medicine(medicine).build())
    );
  }

  public MedicinePropertySetter build(ColumnType columnType) {
    return columnTypeToMedicinePropertySetter.get(columnType);
  }
}
