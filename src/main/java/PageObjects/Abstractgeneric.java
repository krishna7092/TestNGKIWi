package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractgeneric {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//*[@class=\"hidden de:block\"] //*[text()='Cars']")
	WebElement cars;
	
	
	public Carpage clickcar() {
		cars.click();
		return new Carpage(driver);
	}
	
	
	public Abstractgeneric(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	





	public void waittovisible(int time,WebElement web) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(web));
		
	}

}
