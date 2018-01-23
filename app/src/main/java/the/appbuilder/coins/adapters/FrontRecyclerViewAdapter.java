package the.appbuilder.coins.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import the.appbuilder.coins.R;

import android.databinding.DataBindingUtil;
import java.util.ArrayList;
import java.util.List;

import the.appbuilder.coins.model.Front;
import the.appbuilder.coins.activities.FrontRecycleListActivity;
import the.appbuilder.coins.databinding.FrontListRecycleItemBinding;


/**
 * Created by cedricferry on 27/10/17.
 */

public class FrontRecyclerViewAdapter extends RecyclerView.Adapter<FrontRecyclerViewAdapter.ViewHolder> {
    private List<Front> mFrontList = new ArrayList<>();
    private Context context;
    private FrontRecycleListActivity mPresenter;

    public void setPresenter(FrontRecycleListActivity presenter) {
        this.mPresenter = presenter;
    }


    public void clear(){
        this.mFrontList.clear();
    }

    public void addAll(List<Front> frontList) {
        this.mFrontList.clear();
        this.mFrontList.addAll(frontList);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        FrontListRecycleItemBinding binding;

        public ViewHolder(FrontListRecycleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Front frontVar, FrontRecycleListActivity presenter) {
            binding.setFront(frontVar);
            if( presenter instanceof FrontRecycleListActivity) {
                binding.setPresenter(presenter);
            }

            binding.executePendingBindings();
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FrontRecyclerViewAdapter(Context context, ArrayList<Front> frontList ) {
        if(frontList != null) {
            this.mFrontList.addAll(frontList);
        }
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FrontRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
        // create binding
        LayoutInflater vi = LayoutInflater.from(parent.getContext());

        FrontListRecycleItemBinding binding =
        DataBindingUtil.inflate(vi, R.layout.front_list_recycle_item, parent, false);

        return new ViewHolder(binding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Bind the object with the view
        holder.bind(mFrontList.get(position), mPresenter);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mFrontList.size();
    }
}