package pl.uw.mim.io.lekizapteki.excel;

import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.uw.mim.io.lekizapteki.excel.downloader.ExcelDownloader;
import pl.uw.mim.io.lekizapteki.excel.parser.ParseExcelToDatabase;

@Component
@AllArgsConstructor
@Slf4j
public class ExcelProcessingInvoker {

  private ExcelDownloader excelDownloader;
  private ParseExcelToDatabase parseExcelToDatabase;

  @PostConstruct
  public void invoke() {
    excelDownloader.downloadIfUrlRequired();
    parseExcelToDatabase.parse();
  }
}
