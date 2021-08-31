package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CountryUndCitiesSteps {

    LeftNav leftSeite = new LeftNav();
    DialogContent dialogContent = new DialogContent();

    @Given("^Navigate to country page$")
    public void navigateToCountryPage() {

        leftSeite.findElementAndClickFunction("setup");
        leftSeite.findElementAndClickFunction("parameters");
        leftSeite.findElementAndClickFunction("countries");
    }

    @When("^Create a country$")
    public void createACountry() {

        dialogContent.elementClickFuntion("addFormButton");
        dialogContent.elementSendKeysFunctionality("formCountryName", "cikolataUlkesi4");
        dialogContent.elementSendKeysFunctionality("formCode", "123");
        dialogContent.elementClickFuntion("formSave");
    }


    @And("^Navigate to cities page$")
    public void navigateToCitiesPage() {

        leftSeite.findElementAndClickFunction("cities");
    }

    @When("^Create a cities$")
    public void createACities() {

        dialogContent.elementClickFuntion("addFormButton");
        dialogContent.elementClickFuntion("dropDown");
        dialogContent.select("cikolataUlkesi4");
        dialogContent.elementSendKeysFunctionality("formName","Ay");
        dialogContent.elementClickFuntion("formSaveSehir");

    }



    @When("^User delete the \"([^\"]*)\"$")
    public void userDeleteThe(String arg0)  {
        leftSeite.findElementAndClickFunction("countries");
        dialogContent.editAndDeleteFunction("cikolataUlkesi4","delete");
        dialogContent.elementClickFuntion("yesButton");

    }


    @Then("^\"([^\"]*)\" message should be displayed$")
    public void messageShouldBeDisplayed(String mesaj)  {
        dialogContent.elementVerifyContainsText("mesaj",mesaj);
    }
}
