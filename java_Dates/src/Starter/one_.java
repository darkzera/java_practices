package Starter;
import org.w3c.dom.ls.LSOutput;

import java.awt.image.AbstractMultiResolutionImage;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class one_ {
    public static void main(String[] args) {
        Date novaData = new Date(); // Instancia com o valor mais prox. do momento da chamada
        System.out.println(novaData);
        // Convention epoch times
        // Same can be used to before

        Date brithday = new Date(999061992); // Instancia com o valor mais prox. do momento da chamada
        System.out.println(brithday);

        // Instant usage
        Instant firstInstante = brithday.toInstant();
        System.out.println(firstInstante);

        // Calendar
        Calendar agr = Calendar.getInstance();
        System.out.println(agr.getTime());
        agr.add(Calendar.DATE, 3 );
        System.out.println(agr.getTime());
        agr.add(Calendar.DATE, -3 );
        System.out.println(agr.getTime());
        System.out.println(agr.getTime());

        // DateFormat
        // SimpleDateFormat


        // Best of them its a new format after Java 8

        System.out.println("---------------------");
        LocalDate locald = LocalDate.now();
        System.out.println(locald.getDayOfMonth());
        LocalDate today = LocalDate.now();



    }






}
