package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage {


    @FindBy(xpath = "//H3[text()='Страхование путешественников']")
    public WebElement title;

    //кнопка оформить онлайн
    @FindBy(xpath = "(//P[@class='kit-button kit-button_color_green kit-button_size_m'])[1]")
    public WebElement sendAppBtn;


    public InsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 20, 1000);
        wait.until(ExpectedConditions.visibilityOf(sendAppBtn));
    }
}