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
package rulesUpdate;

import RepoEdit.MRepositoryManager;
import java.util.ArrayList;
import org.openrdf.repository.RepositoryException;
import tools.FileReader;

/**
 * Testing purposes
 * @author katetzob
 */
public class Main {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {



        try {
            MRepositoryManager mrm = new MRepositoryManager("http://139.91.183.87:8080/openrdf-sesame", "Katerina");
            String pie = FileReader.readPathConfigFile("repositoryPieFile");
            RulesSet rulesSet = FileReader.readCustomCRMRulesFromPieFile(pie);
            String result="";
      
            for (Rule rule : rulesSet.rulesSet) {
                String rulePath = "";
                String consPath = "";
                String res = "";
 
                if (rule.getPremises() != null) {

                    for (int i = 0; i < rule.getPremises().size(); i++) {

                        String triple = rule.getPremises().get(i);
                        //if it is the starting triple and it is not the only one
                       
                        if (rule.getPremises().size() == 1) {
                            rulePath = triple;
                        } //if there are more than one triples and this is the first one
                        else if (i == 0) {
                            rulePath = triple + ":";
                        } //if there  are more than one triples and this is not the last one
                        else if (i != rule.getPremises().size() - 1) {
                            rulePath += "{" + triple + ":";
                        } else if (i == rule.getPremises().size() - 1) {
                            rulePath += "{" + triple;
                            for (int j = 0; j < rule.getPremises().size() - 1; j++) {
                                rulePath += "}";
                            }
                        }

                    }
                    for (int i = 0; i < rule.getConsequences().size(); i++) {

                        String triple = rule.getConsequences().get(i);
                        consPath += triple;
                    }


                    res = FindsubpathsEqualToRules.subRelFind(rulePath, mrm);
                    if (!res.equalsIgnoreCase("Given Path is not subpath of any Fundamental Relationship")) {
                    
                    
                    result+="The rule with ID: "+rule.getName()+" which corresponds to the path: \n"
                            +rulePath+ " can be applied to the following FRs\n"+
                            res+"To replace it, you can use one of the following consequences: \n";
                         for (int i = 0; i < rule.getConsequences().size(); i++) {

                        String triple = rule.getConsequences().get(i);
                        result += triple+"\n";
                    }
                    }
                }
            }
        } catch (RepositoryException ex) {
            ex.printStackTrace();
        }
    }
}
