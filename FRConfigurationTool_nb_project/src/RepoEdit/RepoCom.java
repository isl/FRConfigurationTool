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



package RepoEdit;

import java.io.IOException;
import java.util.Properties;

import org.openrdf.model.Resource;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.TupleQueryResultHandlerException;
import org.openrdf.repository.RepositoryException;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFParseException;

//import COFORM.DataTypes.RDFResourceID;
// import COFORM.DataTypes.SPARQLStatement;

import java.util.List;
import org.w3c.dom.NodeList;
import tools.FileReader;
import tools.WriteFile;


public class RepoCom {

	/**
	 * @param args
	 * @throws RepositoryException 
	 */
	public static void Repository_Select_Query(String query,MRepositoryManager mrm) throws QueryEvaluationException,RepositoryException, IOException, Exception {
		
      
            try {
             
                WriteFile.write(mrm.runSPARQL2XMLString(query));
            
            } catch (MalformedQueryException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            } 
             catch (TupleQueryResultHandlerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            
	}
        
        /**
	 * @param args
	 * @throws RepositoryException 
         * @return boolean
	 */
	public static boolean Repository_Ask_Query(String query,MRepositoryManager mrm) throws QueryEvaluationException,RepositoryException, IOException, Exception {
		
          
            boolean response = false;
            
            try {
                response = mrm.runSPARQL2AskBoolean(query);
                
            } catch (MalformedQueryException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }  catch (TupleQueryResultHandlerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            
            return response;
            
	}
	
	

}
