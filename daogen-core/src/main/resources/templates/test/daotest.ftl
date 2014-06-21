package ${dao.type.pkg};

import com.dianping.tuangou.navi.dal.dao.test.AbstractDAOTest;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

<#assign daoname = dao.type.name?uncap_first>
<#assign modelname = model.name?uncap_first>
/**
*
* Create by daogen http://code.dianpingoa.com/yihua.huang/daogen/
*
* @author yihua.huang@dianping.com
*/
public class ${dao.type.name}Test extends AbstractDAOTest {

	@Autowired
	private ${dao.type.name} ${daoname};
<#list dao.methods as daomethod><#if daomethod.type == "INSERT"><#assign hasInsert=true></#if></#list><#if hasInsert?exists>

	private ${model.type.name} ${modelname};

	@Before
	public void setup() {
        ${modelname} = new ${model.type.name}();
        <#list model.fields as field>
        ${modelname}.set${field.name?cap_first}(${field.type.suggestValue});
        </#list>
	}

</#if><#list dao.methods as daomethod><#if daomethod.type == "INSERT">
    @org.junit.Ignore</#if>
    @Test
    public void test${daomethod.name?cap_first}() {
<#if daomethod.type == "INSERT">
        ${daoname}.${daomethod.name}(${modelname});
</#if>
    <#if daomethod.type == "LOAD">
        ${daoname}.${daomethod.name}(<#list daomethod.params as param>${param.type.suggestValue}<#if (param_index+1) < daomethod.params?size>, </#if></#list>);
    </#if>
    <#if daomethod.name == "findByStartId">
        List<${entity.typeName}> ${modelname}s = ${daoname}.${daomethod.name}(<#list daomethod.params as param>${param.type.suggestValue}<#if (param_index+1) < daomethod.params?size>, </#if></#list>);
        assertThat(${modelname}s).isNotNull();
    <#elseif daomethod.name == "findByIds">
        List<${daomethod.params[0].type.typeName}> ${daomethod.params[0].name} = new java.util.ArrayList<${daomethod.params[0].type.typeName}>();
        ${daomethod.params[0].name}.add(${typeUtils.getSuggestValue(daomethod.params[0].type.typeOriginName)});
        List<${entity.typeName}> ${modelname}s = ${daoname}.${daomethod.name}(${daomethod.params[0].name});
        assertThat(${modelname}s).isNotNull();
    </#if>
    }
</#list>

}
