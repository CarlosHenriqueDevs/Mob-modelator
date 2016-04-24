package net.carlos.technepe.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;
import java.io.IOException;
import java.io.InputStream;
import net.carlos.technepe.model.mob.Model;
import net.carlos.technepe.model.mob.Part;
import android.view.MotionEvent;
import android.graphics.Rect;
import android.graphics.Paint;

public class Model2DView extends SurfaceView implements Runnable
{
   public static Thread fpsThread;
   private boolean running = false;
   public Model model;
   private Part head;
   private Canvas canvas;
   
   public boolean addBox = false;

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
      
      this.head = new Part(0, 1, 8, 8);
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
	 canvas = getHolder().lockCanvas();
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

   @Override
   public boolean onTouchEvent(MotionEvent event)
   {
      if (addBox)
      {
	 Paint color = new Paint();
	 color.setColor(Color.BLACK);
	 Rect rect = new Rect(300, 300, 390, 390);
	 canvas.drawRect(rect, color);
	 
	 addBox = false;
      }
      
      return super.onTouchEvent(event);
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
