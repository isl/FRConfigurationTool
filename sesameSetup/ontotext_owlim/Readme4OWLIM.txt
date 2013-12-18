
If schemas/ontologies/namespaces change, then next files should be updated with the new stuff.

file locations:


******<HOME_DIR>\applications\apache-tomcat\webapps\openrdf-workbench\WEB-INF\classes\org\openrdf\console\owlim.ttl or bigowlim.ttl

In entry 'owlim:defaultNS' add the namespaces' uris, as next:

owlim:defaultNS "{%defaultNS(';'delimited)|
<http://www.w3.org/2002/07/owl#>;
<http://www.ics.forth.gr/isl/rdfs/3D-COFORM_CIDOC-CRM.rdfs#>;
<http://www.ics.forth.gr/isl/rdfs/3D-COFORM_CIDOC-CRM.rdfs#>;
<http://www.ics.forth.gr/isl/rdfs/3D-COFORM_CRMdig.rdfs#>;
<http://www.ics.forth.gr/isl/rdfs/3D-COFORM_CIDOC-CRM.rdfs#>;
<http://www.ics.forth.gr/isl/rdfs/3D-COFORM_CRMdig.rdfs#>;%}";


In entry 'owlim:imports' add the ordered list of filepaths, for each one of the namespaces above, as next:

owlim:imports "{%imports(';' delimited)|
../ontotext_owlim/ontology/owl.rdfs;
../ontotext_owlim/ontology/3D-COFORM_CIDOC-CRM.rdfs;
../ontotext_owlim/ontology/3D-COFORM_CRMext.rdfs;
../ontotext_owlim/ontology/3D-COFORM_CRMdig.rdfs;
../ontotext_owlim/ontology/crm_reasoning.rdf;
../ontotext_owlim/ontology/crmdig_reasoning.rdf%}" ;



******<HOME_DIR>\ontotext_owlim\Rules_custom.pie
i. In this file make the appropriate updates in section 'Prefices', by adding/removing prefices and namespaces.
ii. Add/Remove/Update the custom rules section, at the end of the file: '//--------------- CUSTOM CRM RULES ----------'


******<HOME_DIR>\applications\apache-tomcat\webapps\openrdf-workbench\transformations\create-owlim.xsl or create-swiftowlim.xsl or create-bigowlim.xsl
In this files you can modify the filepath of the ruleset file.


******<HOME_DIR>\applications\apache-tomcat\webapps\openrdf-workbench\transformations\query.xsl
In this file you can set the prefices for querying, if they are not displayed automatically due to browser's caprices.


To create a new custom cidoc-crm rule: 

i)open the 'Rules_custom_big.pie' in the current folder.
ii) move to the line //--------------- CUSTOM CRM RULES END---------- 
    and add the premises and consequences of the rules BEFORE this line. Use the formatting of the rest of the rules, using always a unique id.
iii)if there are any newly created relationships, they should be added to the './ontology/3D-COFORM_CRMext.rdfs' ontology schema
iv)if there are any newly created relationships that contain reverse and forward links or other rdf reasoning, they should be defined in the './ontology/crm_reasoning.rdf'

------------------------
Note:
To use SwiftOWLIM or BigOWLIM reasoner with sesame, add the libs found in 'SwiftOWLIM-LIBs' or 'BigOWLIM-LIBs' in the 'WEB-INF\lib' folder of both 'openrdf-sesame' and 'openrdf-workbench'webapps.