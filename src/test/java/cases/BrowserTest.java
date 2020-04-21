package cases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import tasks.baiduSearch;
import util.Browser;
import util.RangeDatabyPOI;

import java.io.IOException;


/**
 * @ClassName BrowserTest
 * @Description TODO
 * @Author zhongyang.he
 * @Date 2020/4/18 19:26
 **/
public class BrowserTest {
    WebDriver driver;
    @DataProvider(name="muke")
    public Object[][] getData() throws IOException {
        String path="E:/test.xlsx";
        Object[][] array= RangeDatabyPOI.poiRangeData(path);
        return array;
    }

    @Parameters({"browser","url"})
    @BeforeTest
    public void beforetest(String browser,String url){
        driver= Browser.OpenBrowser(driver,browser,url);

    }

    @Test(dataProvider="muke")
    public void browser(String s1,String s2) throws InterruptedException, IOException {
        baiduSearch.search(driver,s1);
        baiduSearch.search(driver,s2);
    }

    @AfterTest
    public void quit(){
        Browser.CloseBrowser(driver);
    }
}
