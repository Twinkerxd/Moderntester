package Core;

import org.openqa.selenium.WebDriver;

public class BaseSeleniumPage extends BaseSeleniumTests{
    public static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
