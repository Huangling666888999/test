package com.panda.Case;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.panda.Bean.ListBean;
import com.panda.Bean.list_BannersBean;
import com.panda.Bean.list_DataBean;
import com.panda.Bean.list_ItemsBean;
import com.panda.Commen.GsonUtil;
import com.panda.Commen.Initialize;
import com.panda.Commen.SystemUtils;
import com.panda.NetUtils.RestClient;
import com.panda.api.BaseAction;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class Pagelist extends Initialize {
	@BeforeClass
	public static void setup() throws InterruptedException, ClientProtocolException, IOException {
		Map<String, String> id = SystemUtils.getPropertyMap("Config/IdManage.properties");
		Map<String, String> config = SystemUtils.getPropertyMap("Config/config.properties");
		String tabxingxiu = id.get("Tab");
		Thread.sleep(2000);
		BaseAction.eleClick(androiddriver, tabxingxiu, 3000);
		String url = config.get("recommendlist");
		RestClient restClient = new RestClient();
		// 准备请求头信息
		HashMap<String, String>  headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json"); // 这个在postman中可以查询到
		CloseableHttpResponse closeableHttpResponse = restClient.get(url);
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		ListBean list = GsonUtil.parseJsonWithGson(responseString, ListBean.class);
		list_DataBean data = list.getData();
		List<list_ItemsBean> item = data.getItems();
		List<list_BannersBean> bunner = data.getBanners();
		Thread.sleep(9000);
		List<WebElement> elements = Initialize.androiddriver.findElements(By.id("com.panda.videoliveplatform:id/tv_room_name"));
		for (int i = 0; i < item.size(); i++) {
			String itemname = item.get(i).getName();
			String elementsname = elements.get(i).getText();
			// Assert.assertEquals(elements.get(j).getText(),item.get(i).getName(),"name
			// is not same");
			System.out.println("AAA" + itemname + "BBB" + elementsname);
		}
	}

	@Test
	public void test() throws InterruptedException {
		// BaseAction.click(Initialize.androiddriver, tab);
	}

	public static boolean isElementExistTest(AppiumDriver driver, String name) {
		try {
			driver.findElement(By.name(name));
			return true;
		} catch (Exception ex) {
			System.out.println(name + "不存在");
			ex.printStackTrace();
			return false;
		}
	}
}
