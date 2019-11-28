package com.example.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.yaml.snakeyaml.Yaml;

public class GenerateAll {
	
//	static String dataName = "system";
//	static String dataName = "basic_data";
//	static String dataName = "out_warehouse";
	static String dataName = "stock_inventory";
	
	public static void main(String[] args) throws IOException {
			
		Yaml yaml = new Yaml();
		URL url = Test.class.getClassLoader().getResource("application.yml");
        //获取test.yaml文件中的配置数据，然后转换为obj，
        Map map =(Map)yaml.load(new FileInputStream(url.getFile()));
        Map object = (Map)map.get(dataName);
	    CodeGenerator4wmsMP.moduleName = object.get("moduleName").toString();
	    CodeGenerator4wmsMP.mapperPath = object.get("mapperPath").toString();
	    CodeGenerator4wmsMP.dataBase = object.get("dataBase").toString();
	    CodeGenerator4wmsMP.projectPath = object.get("projectPath").toString();
	    String tableNames = object.get("tableNames").toString();;
	    
	    Properties properties = new Properties();
		     // 使用InPutStream流读取properties文件
	    BufferedReader      bufferedReader = new BufferedReader(new FileReader("src\\test\\resources\\"+tableNames+".properties"));
		    properties.load(bufferedReader);
		     // 获取key对应的value值
		    Set<Entry<Object, Object>> entrySet = properties.entrySet();
		    Iterator<Entry<Object, Object>> iterator = entrySet.iterator();
		    while(iterator.hasNext()) {
		    	Entry<Object, Object> entry = iterator.next();
		    	System.out.println(entry.getKey().toString()+entry.getValue());
		    	CodeGenerator4wmsMP.TABLE_NAME = entry.getKey().toString();
		    	CodeGenerator4wmsMP.ENTITY_NAME = entry.getValue().toString();
		    	CodeGenerator4wmsMP.MAPPER_NAME = entry.getValue() + "Mapper";
		    	CodeGenerator4wmsMP.SERVICE_NAME = entry.getValue() + "Service";
		    	CodeGenerator4wmsMP.SERVICE_IMPL_NAME = entry.getValue() + "Service" + "Impl";
		    	CodeGenerator4wmsMP.CONTROLLER_NAME = entry.getValue() + "Controller";
		    	CodeGenerator4wmsMP.main(null);
		    }
	}
}
