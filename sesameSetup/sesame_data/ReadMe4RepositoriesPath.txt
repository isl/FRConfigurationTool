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
 
-------------------------------------------------
          Set Sesame Repositories Path
-------------------------------------------------


CURRENT TEXT VARIABLES AND ABBREVIATIONS
----------------------------------------

<APP>						Application name
<HOME_DIR>					The base directory of the application



To set the path for Sesame repositories:
----------------------------------------

1. Open <APP>-INIT.bat with text editor. (Located at: <HOME_DIR>\bin\<APP>-INIT.bat file.)

2. Locate at the: SET JAVA_OPTS=%JAVA_OPTS% -Dinfo.aduna.platform.appdata.basedir=
   and put the new file path.
   
   For example:
   
   SET JAVA_OPTS=%JAVA_OPTS% -Dinfo.aduna.platform.appdata.basedir=..\sesame_data	
