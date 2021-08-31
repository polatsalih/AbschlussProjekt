package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.util.List;

public class AddAndDeleteSteps {

    LeftNav leftSeite = new LeftNav();
    DialogContent dialogContent = new DialogContent();


    @When("^user click on the element in the leftNav Class$")
    public void userClickOnTheElementInTheLeftNavClass(DataTable elements) {
        List<String> elementToClick=elements.asList(String.class);
        for (int i = 0; i < elementToClick.size(); i++) {
            leftSeite.findElementAndClickFunction(elementToClick.get(i));
        }

    }

    @When("^user click on the element in the dialogContent$")
    public void userClickOnTheElementInTheDialogContent(DataTable elements) {
        List<String> elementToClick=elements.asList(String.class);
        for (int i = 0; i < elementToClick.size(); i++) {
            dialogContent.elementClickFuntion(elementToClick.get(i));
        }
    }

    @When("^user send the keys on the element in the dialogContent$")
    public void userSendTheKeysOnTheElementInTheDialogContent(DataTable elements) {

        List<List<String>> elementSendekeys=elements.asLists(String.class);
        for (int i = 0; i < elementSendekeys.size(); i++) {
            dialogContent.elementSendKeysFunctionality(elementSendekeys.get(i).get(0),elementSendekeys.get(i).get(1));
        }
    }

    @And("^user select \"([^\"]*)\"$")
    public void userSelect(String value) {
        dialogContent.select(value);
    }

    @And("^user delete \"([^\"]*)\"$")
    public void userDelete(String value)  {
        dialogContent.editAndDeleteFunction(value,"delete");
        dialogContent.elementClickFuntion("yesButton");
    }
}
