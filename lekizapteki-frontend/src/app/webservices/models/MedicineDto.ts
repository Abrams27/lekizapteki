export interface MedicineDto {
  id: number;
  name: string;
  ean: string; // jeśli unikatowe to można zamiast id dać ten ean
  dose: string;
}
