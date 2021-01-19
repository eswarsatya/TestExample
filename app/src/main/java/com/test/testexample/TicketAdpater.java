package com.test.testexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TicketAdpater extends RecyclerView.Adapter<TicketAdpater.ViewHolder> {
    Context context;
    int resource;
    ArrayList<MOdelcalss_ticket> mOdelcalss_ticketArrayList;
    ArrayList<Modelclass_values> modelclass_valuesArrayList;
    boolean showingFirst = true;
    public  String RUPEES_SIGN = "₹";
    public TicketAdpater(Context context, int resource, ArrayList<MOdelcalss_ticket> mOdelcalss_ticketArrayList,  ArrayList<Modelclass_values> modelclass_valuesArrayList) {

        this.context = context;
        this.resource = resource;
        this.mOdelcalss_ticketArrayList = mOdelcalss_ticketArrayList;
        this.modelclass_valuesArrayList=modelclass_valuesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        ViewHolder rcv = new ViewHolder(layoutView);

        return rcv;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.tv_code.setText(mOdelcalss_ticketArrayList.get(position).getCode());
        holder.tv_code1.setText(mOdelcalss_ticketArrayList.get(position).getRibbon_msg());

        holder.tv_getupto.setText("Get "+mOdelcalss_ticketArrayList.get(position).getMax_percentage()+"%" +" "+"Upto "+RUPEES_SIGN+mOdelcalss_ticketArrayList.get(position).getMax_value() );
        holder.tv_validtill.setText("Valid till "+mOdelcalss_ticketArrayList.get(position).getValid_till());
        holder.tv_depositamt.setText(RUPEES_SIGN+mOdelcalss_ticketArrayList.get(position).getMin_slab());

String val="For every ";
String val2=val+RUPEES_SIGN+mOdelcalss_ticketArrayList.get(position).getRatio_numerator();
        Spannable spannable1 = new SpannableString(val2+" "+"bet ");

        spannable1.setSpan(new ForegroundColorSpan(Color.YELLOW), val.length(), (val + mOdelcalss_ticketArrayList.get(position).getRatio_numerator()).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        SpannableString word1 = new SpannableString(mOdelcalss_ticketArrayList.get(position).getRatio_deniominator());
//
//        word1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, word1.length(), 0);

        String val3=RUPEES_SIGN+mOdelcalss_ticketArrayList.get(position).getRatio_deniominator();

        Spannable spannable2 = new SpannableString(val3+"will be"+"\n"+"released from the  bonus amount");
        spannable2.setSpan(new ForegroundColorSpan(Color.YELLOW), val3.length(), (val3 + mOdelcalss_ticketArrayList.get(position).getRatio_deniominator()).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.tv_forevery.setText(spannable1+""+spannable2,TextView.BufferType.SPANNABLE);

        String text="Bonus expiry ";

                String text2 = text + mOdelcalss_ticketArrayList.get(position).getBonus_expiry()+" Days";

        Spannable spannable = new SpannableString(text2+"\n"+ "from the issue");

        spannable.setSpan(new ForegroundColorSpan(Color.YELLOW), text.length(), (text + mOdelcalss_ticketArrayList.get(position).getBonus_expiry()+" Days").length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.tv_bonus.setText( spannable, TextView.BufferType.SPANNABLE);
        //holder.tv_bonus.setText( sb);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        holder.rcv_items.setLayoutManager(linearLayoutManager);
        holder.rcv_items.hasFixedSize();
        ValueAdpter valueAdpter=new ValueAdpter(context,R.layout.row_items,modelclass_valuesArrayList);
       holder.rcv_items.setAdapter(valueAdpter);

    }

    @Override
    public int getItemCount() {
        return mOdelcalss_ticketArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
      TextView tv_code,tv_code1,tv_getupto,tv_validtill,tv_depositamt,tv_forevery,tv_bonus;
      RecyclerView rcv_items;
        public ViewHolder(View itemView) {
            super(itemView);

            tv_code = itemView.findViewById(R.id.tv_code);
            tv_code1 = itemView.findViewById(R.id.tv_code1);
            tv_getupto = itemView.findViewById(R.id.tv_getupto);
            tv_validtill = itemView.findViewById(R.id.tv_validtill);
            tv_depositamt = itemView.findViewById(R.id.tv_depositamt);
            rcv_items=itemView.findViewById(R.id.rcv_items);
            tv_forevery = itemView.findViewById(R.id.tv_forevery);
            tv_bonus = itemView.findViewById(R.id.tv_bonus);
         
        }
    }

}
