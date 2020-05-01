<#flush>

<#function returnCity countryCapitalList string >
    <#list countryCapitalList?keys as key> 
 	   <#if string?? && key == string>
 	   		<#return countryCapitalList[key]> 
 	   </#if>
	</#list> 
</#function>


<prompt>
	<#list countryCapitalList?keys as key> 
 	   ${key} = ${countryCapitalList[key]} 
	</#list> 
 </prompt>
 
 <prompt>
 	<#assign city = returnCity(countryCapitalList , "India")?upper_case>
 	India Capital is ${city}
 </prompt>
	