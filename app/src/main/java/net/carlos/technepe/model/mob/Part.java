package net.carlos.technepe.model.mob;

import net.carlos.technepe.model.utils.Vector2;
import android.graphics.Bitmap;
import android.graphics.Rect;

public class Part
{
   private Vector2 pixelCoords;
   private int width;
   private int height;
   public Rect partBox;
   
   public Part()
   {
      this.pixelCoords = new Vector2();
   }
   
   public Part(int x, int y, int width, int height)
   {
      this.pixelCoords.x = x;
      this.pixelCoords.y = y;
      this.width = width;
      this.height = height;
   }
   
   public Part(int x, int y)
   {
      this.pixelCoords.x = x;
      this.pixelCoords.y = y;
   }

   public void setPixelCoords(Vector2 pixelCoords)
   {
      this.pixelCoords = pixelCoords;
   }

   public Vector2 getPixelCoords()
   {
      return pixelCoords;
   }

   public void setWidth(int width)
   {
      this.width = width;
   }

   public int getWidth()
   {
      return width;
   }

   public void setHeight(int height)
   {
      this.height = height;
   }

   public int getHeight()
   {
      return height;
   }
   
   public Bitmap getTexturePart()
   {
      return null;
   }
}
