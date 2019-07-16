package ${package.Service};

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
	
	Boolean save${entity}(@RequestBody ${entity} ${entity?uncap_first});
	
	Boolean save${entity}s(@RequestBody List<${entity}> ${entity?uncap_first}List);
}
</#if>
