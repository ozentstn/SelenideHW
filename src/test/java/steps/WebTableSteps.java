package steps;
import common.PageManager;
import common.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import tests.BaseTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WebTableSteps extends BaseTest{
    PageManager pageManager=new PageManager();

    @Given("Webtables page opened")
    public void openPage(){
        pageManager.webTablePage.open();
    }
    @When("Click on the button named webtables")
    public void clickWebTables(){
        assertThat(pageManager.webTablePage.webtables.isDisplayed()).isTrue();
        pageManager.webTablePage.webtables.click();
    }
    @When("Click on the button marked +")
    public void clickAddRecord(){
        assertThat(pageManager.webTablePage.addRecord.isDisplayed()).isTrue();
        pageManager.webTablePage.addRecord.click();
    }
    @When("Enter fName, lName, eMail, age, salary, department and click on the submit")
    public void detailData(io.cucumber.datatable.DataTable dT){
        java.util.List<java.util.Map<String,String>> x=dT.asMaps(String.class, String.class);
        for (java.util.Map<String,String> y:x){
            pageManager.webTablePage.InputData();
        }
    }
    @When("Edit last record with inputData")
    public void editRecord(){
        pageManager.webTablePage.Edit();
    }
}
