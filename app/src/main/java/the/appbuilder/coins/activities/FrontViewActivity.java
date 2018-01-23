package the.appbuilder.coins.activities;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.linearlistview.LinearListView;
import android.content.Intent;
import the.appbuilder.coins.R;

import the.appbuilder.coins.interfaces.AppAPI;
import the.appbuilder.coins.model.Front;
import the.appbuilder.coins.databinding.ActivityViewFrontBinding;

import com.google.gson.Gson;



import the.appbuilder.coins.utils.TrackableActivity;


public class FrontViewActivity extends TrackableActivity {

    private Front frontVar;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String frontJson = getIntent().getStringExtra("FRONT");


        if(frontJson != null) {
            Gson gson = new Gson();
            frontVar = gson.fromJson(frontJson, Front.class);
        } else {
            frontVar = new Front();
        }

        ActivityViewFrontBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_front);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if(binding != null) {
            binding.setFront(frontVar);
            binding.setPresenter(this);
            Log.d("FrontViewActivity", "Binding enabled");
        }



        
        
        


    }




    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}