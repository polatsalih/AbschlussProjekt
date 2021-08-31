package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class DialogContent extends Parent {

    WebElement projeElement;


    public DialogContent() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(linkText = "Got it!")
    private WebElement gotItBtn;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")

    private WebElement addFormButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement formCountryName;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    private WebElement formCode;


    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']")
    private WebElement formSave;



    @FindBy(css = "mat-select[formcontrolname='id']")
    private WebElement dropDown;

    @FindAll({
            @FindBy(xpath = "//mat-option[@role='option']")
    })
    public List<WebElement> countryList;


    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private WebElement formName;


    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']")
    private WebElement formSaveSehir;


    @FindAll({
            @FindBy(xpath = "//table/tbody/tr/td[2]")
    })
    public List<WebElement> formNameList;


    @FindAll({  // (//ms-delete-button[@class='ng-star-inserted'])[1])
            @FindBy(xpath = "//ms-delete-button/button")
    })
    public List<WebElement> formDeleteButtonList;


    @FindAll({
            @FindBy(xpath = "//ms-edit-button/button")
    })
    public List<WebElement> formEditButtonList;


    @FindBy(css = "button[type='submit']")
    private WebElement yesButton;

    @FindBy(css = "div[id='toast-container']")
    private WebElement mesaj;


    public void elementClickFuntion(String elementName) {

        switch (elementName) {

            case "loginButton":
                projeElement = loginButton;
                break;

            case "gotItBtn":
                projeElement = gotItBtn;
                break;

            case "addFormButton":
                projeElement = addFormButton;
                break;


            case "formSave":
                projeElement = formSave;
                break;


            case "dropDown":
                projeElement = dropDown;
                break;

            case "formSaveSehir":
                projeElement = formSaveSehir;
                break;


            case "yesButton":
                projeElement = yesButton;
                break;



        }
        clickFunction(projeElement);
    }


    public void elementSendKeysFunctionality(String ElementName, String value) {
        switch (ElementName) {
            case "username":
                projeElement = username;
                break;

            case "password":
                projeElement = password;
                break;

            case "formCountryName":
                projeElement = formCountryName;
                break;


            case "formCode":
                projeElement = formCode;
                break;

            case "formName":
                projeElement = formName;
                break;
        }
        sendKeysFunction(projeElement, value);
    }


    public void elementVerifyContainsText(String ElementName, String msg) {

        switch (ElementName) {

            case "mesaj":
                projeElement = mesaj;
                break;
        }
        if (projeElement.getText().length() > 0)
            verifyElementContainsText(projeElement, msg);
    }


    public void editAndDeleteFunction(String countryName, String editOrDelete) {

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ms-edit-button/button"), 5));

        List<WebElement> btnList = new ArrayList<>();

        if (editOrDelete.equalsIgnoreCase("delete"))
            btnList = formDeleteButtonList;
        else
            btnList = formEditButtonList;


        List<WebElement> nameListNew = formNameList;
        for (int i = 0; i < nameListNew.size(); i++) {
            if (nameListNew.get(i).getText().equalsIgnoreCase(countryName)) {
                clickFunction(btnList.get(i));
            }
        }
    }

    public void select(String countryName) {
        for (WebElement element : countryList) {
            if (element.getText().equalsIgnoreCase(countryName)) {
                clickFunction(element);
            }

        }
    }




}