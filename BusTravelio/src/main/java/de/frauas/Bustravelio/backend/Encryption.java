/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.frauas.Bustravelio.backend;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Encryption {
    String pass;
    String algorithm="SHA";
    
    /**
     *
     * Constructor of Encryption
     */
    public Encryption(String password)
    {
        pass=password;
    }
    /**
     *Encrypts password which was given from the user (as plain text)
     * @return
     */
    public String HaschCode()
    {
        byte[]plainText=pass.getBytes();
        MessageDigest md;
                
        try {
            md = MessageDigest.getInstance((algorithm));
            md.reset();
            md.update(plainText);
            byte[] encodedPassword  = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }
                sb.append(Long.toString(encodedPassword[i] & 0xff,16 ));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

}
 

