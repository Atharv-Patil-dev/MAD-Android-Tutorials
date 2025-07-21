package com.example.sqlitedatabase;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    ArrayList<String> arrayListID,arrayListNAME,arrayListPHONE;
    Context context;
    private static LayoutInflater inflater = null;


    public CustomAdapter(Activity mainActivity, ArrayList<String> arrayListID, ArrayList<String> arrayListNAME, ArrayList<String> arrayListPHONE)
    {
        this.arrayListID = arrayListID;
        this.arrayListNAME = arrayListNAME;
        this.arrayListPHONE = arrayListPHONE;
        this.context = mainActivity;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayListNAME.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class Holder
    {
        TextView tvId,tvName,tvPhone;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        View view1 = inflater.inflate(R.layout.list_item,null);

        holder.tvId = view1.findViewById(R.id.textViewID);
        holder.tvName = view1.findViewById(R.id.textViewNAME);
        holder.tvPhone = view1.findViewById(R.id.textViewPHONE);

        holder.tvId.setText(arrayListID.get(i));
        holder.tvName.setText(arrayListNAME.get(i));
        holder.tvPhone.setText(arrayListPHONE.get(i));

        return view1;
    }
}
