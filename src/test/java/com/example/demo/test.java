package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class test {
	
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		     // 使用InPutStream流读取properties文件
		     BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\workspaces\\w20190408\\mybatisPlusDemo\\src\\test\\resources\\basicData.properties"));
//		     BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\workspaces\\w20190408\\mybatisPlusDemo\\src\\test\\resources\\outWarehouse.properties"));
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
