
package com.data;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Luthfi Hamid Masykuri / 13512100
 */
public class UserLogDaoImpl extends Database implements UserLogDao {
    private String Table;
    private String Username;
    
    public UserLogDaoImpl(User user)
    {
        Table = "log";
        assert (user != null);
        Username = user.getUsername();
    }

    @Override
    public List<UserLog> getAllLog() {
         super.Where("username = ", Username);
         try
         {
             ResultSet res = super.Select(Table);
             boolean isExist = res.first();
             List<UserLog> Logs = new LinkedList();
             while (isExist)
             {
                 UserLog log = new UserLog(res);
                 Logs.add(log);
                 isExist = res.next();
             }
             return Logs;
         }
         catch (Exception e)
         {
             e.printStackTrace();
             return null;
         }
    }

    @Override
    public void AddLog(UserLog Log) {
        String col[] = {"username", "tanggal", "waktu", "debet" , "kuota"};
        String val[] = new String[6];
        val[0] = Username;
        val[1] = Log.getDate().toString();
        val[2] = Log.getTime().toString();
        val[3] = ""+Log.getDebet();
        val[4] = ""+Log.getKuota();
        int hasil = super.Insert(Table, col, val);
    }
}
