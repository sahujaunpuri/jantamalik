package in.filternet.jantamaalik.IssuesJava;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.filternet.jantamaalik.ItemClickListener;
import in.filternet.jantamaalik.R;


public class IssuesFragmentRecyclerViewAdapter extends RecyclerView.Adapter<IssuesFragmentRecyclerViewAdapter.IssuesViewHolder> {

     private List<String> dataList = new ArrayList<>();
     private ItemClickListener itemClickListener;

    public  class IssuesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mtextView;

        public IssuesViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mtextView = itemView.findViewById(R.id.Issues_recyclerview_textView);
        }


        @Override
        public void onClick(View view) {
            if (itemClickListener!=null){
                itemClickListener.onClick(view,getAdapterPosition());
            }
        }
    }
    public IssuesFragmentRecyclerViewAdapter(List<String> dataArray){
        this.dataList = dataArray;
        }

    @NonNull
    @Override
    public IssuesFragmentRecyclerViewAdapter.IssuesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.issues_fragment_row_item_layout,parent,false);

          IssuesViewHolder issuesViewHolder = new IssuesViewHolder(view);
        return issuesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IssuesViewHolder holder, int position) {
          holder.mtextView.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

   public void onItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
   }


}