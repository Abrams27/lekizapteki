package pl.uw.mim.io.lekizapteki.excel.parser.mappers.entities;

import lombok.experimental.UtilityClass;
import pl.uw.mim.io.lekizapteki.repositories.entities.PackageEntity;

@UtilityClass
public class PackageEntityMapper {

  public PackageEntity map(String content) {
    return PackageEntity.builder()
        .content(content)
        .build();
  }
}
