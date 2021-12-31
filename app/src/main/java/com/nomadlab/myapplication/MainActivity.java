package com.nomadlab.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.nomadlab.myapplication.repository.RetrofitService;
import com.nomadlab.myapplication.repository.models.Post;
import com.nomadlab.myapplication.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrofit 객체 초기화
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);

//        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
//                Log.d("TAG", response.isSuccessful() + "  <-------------");
//                if (response.isSuccessful()) {
//
//                    Todo todo = response.body().get(0);
//                    Log.d("TAG", "결과값 : " + todo.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
//                Log.d("TAG", "실패");
//            }
//        });


//        service.getTodo(11).enqueue(new Callback<Todo>() {
//            @Override
//            public void onResponse(Call<Todo> call, Response<Todo> response) {
//                Log.d("TAG", " response body : " + response.body().toString());
//                Log.d("TAG", " response code : " + response.code());
//                Log.d("TAG", " response header : " + response.headers());
//                // 인증정보가 조금 틀렸을 경우
//                Log.d("TAG", " response errorBody : " + response.errorBody());
//
//            }
//
//            @Override
//            public void onFailure(Call<Todo> call, Throwable t) {
//
//            }
//        });

        createPost();
    }

    private void createPost() {
        Call<Post> call = service.createPost(30
                , "formUrlEncoded 적용한 제목 필드 부분"
                , "formUrlEncoded 적용한 내용 필드 부분");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", "status code : " + response.code());
                    Post postResponse = response.body();
                    Log.d("TAG", "" + postResponse.toString());
                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

}