package com.dima.inrating_post.repository.retrofit_network;

import com.dima.inrating_post.repository.Model.PostModel.Post;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroNetwork {

    private OkHttpClient client;
    private Retrofit retrofit;
    private Inrating_Api inrating_api;
    private String BASE_URL = "https://api.inrating.top/v1/";
    private static String token = "\n" +
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjJmNGU5ZDA1MzU3MDI3MmFlMGZhZTMzM2Y4ZTY4" +
            "ZWVlMWNiMzc0NmM0Mjg5NzI0ZTExNzJjM2Q4ODYzNDNkNDkyY2ZjZjI4Njg0NzQ0MGEwIn0.eyJhdWQiOiIy" +
            "IiwianRpIjoiMmY0ZTlkMDUzNTcwMjcyYWUwZmFlMzMzZjhlNjhlZWUxY2IzNzQ2YzQyODk3MjRlMTE3MmMz" +
            "ZDg4NjM0M2Q0OTJjZmNmMjg2ODQ3NDQwYTAiLCJpYXQiOjE1MzY4MzE4ODcsIm5iZiI6MTUzNjgzMTg4Nywi" +
            "ZXhwIjoxNTY4MzY3ODg3LCJzdWIiOiIzOCIsInNjb3BlcyI6W119.dRitRnoqNFS3xUgtLdLiDjDVVe7ZFNr" +
            "h24Qm2ML9m-V7kZpgQgajArYoS44kMa1dz_MHUhq3pqk8SnAYIsULgfrOvewTUzmH1C92-yL64Uqnv7lqWiz" +
            "ldX2fbJ2IbB8khOCtQ-CCNA_fGY_zEBJXLsOqr4Z00tbZE6fa0PX4Mu0SsuUakLeygXbXnKOmFyZmLJZWoXK" +
            "pbqiSBU239nrcyqJftBon8DL1BAUuFiadap-gpVSXj8h6BX-FsJx5cgPHFiijIalcEgzOq4VCMkwbQE8xbTs" +
            "mmxkZUOnM7oKab5inzl8EV5iUgcExeSbHT6k_phOkA7XUaR6PhVoKrSQTPcfdijhME1IHfPVDPGO0vhd6hKs" +
            "zRrhjEPEpoothBoB8ss0lmuCFURdxFv17q97rfpDn1OfO_Y3wYuRW2lqFAnw7sLd92CHjfONwQKswLDzwE4h" +
            "iQhB8iS_UEbuL_UamNOiCLfjNnVWbVc9BvoReEa8jG4coc0Kv9VNJVWh3D_hGf8dLRZBd1a7zB6-nSpKGf0e" +
            "AzB0_rBXsyBepjudC-5EFDjloJOxy1Mdruoq6mQa_tFcO99JRteUSd0CXHZO-CN4Bp4xND9kstdutjBn2UWT" +
            "5xhNq_QRBmBsBDAwp647dUCyQofutN9GUlu2LxmhL0ojydazdND_d9rHtY9t-ndw";

    public RetroNetwork() {
        clientCreator();
        retrofitCreator();
    }

    private void clientCreator(){
        client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjJmNGU5ZDA1MzU3MDI3MmFlMGZhZTMzM2Y4ZTY4ZWVlMWNiMzc0NmM0Mjg5NzI0ZTExNzJjM2Q4ODYzNDNkNDkyY2ZjZjI4Njg0NzQ0MGEwIn0.eyJhdWQiOiIyIiwianRpIjoiMmY0ZTlkMDUzNTcwMjcyYWUwZmFlMzMzZjhlNjhlZWUxY2IzNzQ2YzQyODk3MjRlMTE3MmMzZDg4NjM0M2Q0OTJjZmNmMjg2ODQ3NDQwYTAiLCJpYXQiOjE1MzY4MzE4ODcsIm5iZiI6MTUzNjgzMTg4NywiZXhwIjoxNTY4MzY3ODg3LCJzdWIiOiIzOCIsInNjb3BlcyI6W119.dRitRnoqNFS3xUgtLdLiDjDVVe7ZFNrh24Qm2ML9m-V7kZpgQgajArYoS44kMa1dz_MHUhq3pqk8SnAYIsULgfrOvewTUzmH1C92-yL64Uqnv7lqWizldX2fbJ2IbB8khOCtQ-CCNA_fGY_zEBJXLsOqr4Z00tbZE6fa0PX4Mu0SsuUakLeygXbXnKOmFyZmLJZWoXKpbqiSBU239nrcyqJftBon8DL1BAUuFiadap-gpVSXj8h6BX-FsJx5cgPHFiijIalcEgzOq4VCMkwbQE8xbTsmmxkZUOnM7oKab5inzl8EV5iUgcExeSbHT6k_phOkA7XUaR6PhVoKrSQTPcfdijhME1IHfPVDPGO0vhd6hKszRrhjEPEpoothBoB8ss0lmuCFURdxFv17q97rfpDn1OfO_Y3wYuRW2lqFAnw7sLd92CHjfONwQKswLDzwE4hiQhB8iS_UEbuL_UamNOiCLfjNnVWbVc9BvoReEa8jG4coc0Kv9VNJVWh3D_hGf8dLRZBd1a7zB6-nSpKGf0eAzB0_rBXsyBepjudC-5EFDjloJOxy1Mdruoq6mQa_tFcO99JRteUSd0CXHZO-CN4Bp4xND9kstdutjBn2UWT5xhNq_QRBmBsBDAwp647dUCyQofutN9GUlu2LxmhL0ojydazdND_d9rHtY9t-ndw")
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
    }

    private void retrofitCreator(){
        retrofit = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        inrating_api = retrofit.create(Inrating_Api.class);
    }

    public Call<Post> getPost(String slug){
        return inrating_api.getPost(slug);
    }

    public Call<Post> getLikers(String id){
        return inrating_api.getLikers(id);
    }

    public Call<Post> getReposters(String id){
        return inrating_api.getReposters(id);
    }

    public Call<Post> getCommentators(String id){
        return inrating_api.getCommentators(id);
    }

    public Call<Post> getMentions(String id){
        return inrating_api.getMentions(id);
    }

}
