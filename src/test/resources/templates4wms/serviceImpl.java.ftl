package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *	${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} implements ${table.serviceName} {

	@Autowired
    private ${table.mapperName} ${table.mapperName?uncap_first};

    public List<${entity}> select(${entity} ${entity?uncap_first}){
    	List<${entity}> list = ${table.mapperName?uncap_first}.select(${entity?uncap_first});
    	return list;
    }

    public List<${entity}> selectByExampleAndRowBounds(Object example, RowBounds rowBounds){
    	List<${entity}> list = ${table.mapperName?uncap_first}.selectByExampleAndRowBounds(example, rowBounds);
    	return list;
    }

    public List<${entity}> selectByExample(Object example){
    	List<${entity}> list = ${table.mapperName?uncap_first}.selectByExample(example);
    	return list;
    }

    public Integer save(${entity} ${entity?uncap_first}){
    	int i = ${table.mapperName?uncap_first}.insertSelective(${entity?uncap_first});
    	return i;
    }

    public Integer updateByEntity(${entity} ${entity?uncap_first}){
    	int i = ${table.mapperName?uncap_first}.updateByPrimaryKeySelective(${entity?uncap_first});
    	return i;
    }

    public Integer delete${entity}(${entity} ${entity?uncap_first}){
    	int i = ${table.mapperName?uncap_first}.deleteByPrimaryKey(${entity?uncap_first});
    	return i;
    }

}
</#if>
