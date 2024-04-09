package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Abstractgeneric{
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//*[@data-test=\"ModalCloseButton\"]")
	WebElement closepopup;
	
	
	
	
	
	public void closepopup(int waittime) {
		waittovisible(waittime, closepopup);
		closepopup.click();
	}

}
