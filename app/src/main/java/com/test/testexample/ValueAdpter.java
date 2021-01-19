package com.test.testexample;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ValueAdpter extends RecyclerView.Adapter<ValueAdpter.ViewHolder> {
    Context context;
    int resource;
    ArrayList<Modelclass_values> modelclass_valuesArrayList;
    boolean showingFirst = true;
    public  String RUPEES_SIGN = "₹";

    public ValueAdpter(Context context, int resource, ArrayList<Modelclass_values> modelclass_valuesArrayList) {

        this.context = context;
        this.resource = resource;
        this.modelclass_valuesArrayList = modelclass_valuesArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
       ViewHolder rcv = new ViewHolder(layoutView);

        return rcv;
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.tv_purchaseval.setText(">="+modelclass_valuesArrayList.get(position).getMinslab()+" & "+"<"+modelclass_valuesArrayList.get(position).getMaxslab());
        holder.tv_bonusamtval.setText(modelclass_valuesArrayList.get(position).getWageredpercnetslab()+"%"+" ("+"Max. "+RUPEES_SIGN+modelclass_valuesArrayList.get(position).getWageredslabmax()+")");

        holder.tv_instantcashval.setText( modelclass_valuesArrayList.get(position).getSlabotcpercentage()+"%"+" ("+"Max. "+RUPEES_SIGN+modelclass_valuesArrayList.get(position).getSlabotcmax()+")");


    }

    @Override
    public int getItemCount() {
        return modelclass_valuesArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_purchaseval,tv_bonusamtval,tv_instantcashval;
        public ViewHolder(View itemView) {
            super(itemView);

            tv_purchaseval = itemView.findViewById(R.id.tv_purchaseval);
            tv_bonusamtval = itemView.findViewById(R.id.tv_bonusamtval);
            tv_instantcashval = itemView.findViewById(R.id.tv_instantcashval);


        }
    }
}
