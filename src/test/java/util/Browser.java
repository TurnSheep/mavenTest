package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @ClassName Browser
 * @Description TODO
 * @Author zhongyang.he
 * @Date 2020/4/21 22:40
 **/
public class Browser {
    public static void main(String[] args) {

    }

    public static WebDriver OpenBrowser(WebDriver driver,String browser,String url){
        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            driver= new ChromeDriver();
        }
        else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "D:\\Firefox\\geckodriver.exe");
            driver= new FirefoxDriver();
        }
        else if (browser.equals("edge")){

        }
        else if (browser.equals("ie")){

        }
        else{
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static void CloseBrowser(WebDriver driver){
        driver.quit();
    }
}
