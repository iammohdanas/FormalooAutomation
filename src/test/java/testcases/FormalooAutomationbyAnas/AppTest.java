package testcases.FormalooAutomationbyAnas;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testcases.FormalooAutomationbyAnas.RandomPhoneNo;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import junit.framework.Assert;


public class AppTest {
    
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aaana\\OneDrive\\Documents\\Atlan Automation\\tesntg pom\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dashboard.formaloo.com/u");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        };


    @Test
    public void verifyLoginPageTitle(){
        
        String actualTitle =  driver.getTitle();
        String expectedTitle = "Login into Formaloo";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    

    

    @Test
    public void LoginTest(){
        WebElement emailField = driver.findElement(By.xpath("//input[@id='id_username']"));
        emailField.sendKeys("aatricks372@gmail.com"); 
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='id_password']")); 
        passwordField.sendKeys("aatricks"); 
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='sign-in-btn']"));
        loginButton.click();
        String actualTitle =  driver.getTitle();
        String expectedTitle = "Formaloo - Dashboard";
        Assert.assertEquals(expectedTitle,actualTitle );
    }

    
    //Complete E-2-E Scenari Form creation -> Form Validation -> Result Dashboard  Data Validation -> Main Dashboard successful submission validation
    @Test
    public void VerifyCreateForm() throws AWTException, UnsupportedFlavorException, IOException{
        LoginTest();
        timer(10000);
        
        driver.findElement(By.xpath("//div[contains(@class,'create-blank-formaloo')]//div[1]")).click();
        timer(5000);
        String ActualtitleForm = driver.findElement(By.xpath("//div[@class='formz-input-title']")).getText();
        Assert.assertEquals("Title",ActualtitleForm);
        driver.findElement(By.xpath("//input[@class='formz-input-field']")).sendKeys("Job Application");
        String TitleInputText = driver.findElement(By.xpath("//input[@class='formz-input-field']")).getText();
        timer(1000);

        driver.findElement(By.xpath("//span[text()='Text']")).click();
        driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys("Name");         timer(2000);
        driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiTab-root')]")).click();
        driver.findElement(By.xpath("//span[text()='Text']")).click();
        driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]")).sendKeys("Your Academic Background"); timer(2000);
        driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiTab-root')]")).click();
        driver.findElement(By.xpath("//span[text()='Email']")).click();
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("E-Mail");         timer(2000);
        driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiTab-root')]")).click();
        timer(2000);
        driver.findElement(By.xpath("//span[text()='Phone']")).click();
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Contact Number"); timer(2000);
        driver.findElement(By.xpath("(//input[@class='formz-input-field'])[2]")).sendKeys("Submit");
        driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiTab-root')]")).click();
        driver.findElement(By.xpath("//div[@id='formz-tabpanel-0']/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Location"); timer(2000);
        driver.findElement(By.xpath("//div[text()='Save']")).click(); timer(5000);
        String savedTheChanges = driver.findElement(By.xpath("//p[text()='Saved the changes']")).getText();
        String ExpectedSavedChanges = "Saved the changes";
        Assert.assertEquals(ExpectedSavedChanges,savedTheChanges ); timer(2000);
        driver.findElement(By.xpath("//button[text()='Copy ']")).click();

        VerifySuccessSubmitForm2();
         
    }




    

    @Test
    public void LoginWithWrongCredentialTest(){
        WebElement emailField = driver.findElement(By.xpath("//input[@id='id_username']"));
        Random randomGenerator = new Random(); 
        int randomInt = randomGenerator.nextInt(1000); 
        emailField.sendKeys("username"+ randomInt +"@gmail.com"); 
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='id_password']")); 
        passwordField.sendKeys("password"); 
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='sign-in-btn']"));
        loginButton.click();
        WebElement errorvisible = driver.findElement(By.xpath("//li[normalize-space()='Invalid username or password.']"));
    }


     

    /*@Test
    public void CreatedForm(){
        LoginTest();
        driver.findElement(By.xpath("//img[@src='https://s3.amazonaws.com/formaloo-en/f/uploads/ur/b04c5304d29bbe4b/fm/PqRnkNrl/91cf7094-eea4-4d49-b719-67961c5b6c3d.JPG']")).click();
        
    }*/
    
    //E-2E scenario for successful form submission
    @Test
    public void VerifySuccessSubmitForm(){
        LoginTest();
        driver.get("https://anas-ansari-3372.formaloo.co/fylch");
        String[] names = {"Salman", "SRK", "Aamir", "Hrithik", "Saif"};
        String[] usernames = {"anas","gagan","mustafa","tariq","faizan"};

        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};

        Random rand = new Random();
        
        int randomIndex = rand.nextInt(names.length);
        int randomNameIndex = rand.nextInt(usernames.length);
        int randomDomainIndex = rand.nextInt(domains.length);
        String randomEmail = names[randomNameIndex] + rand.nextInt(1000) + "@" + domains[randomDomainIndex];
        String randomPhoneNumber = RandomPhoneNo.generateRandomPhoneNumber();

        
        driver.findElement(By.xpath("//input[contains(@class,'modern-view-global-styles_m-textfield__ZOOyk form-modern-input')]")).sendKeys(names[randomIndex]);
        driver.findElement(By.xpath("//input[@class='phone-number-input_form-input-phone-number__lPFxw form-theme-text--main']")).sendKeys(randomPhoneNumber);
        driver.findElement(By.xpath("(//input[contains(@class,'modern-view-global-styles_m-textfield__ZOOyk form-modern-input')])[2]")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//button[contains(@class,'form-components-style_form-button-submit__ZzOBZ form-theme-button')]")).click();
        
        String expectedReult ="Thanks! submitted successfully";
        String actualResult = driver.findElement(By.xpath("//p[text()='Thanks! submitted successfully']")).getText();
        Assert.assertEquals(actualResult, expectedReult);    
    }    
    

    //E-2E scenario for Data Update Validation
    @Test
    public void RealtimeDataUpdateValidationCheck(){
        LoginTest();
        driver.get("https://anas-ansari-3372.formaloo.co/fylch");
        String[] names = {"Salman Khan", "SRK", "Aamir Khan", "Saif","Amitabh Bachchan","Ranbir Kapoor","Hrithik Roshan","Akshay Kumar","Ranveer Singh","Varun Dhawan","Ajay Devgn"};
        String[] usernames = {"Anas","Gagan","Govind","Mustafa","Tariq","Faizan"};
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
        Random rand = new Random();
        int randomIndex = rand.nextInt(names.length);
        int randomNameIndex = rand.nextInt(usernames.length);
        int randomDomainIndex = rand.nextInt(domains.length);
        String randomEmail = usernames[randomNameIndex] + rand.nextInt(1000) + "@" + domains[randomDomainIndex];
        String randomPhoneNumber = RandomPhoneNo.generateRandomPhoneNumber();
        driver.findElement(By.xpath("//input[contains(@class,'modern-view-global-styles_m-textfield__ZOOyk form-modern-input')]")).sendKeys(names[randomIndex]);
        WebElement PhoneNumberInput = driver.findElement(By.xpath("//input[@class='phone-number-input_form-input-phone-number__lPFxw form-theme-text--main']"));
        PhoneNumberInput.sendKeys(randomPhoneNumber);
        WebElement EmailInput = driver.findElement(By.xpath("(//input[contains(@class,'modern-view-global-styles_m-textfield__ZOOyk form-modern-input')])[2]"));
        EmailInput.sendKeys(randomEmail);
        driver.findElement(By.xpath("//button[contains(@class,'form-components-style_form-button-submit__ZzOBZ form-theme-button')]")).click();
        timer(2000);
        driver.get("https://dashboard.formaloo.com/u");
        //handle this dynamic URL
        driver.findElement(By.xpath("//img[@src='https://s3.amazonaws.com/formaloo-en/f/uploads/ur/b04c5304d29bbe4b/fm/PqRnkNrl/91cf7094-eea4-4d49-b719-67961c5b6c3d.JPG']")).click();
        timer(20000);
        String ResultEmail = driver.findElement(By.xpath("//div[text()='"+randomEmail+"']")).getText();
        Assert.assertEquals(randomEmail,ResultEmail);
    }

    
    
    public void timer(int milsec){
        try {
            Thread.sleep(milsec); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void VerifySuccessSubmitForm2() throws UnsupportedFlavorException, IOException {
        Transferable clipboardContent = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (clipboardContent.isDataFlavorSupported(DataFlavor.stringFlavor)) {

                String copiedUrl = (String) clipboardContent.getTransferData(DataFlavor.stringFlavor);
                driver.get(copiedUrl);
        }
        
        try {
            driver.switchTo().alert().accept(); 
        } catch (Exception e) {
        }
        String randomPhoneNumber = RandomPhoneNo.generateRandomPhoneNumber();
        String[] usernames = {"Anas","Gagan","Govind","Mustafa","Tariq","Faizan","Salman Khan", "SRK", "Aamir Khan", "Saif","Amitabh Bachchan","Ranbir Kapoor","Hrithik Roshan"};
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
        Random rand = new Random();
        int randomNameIndex = rand.nextInt(usernames.length);
        int randomDomainIndex = rand.nextInt(domains.length);
        String randomEmail = usernames[randomNameIndex] + rand.nextInt(1000) + "@" + domains[randomDomainIndex];
        driver.findElement(By.xpath("//input[contains(@class,'modern-view-global-styles_m-textfield__ZOOyk form-modern-input')]")).sendKeys(usernames[randomNameIndex]);
        driver.findElement(By.xpath("(//input[contains(@class,'modern-view-global-styles_m-textfield__ZOOyk form-modern-input')])[2]")).sendKeys("BTech from Sharda University");
        driver.findElement(By.xpath("(//input[contains(@class,'modern-view-global-styles_m-textfield__ZOOyk form-modern-input')])[3]")).sendKeys(randomEmail);
        driver.findElement(By.xpath("//input[@class='phone-number-input_form-input-phone-number__lPFxw form-theme-text--main']")).sendKeys(randomPhoneNumber);
        WebElement locationIput = driver.findElement(By.xpath("//input[@class='dropdown_Select-control__Dfaep form-theme-text--main']"));
        locationIput.click();
        locationIput.sendKeys("Pilibhit"); timer(2000);
        driver.findElement(By.xpath("//button[contains(@class,'form-components-style_form-button-submit__ZzOBZ form-theme-button')]")).click();
        timer(2000);
        String expectedReult ="Thanks! submitted successfully";
        String actualResult = driver.findElement(By.xpath("//p[text()='Thanks! submitted successfully']")).getText();
        Assert.assertEquals(actualResult, expectedReult); 
        
    
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();

    }


}
