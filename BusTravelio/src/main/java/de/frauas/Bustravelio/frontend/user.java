/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.frauas.Bustravelio.frontend;

/**
 *
 * @author User
 */
public class user {
    protected String username;
    protected String firstname;
    protected String lastname;
    protected String emailAddress;
    protected String password;
    protected boolean isAdmin;
    
    
    public user( String username,String firstname, String lastname,String emailAddress, String password, boolean isAdmin)
    {
        this.firstname= firstname;
        this.lastname= lastname;
        this.username= username;
        this.password= password;
        this.emailAddress= emailAddress;
        this.isAdmin= isAdmin;
 
    }

    
    public user (String username, String emailAddresse, String password, boolean isAdmin)
    {
            this.username= username;
            this.emailAddress= emailAddresse;
            this.password= password;
            this.isAdmin= isAdmin;
        
    }
}