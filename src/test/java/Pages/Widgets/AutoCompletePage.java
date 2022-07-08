package Pages.Widgets;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutoCompletePage extends BaseSeleniumPage {
    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li[@class='ui-menu-item']")
    private List<WebElement> elements;

    public AutoCompletePage() {
        PageFactory.initElements(driver,this);
    }

    public void setSearchInput(String text) {
        searchInput.sendKeys(text);
    }

    public void autoCompleteValue(String value) {
        for (WebElement e : elements) {
            if (e.getText().equals(value)) {
                System.out.println(e.getText());
                e.click();
            }
        }
    }
}
