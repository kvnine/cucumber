import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    @Given("Launch the discovery web app")
    public void launchTheDiscoveryWebApp() throws InterruptedException {
        //launching browser

        //how to define string variable
        String app_url = "https://demo.guru99.com/test/newtours/index.php";
        //how to print it console log
        System.out.println("Given url: " + app_url);

        //how to set the driver location
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KVR\\selenium\\TestAutomation\\BrowserDrivers\\chromedriver.exe");
        //how to initiate the chrome driver
        WebDriver driver = new ChromeDriver();
        //how to launch the application
        driver.get(app_url);

        //how to enter value in a text box
        String username_txt_box = "//input[@name='userName']";
        WebElement x = driver.findElement(By.xpath(username_txt_box));
        x.sendKeys("test");

        //submitted my form.

        String firstNameFromApp = x.getText();
        System.out.println("First name in app showing: " + firstNameFromApp);



        String password_txt_box = "//input[@name='password']";
        driver.findElement(By.xpath(password_txt_box)).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='submit']")).click();



        if (driver.findElement(By.xpath("//h3[text()='Login Successfully']")).isDisplayed()){
            System.out.println("Login is successful");
        }else {
            System.out.println("Login is not successful");
        }
//        Thread.sleep(5);
//        driver.navigate().refresh();

        driver.findElement(By.xpath("//a[@href='reservation.php']")).click();
        //3 tyeps of waits available in selenium
        //java wait
        Thread.sleep(5);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);


        driver.navigate().refresh();
        Thread.sleep(5);
        driver.findElement(By.xpath("//a[@href='reservation.php']")).click();

        driver.close();
        driver.quit();

//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.manage().window().maximize();
//        driver.manage().window().minimize();
//        driver.manage().window().fullscreen();
//
//        String pageTileShowing = driver.getTitle();
//        String pageCurrentUrl = driver.getCurrentUrl();
//
//        //Implicit wait - applicable for all element whichever driver gets interact
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        //Explicit wait - applicable only for particular element
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='reservation.php']")));
//
//        //Handling Alerts
//        Alert alertBox = driver.switchTo().alert();
//        alertBox.accept();
//        alertBox.dismiss();
//        alertBox.sendKeys("Hello World");
//        String alertText = alertBox.getText();
//
//        //double click
//        Actions actions = new Actions(driver);
//        actions.doubleClick(driver.findElement(By.xpath("sampleXpath"))).build().perform();
//
//        //Getting text from an element
//        String btnNameShowing = driver.findElement(By.xpath("sampleXpath")).getText();
//
//        //Getting attribute value of an element
//        String buttonId = driver.findElement(By.xpath("sampleXpath")).getAttribute("Id");


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