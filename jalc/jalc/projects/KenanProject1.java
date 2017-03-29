public class KenanProject1
{
   public static void main (String[] args)
   {
   /*Define hours worked, overtime hours worked, pay rate, and gross pay for four cases.
   the ovTime variable equals one if overtime is worked and zero if no overtime is worked.*/
   int hours1=30, hours2=40, hours3=45, hours4=45;
   int ovTimeHour1=hours1-40, ovTimeHour2=hours2-40, //Hours of overtime equals hours worked minus forty.
         ovTimeHour3=hours3-40, ovTimeHour4=hours4-40;
   double payRate1=10.0, payRate2=20.0, payRate3=10.0, payRate4=20.0;
   double grossPay1, grossPay2, grossPay3, grossPay4;
   int ovTime1=0, ovTime2=0, ovTime3=1, ovTime4=1;
   //if I knew how, I would display "if you worked overtime, enter 1, otherwise enter 0."
   
   //calculate gross pay for each combination
   //Since ovTime equals zero, these first two are mathematically equal to hours times pay rate.
   grossPay1 = (hours1 + 0.5 * ovTimeHour1 * ovTime1) * payRate1;
   grossPay2 = (hours2 + 0.5 * ovTimeHour2 * ovTime2) * payRate2;
   /* hours times payRate equals base pay, but the overtime 
   receives 1.5 times payRate. the "+ 0.5 times overtime" compensates for the fact
   that I already counted the overtime hours once in the base pay.
   Multiplying by ovTime can be ignored in these two since ovTime equals 1. */  
   grossPay3 = (hours3 + 0.5 * ovTimeHour3 * ovTime3) * payRate3;
   grossPay4 = (hours4 + 0.5 * ovTimeHour4 * ovTime4) * payRate4;
   
   //display the hours, payRate, overtime, overtimeRate, and wages   
   System.out.println("If you work " + hours1 + " hours per week, " +
                  "at a pay rate of $" + payRate1 + ",");
   System.out.println("Your gross pay is $" + grossPay1 + "\n");
   System.out.println("If you work " + hours2 + " hours per week, " +
                  "at a pay rate of $" + payRate2 + ",");
   System.out.println("Your gross pay is $" + grossPay2 + "\n");
   System.out.println("If you work " + hours3 + " hours per week, " +
                  "at a pay rate of $" + payRate3 + ", including " + ovTimeHour3 +
                  " hours of overtime at $" + (payRate3 * 1.5) + ",");
   System.out.println("Your gross pay is $" + grossPay3 + "\n");
   System.out.println("If you work " + hours4 + " hours per week, " +
                  "at a pay rate of $" + payRate4 + ", including " + ovTimeHour4 +
                  " hours of overtime at $" + (payRate4 * 1.5) + ",");
   System.out.println("Your gross pay is $" + grossPay4 + "\n");
     
   }
}