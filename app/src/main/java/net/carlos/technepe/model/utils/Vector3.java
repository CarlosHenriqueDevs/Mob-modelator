package net.carlos.technepe.model.utils;

public class Vector3 extends Vector2
{
   public int z;
   
   public Vector3(int x, int y, int z)
   {
      this.x = x;
      this.y = y;
      this.z = z;
   }
   
   public void set(int x, int y, int z)
   {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   @Override
   public void set(int x, int y)
   {
      super.set(x, y);
      
      this.z = 0;
   }

   @Override
   public void reset()
   {
      super.reset();
      
      this.z = 0;
   }
   
}
