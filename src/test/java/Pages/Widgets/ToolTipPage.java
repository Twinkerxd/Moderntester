package Pages.Widgets;

import Core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolTipPage extends BaseSeleniumPage {
    @FindBy(id = "age")
    private WebElement ageInput;

    @FindBy(xpath = "//div[@class='ui-tooltip-content']")
    private WebElement toolTip;

    public ToolTipPage() {
        PageFactory.initElements(driver,this);
    }

    public String getToolTipText() {
        mouseOver(ageInput);
        return toolTip.getText();
    }
}
