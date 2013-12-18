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

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 *
 * @author Christos
 */
public class KeyboardInput {
    
    public static String readLine() {
    StringBuffer response = new StringBuffer();
    try {
      BufferedInputStream buff = new BufferedInputStream(System.in);
      int in = 0;
      char inChar;
      do {
        in = buff.read();
        inChar = (char) in;
        if ((in != -1) & (in != '\n') & (in != '\r')) {
          response.append(inChar);
        }
      } while ((in != -1) & (inChar != '\n') & (in != '\r'));
      buff.close();
      return response.toString();
    } catch (IOException e) {
      System.out.println("Exception: " + e.getMessage());
      return null;
    }
  }
    
}
