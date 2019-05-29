package ${package.Controller};


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
    * ${table.comment!}	前端控制器
    * </p>
 *
 * @author ${author}
 * @since ${date}
 * @version v1.0
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
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
    private ${table.serviceName} ${table.serviceName};

    /**
     *	查询数据
     */
    @RequestMapping(value = "/list")
    public List<Books> list(@RequestBody ${entity} ${entity}){
    	QueryWrapper<${entity}> queryWrapper = new QueryWrapper<${entity}>(${entity});
    	
        List<Books> list = ${table.serviceName}.list(queryWrapper);
    	return list;
    }


    /**
     *	 根据id查询
     */
    @RequestMapping(value = "/getById")
    public ${entity} getById(@RequestParam("id") String id){
       ${entity} entity = ${table.serviceName}.getById(id);
       return entity;
    }

    /**
     * 	新增
     */
    @RequestMapping(value = "/save")
    public Boolean save(@RequestBody ${entity} ${entity}){
    	Boolean result = ${table.serviceName}.save(${entity});
        return result;
    }

    /**
     * 	根据id删除
     */
    @RequestMapping(value = "/removeById")
    public Boolean removeById(@RequestParam("id") String id){
    	boolean result = ${table.serviceName}.removeById(id);
        return result;
    }
    
    /**
     *	 批量删除
     */
    @RequestMapping(value = "/removeByIds")
    public Boolean removeByIds(@RequestParam("ids") List<String> ids){
    	boolean result = ${table.serviceName}.removeByIds(ids);
        return result;
    }

    /**
     * 	修改
     */
    @RequestMapping(value = "/updateById")
    public Boolean updateById(@RequestBody ${entity} ${entity}){
    	boolean result = ${table.serviceName}.updateById(${entity});
        return result;
     }
     
    /**
     * 	保存或修改
     */
    @RequestMapping(value = "/saveOrUpdate")
    public Boolean saveOrUpdate(@RequestBody ${entity} ${entity}){
    	boolean result = ${table.serviceName}.saveOrUpdate(${entity});
        return result;
     }
     
     /**
     * 	分页查询
     */
    @RequestMapping(value = "/page")
    public IPage<${entity}> page(@RequestParam(name = "pageNo", defaultValue = "1") int pageNo,@RequestParam(name = "pageSize", defaultValue = "1") int pageSize, @RequestBody ${entity} ${entity}){
    	
    	QueryWrapper<${entity}> queryWrapper = new QueryWrapper<${entity}>(${entity});

    	Page<${entity}> page = new Page<${entity}>(pageNo, pageSize);
    	IPage<${entity}> result = ${table.serviceName}.page(page, queryWrapper);
    	return result;
    }

}
</#if>