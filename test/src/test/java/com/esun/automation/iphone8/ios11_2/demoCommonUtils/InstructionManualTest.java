package com.esun.automation.iphone8.ios11_2.demoCommonUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.esun.automation.module.login.LoginScenarios;

import generator.test.annotation.NoResetSetting;
import generator.test.annotation.TestingAccount;
import generator.test.rules.ExceptionRule;
import generator.test.rules.NoResetSettingRule;
import generator.test.rules.UserLoginTestRule;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

public class InstructionManualTest {
	@Rule
	public ExceptionRule exceptionRule = new ExceptionRule();

	@Rule
	public NoResetSettingRule rule = new NoResetSettingRule();

	@Rule
	public UserLoginTestRule userRule = new UserLoginTestRule();

	private IOSDriver<MobileElement> driver;

	private Integer height;

	private long implicitlyWaitSec;

	private String password;

	private String pid;

	private String userName;

	private Integer width;

	/**
	 * 清除
	 */
	@Test
	public void commonUtilClear() {
		// Given 首次啟用App，同意推播，按下『Allow』 ByName [Allow, click]
		driver.findElement(By.name("Allow")).click();
		// Given 輸入身分證字號 ByName [身分證字號, sendKeys, 輸入身分證]
		driver.findElement(By.name("身分證字號")).sendKeys("輸入身分證");
		// Given 輸入使用者名稱 ByName [使用者名稱, sendKeys, 輸入使用者名稱]
		driver.findElement(By.name("使用者名稱")).sendKeys("輸入使用者名稱");
		// When 輸入密碼 ByName [使用者密碼, sendKeys, 輸入使用者密碼]
		driver.findElement(By.name("使用者密碼")).sendKeys("輸入使用者密碼");
		// When 清除身分證字號 ByName [身分證字號, clear]
		driver.findElement(By.name("身分證字號")).clear();
		// When 清除使用者名稱 ByName [使用者名稱, clear]
		driver.findElement(By.name("使用者名稱")).clear();
		// When 清除密碼 ByName [使用者密碼, clear]
		driver.findElement(By.name("使用者密碼")).clear();
	}

	/**
	 * 買外幣選擇多種幣別切換下拉式選單
	 */
	@Test
	@NoResetSetting(noReset = false)
	@TestingAccount(userName = "esundemo", password = "zxcvbnm1313", pid = "F227424600")
	public void commonUtilPicker() {
		// Given 首次登入略過綁定 []
		LoginScenarios.firstLoginBypassBundle(driver, userName, password, pid, implicitlyWaitSec);
		// Given 一般自然人_延長密碼戶 []
		// Given 按下側邊欄『side menu btn』按鈕 ByName [side menu btn, click]
		driver.findElement(By.name("side menu btn")).click();
		// Given 按下側邊欄『外幣匯兌』按鈕 ByName [外幣匯兌, click]
		driver.findElement(By.name("外幣匯兌")).click();
		// When 按下側邊欄『買外幣』按鈕 ByName [買外幣, click]
		driver.findElement(By.name("買外幣")).click();
		// When 等『WebView loading….』 Waiting [9]
		try {
			Thread.sleep(9 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// When 滑動 TouchAction_0.5 []
		(new TouchAction(driver)).press((width / 2), height - 25).moveTo(0, (-1) * height / 2).release().perform();
		// When 按下『我已閱讀並同意上述規範』 ByXPath [//XCUIElementTypeButton[@name=\"我已閱讀並同意上述規範\"],
		// click]
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"我已閱讀並同意上述規範\"]")).click();
		// When 按下幣別選單 ByXPath
		// [//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeOther[7], click]
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeOther[7]")).click();
		// When 點選歐元 Picker [EUR 歐元]
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel")).setValue("EUR 歐元");
		driver.findElement(By.name("完成")).click();
		// When 按下幣別選單 ByXPath
		// [//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeOther[7], click]
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeOther[7]")).click();
		// When 點選歐元 Picker [JPY 日圓]
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel")).setValue("JPY 日圓");
		driver.findElement(By.name("完成")).click();
		// When 按下幣別選單 ByXPath
		// [//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeOther[7], click]
		driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeOther[7]")).click();
		// When 點選歐元 Picker [GBP 英鎊]
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel")).setValue("GBP 英鎊");
		driver.findElement(By.name("完成")).click();
	}

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
		capabilities.setCapability("app", "/Users/cyndi/Downloads/esun.app");
		if (rule.isNoReset() != null) {
			capabilities.setCapability("noReset", rule.isNoReset());
		}
		capabilities.setCapability("platformVersion", "11.2");
		capabilities.setCapability("deviceName", "iPhone 8");
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		implicitlyWaitSec = 10;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		width = driver.manage().window().getSize().getWidth();
		height = driver.manage().window().getSize().getHeight();
		if (userRule.getHasUser()) {
			userName = userRule.getUserName();
			pid = userRule.getPid();
			password = userRule.getPassword();
		}
		exceptionRule.setDriver(driver);
	}

	@After
	public void tearDown() {
	}
}
