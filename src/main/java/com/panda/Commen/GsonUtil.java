package com.panda.Commen;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {
	  public static <T> T parseJsonWithGson(String jsonData,Class<?>type){
	        Gson gson = new Gson();
	       return (T) gson.fromJson(jsonData,type);
	    }
	  public static <T> List<T> parsJsonArrayWithGson(String str,Class<?> type){
	       Gson gson  = new Gson();
	       /*GSON提供了 TypeToken 这个类来帮助我们捕获（capture）像List<MyZhuiHaoDetailModel>这样的泛型信息。
	       上文创建了一个匿名内部类，这样，Java编译器就会把泛型信息编译到这个匿名内部类里，然后在运行时就可以被
	       getType()方法用反射API提取到。
	    */
	       return gson.fromJson(str,new TypeToken<List<T>>(){
	           }.getType());
	    }
}
