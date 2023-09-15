package automationExerciseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_LoginTest {

     /*
       1. Launch browser
       2. Navigate to url 'http://automationexercise.com'
       3. Verify that home page is visible successfully
       4. Click on 'Signup / Login' button
       5. Verify 'New User Signup!' is visible
       6. Enter name and email address
       7. Click 'Signup' button
       8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       9. Fill details: Title, Name, Email, Password, Date of birth
       10. Select checkbox 'Sign up for our newsletter!'
       11. Select checkbox 'Receive special offers from our partners!'
       12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       13. Click 'Create Account button'
       14. Verify that 'ACCOUNT CREATED!' is visible
       15. Click 'Continue' button
       16. Verify that 'Logged in as username' is visible
       17. Click 'Delete Account' button
       18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    public static void main(String[] args) {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitleL= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitleL);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserElement = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserElement.isDisplayed());

        //6. Enter name and email address
        String name = "mustafa";
        String email = "mustafa01@gmail.com";
        WebElement nameInput = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        nameInput.sendKeys(name);
        WebElement mailInput = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        mailInput.sendKeys(email);

       //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

       //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed());

       //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@type='radio' and @value='Mr']")).click();

        WebElement userName= driver.findElement(By.xpath("//input[@id='name']"));
        userName.clear();
        userName.sendKeys(name);

        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("password12345");

        WebElement date = driver.findElement(By.xpath("//*[@id='days']"));
        date.click();
        date.sendKeys("4");
        WebElement month = driver.findElement(By.xpath("//*[@id='days']"));
        month.click();
        month.sendKeys("March");
        WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
        year.click();
        year.sendKeys("1990");




        //10. Select checkbox 'Sign up for our newsletter!'
       //11. Select checkbox 'Receive special offers from our partners!'
       //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       //13. Click 'Create Account button'
       //14. Verify that 'ACCOUNT CREATED!' is visible
       //15. Click 'Continue' button
       //16. Verify that 'Logged in as username' is visible
       //17. Click 'Delete Account' button
       //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button









        driver.close();

    }
}