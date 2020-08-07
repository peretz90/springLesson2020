<#import "../pager.ftl" as p>

<h1>Our animals</h1>
<#if hasContent>
<@p.pager url page/>
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Species</th>
		<th>Sex</th>
		<th>Birthday</th>
		<th>isDelete</th>
		<th></th>
		<th></th>
	</tr>
	<tbody>
  <#list page.content as animal>
		<tr ${animal.deleted?then('class="alert-danger"', "")}>
			<td>${animal.id}</td>
			<td>${animal.name}</td>
			<td>${animal.species}</td>
			<td>${animal.sex}</td>
			<td><#if animal.birth??>${animal.birth}</#if></td>
			<td><#if animal.deleted??>
              ${animal.deleted?then("true", "false")}
          </#if></td>
			<td><a href="/animals?editAnimal=${animal.id}">edit</a></td>
			<td>${animal.deleted?then('<a href="/animals?repairId=${animal.id}">repair</a>', '<a href="/animals?removeId=${animal.id}">remove</a>')}</td>
		</tr>
  </#list>
	</tbody>
</table>
<@p.pager url page/>
<#else>
		<b>No animals!</b>
</#if>

