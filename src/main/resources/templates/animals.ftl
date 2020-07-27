<h1>Add animal</h1>
<form method="post">
    <input type="text" name="name" placeholder="Name"
        class="form-control ${(nameError??)?string('is-invalid', '')}"
        value="<#if animal??>${animal.name}</#if>"/>
    <input type="text" name="species" placeholder="species"
           class="form-control ${(speciesError??)?string('is-invalid', '')}"
           value="<#if animal??>${animal.species}</#if>" />
    <input type="text" name="sex" placeholder="sex"
           class="form-control ${(sexError??)?string('is-invalid', '')}"
           value="<#if animal??>${animal.sex}</#if>" />
    <input type="date" name="birth"
        class="form-control"
        value="<#if animal??>${animal.birth}</#if>" />
    <button type="submit" style="color: black">Add</button>
</form>

<h1 class="bg-dark">Our animals</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Species</th>
        <th>Sex</th>
        <th>Birthday</th>
        <th>create</th>
        <th>update</th>
    </tr>
    <tbody>
    <#list animals as animal>
        <tr>
            <td>${animal.id}</td>
            <td>${animal.name}</td>
            <td>${animal.species}</td>
            <td>${animal.sex}</td>
            <td>${animal.birth}</td>
            <td style="color: gray">${animal.createdDate}</td>
            <td style="color: aquamarine">${animal.updatedDate}</td>
        </tr>
    </#list>
    </tbody>
</table>