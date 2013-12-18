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



package schemacoveragechecker;

import RepoEdit.MRepositoryManager;
import RepoEdit.RepositoryManager.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openrdf.repository.RepositoryException;
import tools.FileReader;

/**
 * Used in order to find which of the super properties in CIDOC crm are not covered
 * by properties in the FR schema
 * @author Katerina
 */
public class SchemaCoverageChecker {


    /**
     * Checks what properties of the schemata of the repository are not included in the FRs
     * @param mrm
     * @return the uncovered properties (only super-properties i.e. properties that don't have other sub-properties rather than them)
     */
    public static String checkShemaCoverage(MRepositoryManager mrm) {
        ArrayList<String> coformSuperProperties = new ArrayList<String>();
        String result = "";
       
            COFORMSchema cof = new COFORMSchema();
         
            coformSuperProperties = cof.ListSuperPredicates(mrm);
            String fundamentalFolder = System.getProperty("user.dir") + System.getProperty("file.separator")
             +FileReader.readPathConfigFile("fundamentalFolder");

            File f = new File(fundamentalFolder);
            QueryingSchema qs = new QueryingSchema();
            HashSet<String> queryingProps = qs.ListProperties(f, mrm);


            for (String fundamentalProperty : queryingProps) {
                if (coformSuperProperties.contains(fundamentalProperty)) {
                    coformSuperProperties.remove(fundamentalProperty);
                }

            }

            result = "Number of not covered properties in CIDOC: " + coformSuperProperties.size() + "\n";
            result += "Uncovered Properties: \n";
            result += "---------------------\n";
            for (String uncoveredProperty : coformSuperProperties) {
             
                result += uncoveredProperty+"\n";
            }

        
        return result;



    }
}
