package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ReadProperties;

import java.io.IOException;

/**
 * @ClassName baiduSearch
 * @Description TODO
 * @Author zhongyang.he
 * @Date 2020/4/21 22:52
 **/
public class baiduSearch {

    public static void search(WebDriver driver,String s1) throws InterruptedException, IOException {
        driver.findElement(By.id(ReadProperties.getprop("element","elements","baiducontent"))).clear();
        Thread.sleep(2000);
        driver.findElement(By.id(ReadProperties.getprop("element","elements","baiducontent"))).sendKeys(s1);
        driver.findElement(By.id(ReadProperties.getprop("element","elements","baidusearch"))).click();
    }
}
