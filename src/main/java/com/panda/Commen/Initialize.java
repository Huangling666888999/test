package com.panda.Commen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Initialize {

	public static AppiumDriver androiddriver;
	public static IOSDriver iosdriver;

	public static void main(String[] args)  {
		Androidsetting();
		// IOSsetting();
	}
	@BeforeSuite
	public static void Androidsetting() {
		//String deviceName = "/Users/huangling/Documents/soft/android-sdk-macosx/platform-tools/adb shell getprop ro.product.model";
		//String deviceVersion="/Users/huangling/Documents/soft/android-sdk-macosx/platform-tools/adb shell getprop ro.build.version.release";
		String deviceName = "adb shell getprop ro.product.model";
		String deviceVersion="adb shell getprop ro.build.version.release";
		// 设置apk的路径
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "Application");
		File app = new File(appDir, "PandaTV.apk");
		Map<String, String> Control = SystemUtils.getPropertyMap("Config/config.properties");
		// 设置自动化相关参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		//获取手机名称
		String devicename = SystemUtils.getdevicename(deviceName);
		capabilities.setCapability("deviceName", devicename);
		// 设置安卓系统版本
		String deviceversion = SystemUtils.getdevicename(deviceVersion);
		capabilities.setCapability("platformVersion", deviceversion);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("platformName", Control.get("AndplatformName")); // 指定测试平台
		// 每次启动时覆盖session，否则第二次后运行会报错不能新建session
		capabilities.setCapability("sessionOverride", true);
		capabilities.setCapability("appPackage", Control.get("AndappPackage"));
		capabilities.setCapability("appActivity", Control.get("AndappActivity"));
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("noReset", true);
		// 初始化
		try {
			androiddriver = new AndroidDriver(new URL(Control.get("base_url")), capabilities);
			//System.out.println("2222"+androiddriver.getPageSource());
			//androiddriver.findElement(By.id("tab_img")).click();
			//androiddriver.findElement(By.xpath("//android.widget.TabWidget[@resource-id='android:id/tabs']/android.widget.FrameLayout[3]/android.widget.RelativeLayout[1]/android.widget.ImageView[1]")).click();
			//Initialize.androiddriver.findElementById("android:id/tab_img").click();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @BeforeSuite public static void IOSsetting(){ "deviceName": "iPhone X",
	 * "platformName": "ios", "platformVersion": "11.1", "udid":
	 * "f65693f214f335a70c6756ebe9e2eacf97ac5348", "bundleId":
	 * "com.youcai.iphone", "noReset": true, "xcodeOrgId": "1397023553@qq.com",
	 * "xcodeSigningId": "iPhone Developer", "AutomationName": "XCUITest" File
	 * classpathRoot = new File(System.getProperty("user.dir")); File appDir =
	 * new File(classpathRoot, "apps"); File app = new File(appDir,
	 * "YoucaiMainClient-Debug.ipa"); DesiredCapabilities capabilities = new
	 * DesiredCapabilities();
	 * //capabilities.setCapability("device","multiMedia");
	 * capabilities.setCapability(MobileCapabilityType.VERSION, "11.1");
	 * capabilities.setCapability(MobileCapabilityType.PLATFORM,"Mac");
	 * capabilities.setCapability("deviceName",inihelper.IOSdeviceName);
	 * capabilities.setCapability("platformName", inihelper.IOSplatformName);
	 * capabilities.setCapability(MobileCapabilityType.APP,"com.youcai.iphone");
	 * capabilities.setCapability("automationName",inihelper.IOSautomationName);
	 * capabilities.setCapability("udid",inihelper.IOSudid); try { iosdriver =
	 * new IOSDriver(new URL(inihelper.base_url), capabilities); } catch
	 * (MalformedURLException e) { e.printStackTrace(); } }
	 */

}