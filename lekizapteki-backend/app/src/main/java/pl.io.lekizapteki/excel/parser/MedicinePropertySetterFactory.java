package pl.io.lekizapteki.excel.parser;

import java.util.Map;
import lombok.experimental.UtilityClass;
import pl.io.lekizapteki.excel.parser.enums.ColumnType;
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
import pl.io.lekizapteki.repositories.excelDatatypes.Medicine;

@UtilityClass
public class MedicinePropertySetterFactory {

  public MedicinePropertySetter forMedicineAndColumnType(Medicine medicine, ColumnType columnType) {
    final Map<ColumnType, MedicinePropertySetter> columnTypeToMedicinePropertySetter = Map.of(
        ColumnType.INGREDIENT, new IngredientSetter(medicine),
        ColumnType.NAME_FORM_DOSE, new NameFormDoseSetter(medicine),
        ColumnType.PACKAGE, new PackageSetter(medicine),
        ColumnType.EAN, new EanSetter(medicine),
        ColumnType.SALE_PRICE, new SalePriceSetter(medicine),
        ColumnType.RETAIL_PRICE, new RetailPriceSetter(medicine),
        ColumnType.TOTAL_REFUNDING, new TotalRefundingSetter(medicine),
        ColumnType.CHARGE_FACTOR, new ChargeFactorSetter(medicine),
        ColumnType.REFUND, new RefundSetter(medicine)
    );

    return columnTypeToMedicinePropertySetter.get(columnType);
  }
}
