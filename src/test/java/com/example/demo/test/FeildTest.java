package com.example.demo.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FeildTest {
	 
    public static void main(String[] args) {
        //定义list集合
        List<P> list = Arrays.asList(new P(1, "哈哈"), new P(2, "嘿嘿"), new P(3, "呵呵"));
        //从list集合中，取出字段name的列表
        List<String> names = list.stream().map(p -> p.getName()).collect(Collectors.toList());
 
        System.out.println(names);
    }
}
class P{
    int id;
    String name;
 
    public P(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}