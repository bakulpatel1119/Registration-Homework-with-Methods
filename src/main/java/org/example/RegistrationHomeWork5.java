package org.example;
import com.sun.org.apache.xerces.internal.impl.dv.dtd.ENTITYDatatypeValidator;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.IOP.ENCODING_CDR_ENCAPS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import java.time.Clock;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RegistrationHomeWork5

{
    static protected WebDriver driver;

    //------------------------------------------------------------------------------------------------------------------
    // METHOD 1 : WAIT UNTIL CLICKABLE
            public void waitUntilClickable(By by, long time)
            {
                WebDriverWait wait = new WebDriverWait(driver, time);
                wait.until(ExpectedConditions.elementToBeClickable(by));
            }
    //------------------------------------------------------------------------------------------------------------------
    //  METHOD 2 : WAIT FOR ELEMENT VISIBLE
            public void waitForVisible(By by, long time)
            {
                WebDriverWait wait = new WebDriverWait(driver,time);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            }
    //------------------------------------------------------------------------------------------------------------------
    //  METHOD 3 : WAIT FOR ELEMENT IS PRESENCE
            public void waitforElementisPresent(By by, long time)
            {
                WebDriverWait wait = new WebDriverWait(driver,time);
                wait.until(ExpectedConditions.presenceOfElementLocated(by));
            }
    //------------------------------------------------------------------------------------------------------------------
    //  METHOD 4 : GET TEXT FROM ELEMENT
            public String getTextfromElement1(By by)
            {
                return driver.findElement(by).getText();
            }
    //------------------------------------------------------------------------------------------------------------------
    //  METHOD 5 : CLICK ON ELEMENT
            public void clickonElement(By by)
            {
             driver.findElement(by).click();
            }
    //------------------------------------------------------------------------------------------------------------------
    // METHOD 6 : ENTER TEXT (SEND KEY)
        public void enterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    //------------------------------------------------------------------------------------------------------------------
    //  METHOD 7 : SELECT FROM DROP DOWN BY INDEX
        public void selectFromDropDownByIndex(By by, int index)
        {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
        }
    //------------------------------------------------------------------------------------------------------------------
    //  METHOD 8 : SELECT FROM DROP DOWN BY VALUE
        public void selectFromDropDownByValue(By by, String value)
        {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
        }
    //------------------------------------------------------------------------------------------------------------------
    //  METHOD  9 : SELECT FROM DROP DOWN BY VISIBLE
        public void selectFromDropDownByVisible(By by, String visText)
        {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(visText);
        }
    //------------------------------------------------------------------------------------------------------------------
    //  METHOD  10 : CREATE TIME STAMP (EMAIL)
        public String timeStamp()
        {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
        Date date = new Date();
        return (dateFormat.format(date));
        }
    //------------------------------------------------------------------------------------------------------------------
    // METHOD 11 : BEFORE TEST
        @BeforeTest
        public void beforeTest()
        {
        //create an instance of the chrome driver.
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDrivers\\chromedriver.exe");
        // object created for chrome driver
        driver = new ChromeDriver();
        //Maximize the window
        driver.manage().window().maximize();
        //Add implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    //------------------------------------------------------------------------------------------------------------------
    //  METHOD 12 : AFTER TEST
        @AfterTest
        public void afterTest()
        {
        driver.close();
        }

    //------------------------------------------------------------------------------------------------------------------

    //--------------------------------------------------NEXT-----------------------------------------------------------

    // Using Junit annotation
    @Test

    public void registerNext()
    {
        //Method Used for re-useability
        beforeTest();

        // open website
        driver.get("https://www.next.co.uk/secure/account/Login");

        //CLICK ON ELEMENT METHOD USED TO CLICK ON LOGIN BUTTON
        clickonElement(By.xpath("//a[@class=\"nxbtn primary large\"]"));

        //FIND ELEMENT, SELECT DROP DOWN AND "MR" TITLE
        selectFromDropDownByValue(By.xpath("//Select[@id=\"Title\"]"),"Mr");

        // Find element and enter Valid Firstname
        enterText(By.id("FirstName"),"John");

        // Find element and enter Valid Lastname
        enterText(By.id("LastName"),"Smith");

        // Find element and enter Valid Email address
        enterText(By.id("Email"),"jay+"+timeStamp()+"@gmail.com");

        // Find element and enter Valid Password
        enterText(By.xpath("//input[@id=\"Password\"]"),"abcd123456");

        // Find element and enter Valid Date of Birth
        enterText(By.xpath("//input[@id=\"DobDate\"]"),"01 01 80");

       // Find element and enter Valid Phonenumber
        enterText(By.id("PhoneNumber"),"00023456945");

        // Find element and enter Valid HouseNumber
        enterText(By.id("HouseNumberOrName"),"116");

        //Select Option (Yes or No) to get Free Next Directory
        clickonElement(By.xpath("//label[@for=\"RequestDirNo\"]"));

        //Do not wants to complete registration as unnecessary account will be created
        //Therefore wrong postcode entered to match / use Assert Method
        enterText(By.id("Postcode"),"ub5");

        //Find element and click on Great Register My Account button
        clickonElement(By.xpath("//*[@id=\"SignupButton\"]"));

        // ASSERT USED TO MATCH IF EXPECTED AND ACTUAL RESULT APPEARED BY ENTERING INCOMPLETE OR WRONG POSTCODE
        String expected =  "Please enter a valid Postcode";
        String actual = driver.findElement(By.id("Postcode-error")).getText();
        Assert.assertEquals("Failed",expected,actual);

        //afterTest();
    }

       //---------------------------------------------------WILKO----------------------------------------------------------

    // Using Junit annotation
    @Test
     public void RegisterWilko()
     {
         //Method Used for re-useability
         beforeTest();

        // open the website
        driver.get("https://www.wilko.com/");

        //Click on Sign In
        clickonElement(By.xpath("//a[@class=\"navigation-account-link nav__links--anonymous\"]"));

        //Select Title
         selectFromDropDownByValue(By.xpath("//select[@id=\"register.title\"]"),"mr");

         //Enter Valid FirstName
        enterText(By.id("register.firstName"),"John");

         //Enter Valid Lastname
        enterText(By.id("register.lastName"),"Smith");

         //Enter Valid Email Id
        enterText(By.id("register.email"),"abd+"+timeStamp()+"@gmail.com");

         //Enter Valid Password
       enterText(By.xpath("//input[@id=\"password\"]"),"12323aaa");

         //Enter Valid Confirm Password
        enterText(By.xpath("//input[@id=\"register.checkPwd\"]"),"12323aac");

        //afterTest();
      }

      //-------------------------------------------------MOCK PLUS--------------------------------------------------------

        // Using Junit annotation
        @Test

        public void registerMockPlus() {

            //Method Used for re-useability
            beforeTest();

        // open website
        driver.get("https://www.mockplus.com/");

        //Click on Register button
        clickonElement(By.linkText("Register"));

        //Enter email address
        enterText(By.id("email"),"ABC"+timeStamp()+"@gmal.com");

        //Enter Password
        enterText(By.id("password"),"123456abcD");

        //Enter Password
        enterText(By.id("cofPassword"),"123456abcD");

        //Accept Sining up Terms and conditions
        clickonElement(By.xpath("//*[@id=\"agree\"]/span[1]"));

        //Click on Register button
        clickonElement(By.xpath("//button[@id=\"register\"]"));

        // ASSERT USED TO MATCH IF EXPECTED AND ACTUAL
        String expected = "Welcome to Mockplus";
        String actual  = getTextfromElement1(By.xpath("//*[@id=\"chooseProduct\"]/div[1]/h1"));
        Assert.assertEquals("Failed",expected,actual);
    }

    //------------------------------------------------DOMINOS-----------------------------------------------------------

    // Using Junit annotation
    @Test

    public void registerDominos()
    {
        //Method Used for re-useability
        beforeTest();

        //Open the website
        driver.get("https://www.dominos.co.uk/");

        //Click on Register
        clickonElement(By.linkText("Register"));

        //Enter Username
        enterText(By.name("FirstName"),"Raju");

        //Enter Password
        enterText(By.name("Password"),"AAbb&22@453ghB");

        //Enter Phone number
        enterText(By.xpath("//input[@name=\"Telephone\"]"),"00000000094");

        //Enter Email address
        enterText(By.xpath("//input[@type=\"email\"]"),"Raju"+timeStamp()+"@gmail.com");

        //Do not wants to complete registration as unnecessary account will be created
        //Therefore wrong postcode entered to use Assert Method
        enterText(By.xpath("//input[@autocomplete=\"postcode lookup\"]"),"ABC");

        clickonElement(By.xpath("//a[@class=\"btn btn-primary single-line-postcode-button\"]"));

        //Click on Register
        clickonElement(By.xpath("//button[@type=\"submit\"]"));

        // ASSERT USED TO MATCH IF EXPECTED AND ACTUAL RESULT APPEARED BY ENTERING INCOMPLETE OR WRONG POSTCODE
        String expected = "Choose a valid postcode and click find button";
        String actual = getTextfromElement1(By.xpath("//*[@id=\"registerPanel\"]/div/form/div[1]/div[4]/span"));
        Assert.assertEquals("Failed",expected,actual);
    }

    //------------------------------------------------OCADO-------------------------------------------------------------
    @Test

    public void registerOcado()
    {
        //Method Used for re-useability
        beforeTest();

        //Open the website
        driver.get("https://www.ocado.com/");

        //Click on Register button
        clickonElement(By.linkText("Register"));

        //Select title using drop down value
        selectFromDropDownByValue(By.xpath("//select[@id=\"title\"]"),"Mr");

        //Enter Firstname
        enterText(By.id("firstName"),"John");

        //Enter Lastname
        enterText(By.id("lastName"),"Smith");

        //Enter email address
        enterText(By.xpath("//*[@id=\"login\"]"),"Abcd"+timeStamp()+"@hmail.com");

        //Enter password
        enterText(By.id("password"),"abcd4455ggggh");

        //Enter postcode
        enterText(By.id("postcode"),"UB5 4TT");

        //Click on Register button
        clickonElement(By.id("registration-submit-button"));

        // ASSERT USED TO MATCH IF EXPECTED AND ACTUAL
        String expected = "Thanks for registering";
        String actual = getTextfromElement1(By.xpath("//h3[@class=\"prp-heading prp-heading--small\"]"));
        Assert.assertEquals("Failed",expected,actual);
    }
}
//END OF PROGRAMME