package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Carpage extends Abstractgeneric {
	
	
	public Carpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);

		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css = "[data-testid=\"currency-button\"]")
	WebElement currenytext;
	
	
	
	
	
	public String getcurrencytext() {
		waittovisible(5, currenytext);

		return currenytext.getText();
	}

}
