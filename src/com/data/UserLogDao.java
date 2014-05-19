/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.data;

import java.util.List;

/**
 *
 * @author upix
 */
public interface UserLogDao {
    
    public List<UserLog> getAllLog();
    
    public void AddLog(UserLog Log);
    
}
