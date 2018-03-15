package com.example.mdsuhelrana.transitionactivity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private DataService service;
    private ArrayList<DataResponse> list=new ArrayList<>();;
    private DataAdapter adapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv_Id);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(getString(R.string.baseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service=retrofit.create(DataService.class);
       Call<ArrayList<DataResponse>> response= service.getDatas();
       response.enqueue(new Callback<ArrayList<DataResponse>>() {
           @Override
           public void onResponse(Call<ArrayList<DataResponse>> call, Response<ArrayList<DataResponse>> response) {
               if (response.code()==200){
                  list= response.body();
                  adapter=new DataAdapter(MainActivity.this,list);
                  lv.setAdapter(adapter);
                  lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                      @Override
                      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                          DataResponse dataResponse=list.get(i);
                          Intent intent=new Intent(MainActivity.this,DetailsActivtiy.class);
                          intent.putExtra("data",dataResponse);
                          ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                                  new Pair<View, String>(view.findViewById(R.id.tv_title_Id),DetailsActivtiy.VIEW_NAME_HEADER_TITLE));
                          ActivityCompat.startActivity(MainActivity.this,intent,optionsCompat.toBundle());
                      }
                  });
               }
           }
           @Override
           public void onFailure(Call<ArrayList<DataResponse>> call, Throwable t) {
           }
       });
    }
}
