package test;
import java.util.Date;
import java.text.SimpleDateFormat;
class test{
    public static void main(String[] args){
        Date currentTime = new Date();
        System.out.println(currentTime);

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        System.out.println("Current time: " + timeFormat.format(currentTime));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println("Current date: " + dateFormat.format(currentTime));

        SimpleDateFormat day = new SimpleDateFormat("dd");
        System.out.println("Current date: " + day.format(currentTime));

        SimpleDateFormat month = new SimpleDateFormat("MM");
        System.out.println("Current date: " + month.format(currentTime));

        SimpleDateFormat year = new SimpleDateFormat("YYYY");
        System.out.println("Current date: " + year.format(currentTime));


        SimpleDateFormat dayOfTheWeek = new SimpleDateFormat("EEEE");
        System.out.println(dayOfTheWeek.format(currentTime));


        // Day of the year
        SimpleDateFormat dayOfTheYear = new SimpleDateFormat("DD");
        System.out.println("In " + year.format(currentTime) + ",There have been " + dayOfTheYear.format(currentTime) + " days.");

        // Week in year 
        SimpleDateFormat WeekOfTheYear = new SimpleDateFormat("w");
        System.out.println("In " + year.format(currentTime) + ",There have been " + WeekOfTheYear.format(currentTime) + " weeks.");


        // time zone
        SimpleDateFormat timeZone = new SimpleDateFormat("zzzz ZZZZ");
        System.out.println(timeZone.format(currentTime));
    }
}