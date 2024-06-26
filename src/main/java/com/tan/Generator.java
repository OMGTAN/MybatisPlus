package com.tan;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Types;
import java.util.Collections;

@Component
@Slf4j
public class Generator {

    @Autowired
    private DataBaseConfig baseConfig;

    void generate(){

        String mapperPath = "main\\resources\\mapper";

//        String targetPath = "D:\\repos\\svn\\deep\\monitor\\financeLease\\src\\";
//        String packageName = "com.suaee.finance.lease";

//        String targetPath = "D:\\repos\\svn\\deep\\monitor\\manageproject\\src\\";
//        String packageName = "com.suaee.manageproject";

//        String targetPath = "D:\\repos\\svn\\deep\\monitor\\datanalysis\\src\\";
//        String packageName = "com.suaee.datanalysis";

//        String targetPath = "D:\\repos\\svn\\deep\\monitor\\app-monitor\\src\\";
//        String packageName = "com.suaee.app.monitor";

        String targetPath = "D:\\repos\\suaee\\jyb\\jyb-biz\\jyb-biz-model\\src\\";
        String packageName = "com.gientech.dadp.jyb.generate";

        log.info("url：{}", baseConfig.getUrl());
        FastAutoGenerator.create(baseConfig.getUrl(), baseConfig.getUsername(), baseConfig.getPassword())
                .globalConfig(builder -> {
                    builder.author("auth") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("D:\\repos\\github\\MybatisPlus\\src\\test\\java\\"); // 指定输出目录
                            .outputDir(targetPath + "main\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(packageName) // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
//                                    "D:\\repos\\github\\MybatisPlus\\src\\test\\resources\\mapper")); // 设置mapperXml生成路径
                                    targetPath + mapperPath)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.serviceBuilder().convertServiceFileName((entityName -> entityName + ConstVal.SERVICE))
                            .entityBuilder().enableActiveRecord().enableLombok().enableChainModel()
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude("T_QY_USER_CORP_GRP") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            // entity 配置

                            .entityBuilder()
                            .enableLombok()
                    ;
                })
                //模板配置
                .templateConfig(builder -> {
                        builder.controller("template/controller.java.vm");
                    }
                )
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }


}
