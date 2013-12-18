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



---------------------------------------------------------------------------
						Brief paths
---------------------------------------------------------------------------

For reasons of efficiency, some big FRs have been re-written using custom 
owlim rules. In this folder you can find these FRs and the new shorter paths. 
We have not replaced the big paths with these in the respective folders 
(existing in ./Fundamental folder) because we want to maintain the full 
paths to maintain the functionality of the 'Fundamental Relationships 
configuration tool'.
If in the future new rules are made and more paths are to be shorten 
we suggest NOT to replace the big ones with the short ones,
but to keep the short version in this folder.
The rules created for this purpose can be found in the sesame set up folder, 
under the path ./sesameSetup/ontotext_owlim/Rules_custom_big.pie