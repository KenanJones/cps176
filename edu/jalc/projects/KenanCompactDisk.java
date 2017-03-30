/*Kenan Jones 11-17-16
This program reads song titles and composers from a file,
adds each song-title combo to an array as one string with "by" between them,
and prints the array's elements one per line.*/

import java.io.*;
import java.util.*;

public class KenanCompactDisk
{
public static String[] songs = new String[0];
      //the main method reads the file, calls addSong as necessary,and calls printArray
   public static void main (String[] args) throws IOException
   {
   File file1 = new File("Classics.txt");
   Scanner inputFile1 = new Scanner(file1);
   
   while(inputFile1.hasNext())
      {
      addSong(inputFile1.nextLine() + " by " + inputFile1.nextLine());
      }
   System.out.println("Contents of Compact Disc:");
   for(int i = 0; i < 25; i++)
      System.out.print("=");
   System.out.println();
   printArray();
   }
      //addSong adds a new element to String[] songs.
      //it is a direct copy of addNumber in KenanProject7 with variable types changed!
   public static void addSong(String newSong)
   {
   String[] temporary = songs;
   songs = new String[temporary.length + 1];
   for(int i = 0; i < temporary.length; i++)
      {
      songs[i] = temporary[i];
      }
   songs[songs.length - 1] = newSong;
   }
      //prints each item in songs on its own line.
   public static void printArray()
   {
   for(String song: songs)
      {
      System.out.println(song);
      }
   }
}