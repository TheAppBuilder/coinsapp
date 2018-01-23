package the.appbuilder.coins.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import the.appbuilder.coins.R;

import java.util.List;

import the.appbuilder.coins.databinding.FrontListItemBinding;
import the.appbuilder.coins.model.Front;
import the.appbuilder.coins.activities.FrontListActivity;



/**
 * Created by sonique on 1/02/2017.
 */

public class FrontListAdapter extends ArrayAdapter<Front> {
    
    
    
    public FrontListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public FrontListAdapter(Context context, int resource, List<Front> items) {
        super(context, resource, items);
        
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater vi = LayoutInflater.from(getContext());


        FrontListItemBinding binding =
                DataBindingUtil.inflate(vi, R.layout.front_list_item, parent, false);


        Front frontVar = getItem(position);

        binding.setFront(frontVar);

        if( getContext() instanceof FrontListActivity) {
            binding.setPresenter((FrontListActivity) getContext());
        }
        


        return binding.getRoot();

    }
}