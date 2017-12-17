package com.esun.automation.module.login;

import generator.test.utils.CommandUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import java.lang.InterruptedException;
import java.lang.String;
import java.lang.Thread;
import org.openqa.selenium.By;

/**
 * 登入步驟
 */
public class LoginScenarios {
  /**
   * 首次登入略過綁定
   *
   * @param driver
   * @param userName
   * @param password
   * @param pid
   * @param implicitlyWaitSec
   * @return
   */
  public static void firstLoginBypassBundle(IOSDriver<MobileElement> driver, String userName,
      String password, String pid, long implicitlyWaitSec) {
    // 首次啟用App，同意推播，按下『Allow』 ByName [Allow, click]
    driver.findElement(By.name("Allow")).click();
    // 輸入『身分證字號』 ByName [身分證字號, sendKeys, ${pid}]
    driver.findElement(By.name("身分證字號")).sendKeys(pid);
    // 輸入『使用者名稱』 ByName [使用者名稱, sendKeys, ${userName}]
    driver.findElement(By.name("使用者名稱")).sendKeys(userName);
    // 輸入『密碼』 ByName [使用者密碼, sendKeys, ${password}]
    driver.findElement(By.name("使用者密碼")).sendKeys(password);
    // 輸入『圖形驗證碼』 Waiting [10]
    try { 
    	Thread.sleep(10* 1000);
    }catch(InterruptedException e) { e.printStackTrace();
    }
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『登入』 ByName [登入, click]
    driver.findElement(By.name("登入")).click();
    // 檢查重複登入 CheckAlert [確定]
    CommandUtils.presenceClick(driver,2L,"確定",implicitlyWaitSec );
    // 延長密碼判斷 CheckAlert [繼續使用原密碼]
    CommandUtils.presenceClick(driver,2L,"繼續使用原密碼",implicitlyWaitSec );
    // 按下『略過』 ByName [略過, click]
    driver.findElement(By.name("略過")).click();
    // 按下『確定』略過綁定流程 ByName [確定, click]
    driver.findElement(By.name("確定")).click();
    // 按下『完成』略過綁定流程 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『我知道了 !』略過綁定流程 ByName [我知道了 !, click]
    driver.findElement(By.name("我知道了 !")).click();
  }

  /**
   * 首次登入綁定流程(啟用TouchID)
   *
   * @param driver
   * @param userName
   * @param password
   * @param pid
   * @param implicitlyWaitSec
   * @return
   */
  public static void firstLoginBundleTouchIDEnable(IOSDriver<MobileElement> driver, String userName,
      String password, String pid, long implicitlyWaitSec) {
    // 首次啟用App，同意推播，按下『Allow』 ByName [Allow, click]
    driver.findElement(By.name("Allow")).click();
    // 輸入『身分證字號』 ByName [身分證字號, sendKeys, ${pid}]
    driver.findElement(By.name("身分證字號")).sendKeys(pid);
    // 輸入『使用者名稱』 ByName [使用者名稱, sendKeys, ${userName}]
    driver.findElement(By.name("使用者名稱")).sendKeys(userName);
    // 輸入『密碼』 ByName [使用者密碼, sendKeys, ${password}]
    driver.findElement(By.name("使用者密碼")).sendKeys(password);
    // 輸入『圖形驗證碼』 ByName [驗證碼, sendKeys, 12345]
    driver.findElement(By.name("驗證碼")).sendKeys("12345");
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『登入』 ByName [登入, click]
    driver.findElement(By.name("登入")).click();
    // 按下『開始設定』 ByName [開始設定, click]
    driver.findElement(By.name("開始設定")).click();
    // 輸入『綁定碼』  [簡訊綁定碼]
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『綁定此裝置』 ByName [綁定此裝置, click]
    driver.findElement(By.name("綁定此裝置")).click();
    // 按下『開始設定』 ByName [開始設定, click]
    driver.findElement(By.name("開始設定")).click();
    // 輸入『簡易密碼』 ByName [XXXX, sendKeys, 111111]
    driver.findElement(By.name("XXXX")).sendKeys("111111");
    // 輸入『簡易密碼』 ByName [XXXX, sendKeys, 111111]
    driver.findElement(By.name("XXXX")).sendKeys("111111");
    // 按下『啟用Touch ID』 ByName [啟用Touch ID, click]
    driver.findElement(By.name("啟用Touch ID")).click();
    // 按下『確定』 ByName [確定, click]
    driver.findElement(By.name("確定")).click();
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『我知道了 !』開始使用App ByName [我知道了 !, click]
    driver.findElement(By.name("我知道了 !")).click();
  }

  /**
   * 首次直接體驗
   *
   * @param driver
   * @param userName
   * @param password
   * @param pid
   * @param implicitlyWaitSec
   * @return
   */
  public static void firstLoginTryit(IOSDriver<MobileElement> driver, String userName,
      String password, String pid, long implicitlyWaitSec) {
    // 首次啟用App，同意推播，按下『Allow』 ByName [Allow, click]
    driver.findElement(By.name("Allow")).click();
    // 按下『直接開始體驗』 ByName [直接開始體驗, click]
    driver.findElement(By.name("直接開始體驗")).click();
    // 按下『完成』略過綁定流程 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『我知道了 !』開始使用App ByName [我知道了 !, click]
    driver.findElement(By.name("我知道了 !")).click();
  }

  /**
   * 首次登入綁定流程(不啟用TouchID)
   *
   * @param driver
   * @param userName
   * @param password
   * @param pid
   * @param implicitlyWaitSec
   * @return
   */
  public static void firstLoginBundleTouchIDUnable(IOSDriver<MobileElement> driver, String userName,
      String password, String pid, long implicitlyWaitSec) {
    // 首次啟用App，同意推播，按下『Allow』 ByName [Allow, click]
    driver.findElement(By.name("Allow")).click();
    // 輸入『身分證字號』 ByName [身分證字號, sendKeys, ${pid}]
    driver.findElement(By.name("身分證字號")).sendKeys(pid);
    // 輸入『使用者名稱』 ByName [使用者名稱, sendKeys, ${userName}]
    driver.findElement(By.name("使用者名稱")).sendKeys(userName);
    // 輸入『密碼』 ByName [使用者密碼, sendKeys, ${password}]
    driver.findElement(By.name("使用者密碼")).sendKeys(password);
    // 輸入『圖形驗證碼』 ByName [驗證碼, sendKeys, 12345]
    driver.findElement(By.name("驗證碼")).sendKeys("12345");
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『登入』 ByName [登入, click]
    driver.findElement(By.name("登入")).click();
    // 按下『開始設定』 ByName [開始設定, click]
    driver.findElement(By.name("開始設定")).click();
    // 輸入『綁定碼』  [簡訊綁定碼]
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『綁定此裝置』 ByName [綁定此裝置, click]
    driver.findElement(By.name("綁定此裝置")).click();
    // 按下『開始設定』 ByName [開始設定, click]
    driver.findElement(By.name("開始設定")).click();
    // 輸入『簡易密碼』 ByName [XXXX, sendKeys, 111111]
    driver.findElement(By.name("XXXX")).sendKeys("111111");
    // 輸入『簡易密碼』 ByName [XXXX, sendKeys, 111111]
    driver.findElement(By.name("XXXX")).sendKeys("111111");
    // 按下『暫不使用』 ByName [暫不使用, click]
    driver.findElement(By.name("暫不使用")).click();
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『我知道了 !』開始使用App ByName [我知道了 !, click]
    driver.findElement(By.name("我知道了 !")).click();
  }

  /**
   * 非首次(綁定)-簡易密碼
   *
   * @param driver
   * @param userName
   * @param password
   * @param pid
   * @param implicitlyWaitSec
   * @return
   */
  public static void notFirstLoginByEasypwd(IOSDriver<MobileElement> driver, String userName,
      String password, String pid, long implicitlyWaitSec) {
    // 輸入『簡易密碼』 ByName [1, sendKeys, 111111]
    driver.findElement(By.name("1")).sendKeys("111111");
  }

  /**
   * 非首次(綁定)-網銀登入
   *
   * @param driver
   * @param userName
   * @param password
   * @param pid
   * @param implicitlyWaitSec
   * @return
   */
  public static void notFirstLoginByEnterinfoBundle(IOSDriver<MobileElement> driver,
      String userName, String password, String pid, long implicitlyWaitSec) {
    // 按下『網銀登入』 ByName [Allow, click]
    driver.findElement(By.name("Allow")).click();
    // 輸入『身分證字號』 ByName [身分證字號, sendKeys, ${pid}]
    driver.findElement(By.name("身分證字號")).sendKeys(pid);
    // 輸入『使用者名稱』 ByName [使用者名稱, sendKeys, ${userName}]
    driver.findElement(By.name("使用者名稱")).sendKeys(userName);
    // 輸入『密碼』 ByName [使用者密碼, sendKeys, ${password}]
    driver.findElement(By.name("使用者密碼")).sendKeys(password);
    // 輸入『圖形驗證碼』 ByName [驗證碼, sendKeys, 12345]
    driver.findElement(By.name("驗證碼")).sendKeys("12345");
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『登入』 ByName [登入, click]
    driver.findElement(By.name("登入")).click();
  }

  /**
   * 非首次(未綁定)-網銀登入
   *
   * @param driver
   * @param userName
   * @param password
   * @param pid
   * @param implicitlyWaitSec
   * @return
   */
  public static void notFirstLoginByEnterinfoUnbundle(IOSDriver<MobileElement> driver,
      String userName, String password, String pid, long implicitlyWaitSec) {
    // 輸入『身分證字號』 ByName [身分證字號, sendKeys, ${pid}]
    driver.findElement(By.name("身分證字號")).sendKeys(pid);
    // 輸入『使用者名稱』 ByName [使用者名稱, sendKeys, ${userName}]
    driver.findElement(By.name("使用者名稱")).sendKeys(userName);
    // 輸入『密碼』 ByName [使用者密碼, sendKeys, ${password}]
    driver.findElement(By.name("使用者密碼")).sendKeys(password);
    // 輸入『圖形驗證碼』 Waiting [10]
    try { 
    	Thread.sleep(10* 1000);
    }catch(InterruptedException e) { e.printStackTrace();
    }
    // 按下『完成』 ByName [完成, click]
    driver.findElement(By.name("完成")).click();
    // 按下『登入』 ByName [登入, click]
    driver.findElement(By.name("登入")).click();
  }

  /**
   * 非首次登入-直接體驗
   *
   * @param driver
   * @param userName
   * @param password
   * @param pid
   * @param implicitlyWaitSec
   * @return
   */
  public static void notfirstLoginTryit(IOSDriver<MobileElement> driver, String userName,
      String password, String pid, long implicitlyWaitSec) {
    // 按下『直接開始體驗』 ByName [直接開始體驗, click]
    driver.findElement(By.name("直接開始體驗")).click();
  }
}
