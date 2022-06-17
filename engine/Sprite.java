package engine;

/**
 * Abstract class that represents generic object drawn to screen
 */
public abstract class Sprite implements Drawable {
   // Coordinates
   /** 
    * x coordinate of sprite
    * (coordinate is for upper left most point)
    */
   protected int x;
   /** 
    * y coordinate of sprite 
    * (coordinate is for upper left most point)
    */
   protected int y;
   
   /** Width of sprite */
   protected int width;
   /** Height of sprite */
   protected int height;
   
   /** Width of the screen in pixels */
   protected static int screenWidth;
   /** Height of the screen in pixels */
   protected static int screenHeight;
   
   /** 
    * Integer for drawing order.
    * Sprites with higher precedence will be drawn onto the screen later
    */
   protected int precedence;
   
   /** App */
   protected App a;
      
   /**
    * Constructs sprites
    * @param x          x-coordinate
    * @param y          y-coordinate
    * @param width      width
    * @param height     height
    * @param precedence precedence(for drawing order)
    * @param a          app
    */
   public Sprite(int x, int y, int width, int height, int precedence, App a) {
      this.x = x;
      this.y = y;
      
      this.width = width;
      this.height = height;
      
      this.a = a;
      
      this.precedence = precedence;
   }
      
   // Coordinates

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   /**
    * Increment x by dx
    * @param dx value to increment x by
    */
    public void incrementX(int dx) {
      x += dx;
   }
   
   public int getY() {
      return y;
   }
     
   public void setY(int y) {
      this.y = y;
   }
      
   /**
    * Increment y by dy
    * @param dy value to increment y by
    */
   public void incrementY(int dy) {
      y += dy;
   }
   
   /**
    * Gets both x and y coordinates
    * @return [x, y] 
    */
   public int[] getPoint() {
      return new int[]{x, y};
   }

   // Area
      
   public int getWidth() {
      return width;   
   }

   public void setWidth(int width) {
      this.width = width;
   }
   
   public int getHeight() {
      return height;
   }

   public void setHeight(int height)  {
      this.height = height;
   }
   
   // Misc

   public int getPrecedence() {
      return precedence;
   }
   
   public App getGame() {
      return a;
   }

   // Screen

   public int getScreenWidth() {
      return screenWidth;
   }
   
   public int getScreenHeight() {
      return screenHeight;
   }

   public static void setScreenDimensions(int screenWidth, int screenHeight) {
      Sprite.screenWidth = screenWidth;
      Sprite.screenHeight = screenHeight;
   }
}