 FRConfigurationTool
====================
  
   In the recent years there is a trend towards the creation of massive metadata 
   repositories, usually based on the RDF/S technology, as in the domain of cultural 
   heritage. ISO21127 (CIDOC Conceptual Reference Model) is a rich conceptual model 
   or ontology) capable of describing the world stored in such repositories. Simpler 
   models like those consisting only of 'core metadata' as in Dublin Core, lack the 
   expressiveness and the potentiality to integrate the knowledge and to apply 
   reasoning on it. Nevertheless, the more complex structure complicates the information 
   searching: the declarative SPARQL query formulation becomes harder for the user due 
   to the large number of ontology classes and properties, while on the other side keyword 
   search does not take advantage of the information structure. To address this problem, 
   we suggest a new approach: we introduce a simpler model consisting of few fundamental 
   classes and relationships aimed to be used for querying purposes only. 
   Information search with this model is easier and more intuitive for the users, since 
   its size and structure resemble those of the core metadata. Additionally, this model 
   provides high recall rates because in the fundamental relationships we capture the 
   total of potential paths over the CIDOC-CRM and also include property propagation 
   through these paths. With the latter though, we introduce a statistical factor 
   that may deteriorate precision since a property is not necessarily propagated along 
   a path. Precision improvement can be achieved by creating specializations of the 
   fundamental relationships or by adding more constraints on the queries. To define 
   the paths over the CIDOC-CRM schema that correspond to each fundamental relationship, 
   we have created a 'paths language' which is designed to be easy to write and to be 
   comprehended by non-expert users. Thereafter, we constructed a tool that utilizes 
   this language, permits the editing and validation of the fundamental relationships 
   and their translation to SPARQL and provides extra supportive functions.
   The proposed approach was proven adequate for expressing real research queries 
   originating from independent (to this work) scientists in the domain of cultural 
   heritage. The results of queries performed on repositories consisting of real 
   metadata were encouraging, showing even 100% recall, when the repository's information 
   was well-structured. Moreover we have shown that the usage of combined FRs in the 
   query can improve the precision rate.

This distribution contains:
README.txt:		           this file
brief paths:          	   contains the shortened paths (using rules) for selected FRs
documentation:             contains useful documents describing the functionality of the 
                           tool and other useful stuff regarding the design and implementation 
						   of the FRs-FCs Model
Fundamental:			   contains the paths for the Fundamental Relationship
sesameSetup:	      	   the set up folder for the sesame repository, used to connect 
                           locally the FR tool
FRConfigurationTool_nb_project:	   this is the project for development for Netbeans
 
COPYRIGHT (c) 2010-2013 by Institute of Computer Science, 
Foundation for Research and Technology - Hellas
Contact: 
    POBox 1385, Heraklio Crete, GR-700 13 GREECE
    Tel:+30-2810-391632
    Fax: +30-2810-391638
    E-mail: isl@ics.forth.gr
    http://www.ics.forth.gr/isl

 Authors :  Katerina Tzobanaki

 This file is part of FRConfigurationTool, a tool for formulating recall-oriented 
 structured queries on semantic networks.

    FRConfigurationTool is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

 FRConfigurationTool is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with FRConfigurationTool.  If not, see <http://www.gnu.org/licenses/>.


