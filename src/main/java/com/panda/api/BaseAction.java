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
    * ����Ļ�����������»�������
    */
    public static void swipe(String data,AppiumDriver<WebElement> driver)throws InterruptedException{
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;
        if(data.equals("��")){
            driver.swipe(width*9/10,height/2,width/20,height/2,1000);
        }
        if(data.equals("�һ�")){
            driver.swipe(width/10,height/2,width*9/10,height/2,1000);
        }
        if(data.equals("�ϻ�")){
            driver.swipe(width/2,height*9/10,width/2,height/20,1000);
        }
        if(data.equals("�»�")){
            driver.swipe(width/2,height/20,width/2,height*9/10,1000);
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
    /*Ԫ�ض�ȡ*/
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
    /*����Sendkeys��װ*/
    public static void sendkeys(AppiumDriver driver,WebElement element,String value){
        element.sendKeys(value);
    }
    /*����¼��ķ�װ*/
    public static void click(AppiumDriver driver,WebElement element){
       element.click();
    }
	
}
