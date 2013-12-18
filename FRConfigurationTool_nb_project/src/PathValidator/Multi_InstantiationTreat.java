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



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PathValidator;

import GUI.ToolInterface;
import java.util.ArrayList;
import tools.FileReader;
import tools.WriteFile;

/**
 *This class checks whether a multiple-instantiation case occurs and treats it accordingly.
 * @author Katerina
 */
public class Multi_InstantiationTreat {

    private boolean exist;

  
    /**
     * Checks if one class is multiple-instantiated with another
     * @param firstClass the class to be checked
     * @param secondClass the class to be found in the multiple-instantiation table of the first class
     * @param all the user-typed expression (e.g. A:B) that will be used in order to be saved or removed
     * @param type indicates if the action will be to remove or add the case
     * @return 
     */

    public String checkExistenceInMulti(String firstClass, String secondClass, String all, String type) {

        if (ToolInterface.multiClassList == null) {
            ToolInterface.multiClassList = new All_Classes_Multinstantiation_List();
            ToolInterface.multiClassList.createList();
        }

        checkMultiClassList(firstClass, secondClass, all, type);

        String result = "fail";
        if (exist) {
            result = "success";
        }
        if (!exist && type.equalsIgnoreCase("remove")) {

            result = "The multi-instantiation case you provided does not exist!";
        }
        return result;
    }

    private void checkMultiClassList(String firstClass, String secondClass, String all, String type) {


        boolean existsMulti = false;
        String[] multList = null;
        Class_MultiInstantiation foundClass = null;
        if (ToolInterface.multiClassList != null) {
   
            ArrayList<Class_MultiInstantiation> list = ToolInterface.multiClassList.list;
            for (Class_MultiInstantiation multi : list) {
              if (multi.getGivenClass().equalsIgnoreCase(firstClass)) {
                    exist = true;
                    multList = multi.getMultiList();
                    foundClass = multi;
                    break;
                }

            }
            //if there are already multi cases defined for the first class
            if (exist == true) {
              
                for (String multi : multList) {
                  
                    if (multi.equalsIgnoreCase(secondClass)) {
                        existsMulti = true;
                   
                        break;
                    }
                }
                //if the secondclass is not in the multiList, add it

                if (!existsMulti) {
             
                    if (type.equalsIgnoreCase("remove")) {
                        exist = false;
                        return;
                    }
                    String newMultiContext = FileReader.changeDisjointORMultiFile(ToolInterface.multiInstantPath, firstClass, secondClass, type);
                    String res = WriteFile.write_general(newMultiContext, ToolInterface.multiInstantPath, true);
                 
                    if (!res.equalsIgnoreCase("success")) {
                        exist = false;
                    }

                } else {
                    if (type.equalsIgnoreCase("remove")) {

                        String newMultiContext = FileReader.changeDisjointORMultiFile(ToolInterface.multiInstantPath, firstClass, secondClass, type);
                        String res = WriteFile.write_general(newMultiContext, ToolInterface.multiInstantPath, true);
                       
                        if (!res.equalsIgnoreCase("success")) {
                            exist = false;
                        }
                    }
                }


                return;
            } else {
                if (type.equalsIgnoreCase("add")) {
                    String append = WriteFile.appendFile(all.replaceAll(" ", ""), ToolInterface.multiInstantPath);
                    if (append.equalsIgnoreCase("success")) {
                        exist = true;
                    }
                } else {
                    exist = false;
                }
            }
        }



    }
}
