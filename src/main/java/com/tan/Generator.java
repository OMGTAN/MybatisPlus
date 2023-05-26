package com.tan;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
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

    @PostConstruct
    void generate(){

        String targetPath = "D:\\repos\\suaee\\parent\\manageproject\\src\\";
        String packageName = "com.suaee.manageproject";

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
                                    targetPath+ "main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("CEMS_CQ_OBJECT","CEMS_CQ_PROJECT","CEMS_CQ_PUBINFO","CEMS_CQ_SELLER","CEMS_CQ_SHAREHOLDER","CEMS_MERCHANT","CEMS_NOTICE","CEMS_NOTICE_INFO","CEMS_PROJECT","CEMS_PROJECT_CHAIN","CEMS_PROJECT_SYN","CEMS_ZC_PROJECT","CEMS_ZC_SELLER","CEMS_ZZ_INVESTOR","CEMS_ZZ_OBJECT","CEMS_ZZ_PROJECT","CEMS_ZZ_PUBINFO","CEMS_ZZ_SHAREHOLDER","CEMS_ZZ_TRADE") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            // entity 配置
                            .entityBuilder()
                            .enableLombok()

                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
