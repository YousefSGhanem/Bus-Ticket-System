/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.frauas.Bustravelio.backend;
import de.frauas.Bustravelio.frontend.PaymentList;
import de.frauas.Bustravelio.frontend.Travels;
import de.frauas.Bustravelio.frontend.user;
import de.frauas.Bustravelio.frontend.userPayment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DBHandler {
    static String url;
    static String user;
    static String password;
    
    // Create DB connection 
    public static Connection connect(){
        //loadDriver();
        // Wenn das Team Clever cloud nutzen will sollten die drei Zeile geändert (connection ändern)
        Connection connect= null;
        
        // copy the URL from your DB
       url="jdbc:mysql://localhost:3306/progex";
		 user="root";
                 // hier mySQL Workbench password eingeben
		 password="root"; try{
            //connect= DriverManager.getConnection("jdbc:mysql://uu20nc5ew8qyvtni:u6Muqz0qZbHxG2WwN0o5@b8uycnikwqrldx44aozd-mysql.services.clever-cloud.com:3306/b8uycnikwqrldx44aozd","uu20nc5ew8qyvtni","u6Muqz0qZbHxG2WwN0o5" );
            connect= DriverManager.getConnection(url,user,password);
             
        } catch (SQLException e) {

            //handle any errors
            System.out.print("SQLException: "+e.getMessage());
            System.out.print("SQLState: "+e.getSQLState());
            System.out.print("VendorError: "+e.getErrorCode());
        }
        return connect;
    }
    
    public static Connection connect2(){
        //loadDriver();
        Connection connect= null;
        // Copy your DB URL 
         url="jdbc:mysql://localhost:3306/progex";
		 user="root";
                 // mySQL Workbench password eingeben
		 password="root";
                 try{
            //connect= DriverManager.getConnection("jdbc:mysql://uu20nc5ew8qyvtni:u6Muqz0qZbHxG2WwN0o5@b8uycnikwqrldx44aozd-mysql.services.clever-cloud.com:3306/b8uycnikwqrldx44aozd","uu20nc5ew8qyvtni","u6Muqz0qZbHxG2WwN0o5" );
            connect= DriverManager.getConnection(url,user,password);
             
        } catch (SQLException e) {

            //handle any errors
            System.out.print("SQLException: "+e.getMessage());
            System.out.print("SQLState: "+e.getSQLState());
            System.out.print("VendorError: "+e.getErrorCode());
        }
        return connect;
    }
    
    /**
     * Inserts new Datasets into user table
     * @param tablename
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param email
     * @return 
     */
    public static ResultSet newUser( String tablename, String firstname, String lastname,String username,String password, String email )
    {
        // insert statement
       
        String sql= "INSERT INTO " + tablename+ " (`firstname`,`lastname`,`username`,`password`,`emailaddress`,`isAdmin`) VALUES("+"'"+firstname+"',"+"'"+lastname+"','"+username+"',"+"'"+password+"',"+"'"+email+"',0);"; 
      
       // check sql statement 
        System.out.println(sql);
         Connection myConn = connect();
          //Statement stmt
          PreparedStatement prepsInsertUser;
          ResultSet rs= null;
          try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        
   
        prepsInsertUser.close();
         myConn.close();
         
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
    }
    public int DeleteUser (/*Connection myConn,*/ String tablename, String column, String value )
   {
         // select statement
        String sql=  "DELETE  FROM " +tablename + " where " + column+ "= " + "'"+value+"'" +";";
        //check sql statement 
          Connection myConn= connect();
          //Statement stmt
          PreparedStatement prepsInsertUser;
          int updatetdcount=0 ;
           ResultSet rs= null;
    try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        updatetdcount  = prepsInsertUser.getUpdateCount();
        System.out.print(updatetdcount);
        myConn.close();
       
    } catch (SQLException ex) {
      Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
   }
        return updatetdcount;
    }
    

      /**
     * Checks if information is stored in Database
     * Checks for redundancies
     * @param rs
     * @return 
     * 
     */
       public boolean checkstatmentExsist (ResultSet rs)
    {
        boolean result= false;
        try {
            result= rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return result;
}
       
        /**
     *Calls  all datasets from a specific table
     * @param tablename
     * @param column
     * @param value
     * @return
     */
    public ResultSet Selectdata (String tablename, String column, String value )
    {
         // select statement
        String sql=  "SELECT " + column + " FROM " +tablename + " where " + column+ "= " + "'"+value+"'" +";";
        //check sql statement 
        System.out.println(sql);
        Connection myConn= connect();
        Statement stmt;
        ResultSet rs= null;
    try {
        stmt = myConn.createStatement();
         rs = stmt.executeQuery(sql);
       
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
        
        
    }
        public ResultSet SelectData2colmn (String tablename, String column,String column2, String value, String value2 )
    {
         // select statement
        String sql= "SELECT * FROM "+ tablename + " WHERE " + column + "='"+value+"' AND " + column2 +"='"+value2+"'";
        //check sql statement 
        System.out.println(sql);
        Connection myConn= connect();
        //PreparedStatement prepsInsertUser;
        Statement stmt;
        ResultSet rs= null;
    try {
        stmt = myConn.createStatement();
        rs = stmt.executeQuery(sql);
        
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
    }
        public ResultSet newUserPayment( String firstname, String lastname,String username,String password, String address, String email, String dob)
    {
        // insert statement
       
        String sql= "INSERT INTO paymentUsers (firstnamep,lastnamep,usernamep,passwordp,addressp,emailp,DOBp, currentp,isAdminp)"
                + " VALUES("+"'"+firstname+"','"+lastname+"','"+username+"','"+password+"','"+address+"','  "+email+"','" + dob +"','100',0 );"; 
    
       // check sql statement 
        System.out.println(sql);
         Connection myConn= connect();
          //Statement stmt
          PreparedStatement prepsInsertUser;
          
           ResultSet rs= null;
    try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        prepsInsertUser.close();
        myConn.close();
        rs.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
    }
            public String SelectdataP (String column,String column2, String value) throws SQLException
    {
         // select statement
        String sql=  "SELECT " + column + " FROM paymentUsers where " + column2+ "= " + "'"+value+"'" +";";
        //check sql statement 
        String returned = null;
        System.out.println(sql);
        Connection myconn=null;
        try{
            myconn= DriverManager.getConnection(url,user,password );
        }catch (SQLException e){
         //handle any errors
         System.out.print("SQLException: "+e.getMessage());
         System.out.print("SQLState: "+e.getSQLState());
         System.out.print("VendorError: "+e.getErrorCode());
        }
        PreparedStatement prepsInsertUser;
        Statement stmt ;
        ResultSet rs = null;
        
        try{
            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                if("firstnamep".equals(column)){
                    returned = rs.getString("firstnamep");
                }
                if("lastnamep".equals(column)){
                    returned = rs.getString("lastnamep");
                }
                if("usernamep".equals(column)){
                    returned = rs.getString("usernamep");
                }
                
                if("passwordp".equals(column)){
                    returned = rs.getString("passwordp");
                }
                if("addressp".equals(column)){
                    returned = rs.getString("addressp");
                }
                if("emailp".equals(column)){
                    returned = rs.getString("emailp");
                }
                if("DOBp".equals(column)){
                    returned = rs.getString("DOBp");
                }
            }
            myconn.close();
            stmt.close();
            rs.close();
            
        }
        catch(SQLException e){
         System.out.println("die fehler ist hier" + e);
        }
        
        return returned;
    }

 public ArrayList<Travels> travellist (String From, String To,String date, int seat) {
     System.out.println("From----->"+From+"\nTo--------->"+To);
          System.out.println("Datum----->"+date+"place--------->"+seat);

     String sql = "SELECT * FROM travels WHERE fromcity='"+From+"'"
              + " AND tocity ='"+To+"' AND Datum ='"+date+"' AND place >='"+seat+"'";
     //String sql = "SELECT * FROM travels;";
     System.out.println(sql);
     Connection mycon= connect();
     Statement stmt ;
     ResultSet rs = null;
     ArrayList<Travels> travellist =new ArrayList<>();
     try{
         stmt = mycon.createStatement();
         rs = stmt.executeQuery(sql);
         Travels travels;
         while(rs.next()){
             travels = new Travels(rs.getInt("id"),rs.getString("fromcity"),rs.getString("tocity"),rs.getString("Datum"),rs.getString("departureTime"),rs.getString("arriveTime"),rs.getDouble("price"),rs.getInt("place"));
             travellist.add(travels);
             
         }
     }catch(SQLException e){
         System.out.println("der fehler ist hier" + e);
     }
     return travellist;
 }
 public ArrayList<Travels> travellist () {
     String sql = "SELECT * FROM travels ";
     //String sql = "SELECT * FROM travels;";
     System.out.println(sql);
     Connection mycon= connect();
     Statement stmt ;
     ResultSet rs = null;
     ArrayList<Travels> travellist =new ArrayList<>();
     try{
         stmt = mycon.createStatement();
         rs = stmt.executeQuery(sql);
         Travels travels;
         while(rs.next()){
             travels = new Travels(rs.getInt("id"),rs.getString("fromcity"),rs.getString("tocity"),rs.getString("Datum"),rs.getString("departureTime"),rs.getString("arriveTime"),rs.getDouble("price"),rs.getInt("place"));
             travellist.add(travels);
         }
     }catch(SQLException e){
         System.out.println("der fehler ist hier" + e);
     }
     return travellist;
 }
 public ResultSet paymentCoupons( String codep, double price, String email, int isUsed)
    {
        // insert statement
       
        String sql= "INSERT INTO paymentCoupons (codep,price,email,isUsed)"
                + " VALUES("+"'"+codep+"','"+price+"','"+email+"','"+isUsed+"');";
       // check sql statement 
        System.out.println(sql);
        Connection myConn= connect();
         //Statement stmt
        PreparedStatement prepsInsertUser;
        ResultSet rs= null;
        try {
        prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        prepsInsertUser.close();
        myConn.close();
        } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet checkcoupons (String value )
    {
         // select statement
        String sql=  "SELECT * FROM paymentCoupons where codep = '"+value+"' AND isUsed = 1;";
        //check sql statement 
        System.out.println(sql);
        Connection myConn= connect();
        Statement stmt;
        ResultSet rs= null;
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
 public String SelectPrice (String column,String column2, String value) throws SQLException
    {
         // select statement
        String sql=  "SELECT " + column + " FROM paymentCoupons where " + column2+ "= " + "'"+value+"'" +";";
        //check sql statement 
        String returned = null;
        System.out.println(sql);
        Connection myconn=connect();
        
        PreparedStatement prepsInsertUser;
        Statement stmt ;
        ResultSet rs = null;
        
        try{
            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                if("Price".equals(column)){
                    returned = rs.getString("Price");
                }
            }
            myconn.close();
            stmt.close();
            rs.close();
            
        }
        catch(SQLException e){
         System.out.println("die fehler ist hier " + e);
        }
        
        return returned;
    }

   public ResultSet Updatecoupon( String givencode)
    {
        // insert statement
       
        String sql= "UPDATE paymentCoupons SET isUsed = 0 where codep = '" + givencode+"';";
       // check sql statement 
        System.out.println(sql);
         Connection myConn= connect();
          //Statement stmt
          PreparedStatement prepsInsertUser;
          
           ResultSet rs= null;
    try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        prepsInsertUser.close();
        myConn.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
    }
 // to see current mony in your account 
  public String SelectPriceFromUsers (String column,String column2, String value) throws SQLException
    {
         // select statement 
        String sql=  "SELECT " + column + " FROM paymentUsers where " + column2+ " = '"+value+"';";
        //check sql statement 
        String returned = null;
        System.out.println(sql);
        Connection myconn=connect();
        /*try{
            myconn= DriverManager.getConnection("jdbc:mysql://uu20nc5ew8qyvtni:u6Muqz0qZbHxG2WwN0o5@b8uycnikwqrldx44aozd-mysql.services.clever-cloud.com:3306/b8uycnikwqrldx44aozd","uu20nc5ew8qyvtni","u6Muqz0qZbHxG2WwN0o5" );
        }catch (SQLException e){
         //handle any errors
         System.out.print("SQLException: "+e.getMessage());
         System.out.print("SQLState: "+e.getSQLState());
         System.out.print("VendorError: "+e.getErrorCode());
        }*/
        Statement stmt ;
        ResultSet rs = null;
        
        try{
            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                if("usernamep".equals(column2)){
                    returned = rs.getString("currentp");
                }
            }
            myconn.close();
            stmt.close();
            rs.close();
            
        }
        catch(SQLException e){
         System.out.println("die fehler ist hier" + e);
        }
        
        return returned;
    }
    public String SelectemailFromUsers (String column,String column2, String value) throws SQLException
    {
         // select statement 
        String sql=  "SELECT " + column + " FROM paymentUsers where " + column2+ " = '"+value+"';";
        //check sql statement 
        String returned = null;
        System.out.println(sql);
        Connection myconn=connect();
        Statement stmt ;
        ResultSet rs = null;
        
        try{
            stmt = myconn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                if("usernamep".equals(column2)){
                    returned = rs.getString("emailp");
                }
            }
            myconn.close();
            stmt.close();
            rs.close();
            
        }
        catch(SQLException e){
         System.out.println("die fehler ist hier" + e);
        }
        
        return returned;
    }
  // to update the current satus in Database 
  public ResultSet UpdatePayment( String firstname, String lastname,String changedusername, String password, String address, String email, String username)
    {
        // insert statement
       
        String sql= "UPDATE paymentUsers SET firstnamep = '"+firstname+"', lastnamep = '"+ lastname +"', "
                + "usernamep = '"+changedusername + "', passwordp = '"+ password+"', addressp ='"+ address+"', emailp = '"+email+"' WHERE usernamep = '"+ username+"';"; 
    
       // check sql statement 
        System.out.println(sql);
         Connection myConn= connect();
          //Statement stmt
          PreparedStatement prepsInsertUser;
          
           ResultSet rs= null;
    try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        prepsInsertUser.close();
        myConn.close();
        rs.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
    }
  public int Selectcount ()
    {
         // select statement
        String sql= "SELECT usernamep FROM paymentUsers;";
        int count = 0;
//check sql statement 
        //System.out.println(sql);
        Connection myConn= connect();
        Statement stmt;
        ResultSet rs= null;
    try {
        stmt = myConn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()){
            count++;
        }
        stmt.close();
        myConn.close();
        rs.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return count;
    }
 
  public ResultSet UpdatePayment2( String column, String value , String username)
    {
        // insert statement
       
        String sql= "UPDATE paymentUsers SET "+ column + " = '" +value+"' where usernamep = '" + username+"';";
       // check sql statement 
        System.out.println(sql);
         Connection myConn= connect();
          //Statement stmt
          PreparedStatement prepsInsertUser;
          
           ResultSet rs= null;
    try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        prepsInsertUser.close();
        myConn.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
    }
  // tablename = username
  public ResultSet createUserstoryP( String tablename)
    {
        // insert statement
       
        String sql=  "CREATE TABLE IF NOT EXISTS "+ tablename +"( "
                + "id int not null auto_increment,"
                + "sentOrReceived varchar(20) not null,"
                + "sentTo varchar (50),"
                + "reseivedFrom varchar(50),"
                + "price double,date1 varchar(20) not null,"
                + "time1 varchar(50) not null,"     
                + "primary key (id)"
                + ");";
    
       // check sql statement 
        System.out.println(sql);
         Connection myConn= connect2();
          //Statement stmt
          PreparedStatement prepsInsertUser;
          ResultSet rs= null;
          try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        
   
        prepsInsertUser.close();
         myConn.close();
         
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return rs;
    }
   public ResultSet insertUserstoryP( String username, String sentOrReceived, String sentTo, String reseivedFrom, double price, String date, String time)
    {
        createUserstoryP(username);
        // insert statement
        String sql= "INSERT INTO "+username+" (sentOrReceived,sentTo,reseivedFrom,date1, time1, price)"
                + " VALUES('"+sentOrReceived+"','"+sentTo+"','"+reseivedFrom+"','"+date+"','"+time+"',"+ price + ");";
       // check sql statement 
        System.out.println(sql);
        Connection myConn= connect2();
         //Statement stmt
        PreparedStatement prepsInsertUser;
        ResultSet rs= null;
        try {
        prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        prepsInsertUser.close();
        myConn.close();
        } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet inserttravels( int id,int seattodb)
    {
        // insert statement
        String sql= "UPDATE travels SET place ='"+seattodb+"' where id = '" + id+"' ";
        // check sql statement 
        System.out.println(sql);
        Connection myConn= connect();
         //Statement stmt
        PreparedStatement prepsInsertUser;
        ResultSet rs= null;
        try {
        prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        prepsInsertUser.execute();
        rs = prepsInsertUser.getGeneratedKeys();
        prepsInsertUser.close();
        myConn.close();
        } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
  
    
    public ArrayList<PaymentList> PaymentList (String username) {
     String sql = "SELECT * FROM "+username + ";";
     System.out.println("username ------>"+sql);
     Connection mycon= connect2();
     Statement stmt ;
     ResultSet rs = null;
     ArrayList<PaymentList> PaymentList =new ArrayList<>();
     try{
         stmt = mycon.createStatement();
         rs = stmt.executeQuery(sql);
         PaymentList paymentList;
         while(rs.next()){
             paymentList = new PaymentList(rs.getInt("id"),rs.getString("sentOrReceived"),rs.getString("sentTo"),rs.getString("reseivedFrom"),rs.getDouble("price"),rs.getString("date1"),rs.getString("time1"));
             PaymentList.add(paymentList);
         }
     }catch(SQLException e){
         System.out.println("der fehler ist hier" + e);
     }
     return PaymentList;
 }
    public user GetUser ( String user)
    {
        user currentUser= null;
         // select statement
        String sql=  "SELECT firstname, lastname, emailaddress ,username,password,isAdmin FROM users where username= " + "'"+user+"'" +";";
        System.out.println(sql);
        Connection myConn= connect();
        Statement stmt;
        ResultSet rs= null;
        
        
           
    try {
        stmt = myConn.createStatement();
         rs = stmt.executeQuery(sql);
         while(rs.next())
            {
                
                
         currentUser= new user(rs.getString("username"), rs.getString("firstname"),rs.getString("lastname"), rs.getString("emailaddress"), rs.getString("password"),rs.getBoolean("isAdmin"));
            }
           // stmt.close();
           myConn.close();

    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
    return currentUser;
    }
    public userPayment GetUserPayment ( String user)
    {
        userPayment currentUser= null;
         // select statement
        String sql=  "SELECT firstnamep, lastnamep, emailp ,usernamep,passwordp,currentp, DOBp, isAdminp FROM PaymentUsers where usernamep= " + "'"+user+"'" +";";
        System.out.println(sql);
        Connection myConn= connect();
        Statement stmt;
        ResultSet rs= null;
        
        
           
    try {
        stmt = myConn.createStatement();
         rs = stmt.executeQuery(sql);
         while(rs.next())
            {
                
                
         currentUser= new userPayment(rs.getString("usernamep"),rs.getString("emailp"),
                 rs.getString("passwordp"),
                 rs.getBoolean("isAdminp"));
            }
           // stmt.close();
           myConn.close();

    } catch (SQLException ex) {
        Logger.getLogger("DBhandler 699"+DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
    return currentUser;
    }
    public ResultSet checkAdminPayment (String username )
    {
         // select statement
        String sql=  "SELECT * FROM paymentUsers where usernamep = '"+username+"' AND isAdminp = 1;";
        //check sql statement 
        System.out.println(sql);
        Connection myConn= connect();
        Statement stmt;
        ResultSet rs= null;
        try {
            stmt = myConn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet GetAllUserp(/*Connection myConn*/String tablename)
    {
         // select statement
        String sql=  "select usernamep,emailp,passwordp,isAdminp from "+tablename;
        Connection myConn= connect();
        Statement stmt;
        ResultSet rs= null;
    try {
        stmt = myConn.createStatement();
         rs = stmt.executeQuery(sql);
       
        // stmt.close();
         //myConn.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        
             
        return rs;      
        
    }
    public ResultSet GetAllUser(/*Connection myConn*/String tablename)
    {
         // select statement
        String sql=  "select username,emailaddress,password,isAdmin from "+tablename;
        Connection myConn= connect();
        Statement stmt;
        ResultSet rs= null;
    try {
        stmt = myConn.createStatement();
         rs = stmt.executeQuery(sql);
       
        // stmt.close();
         //myConn.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        
             
        return rs;      
        
    }
    
    public int EditUser (/*Connection myConn,*/String tablename, String column, String value,String column2,String condition )
    {
         // select statement
        String sql;
        if(column.equals("IsAdmin")) 
        {
            if( value.equals("yes"))
            {
                sql=  "UPDATE " +tablename + " set " + column+ "= 1 where " + column2+ "= " + "'"+condition+"'" +";";
            }
            else
            {
                 sql=  "UPDATE " +tablename + " set " + column+ "= 0 where " + column2+ "= " + "'"+condition+"'" +";";
            }
        }
       else
        {
           sql=  "UPDATE " +tablename + " set " + column+ "= " + "'"+value+"'"+" where " + column2+ "= " + "'"+condition+"'" +";";
        }
          System.out.print(sql);
        //check sql statement 
        Connection myConn= connect();
        
          //Statement stmt
          PreparedStatement prepsInsertUser;
          int updatetdcount=0 ;
           ResultSet rs= null;
    try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        updatetdcount  = prepsInsertUser.getUpdateCount();
        System.out.print(updatetdcount);
       myConn.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return updatetdcount;
    }
    public int EditUserPayment (/*Connection myConn,*/String tablename, String column, String value,String column2,String condition )
    {
         // select statement
        String sql;
        if(column.equals("isAdminp")) 
        {
            if( value.equals("yes"))
            {
                sql=  "UPDATE " +tablename + " set " + column+ "= 1 where " + column2+ "= " + "'"+condition+"'" +";";
            }
            else
            {
                 sql=  "UPDATE " +tablename + " set " + column+ "= 0 where " + column2+ "= " + "'"+condition+"'" +";";
            }
        }
       else
        {
           sql=  "UPDATE " +tablename + " set " + column+ "= " + "'"+value+"'"+" where " + column2+ "= " + "'"+condition+"'" +";";
        }
          System.out.print(sql);
        //check sql statement 
        Connection myConn= connect();
        
          //Statement stmt
          PreparedStatement prepsInsertUser;
          int updatetdcount=0 ;
           ResultSet rs= null;
    try {
       prepsInsertUser = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       prepsInsertUser.execute();
        updatetdcount  = prepsInsertUser.getUpdateCount();
        System.out.print(updatetdcount);
       myConn.close();
    } catch (SQLException ex) {
        Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
        return updatetdcount;
    }
    public void close( Connection myConn)
    {
        try {
            myConn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
