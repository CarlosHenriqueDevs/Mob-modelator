package net.carlos.technepe.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;

public class Model2DView extends SurfaceView implements Runnable
{
   public static Thread fpsThread;
   private boolean running = false;

   public Model2DView(Context ctx)
   {
      super(ctx);

      this.running = true;

      Model2DView.fpsThread = new Thread(this);
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

	 getHolder().unlockCanvasAndPost(canvas);
      }
   }
   
   private void update()
   {

   }

   private void control()
   {

   }

   public void destroy()
   {
      this.running = false;

      try
      {
	 fpsThread.join();
      }
      catch (InterruptedException e)
      {
	 System.out.println("Thread não matada");
      }
   }

}
