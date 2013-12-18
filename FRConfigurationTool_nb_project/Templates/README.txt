/* 
 *  COPYRIGHT (c) 2010-2013 by Institute of Computer Science, 
 *  Foundation for Research and Technology - Hellas
 *  Contact: 
 *      POBox 1385, Heraklio Crete, GR-700 13 GREECE
 *      Tel:+30-2810-391632
 *      Fax: +30-2810-391638
 *      E-mail: isl@ics.forth.gr
 *      http://www.ics.forth.gr/isl
 *
 *   Authors :  Katerina Tzobanaki
 *
 *   This file is part of FRConfigurationTool, a tool for formulating recall-oriented 
 *   structured queries on semantic networks.
 *
 *    FRConfigurationTool is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *   FRConfigurationTool is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with FRConfigurationTool.  
 *   If not, see <http://www.gnu.org/licenses/>.
 * 
 */



------------------------------------------------------------------------
						TEMPLATES
------------------------------------------------------------------------

This folder contains the Templates for the Query Formulation Interface (QFI) 
of the Integrated Viewer Browser (IVB) component of the 3D-COFORM Project. 
These templates contain the SPARQL transformation of the FR paths and are 
used in the IVB so that the user can perform a 
query. In eachtemplate we specify: 
	- the domain category
	- the range category
	- the name of the FR 
NOTE: For the CONCEPT category, we use in the templates the Type label. 
Moreover, note that the labels are case sensitive.

These templates are to be copied in the folder 'cidoc/relationships' 
of the ivb set-up folder.

The templates are semi-automatically generated, by using the 'Fundamental 
Relationship Configuration tool'.