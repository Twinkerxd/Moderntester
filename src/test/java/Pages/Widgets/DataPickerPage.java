package Pages.Widgets;

import Core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataPickerPage extends BaseSeleniumPage {
    @FindBy(id = "datepicker")
    private WebElement dataInput;

    public DataPickerPage() {
        PageFactory.initElements(driver,this);
    }

    public void setDataPickerDay(String day) {
        dataInput.click();
        driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
    }
}
