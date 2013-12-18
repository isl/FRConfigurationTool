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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author christos
 */
public class VariableFileReader {
    
    public static Stack stack_read_variables_of(String varOf){
        
        Stack<String> varstack = new Stack<String>();
        
        try{
                // Open the file that is the first 
                // command line parameter
                FileInputStream fstream = new FileInputStream("src/PathValidator/var.conf");
                // Get the object of DataInputStream
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                
                //Read File Line By Line
                while ((strLine = br.readLine()) != null){
                        // Print the content on the console
                        //System.out.println (strLine);
                        varstack.push(strLine);
                        
                }
                    //Close the input stream
                    in.close();
            }
        catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        
        
        /*  
         */
        String varOfStart = "==========" + varOf + "_START==========";
        String varOfEnd = "==========" + varOf + "_END==========";
        Stack<String> clstack = new Stack<String>();
        boolean clFlag = false;
        int i=0;
        
        while (i<varstack.size()){
            
            
            
            //elegxos gia to ean teleiosan ta pedia me tis metablites gia tis classes
            if (varOfStart.equals(varstack.elementAt(i)))
            {
                clFlag = false;
            }
            
            
            // eisagogi metabliton sxetika me classes
            if (clFlag==true)
            {
               clstack.push(varstack.elementAt(i));
            }
            
            
            //elegxos gia to ean briskomai mesa sta pedia me tis metablites gia tis classes
            if (varOfEnd.equals(varstack.elementAt(i)))
            {
                clFlag = true;
            }
            
            i++;
        }
        
        //System.out.println(varstack);
        //System.out.println("clstack  "+clstack);
        varstack.removeAllElements();
        //System.out.println(varstack);
        
        return clstack;
    }
    
    
    
    /**
     * Read from file the variables of associations and return a String[][] with that associations
     */
    
    public static String[][] startLeterAs_read_variables_of(String varOf){
        
        Stack<String> varstack = new Stack<String>();
        
        try{
                // Open the file that is the first 
                // command line parameter
                FileInputStream fstream = new FileInputStream("src/PathValidator/var.conf");
                // Get the object of DataInputStream
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                
                //Read File Line By Line
                while ((strLine = br.readLine()) != null){
                        // Print the content on the console
                        //System.out.println (strLine);
                        varstack.push(strLine);
                        
                }
                    //Close the input stream
                    in.close();
            }
        catch (Exception e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            }
        
        
        /*  
         */
        String varOfStart = "==========" + varOf + "_START==========";
        String varOfEnd = "==========" + varOf + "_END==========";
        
        Stack<String> tmpstack = new Stack<String>();
        boolean clFlag = false;
        int i=0;
        
        while (i<varstack.size()){
            
            
            
            //elegxos gia to ean teleiosan ta pedia me tis metablites gia tis classes
            if (varOfEnd.equals(varstack.elementAt(i)))
            {
                clFlag = false;
            }
            
            
            // eisagogi metabliton sxetika me classes
            if (clFlag==true)
            {
               tmpstack.push(varstack.elementAt(i));
                
            }
            
            
            //elegxos gia to ean briskomai mesa sta pedia me tis metablites gia tis classes
            if (varOfStart.equals(varstack.elementAt(i)))
            {
                clFlag = true;
            }
            
            i++;
        }
        
        varstack.removeAllElements();
        
        /* Create a table which has the length of stack and have
         */
        String [][] returnTable = new String [tmpstack.size()][2];
        
        for (i=0;i<tmpstack.size();i++){
            /* Split the sting and save each value in a specific position at 
             * the returnTable
             */
            String [] tmpSplitAr = tmpstack.elementAt(i).split("@"); 
            
            returnTable [i][0] = tmpSplitAr[0];
            returnTable [i][1] = tmpSplitAr[1];
        }
        
        
        return returnTable;
    }
    
}
