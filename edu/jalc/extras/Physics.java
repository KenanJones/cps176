//This Program solves Physics problems in which a single object is in free fall

/*It begins by asking for the units and then uses them to find gravitational acceleration.
Then you may select, one at a time, the quantities you already know
and enter their values. You will then see a list of the quantities
that can be determined with the information you have given.
Select one. You can now select a formula to use, and the result will be displayed.*/
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Physics
{
   //make an array with no null spaces given any array
   public static Object[] arrayMaker (Object[] start)
   {
   int count = 0;//the length without null elements counted
   for(int i = 0; i < start.length; i++){
      if(start[i] != null)
         {count += 1;}}//increment count if something is in the array at that position

   Object[] finish = new Object[count];//new array of proper length
   int k = 0; // a counter
   for(int j = 0; j < start.length; j++){// fill the new array
      if(start[j] != null)
         {finish[k] = start[j];
         k++;}}
   return finish;//return the finished array
   }
   public static double I_Position (double gravity, double fPos, double iVel, double fVel,
                                    double time, boolean fVelT, boolean timeT)
   {
   Object[] options = {"two star", "three star"};//the formulas you can use
   //remove a formula if there is not enough information to use it
   if(timeT == false){options[0]=null;}
   if(fVelT == false){options[1]=null;}
   
   Object[] formulas = Physics.arrayMaker(options);//all the usable formulas
   
   int form = JOptionPane.showOptionDialog(null,"What formula would you like to use?",
                                          "Input",0,3,null,formulas,null);
   
   if (form == -1){System.exit(0);}//end the program if closed or cancelled
   String selected = formulas[form].toString();//the selected formula as a string
   
   double iPos = 0;
   //calculate the final position
   if (selected == "two star")
      {iPos = fPos - iVel * time - 0.5 * gravity * Math.pow(time,2);}
   if (selected == "three star")
      {iPos = fPos - (0.5 * fVel * fVel - iVel * iVel) / gravity;}
   return iPos;
   }
   //find the final position of an object:
   public static double F_Position (double gravity, double iPos, double iVel, double fVel,
                                    double time, boolean timeT, boolean fVelT)
   {
   Object[] options = {"two star", "three star"};//the formulas you can use
   //remove a formula if there is not enough information to use it
   if(timeT == false){options[0]=null;}
   if(fVelT == false){options[1]=null;}
   
   Object[] formulas = Physics.arrayMaker(options);//all the usable formulas
   
   int form = JOptionPane.showOptionDialog(null,"What formula would you like to use?",
                                          "Input",0,3,null,formulas,null);
   
   if (form == -1){System.exit(0);}//end the program if closed or cancelled
   String selected = formulas[form].toString();//the selected formula as a string
   
   double position = 0;
   //calculate the final position
   if (selected == "two star")
      {position = iPos + iVel * time + 0.5 * gravity * Math.pow(time,2);}
   if (selected == "three star")
      {position = iPos + (0.5 * fVel * fVel - iVel * iVel) / gravity;}
   return position;
   }
   //find the time for which the object is observed:
   public static double time (double gravity, double iPos, double fPos, double iVel, double fVel,
                              boolean iPosT, boolean fPosT, boolean iVelT, boolean fVelT)
   {
   Object[] options = {"one star", "two star"};//the formulas you can use
   //remove a formula if there is not enough information to use it
   if(iVelT != true || fVelT != true)options[0] = null;
   if(iPosT != true || fPosT != true || iVelT != true)options[1] = null;
   
   Object[] formulas = Physics.arrayMaker(options);//only the formulas that work
   
   int form = JOptionPane.showOptionDialog(null,"What formula would you like to use?",
                                          "Input",0,3,null,formulas,null);
   
   if (form == -1){System.exit(0);}//end the program if the user closes the window
   String selected = formulas[form].toString();//get the text on the selected button
   
   double time = 0;
   //calculate the time by the selected formula
   if (selected == "one star") {time = (fVel - iVel)/gravity;}
   if (selected == "two star")
      {time =-iVel/gravity+(Math.sqrt(Math.pow(iVel,2)+2*gravity*(fPos-iPos)))/gravity;}
   return time;
   }
   //find the initial velocity of the object:
   public static double I_Velocity (double gravity, double iPos, double fPos, double fVel, double time,
                                    boolean iPosT, boolean fPosT, boolean fVelT, boolean timeT)
   {
   Object[] options = {"one star", "two star", "three star"};//possible formulas
   //remove a formula if there is not enough information to use it
   if(fVelT == false || timeT == false)options[0] = null;
   if(iPosT == false || fPosT == false || timeT == false)options[1] = null;
   if(iPosT == false || fPosT == false || fVelT == false)options[2] = null;
   //all the formulas that have enough information to be used
   Object[] formulas = Physics.arrayMaker(options);
   
   int form = JOptionPane.showOptionDialog(null,"What formula would you like to use?","Input",
                  0,3,null,formulas,null);
   
   if (form == -1){System.exit(0);}//end the program if the user closes the window
   String selected = formulas[form].toString();//get the text on the selected button
   
   double iVel = 0, deltaX = fPos - iPos;
   //calculate the value using the selected formula
   if (selected == "one star")iVel = fVel - gravity * time;
   if (selected == "two star")iVel = deltaX/time - 0.5 * gravity * time;
   if (selected == "three star")iVel = Math.sqrt(fVel*fVel - 2.0*gravity*deltaX);
   
   return iVel;
   }
   //find the final velocity of the object:
   public static double F_Velocity (double gravity, double iPos, double fPos, double iVel, double time,
                                    boolean iPosT, boolean fPosT, boolean iVelT, boolean timeT)
   {
   Object[] options = {"one star","three star"};//possible formulas
   //remove a formula if there is not enough information to use it
   if(iVelT == false || timeT == false)options[0] = null;
   if(iVelT == false || iPosT == false || fPosT == false)options[1] = null;
   
   Object[] formulas = Physics.arrayMaker(options);//only formulas that work
   
   int form = JOptionPane.showOptionDialog(null,"What formula would you like to use?","Input",
                  0,3,null,formulas,null);
   
   if (form == -1){System.exit(0);}//end the program if the user closes the window
   String selected = formulas[form].toString();//get the text on the selected button
   
   double fVel = 0, deltaX = fPos - iPos;
   //use the selected formula to find the final velocity
   if (selected == "one star")fVel = iVel - gravity * time;
   if (selected == "three star")fVel = Math.sqrt(iVel*iVel + 2*deltaX*gravity);

   return fVel;//                                                    __       __
   }//                                                              /  \     /  \
   //                                                              / -- \   / -- \
   //get information and call the correct solver method:          / /  \ \ / /  \ \
   public static void main (String[] physics)//                  / /     ---     \ \
   {
   //initialize all variables
   boolean iPosT = false, fPosT = false, iVelT = false, fVelT = false, timeT = false;
   double iPos = 0, fPos = 0, iVel = 0, fVel = 0, time = 0, gravity;
   
   Object[] possibleValues = { "m/s", "cm/s", "ft/s", "km/s", "miles/h" };//possible units
   Object unitChosen = null;
   boolean test = true;//loop test value
   //this loop executes until the user selects a value
   while(test){
   unitChosen = JOptionPane.showInputDialog(null, "What units are you using?", "Input",
                                            3, null, possibleValues, null);
   if(unitChosen == null){JOptionPane.showMessageDialog(null,"please select a value");}
   else{test = false;}
   }
   String units = new String(unitChosen.toString());//the chosen units
            
   switch (units){//find the value of gravity
      case "cm/s": gravity = -980; break;
      case "ft/s": gravity = -32; break;
      case "miles/h": gravity = -78546; break;
      case "km/s": gravity = -0.0098; break;
      case "m/s":
      default: gravity = -9.8; break;
   }
   Object[] possibleGivens = {"Initial Position","Final Position","Initial Velocity",
                              "Final Velocity","Elapsed Time"};
   String[] chosenGivens = new String[5];//all the users choices
   
   int i = 0;//a counter variable
   test = true;
   //get the value of each known quantity
   while (test){
      Object[] remainingGivens  = Physics.arrayMaker(possibleGivens);//an array of the remaining choices
         
      Object choice = JOptionPane.showInputDialog(null, "Select one given Quantity", "Input",
                      3, null, remainingGivens, null);
         
      if(choice == null)
         {test = false;}//end the loop if the box is cancelled or closed
      else{
         String givenValue = new String(choice.toString());//the users choice as a string
      
         chosenGivens[i] = givenValue;//add the users choice to the array of chosen options
         i += 1;//increment the counter
         for(int j = 0; j < 5; j++){//delete the option from the possible list
            if (givenValue.equals(possibleGivens[j]))
            possibleGivens[j] = null;
            }
         switch (givenValue){
            //get the value of the user's choice and set the corresponding test value to true
            case "Initial Position" :String iPos1 = JOptionPane.showInputDialog(null,"Initial Position");
               iPos = Double.parseDouble(iPos1); iPosT = true; break;
            case "Final Position" :String fPos1 = JOptionPane.showInputDialog(null,"Final Position");
               fPos = Double.parseDouble(fPos1); fPosT = true; break;
            case "Initial Velocity" :String iVel1 = JOptionPane.showInputDialog(null,"Initial Velocity");
               iVel = Double.parseDouble(iVel1); iVelT = true; break;
            case "Final Velocity" :String fVel1 = JOptionPane.showInputDialog(null,"Final Velocity");
               fVel = Double.parseDouble(fVel1); fVelT = true; break;
            case "Elapsed Time" :String time1 = JOptionPane.showInputDialog(null,"Elapsed Time");
               time = Double.parseDouble(time1); timeT = true; break;
      }}}
  
   Object[] solveForPoss = {"Initial Position","Final Position", "Elapsed Time", "Initial Velocity", "Final Velocity"};
   // test if the requirements of each method are satisfied, and set the option to null if they aren't
   if(fPosT == false || iVelT == false || (timeT == false && fVelT == false))
      solveForPoss[0] = null;
   if(iPosT == false || iVelT == false || (timeT == false && fVelT == false))
      solveForPoss[1] = null;
   if((iVelT == false || fVelT == false)&&(iPosT == false || fPosT == false || iVelT == false))
      solveForPoss[2] = null;
   if((fVelT == false || timeT == false)&&(iPosT == false || fPosT == false || timeT == false)
      &&(iPosT == false || fPosT == false || fVelT == false))
      solveForPoss[3] = null;
   if((iVelT == false || timeT == false)&&(iVelT == false || iPosT == false || fPosT == false))
      solveForPoss[4] = null;
   
   Object[] solveFor = Physics.arrayMaker(solveForPoss);//the valid choices
   
   test = true;
   //if there is not enough information, there is an infinite loop without this.
   if (solveFor.length == 0){test = false;}
   while (test){//an exception handling loop
   
      Object solvefor = JOptionPane.showInputDialog(null,"What would you like to solve for?",
                         "Solve for?",3, null, solveFor, null);
      if(solvefor == null)//don't let the user close or cancel this box!
         JOptionPane.showMessageDialog(null,"Please select a value");
      else{
         test = false;//stop the exception handling loop since the user selected a value
         String solveForThis = new String(solvefor.toString());//the user's choice as a string
   
         switch (solveForThis){//use the opropriate method to find the value
            case "Initial Position" : iPos = Physics.I_Position(gravity, fPos, iVel, fVel, time,
                                                                fVelT, timeT);
               JOptionPane.showMessageDialog(null,"the initial position is " + iPos); break;
            case "Final Position" : fPos = Physics.F_Position(gravity, iPos, iVel, fVel, time,
                                                              fVelT, timeT);
               JOptionPane.showMessageDialog(null,"the position is " + fPos); break;
            case "Elapsed Time" : time = Physics.time(gravity, iPos, fPos, iVel, fVel,
                                                      iPosT, fPosT, iVelT, fVelT);
               JOptionPane.showMessageDialog(null,"the time is " + time); break;
            case "Initial Velocity" : iVel = Physics.I_Velocity(gravity, iPos, fPos, fVel, time,
                                                                iPosT, fPosT, fVelT, timeT);
               JOptionPane.showMessageDialog(null,"the initial velocity is " + iVel); break;
            case "Final Velocity" : fVel = Physics.F_Velocity(gravity, iPos, fPos, iVel, time,
                                                              iPosT, fPosT, iVelT, timeT);
               JOptionPane.showMessageDialog(null,"The final velocity is " + fVel); break;
   }}}
   
   System.exit(0);
   }
}