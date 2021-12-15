import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //1. Open your chrome browser
        driver = new ChromeDriver();
        //2. Input the Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test1. Verify the user inputs the right URL and is on the right Webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
        System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        //5. Input the username on the username field
        //Test7. Verify that user is successfully signed up when valid details are inputted
        driver.findElement(By.id("user_username")).sendKeys("Adegoroye");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("Adegoroye@malinator.com");
        //7. Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("Adegoroye123");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

        @Test (priority = 1)
        public void clickuser1Item() throws InterruptedException {
            //9. Click on User1 item on the listpage
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            //Test2. Verify that when user clicks on signup button, the user is directed to the signup page
            String expectedUrl =  "https://selenium-blog.herokuapp.com/signup";
            String actualUrl = driver.getCurrentUrl();
                    if(actualUrl.contains(expectedUrl))
                        //Pass
                        System.out.println("Correct Webpage");
                    else
                        //Fail
                        System.out.println("Wrong Webpage");
            Thread.sleep(5000);
        }

        @Test (priority = 2)
        public void verifyItem() throws InterruptedException {
            //10. Search for an item (using Python with Selenium) and confirm it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            //Test9. Verify that the item searched for on the user1 page is present
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
            String actualPageUrl = driver.getCurrentUrl();
            if (actualPageUrl.contains(expectedPageUrl))
                //Pass
                System.out.println("Correct User1page");
            else
                //Fail
                System.out.println("Wrong User1page");
            Thread.sleep(5000);
        }

        @Test (priority = 3)
                public void logoutSuccessfully(){
        //11. Click on Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
            //Test10. verify that when the user logout, he/she is directed back to the home page
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            if(actualTitle.contains(expectedTitle))
                //Pass
                System.out.println("Correct Webpage");
            else
                //Fail
                System.out.println("Wrong Webpage");

    }

    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Input the username on the username field
        //Test3. Verify that user cannot signup with username lesser than 3 characters
        driver.findElement(By.id("user_username")).sendKeys("To");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("Blessed@malinator.com");
        //7. Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("passwords");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void invalidEmail() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Input the username on the username field
        //Test4. Verify that user cannot signup with invalid Email address
        driver.findElement(By.id("user_username")).sendKeys("Israel");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("£$^@malinator.com");
        //7. Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("Oladimeji");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void invalidPassword() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Input the username on the username field
        //Test5. Verify that user cannot signup with password less than or equal to one character
        driver.findElement(By.id("user_username")).sendKeys("Mayowa");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("Mayowa@malinator.com");
        //7. Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("12");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 7)
    public void emptyFields() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Input the username on the username field
        //Test6. Verify that user cannot signp with all of the fields blank
        driver.findElement(By.id("user_username")).sendKeys("");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //7. Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 8)
    public void negativefield() throws InterruptedException {
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Click on Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. Input the username on the username field
        //Test6. Verify that user cannot signp with some of the fields blank
        driver.findElement(By.id("user_username")).sendKeys("Ayotomiwa");
        //6. Input an email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //7. Locate the password field and Input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @AfterTest
                public void closeBrowser(){
            //Quit the browser
            driver.quit();
        }
}
