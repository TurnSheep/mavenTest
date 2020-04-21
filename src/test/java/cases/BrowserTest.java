package cases;

import dataread.RangeDatabyPOI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;


/**
 * @ClassName BrowserTest
 * @Description TODO
 * @Author zhongyang.he
 * @Date 2020/4/18 19:26
 **/
public class BrowserTest {
    WebDriver dr;
    @DataProvider(name="muke")
    public Object[][] getData() throws IOException {
        String path="E:/test.xlsx";
        Object[][] array= RangeDatabyPOI.poiRangeData(path);
        return array;
    }

    @Parameters({"browser","url"})
    @BeforeTest
    public void beforetest(String browser,String url){
        System.out.println("I'm BeforeTest");

        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            dr= new ChromeDriver();
        }
        else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "D:\\Firefox\\geckodriver.exe");
            dr= new FirefoxDriver();
        }
        else if (browser.equals("edge")){

        }
        else if (browser.equals("ie")){

        }
        else{
        }
        dr.manage().window().maximize();
        dr.get(url);
    }

    @Test(dataProvider="muke")
    public void browser(String s1,String s2) throws InterruptedException{
        dr.findElement(By.id("kw")).clear();
        Thread.sleep(2000);
        dr.findElement(By.id("kw")).sendKeys(s1);
        dr.findElement(By.id("su")).click();
        Thread.sleep(2000);
        dr.findElement(By.id("kw")).clear();
        Thread.sleep(2000);
        dr.findElement(By.id("kw")).sendKeys(s2);
        dr.findElement(By.id("su")).click();
        Thread.sleep(2000);
    }

    @AfterTest
    public void quit(){
        dr.quit();
    }
}
