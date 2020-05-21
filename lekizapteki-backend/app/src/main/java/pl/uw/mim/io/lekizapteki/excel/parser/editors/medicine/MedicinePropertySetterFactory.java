package pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine;

import java.util.Map;
import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.MedicinePropertySetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.ChargeFactorSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.DiseaseSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.EanSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.IngredientSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.NameFormDoseSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.PackageSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.RefundSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.RetailPriceSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.SalePriceSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.editors.medicine.setter.implementations.TotalRefundingSetter;
import pl.uw.mim.io.lekizapteki.excel.parser.enums.ColumnType;
import pl.uw.mim.io.lekizapteki.excel.parser.models.Medicine;

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
        ColumnType.DISEASE, new DiseaseSetter(medicine),
        ColumnType.CHARGE_FACTOR, new ChargeFactorSetter(medicine),
        ColumnType.REFUND, new RefundSetter(medicine)
    );

    return columnTypeToMedicinePropertySetter.get(columnType);
  }
}
