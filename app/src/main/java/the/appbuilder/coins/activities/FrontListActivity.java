package the.appbuilder.coins.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import the.appbuilder.coins.R;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import the.appbuilder.coins.model.Front;
import the.appbuilder.coins.adapters.FrontListAdapter;
import the.appbuilder.coins.AppService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import the.appbuilder.coins.utils.TrackableActivity;



public class FrontListActivity extends TrackableActivity implements SwipeRefreshLayout.OnRefreshListener {

    private FrontListAdapter frontListAdapter;
    private ArrayList<Front> fronts = new ArrayList<Front>();
    private SwipeRefreshLayout frontListRefreshable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_front);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        frontListRefreshable = (SwipeRefreshLayout) findViewById(R.id.content_list_front);
        frontListRefreshable.setOnRefreshListener(this);

        ListView frontList = (ListView) findViewById(R.id.front_list);
        frontListAdapter = new FrontListAdapter(this,R.layout.front_list_item, fronts );
        frontList.setAdapter(frontListAdapter);


    }

    @Override
    public void onRefresh() {
        refresh();
    }

    protected void refresh() {
        frontListRefreshable.setRefreshing(true);
        Call<List<Front>> call1  = AppService.getService().getFronts();
        call1.enqueue(new Callback<List<Front>>() {
            @Override
            public void onResponse(Call<List<Front>> call, Response<List<Front>> response) {
                if(response.isSuccessful()) {
                    frontListAdapter.clear();
                    frontListAdapter.addAll(response.body());
                    frontListAdapter.notifyDataSetChanged();
                } else  {
                    //TODO: Handle error
                    try {
                        Log.e("Front", "Request NOT successful: "+response.errorBody().string());
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(FrontListActivity.this, "Request failed load data", Toast.LENGTH_SHORT).show();
                }
                frontListRefreshable.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Front>> call, Throwable t) {
            	frontListRefreshable.setRefreshing(false);
				Log.e("Front", "onFailure "+t.getMessage());
				Toast.makeText(FrontListActivity.this, "Unable to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    public void onClick(Front frontVar) {
        //Log.d("Front", "onClick: "+frontVar.id);

        Gson gson = new Gson();
        String jsonStr = gson.toJson(frontVar);

        Intent intent = new Intent(this, FrontViewActivity.class);
        intent.putExtra("FRONT", jsonStr);
        startActivity(intent);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}