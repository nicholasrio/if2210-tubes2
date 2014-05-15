/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package katalogv;

import java.sql.SQLException;

/**
 *
 * @author KURING
 */
public class KatalogV {

    /**
     * @param args the command line arguments
     */
    public static void main(String arg[]){
        //contoh pemanggilan
        try {
            SqlStatement s = new SqlStatement();
            s.select_group();
            System.out.println("Success");
        }
        catch(SQLException e){
            System.out.println("Failed");
            e.printStackTrace();
        }
    }
}
