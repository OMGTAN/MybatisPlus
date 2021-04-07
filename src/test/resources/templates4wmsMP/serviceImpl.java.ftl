package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.tec.anji.exception.BusinessException;

/**
 * <p>
 * ${table.comment!} 服务实现类
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
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
	
	<#--
	
	@Autowired
    private UidGenService uidGenService;
    
    @Override
    public Boolean save${entity}(${entity} ${entity?uncap_first}){
    	long uid = uidGenService.getCachedUid();
    	${entity?uncap_first}.setStationNo(String.valueOf(uid));
    	boolean result = save(${entity?uncap_first});
        return result;
    }
    
    @Override
	@Transactional
    public Boolean save${entity}s(List<${entity}> ${entity?uncap_first}List){
    	${entity?uncap_first}List.forEach(${entity?uncap_first} -> {
			long uid = uidGenService.getCachedUid();
			${entity?uncap_first}.setStationNo(String.valueOf(uid));
		});
    	boolean result = saveBatch(${entity?uncap_first}List);
        return result;
    }
    -->
}
</#if>
