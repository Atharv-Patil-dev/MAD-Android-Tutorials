package com.example.firebaseuploaddata.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.firebaseuploaddata.R;
import com.example.firebaseuploaddata.uploadmodel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class sportadapter extends RecyclerView.Adapter<sportadapter.MyViewHolder>{
    Context context;
    List<uploadmodel> sportList;


    public sportadapter(Context context, List<uploadmodel> sportList) {
        this.context = context;
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.new_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        uploadmodel uploadmodel1=sportList.get(position);
        holder.sportname.setText(uploadmodel1.getSportname());
        holder.details.setText(uploadmodel1.getSportdetails());
        holder.startdate.setText(uploadmodel1.getStartdate());
        holder.enddate.setText(uploadmodel1.getEnddate());
        String imageUri=null;
        imageUri=uploadmodel1.getImage();
        Picasso.get().load(imageUri).into(holder.img);

        holder.applyb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent intentapply=new Intent(context, DetailsSports.class);
                intentapply.putExtra("sportId",uploadmodel1.getId());
                intentapply.putExtra("Sportname",uploadmodel1.getSportname());
                intentapply.putExtra("Sportdetails",uploadmodel1.getSportdetails());
                intentapply   Picasso.get().load(imageUri).into(holder.img);.putExtra("startdate",uploadmodel1.getStartdate());
                intentapply.putExtra("enddate",uploadmodel1.getEnddate());
                intentapply.putExtra("img",uploadmodel1.getImage());
                context.startActivity(intentapply);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sportname,details,startdate,enddate,textmarque1;

        Button applyb;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sportname=itemView.findViewById(R.id.textname);
            startdate=itemView.findViewById(R.id.textdate);
            enddate=itemView.findViewById(R.id.textenddate);
            details=itemView.findViewById(R.id.textdoc);
            applyb=itemView.findViewById(R.id.applyb);
            img=itemView.findViewById(R.id.img);;
        }
    }
}
