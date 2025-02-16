package DataProviders;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "valid-user")
    Object [][] testData()
    {
        return new Object[][]
        {
            {"standard_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "invalid-users")
    Object [][] testCredentials()
    {
            return new Object[][]
                    {
                            {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},
                            {"aaaaaaa","secret_sauce","Username and password do not match any user in this service"}
                    };
    }
    @DataProvider(name = "csvData")
    public static Object[][] readCSV() throws IOException, CsvValidationException {
        String filePath = "E:\\private\\ITI's\\introduction to SW engineering\\task\\New Microsoft Excel Worksheet.csv"; // Path to CSV file
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<Object[]> testData = new ArrayList<>();

        String[] nextLine;
        boolean skipHeader = true; // Skip the first line (header)
        while ((nextLine = reader.readNext()) != null) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }
            testData.add(new Object[]{nextLine[0], nextLine[1]});
        }
        reader.close();
        return testData.toArray(new Object[0][]);
    }
}

