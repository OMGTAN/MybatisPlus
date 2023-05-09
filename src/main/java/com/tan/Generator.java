package com.tan;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Types;
import java.util.Collections;

@Component
public class Generator {

    @Autowired
    private DataBaseConfig baseConfig;

    @PostConstruct
    void generate(){
        FastAutoGenerator.create(baseConfig.getUrl(), baseConfig.getUsername(), baseConfig.getPassword())
                .globalConfig(builder -> {
                    builder.author("auth") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\repos\\github\\MybatisPlus\\src\\test\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.tan.test") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\repos\\github\\MybatisPlus\\src\\test\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
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
