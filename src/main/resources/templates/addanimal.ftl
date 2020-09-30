<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
  <h2>Add animal for ${user.firstName} ${user.surname} ${user.lastName}</h2>
  <form method="post">
      <#if animalError?? && animalError?has_content><div style="color:red">${animalError}</div></#if>
    <input type="hidden" name="id"
           value="<#if animal?? && animal.id??>${animal.id}</#if>"/>
    <input type="text" name="name" placeholder="Name"
           class="form-control ${(nameError??)?string('is-invalid', '')}"
           value="<#if animal?? && animal.name??>${animal.name}</#if>"/>
    <input type="text" name="species" placeholder="species"
           class="form-control ${(speciesError??)?string('is-invalid', '')}"
           value="<#if animal?? && animal.species??>${animal.species}</#if>" />
    <input type="text" name="sex" placeholder="sex"
           class="form-control ${(sexError??)?string('is-invalid', '')}"
           value="<#if animal?? && animal.sex??>${animal.sex}</#if>" />
    <input type="date" name="birth"
           class="form-control ${(birthError??)?string('is-invalid', '')}"
           value="<#if animal?? && animal.birth??>${animal.birth}</#if>">
    <input type="hidden" name="animalOwner"
           class="form-control ${(animalOwnerError??)?string('is-invalid', '')}"
           value="<#if user??>${user.id}</#if>" />
    <button type="submit" style="color: black"><#if animal??>Edit<#else>Add</#if></button>
  </form>
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
      <th></th>
    </tr>
    <tbody>
    <#list animals as animal>
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
</@pt.page>