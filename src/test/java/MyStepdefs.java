import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
//    @Given("setup api inventory")
//    public void setup_api_inventory() {
//        System.out.println("setting info..............");
//    }
//    @When("trigger api")
//    public void trigger_api() {
//        System.out.println("action.............");
//    }
//    @Then("verify books list is returned")
//    public void verify_books_list_is_returned() {
//        System.out.println("verifying..................");
//    }

    @Given("Launch the discovery app")
    public void launchTheDiscoveryApp() {
        //launching browser
    }

    @When("Fill the details of customer and click on Create Account button")
    public void fillTheDetailsOfCustomerAndClickOnCreateAccountButton() {
        //fill all the details and create
    }

    @Then("Account should be created")
    public void accountShouldBeCreated() {
        //verify whether account got created or not
    }

    @And("Account should be present in db")
    public void accountShouldBePresentInDb() {
        //verify whether account is present in db or not
    }

    private String booksListEndPoint;
    private  RequestSpecification requestObj;
    private  Response responseObj;

    @Given("^setup api inventory$")
    public void setupApiInventory() {
        setBooksListEndPoint("https://api.nytimes.com/svc/books/v3/lists.{format}");
        JsonObject requestDataObj = new JsonObject();
        //setup request body content
        setRequestObj(given().body(requestDataObj.toString()));
    }

    @When("^trigger api$")
    public void triggerApi() {
        setResponseObj(getRequestObj().when().get(booksListEndPoint,"json"));
    }

    @Then("^verify books list is returned$")
    public void verifyBooksListIsReturned() {
        System.out.println(getResponseObj().getContentType());
        System.out.println(getResponseObj().asString());
        getResponseObj().then().statusCode(200);
    }


    public String getBooksListEndPoint() {
        return booksListEndPoint;
    }

    public void setBooksListEndPoint(String booksListEndPoint) {
        this.booksListEndPoint = booksListEndPoint;
    }

    public RequestSpecification getRequestObj() {
        return requestObj;
    }

    public void setRequestObj(RequestSpecification requestObj) {
        this.requestObj = requestObj;
    }

    public Response getResponseObj() {
        return responseObj;
    }

    public void setResponseObj(Response responseObj) {
        this.responseObj = responseObj;
    }
}