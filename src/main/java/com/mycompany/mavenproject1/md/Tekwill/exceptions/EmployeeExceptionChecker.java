/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.md.Tekwill.exceptions;

import java.lang.Exception;
import com.mycompany.mavenproject1.md.Tekwill.exceptions.EmployeeException;

/**
 *
 * @author super
 */
public class EmployeeExceptionChecker {
    public static void checkInfo(String name, String lastName) throws EmployeeException{
        boolean bad=false;
        if( (name.length()==0) || (lastName.length()==0) ){
            bad=true;
        }
        
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            if( !(  (('a'<=c) && (c<='z')) || (('A'<=c) && (c<='Z'))  ) ){
                bad=true;
            }
        }
        
        for(int i=0; i<lastName.length(); i++){
            char c = lastName.charAt(i);
            if( !(  (('a'<=c) && (c<='z')) || (('A'<=c) && (c<='Z'))  ) ){
                bad=true;
            }
        }
        
        if(bad){
            throw new EmployeeException("<html>Name or last name of the employee aren't valid. <br> Only small or capital latin letters are accepted. </html>");
        }
    }
}
