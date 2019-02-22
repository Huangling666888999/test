package com.panda.api;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.panda.Commen.Initialize;

import android.R.bool;
import android.text.method.Touch;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class BaseAction {
	public static  String value;
	public static WebElement element;
    /*
    * ����Ļ�����������»�������
    */
    public static void swipeAction(String drection,AppiumDriver<WebElement> driver,int duration)throws InterruptedException{
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;
        switch(drection){
        case "Up":
        	driver.swipe(width/2,height*9/10,width/2,height/20,duration);
        case "Down":
        	 driver.swipe(width/2,height/20,width/2,height*9/10,duration);
        case "left":
        	driver.swipe(width*9/10,height/2,width/20,height/2,duration);
        case "Right":
        	 driver.swipe(width/10,height/2,width*9/10,height/2,duration);
        }
    }
    /*
    * Ԫ��֮��Ļ�������
    * */
    public static void Element_slide(AppiumDriver  driver,WebElement element,String  data){
        int xStartPoint=element.getLocation().getX();
        int xEndPoint=xStartPoint+element.getSize().getWidth();
        int y=element.getLocation().getY();
        TouchAction Action=new TouchAction(driver);
        if(data.equals("��")){
            Action.press(xEndPoint-20,y+20).waitAction().moveTo(xStartPoint,y+20).release().perform();
        }
        if(data.equals("�һ�")){
            Action.press(xStartPoint+20,y+20).waitAction().moveTo(xEndPoint,y+20).release().perform();
        }
    }
   /*
    * ��ĳ�������ϻ���ֱ��ĳ��Ԫʣ����
    */
    public void  SwipeUtilElementAppear(AppiumDriver  driver,By by,String direction,int duration) throws InterruptedException {
		boolean flag=true;
		try {
		driver.findElement(by);
		flag=flag;
		} catch (Exception e) {
			// TODO: handle exception
			this.swipeAction(direction,driver, duration);
		}
	}
    /*
    *��ͼ����
     */
    public static  void screenShot(AppiumDriver  driver,String screenName) throws IOException {
        //����ʱ���ʽ
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        //����ʱ���
        String dataString=format.format(new Date());
        String dir_name=System.getProperty("user.dir")+"\\�쳣ͼƬ";
        System.out.print("�쳣ͼƬĿ¼"+dir_name);
        if(!(new File(dir_name)).isDirectory()){
            new File(dir_name).mkdir();
        }
        File screen=driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(dir_name+"\\"+dataString+screenName+".jpg"));
    }
    /*
    * �������л��������⣩
    * */
    public static void horizontal(String data, AppiumDriver driver)throws  InterruptedException,IOException{
        if(data.equals("����")){
          //�л�������
        }
        if(data.equals("����")){
            driver.rotate(ScreenOrientation.PORTRAIT);//�л�������
        }
    }
  
    /*����Sendkeys��װ*/
    public static void sendkeys(AppiumDriver driver,WebElement element,String value){
        element.sendKeys(value);
    }
    /*����¼��ķ�װ*/
    public static void click(AppiumDriver driver,WebElement element){
       element.click();
    }
    /*
     * ��ĳ��Ԫ���ϳ���
     */
    public static void longpress_element(AppiumDriver driver,WebElement element){
    	try{
    	TouchAction touch=new TouchAction(driver);
    	touch.longPress(element).release().perform();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    /*
     *������㳤��
     */
    public static void longpress_coordinate(AppiumDriver driver,int x,int y){
    	try {
			TouchAction touch=new TouchAction(driver);
			touch.longPress(x, y).release().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    /*
     * �ж�Ԫ���Ƿ����
     */
    public static boolean isElementExist(AppiumDriver driver,By by){
    	try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    /*
     * ���ƶ��ĳ�ʱʱ����Ԫ���Ƿ���ڣ���������������ؽ����������������ڳ�ʱ�󷵻ؽ��
     */
    public static boolean isElementExist_time(AppiumDriver driver,By by,int timeout){
    	try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
		return true;
    	} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	
    }
    public static void eleClick (AppiumDriver driver,String value1,int sleeptime) throws InterruptedException{
        value=value1;
    	Thread.sleep(sleeptime);
    	element=BaseAction.findElement(driver);
    	try
    	{
    		 if(element!=null){
    	    	   element.click();
    	        }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    /*Ԫ�ض�ȡ*/
    public static WebElement findElement(AppiumDriver driver){
        String string[]=value.split("\\|");
        if(string[1].equals("id")){
             element=driver.findElement(By.id(string[0]));
        }
        if (string[1].equals("name")){
             element=driver.findElement(By.name(string[0]));
        }
        if(string[1].equals("xpath")){
             element=driver.findElement(By.xpath(string[0]));
        }
        if(string[1].equals("class")){
             element = driver.findElementByClassName(string[0]);
        }
        return element;
    }
}
 
