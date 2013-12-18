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
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import subrelationshipsfinder.FundamentalCategories.Category;
import subrelationshipsfinder.NewRelationship;
import tools.FileReader;

/**
 * Turns the path to IVB template, using the pathToSPARQL code
 * @author Katerina
 */
public class PathToIVBTemplate {

    /**
     * Creates the template for the IVB component. The input variables are case sensitive
     * @param sparql
     * @param domain
     * @param range
     * @param Rname
     * @param mrm
     * @return
     */
    public static String templateCreator(String sparql, String domain, String range, String Rname, MRepositoryManager mrm) {

        String xmlSparql = alterSparqlToTemplate(sparql);
        NewRelationship newRel =new NewRelationship();
        newRel.setMrm(mrm);
        Category domainCat=newRel.findCategoryFromVar(domain,mrm);
        Category rangeCat=newRel.findCategoryFromVar(range,mrm);
        String domainTempl=domainCat.toString().substring(0, 1)+domainCat.toString().substring(1).toLowerCase();
        String rangeTempl=rangeCat.toString().substring(0, 1)+rangeCat.toString().substring(1).toLowerCase();
      //the ivb reads 'Type' instead of Concept
        if(rangeTempl.equalsIgnoreCase("concept")){
        rangeTempl="Type";
        }
         if(domainTempl.equalsIgnoreCase("concept")){
        domainTempl="Type";
        }
        ToolInterface.range=rangeCat;
        ToolInterface.domain=domainCat;
      //create the default elements of the template and add the extra strings
        String template = "<?xml version=\"1.0\"?>\n"
                + " <relation>\n"
                + " <subject>"+domainTempl+"</subject>\n"
                + " <object>"+rangeTempl+"</object>\n"
                + " <name>"+Rname+"</name>\n"
                +" <label>"+Rname+"</label>\n"
                +" <query>\n"
                +xmlSparql
                +"</query>\n </relation>";
                ;

        return template;
    }

    private static String alterSparqlToTemplate(String sparql) {
        String templateFormat = sparql.substring(sparql.indexOf("$Label. }") + 9);
        templateFormat = templateFormat.substring(0, templateFormat.length() - 1);
        templateFormat = templateFormat.replaceAll("StartVar", "uri");
        templateFormat = templateFormat.replaceAll("Endvar", "param");

        templateFormat = "<![CDATA[  \n" + templateFormat + "\n ]]>";

        return templateFormat;
    }
}
