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
</@pt.page>