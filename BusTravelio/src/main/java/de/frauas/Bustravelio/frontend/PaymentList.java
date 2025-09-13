/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.frauas.Bustravelio.frontend;

/**
 *
 * @author haith
 */
public class PaymentList {
    private int id;
    private String sentOrReceived;
    private String sentTo;
    private String reseivedFrom;
    private double price;
    private String date1;
    private String time1;
    public PaymentList(int id, String sentOrReceived, String sentTo, String reseivedFrom, double price,String date1,String time1){
            
            this.id=id;
            this.sentOrReceived=sentOrReceived;
            this.sentTo=sentTo;
            this.reseivedFrom=reseivedFrom;
            this.price=price;
            this.date1=date1;
            this.time1=time1;

    }



  
        public int getId(){
            return id;
        }
        public String getsentOrReceived(){
            return sentOrReceived;
        }
        public String getsentTo(){
            return sentTo;
        }
           public String getreseivedFrom(){
            return reseivedFrom;
        }
         public double getprice(){
            return price;
        }
          public String getdate1(){
            return date1;
        }
           public String gettime1(){
            return time1;
        }        

}
