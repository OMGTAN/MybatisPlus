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
    
    @Autowired
	private UidGenService uidGenService;

	@Override
    public List<${entity}> select(${entity} ${entity?uncap_first}){
    	List<${entity}> list = ${table.mapperName?uncap_first}.select(${entity?uncap_first});
    	return list;
    }

	@Override
    public List<${entity}> selectByExampleAndRowBounds(Object example, RowBounds rowBounds){
    	List<${entity}> list = ${table.mapperName?uncap_first}.selectByExampleAndRowBounds(example, rowBounds);
    	return list;
    }

	@Override
    public List<${entity}> selectByExample(Object example){
    	List<${entity}> list = ${table.mapperName?uncap_first}.selectByExample(example);
    	return list;
    }

	@Override
    public Integer save(${entity} ${entity?uncap_first}){
    	long uid = uidGenService.getDefaultUid();
    	${entity?uncap_first}.setPlanUkey(String.valueOf(uid));
    	int i = ${table.mapperName?uncap_first}.insertSelective(${entity?uncap_first});
    	return i;
    }
	
	@Override
	@Transactional
    public Integer save${entity}s(List<${entity}> ${entity?uncap_first}List){
    	ValidationUtils.returnIfEmputy(retrievalPlanList);
    	${entity?uncap_first}List.forEach(
    		${entity?uncap_first} -> save(${entity?uncap_first})
    	);
    	return ${entity?uncap_first}List.size();
    }
	
	@Override
    public Integer update${entity}(${entity} ${entity?uncap_first}){
    	int i = ${table.mapperName?uncap_first}.updateByPrimaryKeySelective(${entity?uncap_first});
    	return i;
    }
    
    @Override
    @Transactional
    public Integer update${entity}s(List<${entity}> ${entity?uncap_first}List){
    	${entity?uncap_first}List.forEach(
    		${entity?uncap_first} -> update${entity}(${entity?uncap_first})
    	);
    	return ${entity?uncap_first}List.size();
    }
    
    @Override
    @Transactional
    public void deleteAndSave(List<${entity}> ${entity?uncap_first}List){
    	ValidationUtils.returnIfEmputy(retrievalPlanList);
    	//TODO 删除旧数据
    	${entity?uncap_first}List.forEach(
    		${entity?uncap_first} -> save(${entity?uncap_first})
    	);
    }

	@Override
    public Integer delete${entity}(${entity} ${entity?uncap_first}){
    	int i = ${table.mapperName?uncap_first}.delete(${entity?uncap_first});
    	return i;
    }

	@Override
    public Integer deleteByPrimaryKey(${entity} ${entity?uncap_first}){
    	int i = ${table.mapperName?uncap_first}.deleteByPrimaryKey(${entity?uncap_first});
    	return i;
    }
    
    @Override
    @Transactional
    public Integer delete${entity}s(List<${entity}> ${entity?uncap_first}List){
    	ValidationUtils.returnIfEmputy(retrievalPlanList);
    	${entity?uncap_first}List.forEach(
    		${entity?uncap_first} -> delete${entity}(${entity?uncap_first})
    	);
    	return ${entity?uncap_first}List.size();
    }

}
</#if>
