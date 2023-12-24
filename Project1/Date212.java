import java.lang.Integer;

/**
 * The Date212 class represents a date with year, month, and day as integers.
 * It provides methods for parsing, formatting, and comparing dates.
 */

public class Date212 {
   //instance variables
   private int year;
   private int month;
   private int day;

   /**
     * Constructs a Date212 object from a string in the format yyyymmdd.
     *
     * @param s The input date string in yyyymmdd format.
     * @throws IllegalArgumentException If the input string is not a valid date.
     */
   
   public Date212(String s) {  
      // Validate and parse the input string
      if(!isValid(s)){
         throw new IllegalArgumentException("Not valid date " + s);
      }
      else{
      year = Integer.parseInt(s.substring(0, 4)); //extract year
      month = Integer.parseInt(s.substring(4,6)); //extract month
      day = Integer.parseInt(s.substring(6, 8)); // extract day
      
      }
   }

   /**
     * Checks if a given string is a valid date in yyyymmdd format.
     *
     * @param str The input string to validate.
     * @return True if the input string is a valid date, false otherwise.
     */

   private boolean isValid(String str) {
    if (str.length() == 8) {
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(4, 6));
        int day = Integer.parseInt(str.substring(6));
        //validate year, month, day
        boolean validYear = year >= 0;
        boolean validMonth = month >= 1 && month <= 12;
        boolean validDay = day >= 1 && day <= 31;
        
        return validYear && validMonth && validDay; // Valid date if all conditions are met
    }
    return false; // Invalid date
}

   // to String method returns a formatted string representation of the date in mm/dd/yyyy format.
   public String toString ()
   {
      String formatMonth, formatDay;
      if(month<10) {
         formatMonth = "0" + month;
      }
      else {
         formatMonth = String.valueOf(month);
      }
      if(day <10){
         formatDay = "0"+ day;
      }
      else {
         formatDay = String.valueOf(day);
      }
      String formatDate = formatMonth + "/" + formatDay + "/"+ year;
      return formatDate;
   } //end of toString


   public int getYear(){
      return year;
   }
   public int getMonth(){
      return month;
   }
   public int getDay(){
      return day;
   } 

  /**
     * Compares this date to another Date212 object.
     *
     * @param other The other Date212 object to compare to.
     * @return 0 if the dates are equal, a positive value if this date is after the other date,
     *         and a negative value if this date is before the other date.
     */

    public int compareTo(Date212 other)  
    {
    // First, compare the years
    int yearComparison = Integer.compare(this.year, other.year);
    if (yearComparison != 0) {
        return yearComparison;
    }

    // Years are the same, so compare the months
    int monthComparison = Integer.compare(this.month, other.month);
    if (monthComparison != 0) {
        return monthComparison;
    }

    // Months are the same, so compare the days
    return Integer.compare(this.day, other.day);
   }  //end of comapreto  


}//end of Date212 class


