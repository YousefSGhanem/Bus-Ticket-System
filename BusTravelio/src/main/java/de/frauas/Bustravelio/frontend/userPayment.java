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
public class userPayment {
    protected String usernamep;
    protected String firstnamep;
    protected String lastnamep;
    protected String currentp;
    protected String passwordp;
    protected String DOBp;
    protected String emailp;
    protected String addressp;
    protected boolean isAdminp;
    
    
    public userPayment( String usernamep,String firstnamep, String lastnamep,String currentp, String passwordp, String addressp,String DOBp, String emailp, boolean isAdminp)
    {
        this.firstnamep= firstnamep;
        this.lastnamep= lastnamep;
        this.usernamep= usernamep;
        this.addressp= addressp;
        this.passwordp= passwordp;
        this.DOBp= DOBp;
        this.emailp= emailp;
        this.currentp= currentp;
        this.isAdminp= isAdminp;
 
    }

    
    public userPayment (String usernamep, String emailp, String passwordp, boolean isAdminp)
    {
            this.usernamep= usernamep;
            this.emailp= emailp;
            this.passwordp= passwordp;
            this.isAdminp= isAdminp;
        
    }
}