import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("setup api inventory")
    public void setup_api_inventory() {
        System.out.println("setting info..............");
    }
    @When("trigger api")
    public void trigger_api() {
        System.out.println("action.............");
    }
    @Then("verify books list is returned")
    public void verify_books_list_is_returned() {
        System.out.println("verifying..................");
    }
}
