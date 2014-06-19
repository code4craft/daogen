package ${dao.pkg};

import com.dianping.avatar.dao.GenericDao;
import com.dianping.avatar.dao.annotation.DAOAction;
import com.dianping.avatar.dao.annotation.DAOActionType;
import com.dianping.avatar.dao.annotation.DAOParam;

<#if dao.imports.imports?has_content>
    <#list dao.imports.imports as imp>
import ${imp};
    </#list>
</#if>

/**
*
* Create by daogen https://github.com/code4craft/daogen
*
* @author yihua.huang@dianping.com
*/
public interface ${dao.typeName} extends GenericDao {

<#list dao.methods as method>
    @DAOAction(action = DAOActionType.${method.type})
    <#if method.returnCollection?exists>${method.returnCollection}<${method.returnType.typeName}><#else>${method.returnType.typeName}</#if> ${method.name}(<#list method.params as param>@DAOParam("${param.name}") <#if param.multi>List<${param.type.typeName}><#else>${param.type.typeName}</#if> ${param.name}<#if (param_index+1) < method.params?size>, </#if></#list>);

</#list>
}
