package Pages;

import Core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePage extends BaseSeleniumPage {
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> rows;

    //tbody/tr/td[contains(text(),'Switzerland')]

    public TablePage() {
        PageFactory.initElements(driver,this);
    }

}
