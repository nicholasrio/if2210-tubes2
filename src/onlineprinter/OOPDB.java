/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineprinter;

import java.io.Console;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luthfi Hamid M / 135120100
 */
public class OOPDB {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        // TODO code application logic here
        Console console = null;
        Scanner in = new Scanner(System.in);
        UserDao Data = new UserDaoImpl();
        String username;
        String password;
        String nama;
        String email;
        int saldo;
        User user = null;
        int pil;
        do {
            if (user != null)
            {
                System.out.println("Welcome, "+user.getNama());
            }
            System.out.println("1. Show All User");
            System.out.println("2. Search User Name");
            System.out.println("3. Add User");
            System.out.println("4. Delete User");
            if (user != null)
            {
                System.out.println("5. Logout");
                System.out.println("6. Show your data");
                System.out.println("7. Update your data");
            }
            else
            {
                System.out.println("5. Login");
            }
            System.out.print("Your Choice : ");
            pil = in.nextInt();
            switch (pil)
            {
                case 1 :
                    List<User> users = Data.getAllUser();
                    for (User usr : users)
                    {
                        System.out.println("#");
                        usr.print();
                    }
                    break;
                case 2 :
                {
                    System.out.print("Search : ");
                    username = in.next();
                    User usr = Data.getByUsername(username);
                    if (usr != null)
                    {
                        usr.print();
                    }
                    else
                    {
                        System.out.println("Not Found!");
                    }
                    break;
                }
                case 3 :
                {
                    System.out.print("Username : ");
                    username = in.next();
                    System.out.print("password : ");
                    password = in.next();
                    System.out.print("nama : ");
                    nama = in.next();
                    System.out.print("email : ");
                    email = in.next();
                    System.out.print("saldo : ");
                    saldo = in.nextInt();
                    User usr = new User(username,password,nama,email,saldo);
                    Data.AddUser(usr);
                }
                    break;
                case 4 :
                {
                    System.out.print("Search : ");
                    username = in.next();
                    Data.DeleteUser(username);
                } 
                    break;
                case 5 :
                    if (user != null)
                    {
                        user = null;
                    }
                    else
                    {
                        
                            System.out.print("Username : ");
                            username = in.next();
                            System.out.print("Password : ");
                            password = in.next();
                            System.out.println(password);
                            user = Data.Validate(username, password);
                    }
                    break;
                case 6 :
                    if (user != null)
                    {
                        user.print();
                    }
                    break;
                case 7 :
                {
                    if (user != null)
                    {
                        String c_user = user.getUsername();
                        System.out.print("Username : ");
                        username = in.next();
                        user.setUsername(username);
                        System.out.print("password : ");
                        password = in.next();
                        user.setPassword(password);
                        System.out.print("nama : ");
                        nama = in.next();
                        user.setNama(nama);
                        System.out.print("email : ");
                        email = in.next();
                        user.setEmail(email);
                        System.out.print("saldo : ");
                        saldo = in.nextInt();
                        user.setSaldo(saldo);
                        Data.UpdateUser(c_user, user);
                    }
                }
                    break;
                default : break;
            }
        } while (pil != 0);
    }
*/    
}
