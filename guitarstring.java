// Zacharia Kornas
// TA: Kent Zeng
// The GuitarString class represents a single guitar string
// that is a simulation of a real guitar string and can be
// used to produce music.
import java.util.*;
import java.lang.*;

public class GuitarString { 
   public static final double ENERGY_DECAY = 0.996; 
   private Queue<Double> ringBuffer;
   
   // Constructs a GuitarString with an empty ring buffer.
   // Throws an IllegalArgumentException 
   // if the frequency passed in is less than or equal to zero
   // or if resulting size of the ring buffer is less than 2
   // Parameters:
   //    frequency - the frequency passed in used to calculate
   //                length of ring buffer. 
   public GuitarString(double frequency) {
      if(frequency <= 0.0 || (int)(Math.round(StdAudio.SAMPLE_RATE / frequency)) < 2){
         throw new IllegalArgumentException();
      }
      ringBuffer = new LinkedList<Double>();
      for(int i = 0; i <= (int)(Math.round(StdAudio.SAMPLE_RATE / frequency)) - 1; i++) {
         ringBuffer.add(0.0);
      }
   }
  
  // Constructs a GuitarString with an empty ring buffer.
  // Throws an IllegalArgumentException
  // if ring buffer is less than 2
  // Parameters:
  //  init - The array passed in used to initilize the 
  //         contents of the ring buffer
   public GuitarString(double[] init) {
      if(init.length < 2){
         throw new IllegalArgumentException();
      }
      ringBuffer = new LinkedList<Double>();
      for(int i = 0; i < init.length; i++){
         ringBuffer.add(init[i]);
      }
   }
   
   // Replaces values in the ringBuffer in the guitarString
   // with random numbers between -0.5, 0.5 to simulate
   // the GuitarString being plucked
   public void pluck(){
      for(int i = 0; i <= ringBuffer.size() - 1; i++){
         ringBuffer.remove();
         ringBuffer.add((double)(Math.random() - 0.5));
      }
   }
   
   // Applies the Karplus-String update one time.
   public void tic(){
      double firstValue = ringBuffer.remove();
      double secondValue = ringBuffer.peek();
      ringBuffer.add(ENERGY_DECAY * (0.5 * (firstValue + secondValue)));
   }
   
   // Returns the current value at the front of the ringBuffer
   public double sample(){
      return ringBuffer.peek();
   }
}
