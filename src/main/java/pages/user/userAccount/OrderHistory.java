package pages.user.userAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderHistory extends BasePage {
    public OrderHistory(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="tbody tr")
    private List<WebElement> orderTableElements;
    @FindBy(css = "[scope='row']")
    private List<WebElement> ordersNumbers;

    public String getExpectedOrder(String orderNumberFromUser){
        String orderNumber = null;
        for (WebElement orderElement:
                orderTableElements) {
            List<WebElement> rowCells = orderElement.findElements(By.cssSelector("th"));
            for (WebElement rowElement :
                    rowCells) {
                if (Objects.equals(rowElement.getText(), orderNumberFromUser)){
                    orderNumber = rowElement.getText()
                            .replace("Order reference: ", "");
                }
            }
        }
        return orderNumber;
    }
    
    public List<String> getListOfOrdersInHistory(){
        List<String> ordersNumbers = new ArrayList<>();
        for (WebElement orderElement :
                this.ordersNumbers) {
            ordersNumbers.add(orderElement.getText());
        }
        return ordersNumbers;
    }

    public void openOrderDetail (String oderToOpen){
        for (WebElement row :
                orderTableElements) {
            if (row.getText().contains(oderToOpen)){
                click(row.findElement(By.cssSelector("[data-link-action='view-order-details']")));
            }
        }
    }
}
