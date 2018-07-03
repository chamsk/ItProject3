package ru.udmrem.itproject3;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {


    List<String> list;



    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, final int position) {
        holder.textView.setText(list.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CLICK", String.valueOf(position));
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addList(List<String> list){
        this.list = list;
    }




    class ListHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ListHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvName);
        }

    }

}
