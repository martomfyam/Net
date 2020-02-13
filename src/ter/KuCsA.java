/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ter;

import database.Mysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Telnet
 */
public class KuCsA {

    String message = "";
    PreparedStatement pst;
    ResultSet rs;
    String data[] = new String[4];
    

    void SelectDat() {
        try {
            pst = Mysql.connect("kucsa")
                   .prepareStatement("select firstname,lastname,tel1,sex from members where year!='associate' and year!=1 ");
                    //hardware module
                  // .prepareStatement("select firstname,lastname,tel1,sex from members WHERE tel1='+254715493752' or tel1='+254722861054' or tel1='+254716082854' or tel1='+254735534771' or tel1='+254736453532' or tel1='+254740863901' or tel1='+254745365696' or tel1='+254746293583' or tel1='+254746843209' or tel1='+254700628185' or tel1='+254704400677' or tel1='+254705297905' or tel1='+254705309169' or tel1='+254705895613' or tel1='+254707351067' or tel1='+254713604008' or tel1='+254713886740' or tel1='+254748232218' or tel1='+254796045771' or tel1='+254797936562' or tel1='+254798428931' or tel1='+254798473257' or tel1='+254799566927' or tel1='+254799825279' or tel1='+254799855071'  ");
                 // .prepareStatement("select firstname,lastname,tel1,sex from members WHERE tel1='+254792020946'  ");
                //    .prepareStatement("select firstname,lastname,tel1,sex from members where year!=1 and year!=2 and year!=3 and year!=4; ");
                    
        } catch (SQLException ex) {
            Logger.getLogger(CA.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs = pst.executeQuery();
            while (rs.next()) {
//                data[0] = rs.getString("Gender");
                data[0] = rs.getString("firstname");
                data[1] = rs.getString("lastname");
                data[2] = rs.getString("tel1");
                data[3] = rs.getString("sex");
            //    data[4] = rs.getString("othername");
                
                message = processMessage(data);

                sendSMS(rs.getString("tel1"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param data: index 0 {sex} 1{firstname+lastname}
     * @return
     */
    private String processMessage(String data[]) {
      
        String name=data[0]+" "+data[1] ;
      // message = "Dear {sex} {name} here is the link to KUCSA whatsapp group. https://chat.whatsapp.com/BiwQRa87oNEBqZtUUNfCMc  . Nice time ";
     //  message = "DSC FIREBASE MEETUP REMINDER... Hello {sex} {name} Hope this finds you well.(DSC firebase for Android) event will be kicking off @ 6:30pm sakagwa 25.Remember to carry your laptop and extension .You're welcomed. ";
    //   message = "CHANGE OF VENUE!..Hello "+data[0]+" KUCSA meeting happening now at LH 38 (SCHOOL OF LAW) [agri side].Kindly keep time. ";
     //  message = " Dear {sex} {name} MESWA wishes you a Merry Christmas and a Prosperous New Year 2019. ";
     //  message = "KUCSA MEETING REMINDER!!.. Hello {sex} {name} KUCSA meeting happening now at Sakagwa 25 .Kindly keep time. ";
     //  message = "KUCSA MEETING REMINDER!!.. Hello {name} KUCSA meeting kicking off in few minutes at Sakagwa 25 / 15 .Kindly keep time. ";
       message = "KUCSA MEETING REMINDER! Hello {sir} {name} remember to attend our KUCSA meeting which will happen today. TIME 6.30pm Kindly keep time. Thankyou";
    //  message = "WEB MODULE REMINDER...Dear {sex} {name} web module will be kicking off today at sakagwa 6pm. if you have a laptop remember to carry it. welcome all ";
   //  message = "WEB MODULE REMINDER!!.. Hello {name} Web module kicking off in few minutes at Sakagwa 25 .Kindly keep time. ";
  //    message = "HARDWARE MODULE REMINDER!... Dear {sex} {name} We shall be having hardware module today TIME and VENUE  will be communicated.please ensure you join our whatsapp group for more information. https://chat.whatsapp.com/BiwQRa87oNEBqZtUUNfCMc ";
     //  message = " Hello {sex} {name} tomorrow's event (firebase for android) as been postponed to 2nd march due to some logistical mishap. apologies for any inconveniences caused.";
    //   message = "HARDWARE MODULE REMINDER!... Dear {sex} {name}  Hardware module kicking off @6:30 pm in Sakagwa 25 / 15.  Purpose to attend  ";
   //    message = "KUCSA ELECTIONS POSTPONED!!  Hello {sex} {name}, Due to unavoidable circumstances we have postponed the club elections to Tuesday next week. So we will be having our normal meeting which will happen at LH 25. TIME 6.30pm Kindly keep time. Thankyou";
   //    message = "MEETING CALL OFF! Dear {sex} {name} We shall not be having our KuCsA meeting today due to CYNTHIA'S fundraising which will be at LH.8 . we are sorry for this incovenience...   Remember to RSVP for attlasian meetup through this link:-   https://aug.atlassian.com/events/details/atlassian-nairobi-presents-atlassian-tools-and-practices-workshop   .Tell a friend to tell a friend";
    //   message = "Hello {sex} "+data[0]+" we shall be having our meeting today LH 8 (Admin) @6:30pm. Kindly keep time ";
    //     message = "Hello {sex} {name}. Trust this finds you well.I hereby write this message on behalf of the KUCSA club requesting for support in purchasing a club’s projector. The club intends to hold a MINI – HARAMBEE on 21st march 2019. We are targeting to raise KSh 70,000 to aide us in purcharsaing the projector.You can channel your contributions through the clubs treasurer faith jepkogei(0700434328).Your contribution will be highly appreciated.regards Martin KuCsA P.R";
   //    message = "DSC FIREBASE MEETUP REMINDER!!!.. DSC firebase event kicking off in few minutes time at LH 20. Free net will be provided.Remember to carry your laptop and extension. Hurry up!! ";
     //    message = "Dear {sex} {name} KUCSA club is glad to welcome you back for 2018/19 2nd session. we wish to invite you to our first meeting of this sem which will be happening tomorrow 6:30pm at sakagwa 25. GDG kisumu updates among other stuff to be show-cased. purpose to attend.  ";
        //    message = "KUCSA ELECTIONS REMINDER!! Dear {name} we shall be having our club elections today 6:30pm at sakagwa 25.we shall elect the club's: chairperson, vice chairperson, Treasurer, Secretary, Organising secretary and Publicity Secretary. You can regiser your interest in any position via this number before 2pm. Thankyou";
    //  message = " KUCSA AGM REMINDER! Dear {sex} {name} we shall be having our AGM today at 3pm in sakagwa 25 for the handing over of leadership. The meeting is scheduled at that time so that we can have our patron, Dean and other stakeholders in attendance. kindly lets keep time. Thankyou. ";
     //  message = "MEETUP REMINDER!!Kindly attend ZALEGO- INSTITUTE OF TECHNOLOGY event ,, happening in SG25 now.. ";
   //  message = "KUCSA MINI-HARAMBEE Dear {sex} {name} Hope this finds you well, KUCSA club is intending to purchase a projector and we are kindly requesting for your support towards the project.You can channel your contributions through the clubs treasurer faith jepkogei(0700434328). ";
   // message = "KUCSA MINI-HARAMBEE (TODAY)   Hello {sex} {name} Hope this finds you well, reminding you of KUCSA's MINI HARAMBEE which will be held today at SAKAGWA 25 as from 2pm. we are kindly requesting for your support towards the project.You can channel your contributions through the clubs treasurer faith jepkogei(0700434328). Thankyou  ";
  //  message = "KUCSA MINI-HARAMBEE (NOW)... Hello {name} KUCSA MINI-HARAMBEE kicking off in few minutes at Sakagwa 25 .All are welcomed. ";
  //  message = "KUCSA MEETING  Hello {name} On behalf of KUCSA, I welcome you to our first meeting on 28th Tuesday (today) @6:30pm LH 25(SAKAGWA).Its a new year with lots of good stuff.Can't wait to get started. Purpose to attend "+data[1]+".";
   
   
     String sex = data[3].equalsIgnoreCase("M") ? "Sir." : "Madam.";
      
         
        return message.replace("{name}", " "+ name + " ").replace("{sex}", sex);
    }

    private void sendSMS(String recepient) {
        
        try {
            pst = Mysql.connect("kucsa").
                    prepareStatement("INSERT INTO outbox(receiver,msg,msgtype,sender)"
                            + " VALUES(?,?,?,?)");
            pst.setString(1, recepient);
            pst.setString(2, message);
            pst.setString(3, "sms.text");
            pst.setString(4, "+2547");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            pst.execute();
        } catch (SQLException ex) {
        }
        System.out.println(" sent");
        
    }

    public static void main(String[] args) {
       KuCsA c= new KuCsA();
       c.SelectDat();
    }
}
