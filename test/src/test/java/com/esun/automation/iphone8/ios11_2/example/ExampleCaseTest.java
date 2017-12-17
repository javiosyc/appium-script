package com.esun.automation.iphone8.ios11_2.example;

import static org.junit.Assert.*;

import com.esun.automation.module.login.LoginScenarios;
import generator.test.annotation.NoResetSetting;
import generator.test.rules.ExceptionRule;
import generator.test.rules.NoResetSettingRule;
import generator.test.rules.UserLoginTestRule;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import java.lang.Integer;
import java.lang.String;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ExampleCaseTest {
  private IOSDriver<MobileElement> driver;

  @Rule
  public ExceptionRule exceptionRule = new ExceptionRule();

  @Rule
  public NoResetSettingRule noResetSettingRule = new NoResetSettingRule();

  @Rule
  public UserLoginTestRule userLoginTestRule = new UserLoginTestRule();

  private String userName;

  private String pid;

  private String password;

  private Integer width;

  private Integer height;

  private long implicitlyWaitSec;

  /**
   * <pre>
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
   * </pre>
   */
  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("app","/Users/cyndi/Downloads/esun.app");
    if (noResetSettingRule.isNoReset()!=null) {
      capabilities.setCapability("noReset", noResetSettingRule.isNoReset());
    }
    else {
      capabilities.setCapability("noReset", true);
    }
    capabilities.setCapability("platformVersion","11.2");
    capabilities.setCapability("deviceName","iPhone 8");
    driver= new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    implicitlyWaitSec= 10;
    driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
    width = driver.manage().window().getSize().getWidth();
    height = driver.manage().window().getSize().getHeight();
    if(userLoginTestRule.getHasUser()) {
      userName=userLoginTestRule.getUserName();
      pid=userLoginTestRule.getPid();
      password=userLoginTestRule.getPassword();
    }
    exceptionRule.setDriver(driver);
  }

  @After
  public void tearDown() {
  }

  /**
   * 測試情境說明
   */
  @Test
  @NoResetSetting(
      noReset = false
  )
  public void exampleScenario() {
    // Given 首次登入略過綁定 以什麼方式找元件 [欲操作之元件名稱, 對元件執行什麼動作, 傳送/設定什麼值]
    LoginScenarios.firstLoginBypassBundle(driver,userName,password,pid,implicitlyWaitSec);
    // Given 一般自然人_延長密碼戶  []
    // When  ByName [click]
    // Then  ByName [click]
    List<MobileElement> expectedElements = driver.findElements(By.name("click"));
    assertTrue(expectedElements.size() >0);
  }

  /**
   * 測試情境說明
   */
  @Test
  public void exampleScenario_noRest() {
    // Given 一般自然人_延長密碼戶  []
    // When  ByName [click]
    // Then  ByName [click]
    List<MobileElement> expectedElements = driver.findElements(By.name("click"));
    assertTrue(expectedElements.size() >0);
  }
}
