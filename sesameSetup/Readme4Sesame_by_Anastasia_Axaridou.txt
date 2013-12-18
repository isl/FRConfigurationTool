

------------------------------------------
*** HOW TO WORK WITH SESAME (optional) ***
------------------------------------------
You can work with sesame by using Sesame's web application called 
'openrdf-workbench', available at:
	http://localhost:8080/openrdf-workbench

With openrdf-workbench you can:

- view the existing Sesame repositories.

- connect to a repository by making it the current one.

- view the contexts (a mechanism for grouping relations) that 
  exist in the current repository.

- execute SPARQL statements in the current repository.


----------------------------------------------------------------
*** SESAME--HOW TO RESET (explanation)
----------------------------------------------------------------
----Clean Seasame repositories----
An easy way to clean all Sesame repositories, is stop the server 
and then delete the repository folders:
<HOME_DIR>\sesame_data\OpenRDF Sesame\repositories\{SYSTEM,etc}.
To clean data from a repository, perhaps delete the contents of a 
repository folder is ok.

----Reset Sesame repositoty schemas and data----
To reset completely Sesame and replace/update the initial schemas, 
do the next steps:

1. stop the RI-server.
2. delete all repository folders: <HOME_DIR>\sesame_data\OpenRDF Sesame\repositories
3. update the ontologies in folder <HOME_DIR>\ontotext_owlim\ontology
4. to update the initial schemas and namespaces, follow the instructions 
   in <HOME_DIR>\ontotext_owlim\Readme4OWLIM.txt
5. start the RI-server
6. use openrdf-workbench to create a new OWLIM repository. 
   For SwiftOWLIM, in 'Repository type' option select "In-memory" and for BigOWLIM "File".


----Verification----
To verify that a Sesame-OWLIM repository is actually back to its initial 
state you may check:

i. http://localhost:8080/openrdf-workbench/repositories/<REPOSITORY_NAME>/Namespaces, 
to see if the expected namespaces can be listed on the page without errors.
ii. http://localhost:8080/openrdf-workbench/repositories/<REPOSITORY_NAME>/Types, 
to see if only rdf, rdfs, and owl types are listed on the page. 
Other types e.g. crm type will be added to this list after rdf data ingestion.
