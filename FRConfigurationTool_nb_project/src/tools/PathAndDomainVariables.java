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
package tools;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Keeps the first and last and domain class of a path
 * @author Katerina
 */
public class PathAndDomainVariables {

    public Hashtable<Integer, ArrayList<String>> qtable;
    public ArrayList<String> domainVar;
    public String EndVarClass;
    public String StartVarClass;

    public ArrayList<String> getDomainVar() {
        return domainVar;
    }

    public String getEndVarClass() {
      
        return EndVarClass;
    }

    public void setEndVarClass(String EndVarClass) {

        String withPrefix=crmPrefix(EndVarClass);
        this.EndVarClass = withPrefix;
    }

    public String getStartVarClass() {
  
        return StartVarClass;
    }

    public void setStartVarClass(String StartVarClass) {
        String withPrefix = crmPrefix(StartVarClass);
        this.StartVarClass = withPrefix;
    }

    public void setDomainVar(ArrayList<String> domainVar) {
        this.domainVar = domainVar;
    }

    public Hashtable<Integer, ArrayList<String>> getQtable() {
        return qtable;
    }

    public void setQtable(Hashtable<Integer, ArrayList<String>> qtable) {
        this.qtable = qtable;
    }
/**
     * adds the prefix to a predicate
     * @param withoutprefix
     * @return 
     */
    private static String crmPrefix(String withoutprefix) {

        String AssociationTable[][] = VariableFileReader.startLeterAs_read_variables_of("StartLetterAssociation");
        String selectNamespace = "";
        String prefixVar = "";


        for (int g = 0; g < AssociationTable.length; g++) {

            /* Assigning prefix to predicate according to the
             * link's first letter
             */

            if (AssociationTable[g][0].equals(Character.toString(withoutprefix.charAt(0)))) {
                selectNamespace = AssociationTable[g][1];
                prefixVar = selectNamespace + ":" + withoutprefix;
                //re-construct the OR of predicates with the prefixes
                //if it is the first we donnot add the OR

            }
        }

        return prefixVar;
    }
}
