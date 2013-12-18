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



------------------------------------------------------------------------------------------
						Fundamental
------------------------------------------------------------------------------------------

This folder contains the paths for each one Fundamental Relationship defined in this project. 
The organization of the paths is performed in a strict way, which MUST be maintained as is for
sake of the functionality of the 'Fundamental Relationship Configuration Tool'.
The first level of hierarchy is the Fundamental Categories. Thus, there exist 6 
folders, each one for each FC: 
	Thing
	Place
	Actor
	Concept
	Time
	Event

In each of these folders, we store the paths that have as domain (starting) class the respective FC. 
For instance in the Actor folder we can find all the paths that refer to actors,
or in other words that can answer questions about Actors e.g. "which 'Actor is from Crete' ?".
The second level of hierarchy is again the Fundamental Categories, for that we make all the
possible combinations of FC-FC. For example in the folder Actor, there are 6 sub-folders,
one for each combination: 
	Actor
	  Actor-Thing
          Actor-Place
	  Actor-Actor
	  Actor-Concept
	  Actor-Time
	  Actor-Event

In each folder we store the respective paths, that have as domain class the first FC (also the 
name of the upper folder) and as range class the second FC. For example, in the Actor-Thing folder 
we store the FRs with domain class Actor and range the class Thing, e.g. Actor has Thing, Actor 
created Thing etc.

Each path is written in a specific format that again must be followed:
<DomainFC><FR><RangeFc>'Path.txt' for example: "ActorFromActorPath.txt".

The user is not supposed to modify the paths or create new paths directly in this folder,
but through the use of the 'Fundamental Relationship Configuration Tool'.

For more information about this folder, you can also refer to the master thesis, 
chapter 4, in the documentation folder.