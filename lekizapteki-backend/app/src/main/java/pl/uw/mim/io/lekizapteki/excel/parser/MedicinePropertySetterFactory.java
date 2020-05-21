package pl.uw.mim.io.lekizapteki.excel.parser;

import java.util.Map;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.enums.ColumnType;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.ChargeFactorSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.EanSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.IngredientSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.MedicinePropertySetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.NameFormDoseSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.PackageSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.RefundSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.RetailPriceSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.SalePriceSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.columnTypes.TotalRefundingSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.repositories.excelDatatypes.Medicine;

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
