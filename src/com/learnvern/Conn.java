
package com.learnvern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


class Conn {
    Connection c;
    Statement s;
    Conn(){ //no main method coz just use object only of this class does't run it.
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //initialise driver using forname with argument(address pass of driver
            c = DriverManager.getConnection("jdbc:mysql:///inventorysystem","root","sbjilu11"); //establish connection
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
