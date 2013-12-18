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
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *This is a list consisting of the defined multi-instantiation classes, created from
 * the respective file for multi-instantiation classes (in the set up folder).
 *The procedure is analogous to the disjointness classes. 
 * @author katetzob
 */
public class All_Classes_Multinstantiation_List {

    public static ArrayList<Class_MultiInstantiation> list;

    /**
     * 
     */
    public void createList() {
        list = readMultiInstFileToListOfClassMulitinst();



    }

    /**
     * Finds which classes can be multiple-instantiated with which classes and saves them together in a new object
     * All the new objects are returned in a list
     * 
     * @param prop
     * @return 
     */
    private ArrayList<Class_MultiInstantiation> readMultiInstFileToListOfClassMulitinst() {

        ArrayList<Class_MultiInstantiation> list = new ArrayList<Class_MultiInstantiation>();

        try {

            FileInputStream fstream = new FileInputStream(ToolInterface.multiInstantPath);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {

                String firstClass = strLine.substring(0, strLine.indexOf(":"));
                firstClass = firstClass.replaceAll(" ", "");
                String otherClasses = strLine.substring(strLine.indexOf(":") + 1);
                otherClasses = otherClasses.replaceAll(" ", "");
                String[] table = otherClasses.split(",");
                Class_MultiInstantiation classMultiInst = new Class_MultiInstantiation(firstClass, table);
                list.add(classMultiInst);
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return list;
    }
}
