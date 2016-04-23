package net.carlos.technepe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import net.carlos.technepe.model.Model2DView;

public class ModelActivity extends Activity
{
   private Model2DView model2d;
   
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      // TODO: Implement this method
      super.onCreate(savedInstanceState);
      setContentView(R.layout.model_studio);
      
      this.model2d = new Model2DView(this);
      
      LinearLayout ll = (LinearLayout) findViewById(R.id.layout_model);
      ll.addView(model2d);
   }

   @Override
   protected void onDestroy()
   {
      // TODO: Implement this method
      super.onDestroy();
      
      model2d.destroy();
   }
   
}
