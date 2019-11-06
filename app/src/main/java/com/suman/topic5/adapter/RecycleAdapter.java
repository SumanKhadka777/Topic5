package com.suman.topic5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.suman.topic5.R;
import com.suman.topic5.model.Recycle;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder>{
    Context mcontext;
    List<Recycle> recycleList= new ArrayList<>();

    public RecycleAdapter(Context mcontext, List<Recycle> recycleList) {
        this.mcontext = mcontext;
        this.recycleList = recycleList;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_data,parent,false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        final Recycle rcv = recycleList.get(position);
        holder.cv.setImageResource(rcv.getImage());
        holder.name.setText(rcv.getName());
        holder.age.setText(rcv.getAge());
        holder.gender.setText(rcv.getGender());
    }

    @Override
    public int getItemCount() {
       return recycleList.size();
    }


    public class RecycleViewHolder extends RecyclerView.ViewHolder{

        CircleImageView cv;
        TextView name , age , gender;


        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cimage);
            name = itemView.findViewById(R.id.txtNamec);
            age = itemView.findViewById(R.id.txtAgec);
            gender = itemView.findViewById(R.id.txtGenderc);
        }
    }
}

