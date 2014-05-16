/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineprinter;

import java.util.List;

/**
 *
 * @author Luthfi Hamid M / 135120100
 */
public interface UserDao {
    public List<User> getAllUser();
    public User getByUsername(String username);
    public User Validate(String username, String pass);
    public void UpdateUser(String username,User user);
    public void DeleteUser(String username);
    public void AddUser(User user);
}
