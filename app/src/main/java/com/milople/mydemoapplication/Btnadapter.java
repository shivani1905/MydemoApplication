package com.milople.mydemoapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Btnadapter extends RecyclerView.Adapter {
    Context ctx;
    List<Btnmodel> btnmodelList;
    Boolean flag=false;
    List<Integer>seat=new ArrayList<>();
    Intent intent;int count;
    public Btnadapter(Context ctx, List<Btnmodel> btnmodelList) {
        this.ctx = ctx;
        this.btnmodelList = btnmodelList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Myhomeholder(LayoutInflater.from(ctx).inflate(R.layout.row_button, null, false));
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Myhomeholder myhomeholder = (Myhomeholder) holder;
        Btnmodel btnmodel = btnmodelList.get(position);
        myhomeholder.btnclr.setText(btnmodel.getTnumber()+"");
        myhomeholder.btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    for(int i=0;i<1;i++)
                    {
                       /* if(seat.size()==0) {
                            seat.add(btnmodel.getTnumber());
                            intent = new Intent("message");
                            intent.putExtra("pos", btnmodel.getTnumber());
                            Log.e("seat ",seat.get(i)+"");
                            LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);
                        }*/
                    /*else if(seat.get(i).toString().equals(btnmodel.getTnumber()))
                     {}*/
                    /* else
                     {*/
                         seat.add(btnmodel.getTnumber());
                         intent=new Intent("message");
                         intent.putExtra("pos",btnmodel.getTnumber());
                         LocalBroadcastManager.getInstance(ctx).sendBroadcast(intent);
                     /*}*/
                    }


            }
        });
    }

    @Override
    public int getItemCount() {
        return btnmodelList.size();
    }
    private class Myhomeholder extends RecyclerView.ViewHolder {
        Button btnclr;

        public Myhomeholder(@NonNull View itemView) {
            super(itemView);
            btnclr = itemView.findViewById(R.id.btnclr);


        }
    }

}
