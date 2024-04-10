package Test;

import Listeners.Retry;
import PageObjects.Carpage;
import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarPageTest extends Base {
    Carpage clickcar;



    @Test(groups = {"smoke","sanity"})
    public void switchtocar(){
        homePage.closepopup(5);
        homePage.clickcar();

        generic.switchwindow("child");


    }


    @Test (retryAnalyzer = Retry.class)//here depends on wont make sence i just mentioned here
    public void currency(){
        homePage.closepopup(5);
        clickcar=homePage.clickcar();
        generic.switchwindow("child");
        String currenytext=clickcar.getcurrencytext();
        Assert.assertEquals(currenytext,"hello");
    }


}
