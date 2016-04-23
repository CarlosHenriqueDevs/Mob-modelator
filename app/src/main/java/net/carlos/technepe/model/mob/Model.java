package net.carlos.technepe.model.mob;

import java.util.ArrayList;
import android.graphics.Bitmap;
import net.carlos.technepe.model.utils.Vector2;
import android.graphics.Rect;

public class Model
{
   private ArrayList<Part> parts = new ArrayList<>();
   public static Bitmap modelSkin;
   
   public Model(Bitmap modelSkin)
   {
      this.modelSkin = modelSkin;
   }
   
   public void addBox(Vector2 pxCoords, Part part, int width, int height)
   {
      part.partBox = new Rect(pxCoords.x, pxCoords.y, pxCoords.x + width, 
                              pxCoords.y + height);
   }
}
