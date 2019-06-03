package review.io.readwrite;

/**
 * System.getProperty("")
 * 获取java 虚拟机或是操作系统的属性
 * 使用java -D 配置系统属性，格式：java -Dkey=value （或ide中run configure中配置vm arguments）
 * ---设置的是JVM参数而不是program参数，使用此参数的参数优先级最高，会覆盖项目中配置的此项---测试并未覆盖
 * 如果value中有空格，则需要用双引号将该值括起来，如：-Dname=”kazaf f”。
 * 该参数通常用于设置系统级全局变量值，如配置文件路径，保证该属性在程序中任何地方都可访问
 * 1.获取系统环境信息
 * 2.作为轻量级的配置文件使用
 */
import java.util.Enumeration;
import java.util.Properties;
import java.util.Map.Entry;

public class SystemProperties {
	public static void main(String[] args) {
		Properties prop = System.getProperties();

		/*// 列出全部系统属性内容
		for (Entry<Object, Object> entry : prop.entrySet()) {
			System.out.print("key:" + entry.getKey() + "\t");
			System.out.println("value:" + entry.getValue());
		}*/
		
		//prop.list(System.out);		//该方法也可以列出全部系统属性
		
		//获取指定系统属性内容
		String version =prop.getProperty("java.version");
		System.out.println(version);

		version=System.getProperty("java.version");
		System.out.println(version);
		
		//设置系统属性
		System.setProperty("keyAA","valueAA");
		System.out.println(System.getProperty("keyAA"));

		setProperty("mykey", "myvalue");
		System.out.println(prop.getProperty("mykey", "default"));
		
		/*//列出全部系统属性名
		Enumeration<String> names=(Enumeration<String>) prop.propertyNames();
		while(names.hasMoreElements()){
			String s=names.nextElement();
			System.out.print(s);
		}

		for (String key : prop.stringPropertyNames()) {
			System.out.print(key+"\t\t");
			System.out.println(prop.getProperty(key));
		}*/
		System.setProperty("aa","bb");
		System.out.println(System.getProperty("aa"));
	}
	
	private static void setProperty(String key,String value){
		Properties prop =System.getProperties();
		prop.setProperty(key, value);
	}
}
