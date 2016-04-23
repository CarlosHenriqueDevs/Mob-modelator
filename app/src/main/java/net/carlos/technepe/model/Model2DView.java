package net.carlos.technepe.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;
import net.carlos.technepe.model.mob.Model;
import android.graphics.Bitmap;
import java.io.InputStream;
import java.io.IOException;
import android.graphics.BitmapFactory;
import net.carlos.technepe.model.mob.Part;

public class Model2DView extends SurfaceView implements Runnable
{
   public static Thread fpsThread;
   private boolean running = false;
   private Model model;
   private Part head;

   public Model2DView(Context ctx)
   {
      super(ctx);

      this.running = true;

      Model2DView.fpsThread = new Thread(this);
      Model2DView.fpsThread.start();

      try
      {
	 InputStream is = ctx.getAssets().open("model.png");
	 this.model = new Model(BitmapFactory.decodeStream(is));
      }
      catch (IOException e)
      {}

      this.head = new Part(0, 8, 8, 8);
   }

   @Override
   public void run()
   {
      while (running)
      {
	 draw();
	 update();
	 control();
      }
   }

   private void draw()
   {
      if (getHolder().getSurface().isValid())
      {
	 Canvas canvas = getHolder().lockCanvas();
	 canvas.drawColor(Color.WHITE);
	 canvas.drawBitmap(head.getTexturePart(), 300, 300, null);

	 getHolder().unlockCanvasAndPost(canvas);
      }
   }

   private void update()
   {

   }

   private void control()
   {
      try
      {
	 fpsThread.sleep(50);
      }
      catch (InterruptedException e)
      {}
   }

   public void destroy()
   {
      this.running = false;

      boolean retry = true;

      while (retry)
      {
	 try
	 {
	    fpsThread.join();
	 }
	 catch (InterruptedException e)
	 {
	    
	 }
	 
	 retry = false;
      }
   }

   public int[] getPixels(Bitmap input)
   {
      int[] allpixels = new int [input.getHeight() * input.getWidth()];

      input.getPixels(allpixels, 0, input.getWidth(), 0, 0, input.getWidth(), input.getHeight());

      return allpixels;
   }

}
