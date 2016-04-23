package net.carlos.technepe.model;

import android.opengl.GLSurfaceView;
import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import static android.opengl.GLES10.*;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;

public class Model3DView extends GLSurfaceView
{
   public Model3DView(Context ctx)
   {
      super(ctx);
      
      setRenderer(new ModelRenderView());
   }

   public class ModelRenderView implements Renderer
   {
      @Override
      public void onSurfaceCreated(GL10 gl, EGLConfig conf)
      {
	 
      }

      @Override
      public void onSurfaceChanged(GL10 gl, int width, int height)
      {
	 glViewport(0, 0, width, height);
      }

      @Override
      public void onDrawFrame(GL10 gl)
      {
	 glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
      }
      
   }
}
