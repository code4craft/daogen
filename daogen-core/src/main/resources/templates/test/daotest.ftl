package ${dao.pkg};

import ${entity.typeFullName};
import com.dianping.tuangou.navi.dal.dao.test.AbstractDAOTest;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

<#if dao.imports.imports?has_content>
    <#list dao.imports.imports as imp>
import ${imp};
    </#list>
</#if>

import static org.assertj.core.api.Assertions.assertThat;

<#assign typeUtils = map.typeUtils>
<#assign daoname = dao.typeName?uncap_first>
<#assign entityname = model.name?uncap_first>
/**
*
* Create by daogen https://github.com/code4craft/daogen
*
* @author yihua.huang@dianping.com
*/
public class ${dao.typeName}Test extends AbstractDAOTest {

	@Autowired
	private ${dao.typeName} ${daoname};
<#list dao.methods as daomethod><#if daomethod.type == "INSERT"><#assign hasInsert=true></#if></#list><#if hasInsert?exists>

	private ${entity.typeName} ${entityname};

	@Before
	public void setup() {
        ${entityname} = new ${entity.typeName}();
        <#list model.fields as field>
        ${entityname}.set${field.name?cap_first}(${typeUtils.getSuggestValue(field.typeOriginName)});
        </#list>
	}

</#if><#list dao.methods as daomethod><#if daomethod.type == "INSERT">
    @org.junit.Ignore</#if>
    @Test
    public void test${daomethod.name?cap_first}() {
<#if daomethod.type == "INSERT">
        ${daoname}.${daomethod.name}(${entityname});
</#if>
    <#if daomethod.type == "LOAD">
        ${daoname}.${daomethod.name}(<#list daomethod.params as param>${typeUtils.getSuggestValue(param.type.typeOriginName)}<#if (param_index+1) < daomethod.params?size>, </#if></#list>);
    </#if>
    <#if daomethod.name == "findByStartId">
        List<${entity.typeName}> ${entityname}s = ${daoname}.${daomethod.name}(<#list daomethod.params as param>${typeUtils.getSuggestValue(param.type.typeOriginName)}<#if (param_index+1) < daomethod.params?size>, </#if></#list>);
        assertThat(${entityname}s).isNotNull();
    <#elseif daomethod.name == "findByIds">
        List<${daomethod.params[0].type.typeName}> ${daomethod.params[0].name} = new java.util.ArrayList<${daomethod.params[0].type.typeName}>();
        ${daomethod.params[0].name}.add(${typeUtils.getSuggestValue(daomethod.params[0].type.typeOriginName)});
        List<${entity.typeName}> ${entityname}s = ${daoname}.${daomethod.name}(${daomethod.params[0].name});
        assertThat(${entityname}s).isNotNull();
    </#if>
    }
</#list>

}
