package com.hcmute.tin3p.retrofit2andrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.hcmute.tin3p.retrofit2andrxjava.Adapter.PostAdapter;
import com.hcmute.tin3p.retrofit2andrxjava.Retrofit.IMyAPI;
import com.hcmute.tin3p.retrofit2andrxjava.Retrofit.RetrofitClient;
import com.hcmute.tin3p.retrofit2andrxjava.model.Post;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    IMyAPI myAPI;
    RecyclerView recyclerView_post;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init API
        Retrofit retrofit= RetrofitClient.getClient2("https://jsonplaceholder.typicode.com/");
        myAPI=retrofit.create(IMyAPI.class);

        //view
        recyclerView_post=findViewById(R.id.id_recycleview_post);
        recyclerView_post.setHasFixedSize(true);
        recyclerView_post.setLayoutManager(new LinearLayoutManager(this));
        fetchData();
    }

    private void fetchData() {
        //ImYAPI goi tai day
        compositeDisposable.add(myAPI.getPostUserComment("1")
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Post>>() {
            @Override
            public void accept(List<Post> posts) throws Exception {
                displayData(posts);
            }
        }));
    }

    private void displayData(List<Post> posts) {
        PostAdapter adapter=new PostAdapter(this,posts);
        recyclerView_post.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
