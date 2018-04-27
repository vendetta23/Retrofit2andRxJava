package com.hcmute.tin3p.retrofit2andrxjava.Retrofit;

import com.hcmute.tin3p.retrofit2andrxjava.model.Post;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

//create retrofix apis
//get posts tai day... it bua se lam api co ban bang php thu
public interface IMyAPI {
    @GET("posts")
    Observable<List<Post>> getPost();

    @GET("/posts?")
    Observable<List<Post>> getPostUserComment(@Query("user")String tags);
}
