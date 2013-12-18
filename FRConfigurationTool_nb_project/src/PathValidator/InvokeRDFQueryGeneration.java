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
import RepoEdit.MRepositoryManager;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import subrelationshipsfinder.FundamentalCategories.Category;
import subrelationshipsfinder.NewRelationship;
import tools.WriteFile;
import tools.*;

/**
 *  Contains the necessary methods in order to create query statements 
 * in SPARQL or IVB template
 * @author katetzob
 */
public class InvokeRDFQueryGeneration {

    /**
     * With this method we invoke the translation of a FR path to
     * SPARQL or IVB template format. The result is also written in the SPARQL.txt
     * under the user directory in the folders results/SPARQLS
     * @param inputStr the path
     * @param type sparql or template
     * @param mrm 
     * @param relName the fundamental relationship name (for ivb template usage)
     * @return the sparql or template
     */
    public static String QueryGen(String inputStr, String type, MRepositoryManager mrm,String relName) {

        Path2SPARQLv2 p2s=new Path2SPARQLv2();
        Hashtable<String, String> results = p2s.SPARQLgen(inputStr);
        String query = results.get("query");
  
        if (type.equalsIgnoreCase("IVBtemplate")) {
            query = PathToIVBTemplate.templateCreator(query, results.get("domain"), results.get("range"), relName, mrm);

        } else {
            NewRelationship newRel = new NewRelationship();
            newRel.setMrm(mrm);
            Category domainCat = newRel.findCategoryFromVar(results.get("domain"), mrm);
            Category rangeCat = newRel.findCategoryFromVar(results.get("range"), mrm);
            ToolInterface.range = rangeCat;
            ToolInterface.domain = domainCat;

        }
        return query;
    }
}
