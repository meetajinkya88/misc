<?xml version="1.0"?>
<vxml version="2.0">


<#import "macros.ftl" as macro>

<#function printMessage str="">
  <#if str?has_content>
 	 <#return str>
  <#else> 
   	 <#return "Default Option">
  </#if>
</#function>


 <prompt>
   		<#list ivrOptions?keys as key> 
    		${key} = ${ivrOptions[key]} 
		</#list> 
  </prompt>
<form>
  <prompt>
        ${welcomeMessage}
  </prompt>
  <field name="customerid" type="digits">
      
      <prompt>
        ${customerMessage}
      </prompt>
  </field>

  <field name="age" type="digits?minlength=1;maxlength=2">
      <prompt>
        ${enterAgeMessage}
      </prompt>
  </field>
  
  field name="index" type="digits?minlength=1;maxlength=3">
     <prompt>
        Please select from following option.
     </prompt>
 	 <#list ivrOptions as ivrOption>
  	 	<prompt>
  	 		 ${ivrOption.option}.${printMessage(ivrOption.optionMessage)}
   		<prompt>
  	 </#list>
   </field>
   
  <block>
    
    <prompt>
      <@macro.sample />
    </prompt>
    <prompt>
        
    </prompt>
    <submit namelist="customerid age" next="http://xyz.com"/>
  </block>
</form>

</vxml>