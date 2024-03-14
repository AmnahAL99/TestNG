package SDA.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][] {
                {"admin", "password"},
                {"user1", "passwd1"},
                {"user2", "passwd2"}
                // Add more username-password pairs as needed
        };
    }
}
