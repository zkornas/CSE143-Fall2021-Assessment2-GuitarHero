// Zacharia Kornas
// TA: Kent Zeng
// The Guitar37 class represents a virtual guitar
// with 37 chords that produce music
import java.util.*;

public class Guitar37 implements Guitar {
   public static final String KEYBOARD =
         "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
   public static final int NUM_STRING = 37;        // number of GuitarStrings
   private int tic = 0;
   private GuitarString[] frequencies;
   
   // Constructs a virtual guitar with 37 chords
   public Guitar37(){
      frequencies = new GuitarString[NUM_STRING];
      for(int i = 0; i < NUM_STRING; i++){
         frequencies[i] = new GuitarString(440.0 * Math.pow(2.0,(i - 24.0) / 12.0));
      }
   }
   
   // Plays a note of a specific pitch
   // Ignores pitches if they are not assigned to a guitar string
   // Parameters:
   //    pitch - the pitch that the note is played at
   public void playNote(int pitch){
      int key = pitch + 24;
      if(key >= 0 && key <= NUM_STRING - 1){
         GuitarString string = frequencies[key];
         string.pluck();
      }
      
   }
   
   // Checks to see if the given character is assigned
   // to a chord on the virtual guitar
   // Parameters:
   //    string - the character the client wants to verify is
   //             assigned to a chord on the virtual guitar
   // Returns true or false depending on if the character is assigned to a chord
   public boolean hasString(char string) {
      return(KEYBOARD.indexOf(string) > -1);
   }
   
   // Simulates plucking the chord assigned to the given character
   // Throws IllegalArgumentException if character is not assigned to a chord
   // Paramters:
   //    string - the character that represents the chord that the client
   //             wants to pluck
   public void pluck(char string) {
      int note = KEYBOARD.indexOf(string);
      if(note == -1){
         throw new IllegalArgumentException();
      }
      frequencies[note].pluck();
   }
   
   // Returns the sum of all current samples from all chords
   // on the virtual guitar
   public double sample() {
      double sample = 0;
      for(int i = 0; i < NUM_STRING; i++){
         GuitarString string = frequencies[i];
         sample += string.sample();
      }
      return sample;
   }
   
   // Advances time forward by one tic
   public void tic() {
      for(int i = 0; i < NUM_STRING; i++){
         GuitarString string = frequencies[i];
         string.tic();
      }
      tic++;
   }
   
   // Returns the current time in tics
   public int time() {
      return tic;
   }

}
