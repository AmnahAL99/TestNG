package MyPractice.Task3;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelDataSupplier {

    @DataProvider(name = "loginData")
    public String[][] getData() throws Exception {
        // Paths to the two Excel files
        String filePath1 = getFilePath("excelfile.xlsx");
        String filePath2 = getFilePath("excelfile2.xlsx");

        // Read data from both Excel files
        List<List<String>> dataFromFile1 = readExcelData(filePath1);
        List<List<String>> dataFromFile2 = readExcelData(filePath2);

        // Merge the data lists
        List<List<String>> mergedDataList = new ArrayList<>(dataFromFile1);
        mergedDataList.addAll(dataFromFile2);

        // Convert the merged list of lists into a 2D array
        String[][] mergedData = listTo2DArray(mergedDataList);

        // Optional: Print the merged data for verification
        printData(mergedData);

        return mergedData;
    }

    private String getFilePath(String fileName) {
        String separator = File.separator;
        return System.getProperty("user.dir") + separator + "resources" + separator + fileName;
    }

    private List<List<String>> readExcelData(String filePath) throws Exception {
        File excelFile = new File(filePath);
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        List<List<String>> dataList = new ArrayList<>();

        for (int i = 1; i < noOfRows; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            List<String> rowData = new ArrayList<>();
            boolean rowIsEmpty = true;
            for (int j = 0; j < noOfColumns; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                DataFormatter df = new DataFormatter();
                String cellValue = df.formatCellValue(cell);
                if (cellValue != null && !cellValue.trim().isEmpty()) {
                    rowIsEmpty = false;
                }
                rowData.add(cellValue);
            }
            if (!rowIsEmpty) {
                dataList.add(rowData);
            }
        }

        workbook.close();
        fis.close();

        return dataList;
    }
    private String[][] listTo2DArray(List<List<String>> dataList) {
        int noOfRows = dataList.size();
        int noOfColumns = dataList.get(0).size();
        String[][] data = new String[noOfRows][noOfColumns];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i).toArray(new String[0]);
        }
        return data;
    }

    private void printData(String[][] data) {
        for (String[] dataRow : data) {
            System.out.println(Arrays.toString(dataRow));
        }
    }
}

