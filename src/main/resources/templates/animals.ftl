<#import "parts/pageTemplate.ftl" as pt>



<@pt.page>
    <h2>Search</h2>
    <form method="get" action="animals">
        <input type="text" name="nameFilter" placeholder="Name" value="${nameFilter!}">
        <input type="text" name="speciesFilter" placeholder="Species" value="${speciesFilter!}">
        <input type="submit" value="Search">
    </form>
    <#include "parts/animalParts/animalList.ftl">
</@pt.page>