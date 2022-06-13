package pages.user.userAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderDetail extends BasePage {
    public OrderDetail(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#order-infos .row")
    private WebElement orderInfo;

    public String getOrderInfo(){
        return orderInfo.getText();
    }
}
