package com.panda.Case;

import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.panda.Commen.Initialize;
import com.panda.Commen.SystemUtils;
import com.panda.api.BaseAction;

import junit.framework.TestSuite;

public class Pagelist {
	@Test
public static void findbyid(){
	Map<String, String> id = SystemUtils.getPropertyMap("Config/IdManage.properties");
	WebElement tab=BaseAction.findElement(Initialize.androiddriver, id.get("Tab"));
	BaseAction.click(Initialize.androiddriver, tab);
}
}
