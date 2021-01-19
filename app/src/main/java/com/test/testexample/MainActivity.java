package com.test.testexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String url ="https://run.mocky.io/v3/4c663239-03af-49b5-bcb3-0b0c41565bd2";
    RecyclerView rcv_ticket;
    private NetworkInfo activeNetworkInfo = null;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    ArrayList<MOdelcalss_ticket>mOdelcalss_ticketArrayList;
    MOdelcalss_ticket mOdelcalss_ticket;
    ArrayList<Modelclass_values>modelclass_valuesArrayList;
    Modelclass_values modelclassValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_ticket=findViewById(R.id.rcv_ticket);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rcv_ticket.setLayoutManager(linearLayoutManager);
        rcv_ticket.hasFixedSize();
        isNetworkAvailable();
        if (activeNetworkInfo==null){
            Toast.makeText(getApplicationContext(),"Check Your internet connection",Toast.LENGTH_SHORT).show();
        }else {

            gettickets();

        }
    }
public void gettickets(){
    mRequestQueue = Volley.newRequestQueue(this);

    //String Request initialized
    mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

         //   Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
Log.i("mfkl",response);
            try {
                JSONArray jsonArray=new JSONArray(response);
                mOdelcalss_ticketArrayList=new ArrayList<>();
modelclass_valuesArrayList=new ArrayList<>();
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    mOdelcalss_ticket=new MOdelcalss_ticket();
modelclassValues=new Modelclass_values();
                    mOdelcalss_ticket.setCode(jsonObject.getString("code"));
                    mOdelcalss_ticket.setRibbon_msg(jsonObject.getString("ribbon_msg"));
                    mOdelcalss_ticket.setValid_till(jsonObject.getString("valid_until"));

                    String slabs=jsonObject.getString("slabs");
                    JSONArray jsonArray1= new JSONArray(slabs);
                    for (int j=0; j<jsonArray1.length();j++){
                        JSONObject jsonObject1=jsonArray1.getJSONObject(j);
                        double x=jsonObject1.getDouble("wagered_max");
                        double y=jsonObject1.getDouble("otc_max");
                        double z=x+y;
                        mOdelcalss_ticket.setMax_value(String.valueOf(z));
                      double a=jsonObject1.getDouble("wagered_percent");
                      double b=jsonObject1.getDouble("otc_percent");
                      double   c=a+b;
                        mOdelcalss_ticket.setMax_percentage(String.valueOf(c));
mOdelcalss_ticket.setMin_slab(String.valueOf(jsonObject1.getDouble("min")));
modelclassValues.setMaxslab(String.valueOf(jsonObject1.getDouble("max")));
                        modelclassValues.setMaxslab(String.valueOf(jsonObject1.getDouble("max")));
                        modelclassValues.setMinslab(String.valueOf(jsonObject1.getDouble("min")));
                        modelclassValues.setSlabotcmax(String.valueOf(y));
                        modelclassValues.setSlabotcpercentage(String.valueOf(b));
                        modelclassValues.setWageredpercnetslab(String.valueOf(a));
                        modelclassValues.setWageredslabmax(String.valueOf(x));


                    }
                    mOdelcalss_ticket.setRatio_numerator(jsonObject.getString("wager_to_release_ratio_numerator"));
                    mOdelcalss_ticket.setRatio_deniominator(jsonObject.getString("wager_to_release_ratio_denominator"));
                    mOdelcalss_ticket.setBonus_expiry(jsonObject.getString("wager_bonus_expiry"));

                    modelclass_valuesArrayList.add(modelclassValues);

mOdelcalss_ticketArrayList.add(mOdelcalss_ticket);


                }


TicketAdpater ticketAdpater=new TicketAdpater(MainActivity.this,R.layout.row_tickets,mOdelcalss_ticketArrayList,modelclass_valuesArrayList);
                rcv_ticket.setAdapter(ticketAdpater);








            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

           // Log.i(getApplicationContext(),"Error :" + error.toString());
        }
    });

    mRequestQueue.add(mStringRequest);

}
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}