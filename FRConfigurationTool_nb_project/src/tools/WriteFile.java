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

import java.io.*;
import java.util.ArrayList;
import subrelationshipsfinder.FundamentalCategories.Category;

/**
 *Write content in file in various ways
 * @author christos-Katerina
 */
public class WriteFile {

    public static String fileSeparator = System.getProperty("file.separator");
/**
     * Write the RESULTS.xml file
     * @param wrstr the content
     * @throws IOException 
     */
    public static void write(String wrstr) throws IOException {
        Writer output = null;
     
        String text = wrstr;

        File file = new File("./src/results/RESULTS.xml");
        output = new BufferedWriter(new FileWriter(file));
        output.write(text);
        output.close();

        // set file to writable
        file.setWritable(true);

        //System.out.println("Your file RESULTS.xml has been written!");
    }

    /**
     *  Writes specified content in specified filepath
     * @param wrstr the content
     * @param fl the filename
     * @param override
     * @return a outcome message
     */
    public static String write_general(String wrstr, String fl, boolean override) {

        try {
            Writer output = null;
            String text = wrstr;

            File file = new File(fl);
            if (file.exists()) {
                if (!override) {
                    return "exists";
                }
            }
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
            output.close();

            // set file to writable
            file.setWritable(true);

          
        } catch (IOException ex) {

            ex.printStackTrace();
            return "Error Writing File to directory: \n" + fl;
        }
        return "success";
    }

    /**
     * Saves the user's path, sparql or template to the respective folders 
     * @param domain the path's domain
     * @param range the path's range
     * @param FRname FR name
     * @param content the content to be saved in the file
     * @param type type of string to be saved
     * @param overrride true overrides the existing content of the file
     * @return outcome message and saved filename
     */
    public static ArrayList<String> saveFileFromInterface(Category domain, Category range, String FRname, String content, String type, boolean overrride) {
        ArrayList<String> results = new ArrayList<String>();
        String output = "";
        String fileDir = System.getProperty("user.dir");
        String fileName = domain + FRname + range;



        if (type.equalsIgnoreCase("Relationship") || type.equalsIgnoreCase("subRelationship")) {
            fileDir += fileSeparator + "Fundamental" + fileSeparator + domain.toString().toUpperCase() + fileSeparator;
            fileDir += domain.toString().toUpperCase() + "-" + range.toString().toUpperCase() + fileSeparator;
            fileDir += fileName + "Path.txt";
            output = write_general(content, fileDir, overrride);

        } else if (type.equalsIgnoreCase("sparql")) {
            fileDir += fileSeparator + "SPARQLs" + fileSeparator + fileName + "Sparql.txt";
            output = write_general(content, fileDir, overrride);
        } else if (type.equalsIgnoreCase("template")) {
            fileDir += fileSeparator + "Templates" + fileSeparator + fileName + "Template.xml";
            output = write_general(content, fileDir, overrride);
        } else {
            output = "Nothing to save!";
        }
        results.add(output);
        results.add(fileDir);

        return results;
    }

    /**
     * This method appends a file with more text.
     * @param context The text to be added
     * @param filename the name of the file
     * @return
     */
    public static String appendFile(String context, String filename) {

        try {
            
            // Create file 
            FileWriter fstream = new FileWriter(filename, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(context+"\n");
            //Close the output stream
            out.close();
        } catch (IOException ex) {

            ex.printStackTrace();
            return "Error Appending File: \n" + filename;
        }
        return "success";
    }
}
