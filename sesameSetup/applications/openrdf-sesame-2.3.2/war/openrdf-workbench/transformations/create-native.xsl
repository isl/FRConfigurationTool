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
								<option value="native">
									Native Java Store
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
								name="Repository ID" size="16" value="native" />
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
								name="Repository title" size="48" value="Native store" />
						</td>
						<td></td>
					</tr>
					<tr>
						<th>
							<xsl:value-of
								select="$repository-indexes.label" />
						</th>
						<td>
							<input type="text" id="indexes"
								name="Triple indexes" size="16" value="spoc,posc" />
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
