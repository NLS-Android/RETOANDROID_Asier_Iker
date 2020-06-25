package com.ciber.retoandroid_asier_iker;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("user1")
    Call<Post> getSampleResponse();
}
