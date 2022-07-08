package Pages.Widgets;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccordionPage extends BaseSeleniumPage {
    @FindBy(xpath = "//div[@id='accordion']//h3")
    private List<WebElement> accordion;

    public AccordionPage() {
        PageFactory.initElements(driver,this);
    }

    public void clickAccordionElement(int number) {
        accordion.get(number - 1).click();
    }
}
