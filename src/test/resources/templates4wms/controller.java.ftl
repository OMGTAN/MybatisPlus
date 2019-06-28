package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ${package.Entity}.${entity};
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 *		${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 * @version v1.0
 */
<#if restControllerStyle>
@RestController
@RequestMapping(value = "/${entity?uncap_first}s")
<#else>
@Controller
</#if>
<#-- @RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>") -->
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>
    
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    /**
     *	分页
     */
    @GetMapping
    public PageInfo<${entity}> list${entity}s(${entity} ${entity?uncap_first}, String sort, @RequestParam(name = "pageNo", defaultValue = "1") int pageNo, @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
    	List<${entity}> list;
    	PageInfo<${entity}> pageInfo = null;
    	Example example = new Example(${entity}.class);
    	Criteria cri = example.createCriteria();
    	example.setOrderByClause(sort);
    	//TODO
    	
    	PageHelper.startPage(pageNo, pageSize);
    	list = ${table.serviceName?uncap_first}.selectByExample(example);
    	pageInfo = new PageInfo<>(list);
    	return pageInfo;
    }

    /**
     * 	新增
     */
    @PostMapping
    public Integer save(@RequestBody ${entity} ${entity?uncap_first}){
    	Integer result = ${table.serviceName?uncap_first}.save(${entity?uncap_first});
        return result;
    }
    
    /**
     * 	修改
     */
    @PutMapping
    public Integer updateByEntity(@RequestBody ${entity} ${entity?uncap_first}){
    	Integer result = ${table.serviceName?uncap_first}.updateByEntity(${entity?uncap_first});
        return result;
     }
    
    /**
     * 	删除
     */
    @DeleteMapping
    public Integer delete${entity}(@RequestBody ${entity} ${entity?uncap_first}){
    	Integer result = ${table.serviceName?uncap_first}.delete${entity}(${entity?uncap_first});
        return result;
     }


   

}
</#if>