package engine;

import java.util.HashMap;
import java.lang.Thread;
import java.awt.event.KeyEvent;

/**
 * Class representing whole game
 */
public class Game {
   /** All the objects */
   private HashMap<String, Object> objects;

   /** Screen */
   private Display display;

   /** Input */
   private Input input;
   
   /** Whether game is currently running or not */
   private boolean running;

   /** Duration of frame in milliseconds */
   private int frameTime = 8;

   /** Width of screen */
   private int width;
   /** Height of screen */
   private int height;
   
   /** Title */
   private final String title;
   
   // Constructor
   public Game(String title, int width, int height) {
      // initialize title
      this.title = title;

      this.width = width;
      this.height = height;

      // initialize the object map
      objects = new HashMap<String, Object>();
      
      running = true;
         
      input = new Input(objects);
      
      display = new Display(objects, input, width, height, this.title);
   }
   
   /**
    * Method representing main logic of app
    */
   public void run() {
      // Game loop
      while(running) {
         // Update states
         updateStates();
         // Update Screen  
         display.updateScreen();
         // Wait between each frame
         try{ Thread.sleep(frameTime); }
         catch(InterruptedException e){ System.err.println(e); }
      }
   }
   
   /**
    * Update the state of all the Updateable objects
    */
   private void updateStates() {
      for(Object o : objects.values())
            if(o instanceof Updateable)
               ((Updateable)o).update();
   }
   
   /**
    * Returns a hashmap of all of the objects
    * @return Hashmap of all of the objects
    */
   public HashMap<String, Object> getObjects() {
      return objects;
   }
   
   /**
    * Returns the dimensions of the screen
    * @return [width, height]
    */
   public int[] getDimensions() {
      return new int[]{width,height};
   }
}