package net.carlos.technepe.model.utils;

public class Vector2
{
   public int x;
   public int y;
   
   public Vector2(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
   public Vector2() {}
   
   public void reset()
   {
      this.x = 0;
      this.y = 0;
   }
   
   public void set(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
}
