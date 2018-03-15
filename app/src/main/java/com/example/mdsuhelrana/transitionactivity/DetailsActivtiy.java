package com.example.mdsuhelrana.transitionactivity;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivtiy extends AppCompatActivity {
    TextView tvName,tvBody;

    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_activtiy);
        tvName=findViewById(R.id.tvName_Id);
       tvBody=findViewById(R.id.tvBody_Id);
        ViewCompat.setTransitionName(tvName,VIEW_NAME_HEADER_TITLE);
       DataResponse response= (DataResponse) getIntent().getSerializableExtra("data");
       String title= response.getTitle();
      tvName.setText(title);
      tvBody.setText(response.getBody());
    }
}
