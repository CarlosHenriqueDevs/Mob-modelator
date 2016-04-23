package net.carlos.technepe;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends Activity 
{
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      
      Intent i = new Intent(this, ModelActivity.class);
      startActivity(i);
   }
}
