package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;


public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder>{

    Context context;
    private List<Laptops> laptopsList;

    public LaptopAdapter(Context context, List<Laptops> laptopsList) {
        this.context = context;
        this.laptopsList = laptopsList;
    }

    @NonNull
    @Override
    public LaptopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//

        LayoutInflater layoutInflater = LayoutInflater.from(context);//
        View view = layoutInflater.inflate(R.layout.laptop_item,parent,false);//

        return new LaptopViewHolder(view);
    }

    public void onBindViewHolder (LaptopViewHolder holder, int position){
        Laptops laptops = laptopsList.get(position);

        holder.imageView.setImageResource(laptops.getImage());
        holder.textViewTitle.setText(laptops.getTitle());
        holder.textViewDescrip.setText(laptops.getDescrip());
        holder.textViewRating.setText(String.valueOf(laptops.getRating()));
        holder.textViewPrice.setText(String.valueOf(laptops.getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context,MainActivity2.class);
        intent.putExtra("title",laptops.getTitle());
        intent.putExtra("descri",laptops.getDescrip());
        intent.putExtra("img",laptops.getImage());

        context.startActivity(intent);
    }
});
       /* holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MainActivity2.class);
              intent.putExtra("title1",laptops.getTitle());
                intent.putExtra("descrip",laptops.getDescrip());
                intent.putExtra("rating",String.valueOf(laptops.getRating()));
                intent.putExtra("price",String.valueOf(laptops.getPrice()));
                intent.putExtra("image1",laptops.getImage());

                context.startActivity(intent);
            }
        });*/

    }
    public int getItemCount(){ return laptopsList.size();}

    public class LaptopViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle, textViewDescrip, textViewRating, textViewPrice;

        public LaptopViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.TV_Title);
            textViewDescrip = itemView.findViewById(R.id.TV_Descrip);
            textViewRating = itemView.findViewById(R.id.TV_Rating);
            textViewPrice = itemView.findViewById(R.id.TV_Price);
        }


    }

}



