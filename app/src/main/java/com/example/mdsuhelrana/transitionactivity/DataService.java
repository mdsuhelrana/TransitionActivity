package com.example.mdsuhelrana.transitionactivity;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Md Suhel Rana on 3/14/2018.
 */

public interface DataService {
    @GET("posts")
    Call<ArrayList<DataResponse>> getDatas();
}


