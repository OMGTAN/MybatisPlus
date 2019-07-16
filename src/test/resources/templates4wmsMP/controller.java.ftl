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
import com.tec.anji.service.UidGenService;
import com.tec.anji.util.EmptyUtils;

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
    public IPage<${entity}> list${entity}sByPage(${entity} ${entity?uncap_first}, @RequestParam(name = "isAsc", defaultValue = "true")Boolean isAsc, String[] columns, @RequestParam(name = "pageNo", defaultValue = "1") int pageNo, @RequestParam(name = "pageSize", defaultValue = "10") int pageSize){
    	QueryWrapper<${entity}> queryWrapper = new QueryWrapper<${entity}>(${entity?uncap_first});
    	queryWrapper.orderBy(!EmptyUtils.isEmpty(columns), isAsc, columns);

    	Page<${entity}> page = new Page<${entity}>(pageNo, pageSize);
    	IPage<${entity}> result = ${table.serviceName?uncap_first}.page(page, queryWrapper);
    	return result;
    }
    
    
    /**
     *	根据条件查询list
     */
    @GetMapping(value = "/all")
    public List<${entity}> list${entity}s(${entity} ${entity?uncap_first}){
    	QueryWrapper<${entity}> queryWrapper = new QueryWrapper<${entity}>(${entity?uncap_first});
    	
        List<${entity}> list = ${table.serviceName?uncap_first}.list(queryWrapper);
    	return list;
    }
    
    /**
     *	根据主键查询${entity?uncap_first}
     */
    @GetMapping(value = "/{id}")
    public ${entity} getById(@PathVariable String id){
    	
    	${entity} ${entity?uncap_first} = ${table.serviceName?uncap_first}.getById(id);
    	return ${entity?uncap_first};
    }


    /**
     * 	新增
     */
    @PostMapping
    public Boolean save${entity}(@RequestBody ${entity} ${entity?uncap_first}){
    	Boolean result = ${table.serviceName?uncap_first}.save(${entity?uncap_first});
        return result;
    }

    /**
     * 	新增list
     */
    @PostMapping(value = "/list")
    public Boolean save${entity}s(@RequestBody List<${entity}> ${entity?uncap_first}List){
    	Boolean result = ${table.serviceName?uncap_first}.saveBatch(${entity?uncap_first}List);
        return result;
    }
    
    /**
     * 	修改
     */
    @PutMapping
    public Boolean update${entity}(@RequestBody ${entity} ${entity?uncap_first}){
    	Boolean result = ${table.serviceName?uncap_first}.updateById(${entity?uncap_first});
        return result;
     }
    
    /**
     * 	修改list
     */
    @PutMapping(value = "/list")
    public Boolean update${entity}s(@RequestBody List<${entity}> ${entity?uncap_first}List){
    	Boolean result = ${table.serviceName?uncap_first}.updateBatchById(${entity?uncap_first}List);
        return result;
     }
    
    /**
     * 	删除
     */
    @DeleteMapping
    public Boolean delete${entity}(@RequestBody ${entity} ${entity?uncap_first}){
    	QueryWrapper<${entity}> queryWrapper = new QueryWrapper<${entity}>(${entity?uncap_first});
    	Boolean result = ${table.serviceName?uncap_first}.remove(queryWrapper);
        return result;
     }
    
    /**
     * 	删除list
     */
    @DeleteMapping(value = "/list")
    public Boolean delete${entity}s(@RequestBody List<String> idsList){
    	Boolean result = ${table.serviceName?uncap_first}.removeByIds(idsList);
        return result;
     }


   

}
</#if>