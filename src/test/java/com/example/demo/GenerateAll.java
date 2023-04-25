package com.example.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.ResolverUtil.Test;
import org.yaml.snakeyaml.Yaml;

public class GenerateAll {
	
//	static String dataName = "system";
//	static String dataName = "basic_data";
//	static String dataName = "out_warehouse";
//	static String dataName = "stock_inventory";
	static String dataName = "blog";
//	static String dataName = "auth";
	
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
	    CodeGenerator4wmsMP.ip = object.get("ip").toString();
	    CodeGenerator4wmsMP.port = object.get("port").toString();
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
				Object key = entry.getKey();
				String nameFromKey = getNameFromKey(key.toString());
				CodeGenerator4wmsMP.TABLE_NAME = key.toString();
		    	CodeGenerator4wmsMP.ENTITY_NAME = nameFromKey.toString();
		    	CodeGenerator4wmsMP.MAPPER_NAME = nameFromKey + "Mapper";
		    	CodeGenerator4wmsMP.SERVICE_NAME = nameFromKey + "Service";
		    	CodeGenerator4wmsMP.SERVICE_IMPL_NAME = nameFromKey + "Service" + "Impl";
		    	CodeGenerator4wmsMP.CONTROLLER_NAME = nameFromKey + "Controller";
		    	CodeGenerator4wmsMP.main(null);
		    }
	}

	static String getNameFromKey(String key){
		String[] s = key.toLowerCase().split("_");
		List<String> strings = Arrays.asList(s);
		Iterator<String> iterator = strings.stream().iterator();
		StringBuilder sb = new StringBuilder();
		iterator.next();
		while(iterator.hasNext()){
			String next = iterator.next();
			sb.append((char)(next.charAt(0)-32)).append(next.substring(1));
		}
		return sb.toString();
	}
}
