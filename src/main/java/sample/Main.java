package sample;



import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Random;
import java.util.Stack;

public class Main/*implements EventHandler<ActionEvent>*/ {


    public static void main(String[] args)
    {
//            Sql sqlObj=new Sql();
//
            Gui obj =new Gui();
            obj.setStartup();
    }

    public static Date getDate(){
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        return date;
    }
    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
    public static String get5RandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(99999);

        // this will convert any number sequence into 6 character.
        return String.format("%05d", number);
    }
}
