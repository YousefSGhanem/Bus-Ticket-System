/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.frauas.Bustravelio.frontend;

/**
 *
 * @author Mohamad Fakher
 */
public class Travels {
        private int id;
        private String fromcity;
        private String tocity;
        private String Datum;
        private String departureTime;
        private String arriveTime;
        private double price;
        private int seat;

        /*
        public Travels(String Fromcity,String Tocity,String Datum,String DepartureTime,String ArriveTime,double Price,int seat){
            
            this.fromcity=Fromcity;
            this.tocity=Tocity;
            this.Datum=Datum;
            this.departureTime=DepartureTime;
            this.arriveTime=ArriveTime;
            this.price=Price;
            this.seat=seat;

    }
       */ 
         public Travels(int id,String Fromcity,String Tocity,String Datum,String DepartureTime,String ArriveTime,double Price,int seat){
            
            this.id=id;
            this.fromcity=Fromcity;
            this.tocity=Tocity;
            this.Datum=Datum;
            this.departureTime=DepartureTime;
            this.arriveTime=ArriveTime;
            this.price=Price;
            this.seat=seat;

    }



  
        public int getId(){
            return id;
        }
        public String getfromcity(){
            return fromcity;
        }
        public String gettocity(){
            return tocity;
        }
           public String getdatum(){
            return Datum;
        }
         public String getdepartureTime(){
            return departureTime;
        }
          public String getarriveTime(){
            return arriveTime;
        }
           public Double getprice(){
            return price;
        }        

            public int getseat() {
                return seat;
    }

        
    }
