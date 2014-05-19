
package com.data;

import java.util.List;

/**
 *
 * @author Luthfi Hamid Masykuri / 13512100
 */
public interface UserLogDao {
    
    public List<UserLog> getAllLog();
    
    public void AddLog(UserLog Log);
    
}
