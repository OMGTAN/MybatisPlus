package ${package.Service};

import ${package.Entity}.${entity};

import java.util.List;

import org.apache.ibatis.session.RowBounds;

/**
 * <p>
 *	${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} {
	
	/**
     * 	根据实体中的属性值进行查询，查询条件使用等号
     */
    List<${entity}> select(${entity} ${entity?uncap_first});
	
	/**
     * 	根据example条件和RowBounds进行分页查询
     */
    List<${entity}> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);
	
	/**
     * 	根据example查询
     */
    List<${entity}> selectByExample(Object example);
	
	/**
     * 	新增
     */
    Integer save(${entity} ${entity?uncap_first});
	
	/**
     * 	修改
     */
    Integer updateByEntity(${entity} ${entity?uncap_first});
	
	/**
     * 	删除
     */
    Integer delete${entity}(${entity} ${entity?uncap_first});
}
</#if>
