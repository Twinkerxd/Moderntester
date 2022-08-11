package Pages.Basic;

import Core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePage extends BaseSeleniumPage {
    @FindBy(xpath = "//tbody/tr") private List<WebElement> rowsList;

    public TablePage() {
        PageFactory.initElements(driver,this);
    }

    public void someMethod() {
        for (WebElement webElement : rowsList) {
            String rank = webElement.findElement(By.xpath("./th")).getText();
            String peak = webElement.findElement(By.xpath("./td[1]")).getText();
            String mountainRange = webElement.findElement(By.xpath("./td[2]")).getText();
            String state = webElement.findElement(By.xpath("./td[3]")).getText();
            String height = webElement.findElement(By.xpath("./td[4]")).getText();

            if (state.contains("Switzerland") && Integer.parseInt(height) > 4000) {
                System.out.println("Rank:" + rank + " Peak:" + peak + " Mountain range:" + mountainRange);
            }
        }
    }
}
