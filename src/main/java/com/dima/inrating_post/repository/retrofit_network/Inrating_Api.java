package com.dima.inrating_post.repository.retrofit_network;

import com.dima.inrating_post.repository.Model.PostModel.Post;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Inrating_Api {

    @POST("users/posts/get")
    Call<Post> getPost(@Query("slug") String slug);

    @POST("users/posts/likers/all")
    Call<Post> getLikers(@Query("id") String id);

    @POST("users/posts/reposters/all")
    Call<Post> getReposters(@Query("id") String id);

    @POST("users/posts/commentators/all")
    Call<Post> getCommentators(@Query("id") String id);

    @POST("users/posts/mentions/all")
    Call<Post> getMentions(@Query("id") String id);

}
