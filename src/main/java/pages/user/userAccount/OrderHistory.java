package pages.user.userAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class OrderHistory extends BasePage {
    public OrderHistory(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="tbody tr")
    private List<WebElement> orderTableElements;

    public String getOrder(String orderNumberFromUser){
        String orderNumber = null;
        for (WebElement orderElement:
                orderTableElements) {
            List<WebElement> rowCells = orderElement.findElements(By.cssSelector("th"));
            for (WebElement rowElement :
                    rowCells) {
                if (rowElement.getText() == orderNumberFromUser){
                    orderNumber = rowElement.getText();
                }
            }
        }
        return orderNumber;
    }
}
