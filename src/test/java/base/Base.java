package base;

import PageObjects.HomePage;
import genericutils.Genericmethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    static Properties prop;
   public  WebDriver driver;
    public Genericmethods generic;
    public HomePage homePage;

   static{
       System.out.println("first static");
       prop =new Properties();
       try {
           prop.load(new FileInputStream("src/main/resources/global properties/global.properties"));
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       ;

   }
    public WebDriver initilaize(){
       System.out.println(" intialize");
       if(prop.getProperty("Browser").equalsIgnoreCase("chrome")){
           driver=new ChromeDriver();
       }else{
           driver=new EdgeDriver();
       }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        generic=new Genericmethods(driver);
        return driver;

    }
    //if we mention as groups in xml this method also we need to include the groups so this will work
    // because this also method which we need to tag for group
    //so soln for this we can mention alwaysrun =true
    @BeforeMethod(alwaysRun = true)
    public void launchbrowser(){
        WebDriver driver = initilaize();
        driver.get(prop.getProperty("URL"));
        homePage=new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.quit();
    }

    @BeforeMethod(groups = "devtools")
    public void devtools(){
       //driver change into chrome detools
    }
}
