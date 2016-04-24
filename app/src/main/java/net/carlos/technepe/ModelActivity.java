package net.carlos.technepe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import net.carlos.technepe.model.Model2DView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.view.View;

public class ModelActivity extends Activity
{
   private Model2DView model2d;
   private Spinner partModels;
   private Spinner vision;
   
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      // TODO: Implement this method
      super.onCreate(savedInstanceState);
      setContentView(R.layout.model_studio);
      
      this.model2d = new Model2DView(this);
      
      LinearLayout ll = (LinearLayout) findViewById(R.id.layout_model);
      ll.addView(model2d);
      
      ArrayAdapter<String> adParts = new ArrayAdapter<String>(this,
                                    android.R.layout.simple_list_item_1, parts);
				    
      ArrayAdapter<String> adVision = new ArrayAdapter<String>(this, 
                                     android.R.layout.simple_list_item_1, views);
      
      partModels = (Spinner) findViewById(R.id.model_select_part);
      vision = (Spinner) findViewById(R.id.model_part_vision);
      ImageView texture = (ImageView) findViewById(R.id.model_texture);
      texture.setImageBitmap(model2d.model.modelSkin);
      
      partModels.setAdapter(adParts);
      vision.setAdapter(adVision);
   }

   @Override
   protected void onDestroy()
   {
      super.onDestroy();
      
      model2d.destroy();
   }
   
   public void addBox(View v)
   {
      model2d.addBox = true;
   }
   
   private static final String[] parts = {"head", "body", "right hand", "left hand", "left leg", "right leg"};
   private static final String[] views = {"Front", "Top", "Right", "Left"};
}
