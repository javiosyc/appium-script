package sauce_appium_junit.foreign;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import java.lang.InterruptedException;
import java.lang.Thread;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BuyForeignCurrencyTest {
  private IOSDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("app","/Users/esunbank/test-script/esun.app");
    capabilities.setCapability("showXcodeLog","true");
    capabilities.setCapability("noReset","false");
    capabilities.setCapability("platformVersion","11.0");
    capabilities.setCapability("deviceName","iPhone 7");
    driver= new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(12 ,TimeUnit.SECONDS);
  }

  @After
  public void tearDown() {
  }

  /**
   *
   *                ░░░░░░░░░ ░░                                        ░░░░▒▒░░░░░     ░░░░
   *           ░ ░████▓▓▓▓▓▓▓▓▓███▓░░                                ░██████████████░██▓▓▒▓▓░
   *         ░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▒                   ░ ░      ░███████████████████▓▓▓▓▓▓█
   *      ░▒█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░░             ░███░    ░██████▓▓▓▓▓▓▓▓▓███████▓▓▓█▓▓▒░
   *     ▒█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█░   ░▒▓    ██████░    ███████▓▓▓▓▓▓▓▓▓▓████████████▓
   *   ░█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓  ▒▒▓▓   ███████░░░███████████████████████████░▓█
   *  ░░█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█░       ░████████████████████████████████████░
   *  ░░█▓▓▓▓▓▓▓▓▓██▓▒░▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓▓░░▓▓▓▓▓█░       ██████████░░░▓█░██░░░░███████████████
   *  ░█▓▓▓▓▓░░░░ ░░░▒▓██▓▓▓▓▓▓▓░░░░░ ░░▒▓██▓▓▓▓▓▓        ████████▒░░░▓░▒█░░░░░█▓░█████████████░
   *  ░▓▓▓▓███████ ░████████▓▓████████ ░███████▓▓▓█░       ░███████▓░▒░░▒░░░░░▒█░░░██████████████░   ░▒█
   *  ░█▓▓▓▓▓▓░░▓▓ ░▓▓░ ░▓▓▓█▓█▓▓▓ ░▓▓ ░▓▓  ▓▓▓█▓▓█▒        ░███████░░░░██░░░░░░░░▒█▒░░░█████████████████
   *  █▓▓▓▓    ██  ██░ ░░▒▓▓▓▓░   ░██  █▓  ░░█▓▓▓▓▓       ░░░██████░░░▒█░▒░░░██░░░░▒░░░█████████████████
   *  █▓▓▓▓██  ██  ██░ ░███▓▓▓███ ░██  █▓  ███▓▓▓█▓       ░░░░░▒░░░▓░░░▒▒▒░▒██░░░░░░▒▒█████████████████░
   *  █▓▓▓▓░░   ░  ██░ ░░ ░▓▓█▒░  ░░▒  █▓░ ░  █▓▓█░       ░░░░░░  ███░░▒░▒▒▒░░░░░▓██████████████████▒
   *  ▓█▓▓░▓███▓▓  ██▓█▓▓▓█▓▓█▓████▓▓  █▓█▓▓▓██▓▓█░          ░░░░░▒▒▒░░▒░░░░░░▒████████▒█████████░
   *  ░█▓▓▓▓▓▓▓▓▓  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  █▓▓▓▓▓▓▓▓█▒             ░▓▓▓▓░░░░▒░░░░▒▒▓▓▓▓░░ ░░███▒░
   *  ░█▓▓▓▓▓▓▓▓ ░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ░█▓▓▓▓▓▓▓▓█                  ░▒▒▒▓▒░░░▒▒▒▓▓▓░░░  ░░
   *  █▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██                   ▒▒▒▓░▓▒▒▒▒▒▓░ ░░░░ ░░░░░
   *  ░██▓▓▓▓▓▓▒░░▓░▓▒▓░▓░▓▓▓▓▒▓▓▒▓▓▓▓▓▓▓▓█▒                    ▓▒▒▒▒▓▒▒▒▒▒▒▓     ░░░░░
   *   ░░█▓▓▓▓▓░░░▓░▓▓░░▒░▓▓░▓▒▓░▒░▒▓▓▓▓██░                      ▓▓▓▓▓▓▓▓▓▓▓▓░
   *     ░░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓░                   ░░   ░▓▓▓▓▓ ▓▓▓▓▓▓░
   *         ▒██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░                   ░▒▒▒▒▒▒▒▒▓▒░▓    ░░░░▒▓▒▒▒▒▒▒▒▒▓░
   *            ░░▓█████▓▓▓█████▒░                     ░▓▒▒▒▒▒▒▒▒▒▒▓▓▓░     ▒▓▓▓▓▒▒▒▒▒▒▒▒▓░░
   *
   */
  @Test
  public void buyForeignCurrencyFailed() {
    // Given 首次啟用App，同意推播，按下『Allow』 ByName [Allow, click] 
    driver.findElement(By.name("Allow")).click();
    // And 輸入『身分證字號』 ByName [身分證字號, sendKeys, #{一般自然人_未開通OTP.pid}] 
    driver.findElement(By.name("身分證字號")).sendKeys("A183364168");
    // And 輸入『使用者名稱』 ByName [使用者名稱, sendKeys, #{一般自然人_未開通OTP.userName}] 
    driver.findElement(By.name("使用者名稱")).sendKeys("mbl001");
    // And 輸入『密碼』 ByName [使用者密碼, sendKeys, #{一般自然人_未開通OTP.password}] 
    driver.findElement(By.name("使用者密碼")).sendKeys("esb3131");
    // And 等『WebView loading….』 Waiting [10.0] 
    try { 
    	Thread.sleep(10* 1000);
    }catch(InterruptedException e) { e.printStackTrace();
    }
    // And 按下『完成』 ByName [完成, click] 
    driver.findElement(By.name("完成")).click();
    // And 按下『登入』 ByName [登入, click] 
    driver.findElement(By.name("登入")).click();
    // And 按下『略過』 ByName [略過, click] 
    driver.findElement(By.name("略過")).click();
    // And 按下『確定』 ByName [確定, click] 
    driver.findElement(By.name("確定")).click();
    // And 按下『完成』 ByName [完成, click] 
    driver.findElement(By.name("完成")).click();
    // And 按下『我知道了 !』 ByName [我知道了 !, click] 
    driver.findElement(By.name("我知道了 !")).click();
    // And 按下側邊欄『side menu btn』按鈕 ByName [side menu btn, click] 
    driver.findElement(By.name("side menu btn")).click();
    // When 按下側邊欄『外幣匯兌』按鈕 ByName [外幣匯兌, click] 
    driver.findElement(By.name("外幣匯兌")).click();
    // And 按下側邊欄『買外幣』按鈕 ByName [買外幣, click] 
    driver.findElement(By.name("買外幣")).click();
    // And 等『WebView loading….』 Waiting [10.0] 
    try { 
    	Thread.sleep(10* 1000);
    }catch(InterruptedException e) { e.printStackTrace();
    }
    // And 滑動 TouchAction [] 
    (new TouchAction(driver)).press(180,500).moveTo(0,-400).release().perform();
    // And 按下『我已閱讀並同意上述規範』 ByXPath [//XCUIElementTypeButton[@name=\"我已閱讀並同意上述規範\"], click] 
    driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"我已閱讀並同意上述規範\"]")).click();
    // And 點選『輸入金額欄位』 ByXPath [//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeTextField, click] 
    driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeTextField")).click();
    // And 輸入等值購買外幣之『台幣金額』 ByXPath [//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeTextField, sendKeys, 100000.0] 
    driver.findElement(By.name("//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeTextField")).sendKeys("100000.0");
    // And 按下『下一步』進入交易確認頁 ByName [下一步, click] 
    driver.findElement(By.name("下一步")).click();
    // And 按下『確定』進行交易 ByName [確定, click] 
    driver.findElement(By.name("確定")).click();
    // Then 結果餘額不足，故交易失敗 ByName [餘額不足] 
    List<MobileElement> expectedElements = driver.findElements(By.name("餘額不足"));
    assertThat(expectedElements.size(), equalTo(1));
  }

  /**
   *
   *                ░░░░░░░░░ ░░                                        ░░░░▒▒░░░░░     ░░░░
   *           ░ ░████▓▓▓▓▓▓▓▓▓███▓░░                                ░██████████████░██▓▓▒▓▓░
   *         ░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▒                   ░ ░      ░███████████████████▓▓▓▓▓▓█
   *      ░▒█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░░             ░███░    ░██████▓▓▓▓▓▓▓▓▓███████▓▓▓█▓▓▒░
   *     ▒█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█░   ░▒▓    ██████░    ███████▓▓▓▓▓▓▓▓▓▓████████████▓
   *   ░█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓  ▒▒▓▓   ███████░░░███████████████████████████░▓█
   *  ░░█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█░       ░████████████████████████████████████░
   *  ░░█▓▓▓▓▓▓▓▓▓██▓▒░▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓▓░░▓▓▓▓▓█░       ██████████░░░▓█░██░░░░███████████████
   *  ░█▓▓▓▓▓░░░░ ░░░▒▓██▓▓▓▓▓▓▓░░░░░ ░░▒▓██▓▓▓▓▓▓        ████████▒░░░▓░▒█░░░░░█▓░█████████████░
   *  ░▓▓▓▓███████ ░████████▓▓████████ ░███████▓▓▓█░       ░███████▓░▒░░▒░░░░░▒█░░░██████████████░   ░▒█
   *  ░█▓▓▓▓▓▓░░▓▓ ░▓▓░ ░▓▓▓█▓█▓▓▓ ░▓▓ ░▓▓  ▓▓▓█▓▓█▒        ░███████░░░░██░░░░░░░░▒█▒░░░█████████████████
   *  █▓▓▓▓    ██  ██░ ░░▒▓▓▓▓░   ░██  █▓  ░░█▓▓▓▓▓       ░░░██████░░░▒█░▒░░░██░░░░▒░░░█████████████████
   *  █▓▓▓▓██  ██  ██░ ░███▓▓▓███ ░██  █▓  ███▓▓▓█▓       ░░░░░▒░░░▓░░░▒▒▒░▒██░░░░░░▒▒█████████████████░
   *  █▓▓▓▓░░   ░  ██░ ░░ ░▓▓█▒░  ░░▒  █▓░ ░  █▓▓█░       ░░░░░░  ███░░▒░▒▒▒░░░░░▓██████████████████▒
   *  ▓█▓▓░▓███▓▓  ██▓█▓▓▓█▓▓█▓████▓▓  █▓█▓▓▓██▓▓█░          ░░░░░▒▒▒░░▒░░░░░░▒████████▒█████████░
   *  ░█▓▓▓▓▓▓▓▓▓  ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓  █▓▓▓▓▓▓▓▓█▒             ░▓▓▓▓░░░░▒░░░░▒▒▓▓▓▓░░ ░░███▒░
   *  ░█▓▓▓▓▓▓▓▓ ░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ░█▓▓▓▓▓▓▓▓█                  ░▒▒▒▓▒░░░▒▒▒▓▓▓░░░  ░░
   *  █▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██                   ▒▒▒▓░▓▒▒▒▒▒▓░ ░░░░ ░░░░░
   *  ░██▓▓▓▓▓▓▒░░▓░▓▒▓░▓░▓▓▓▓▒▓▓▒▓▓▓▓▓▓▓▓█▒                    ▓▒▒▒▒▓▒▒▒▒▒▒▓     ░░░░░
   *   ░░█▓▓▓▓▓░░░▓░▓▓░░▒░▓▓░▓▒▓░▒░▒▓▓▓▓██░                      ▓▓▓▓▓▓▓▓▓▓▓▓░
   *     ░░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓░                   ░░   ░▓▓▓▓▓ ▓▓▓▓▓▓░
   *         ▒██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░                   ░▒▒▒▒▒▒▒▒▓▒░▓    ░░░░▒▓▒▒▒▒▒▒▒▒▓░
   *            ░░▓█████▓▓▓█████▒░                     ░▓▒▒▒▒▒▒▒▒▒▒▓▓▓░     ▒▓▓▓▓▒▒▒▒▒▒▒▒▓░░
   *
   */
  @Test
  public void buyForeignCurrencyFailed_1() {
    // Given 首次啟用App，同意推播，按下『Allow』 ByName [Allow, click] 
    driver.findElement(By.name("Allow")).click();
    // And 輸入『身分證字號』 ByName [身分證字號, sendKeys, #{一般自然人_未開通OTP.pid}] 
    driver.findElement(By.name("身分證字號")).sendKeys("A183364168");
    // And 輸入『使用者名稱』 ByName [使用者名稱, sendKeys, #{一般自然人_未開通OTP.userName}] 
    driver.findElement(By.name("使用者名稱")).sendKeys("mbl001");
    // And 輸入『密碼』 ByName [使用者密碼, sendKeys, #{一般自然人_未開通OTP.password}] 
    driver.findElement(By.name("使用者密碼")).sendKeys("esb3131");
    // And 等『WebView loading….』 Waiting [10.0] 
    try { 
    	Thread.sleep(10* 1000);
    }catch(InterruptedException e) { e.printStackTrace();
    }
    // And 按下『完成』 ByName [完成, click] 
    driver.findElement(By.name("完成")).click();
    // And 按下『登入』 ByName [登入, click] 
    driver.findElement(By.name("登入")).click();
    // And 按下『略過』 ByName [略過, click] 
    driver.findElement(By.name("略過")).click();
    // And 按下『確定』 ByName [確定, click] 
    driver.findElement(By.name("確定")).click();
    // And 按下『完成』 ByName [完成, click] 
    driver.findElement(By.name("完成")).click();
    // And 按下『我知道了 !』 ByName [我知道了 !, click] 
    driver.findElement(By.name("我知道了 !")).click();
    // And 滑動 TouchAction [] 
    (new TouchAction(driver)).press(180,500).moveTo(0,-400).release().perform();
  }
}
