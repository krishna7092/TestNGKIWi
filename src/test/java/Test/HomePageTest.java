package Test;

import base.Base;
import genericutils.staticutils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class HomePageTest extends Base {



    @Test(dataProvider = "testdata")
    public void launch(HashMap map){
        System.out.println("client : " +map.get("client") + "password: " + map.get("pass"));
        homePage.closepopup(4);
    }

    @DataProvider
    public Object[][] testdata() throws IOException {

        //need to get it from json
        HashMap<String,String> map=new HashMap<>();
        map.put("client","amazon123");
        map.put("pass","123Test");

        HashMap<String,String> map2=new HashMap<>();
        map2.put("client","amazon123");
        map2.put("pass","123Test");
        List<HashMap<String, String>> jsonreader = staticutils.jsonreader();
        //return new Object[][]{{map},{map2}};
       return new Object[][]{{jsonreader.get(0)},{jsonreader.get(1)}};
    }
}
