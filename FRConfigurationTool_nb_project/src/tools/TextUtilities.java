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

/**
 *
 * @author Christos
 */
/*
 * TextUtilities.java - Utility functions used by the text area classes
 * Copyright (C) 1999 Slava Pestov
 *
 * You may use and modify this package for any purpose. Redistribution is
 * permitted, in both source and binary form, provided that this notice
 * remains intact in all source distributions of this package.
 */



import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * Class with several utility functions used by the text area component.
 * 
 * @author Slava Pestov
 * @version $Id$
 */
public class TextUtilities
{
	
	


  /**
   * Returns the offset of the bracket matching the one at the specified offset
   * of the document, or -1 if the bracket is unmatched (or if the character is
   * not a bracket).
   * 
   * @param doc
   *           The document
   * @param offset
   *           The offset
   * @exception BadLocationException
   *               If an out-of-bounds access was attempted on the document
   *               text
   */
  public static int findMatchingBracket( Document doc, int offset ) throws BadLocationException
  {
    if( doc.getLength() == 0 )
      return -1;
    char c = doc.getText( offset, 1 ).charAt( 0 );
    char cprime; // c` - corresponding character
    boolean direction; // true = back, false = forward

    switch( c )
    {
    case '(' :
      cprime = ')';
      direction = false;
      break;
    case ')' :
      cprime = '(';
      direction = true;
      break;
    case '[' :
      cprime = ']';
      direction = false;
      break;
    case ']' :
      cprime = '[';
      direction = true;
      break;
    case '{' :
      cprime = '}';
      direction = false;
      break;
    case '}' :
      cprime = '{';
      direction = true;
      break;
    default :
      return -1;
    }

    int count;

    // How to merge these two cases is left as an exercise
    // for the reader.

    // Go back or forward
    if( direction )
    {
      // Count is 1 initially because we have already
      // `found' one closing bracket
      count = 1;

      // Get text[0,offset-1];
      String text = doc.getText( 0, offset );

      // Scan backwards
      for( int i = offset - 1; i >= 0; i-- )
      {
        // If text[i] == c, we have found another
        // closing bracket, therefore we will need
        // two opening brackets to complete the
        // match.
        char x = text.charAt( i );
        if( x == c )
          count++ ;

        // If text[i] == cprime, we have found a
        // opening bracket, so we return i if
        // --count == 0
        else if( x == cprime )
        {
          if( --count == 0 )
            return i;
        }
      }
    }
    else
    {
      // Count is 1 initially because we have already
      // `found' one opening bracket
      count = 1;

      // So we don't have to + 1 in every loop
      offset++ ;

      // Number of characters to check
      int len = doc.getLength() - offset;

      // Get text[offset+1,len];
      String text = doc.getText( offset, len );

      // Scan forwards
      for( int i = 0; i < len; i++ )
      {
        // If text[i] == c, we have found another
        // opening bracket, therefore we will need
        // two closing brackets to complete the
        // match.
        char x = text.charAt( i );

        if( x == c )
          count++ ;

        // If text[i] == cprime, we have found an
        // closing bracket, so we return i if
        // --count == 0
        else if( x == cprime )
        {
          if( --count == 0 )
            return i + offset;
        }
      }
    }

    // Nothing found
    return -1;
  }

  
  public static int  countCharsInPhrase(String input, char character){
  int count=0;
  int length=input.length();
  int point=0;
  while (point<length){
      
      if(input.charAt(point)==character) count++;
  point++;
  }
     // System.out.println("Number of characters "+count);
  return count;
  }
}
