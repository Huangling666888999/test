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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;


public class BaseAction {
    /*
    * 在屏幕进行左右上下滑动操作
    */
    public static void swipe(String data,AppiumDriver<WebElement> driver)throws InterruptedException{
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;
        if(data.equals("左滑")){
            driver.swipe(width*9/10,height/2,width/20,height/2,1000);
        }
        if(data.equals("右滑")){
            driver.swipe(width/10,height/2,width*9/10,height/2,1000);
        }
        if(data.equals("上滑")){
            driver.swipe(width/2,height*9/10,width/2,height/20,1000);
        }
        if(data.equals("下滑")){
            driver.swipe(width/2,height/20,width/2,height*9/10,1000);
        }
    }
    /*
    * 元素之间的滑动操作
    * */
    public static void Element_slide(AppiumDriver  driver,WebElement element,String  data){
        int xStartPoint=element.getLocation().getX();
        int xEndPoint=xStartPoint+element.getSize().getWidth();
        int y=element.getLocation().getY();
        TouchAction Action=new TouchAction(driver);
        if(data.equals("左滑")){
            Action.press(xEndPoint-20,y+20).waitAction().moveTo(xStartPoint,y+20).release().perform();
        }
        if(data.equals("右滑")){
            Action.press(xStartPoint+20,y+20).waitAction().moveTo(xEndPoint,y+20).release().perform();
        }
    }
    /*
    *截图操作
     */
    public static  void screenShot(AppiumDriver  driver,String screenName) throws IOException {
        //设置时间格式
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        //生成时间戳
        String dataString=format.format(new Date());
        String dir_name=System.getProperty("user.dir")+"\\异常图片";
        System.out.print("异常图片目录"+dir_name);
        if(!(new File(dir_name)).isDirectory()){
            new File(dir_name).mkdir();
        }
        File screen=driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(dir_name+"\\"+dataString+screenName+".jpg"));
    }
    /*
    * 横竖屏切换（有问题）
    * */
    public static void horizontal(String data, AppiumDriver driver)throws  InterruptedException,IOException{
        if(data.equals("横屏")){
          //切换到横屏
        }
        if(data.equals("竖屏")){
            driver.rotate(ScreenOrientation.PORTRAIT);//切换到竖屏
        }
    }
    /*元素读取*/
    public static WebElement findElement(AppiumDriver driver,String value){
        String string[]=value.split("\\|");
        WebElement element=null;
        if(string[1].equals("id")){
             element=driver.findElement(By.id(string[0]));
             System.out.println("66666666"+value);
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
    /*发送Sendkeys封装*/
    public static void sendkeys(AppiumDriver driver,WebElement element,String value){
        element.sendKeys(value);
    }
    /*点击事件的封装*/
    public static void click(AppiumDriver driver,WebElement element){
       element.click();
    }
	
}
