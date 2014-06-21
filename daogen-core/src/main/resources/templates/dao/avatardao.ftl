package ${dao.type.pkg};

import com.dianping.avatar.dao.GenericDao;
import com.dianping.avatar.dao.annotation.DAOAction;
import com.dianping.avatar.dao.annotation.DAOActionType;
import com.dianping.avatar.dao.annotation.DAOParam;

/**
*
* Create by daogen http://code.dianpingoa.com/yihua.huang/daogen/
*
* @author yihua.huang@dianping.com
*/
public interface ${dao.type.name} extends GenericDao {

<#list dao.methods as method>
    @DAOAction(action = DAOActionType.${method.type})
    <#if method.returnCollection?exists>${method.returnCollection}<${method.returnType.name}><#else>${method.returnType.name}</#if> ${method.name}(<#list method.params as param>@DAOParam("${param.name}") <#if param.multi>List<${param.type.name}><#else>${param.type.name}</#if> ${param.name}<#if (param_index+1) < method.params?size>, </#if></#list>);

</#list>
}
