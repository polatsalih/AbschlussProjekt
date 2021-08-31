package Pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent {

    public LeftNav() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Setup'][1]")
            private WebElement setup;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(css = "a[href='/countries/list']")
    private WebElement countries;

    @FindBy(xpath = "//span[text()='Cities']")
    private WebElement cities;




    WebElement leftElement;

    public void findElementAndClickFunction(String elementName) {

        switch (elementName) {

            case "setup":
                leftElement=setup;
                break;

            case "parameters":
                leftElement=parameters;
                break;

            case "countries":
                leftElement=countries;
                break;

            case "cities":
                leftElement=cities;
                break;

        }
        clickFunction(leftElement);
    }
}
