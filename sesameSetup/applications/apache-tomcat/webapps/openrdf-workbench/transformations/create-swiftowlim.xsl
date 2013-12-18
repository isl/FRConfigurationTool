<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE rdf:RDF [
<!ENTITY xsd  "http://www.w3.org/2001/XMLSchema#" >
 ]>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
	xmlns:sparql="http://www.w3.org/2005/sparql-results#"
	xmlns="http://www.w3.org/1999/xhtml">

   <xsl:include href="../locale/messages.xsl" />

   <xsl:variable name="title">
      <xsl:value-of select="$repository-create.title" />
   </xsl:variable>
   
   <xsl:include href="template.xsl" />

   <xsl:template match="sparql:sparql">
      <script type="text/javascript">
		<![CDATA[
		function populateParameters() {
			var href = document.location.href;
			var elements = href.substring(href.indexOf('?') + 1).split(decodeURIComponent('%26'));
			for (var i=0;elements.length-i;i++) {
				var pair = elements[i].split('=');
				var value = decodeURIComponent(pair[1]).replace(/\+/g, ' ');
				if (pair[0] == 'id') {
					document.getElementById('id').value = value;
				}
				if (pair[0] == 'title') {
					document.getElementById('title').value = value;
				}
			}
		}
		window.onload = function() {
			populateParameters();
		}
		
		function setCustomRuleset(value) {
			value = value.replace(/\\/g, '/');
			document.getElementById('customRulesetOption').value = value;
			document.getElementById('customRulesetOption').selected = true;
		}
		
		]]>
	</script>
      <form action="create" method="post">
         <table class="dataentry">
            <tbody>
               <tr>
                  <th>
                     <xsl:value-of
                        select="$repository-type.label" />
                  </th>
                  <td>
                     <select id="type" name="type">
                        <option value="owlim">
                           SwiftOWLIM
                        </option>
                     </select>
                  </td>
                  <td></td>
               </tr>
               <tr>
                  <th>
                     <xsl:value-of select="$repository-id.label" />
                  </th>
                  <td>
                     <input type="text" id="id"
                        name="Repository ID" size="16" value="SwiftOWLIM" />
                  </td>
                  <td></td>
               </tr>
               <tr>
                  <th>
                     <xsl:value-of
                        select="$repository-title.label" />
                  </th>
                  <td>
                     <input type="text" id="title"
                        name="Repository title" size="48" value="Sample SwiftOWLIM Repository" />
                  </td>
                  <td></td>
               </tr>

               <tr>
                  <td>Repository type
                  </td>
                  <td>
                     <select name="Repository type">
                        <option value="file-repository">File</option>
                        <option value="in-memory-repository" selected="true">In-Memory</option>
                        <option value="weighted-file-repository">Weighted</option>
                     </select>
                  </td>
                  <td></td>
               </tr>
               <tr>
                  <td>Ruleset
                  </td>
                  <td>
                     <select name="Ruleset">
                        <option value="rdfs">RDFS</option>
                        <option value="owl-horst">OWL/Horst</option>
                        <option value="owl-max">OWL/Max</option>
						<option id="customRulesetOption" value="../ontotext_owlim/Rules_custom.pie" selected="true">Select a Ruleset (.pie) file</option>
                     </select>
                     <label for="partialRDFS">Partial</label>
                     <input name="Partial RDFS" id="partialRDFS" type="checkbox" value="true" />
				  </td>
                  <td></td>
               </tr>
			   <tr>
			      <td>Select a custom Ruleset (.pie) file
                  </td>
			      <td>
                     <input name="select Ruleset" id="selectedRuleset" type="file" onchange="setCustomRuleset(this.value)" />
				  </td>
                  <td></td>
			   </tr>
               <tr>
                  <td></td>
                  <td>
                     <input type="button" value="{$cancel.label}"
                        style="float:right" href="repositories"
                        onclick="document.location.href=this.getAttribute('href')" />
                     <input type="submit"
                        value="{$create.label}" />
                  </td>
               </tr>
            </tbody>
         </table>
      </form>
   </xsl:template>

</xsl:stylesheet>

