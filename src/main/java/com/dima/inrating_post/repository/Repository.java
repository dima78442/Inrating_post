package com.dima.inrating_post.repository;

import android.widget.ImageView;

import com.dima.inrating_post.repository.Model.Model.Model;
import com.dima.inrating_post.repository.Model.PostModel.Post;
import com.dima.inrating_post.repository.picasso_network.PicassoNetwork;
import com.dima.inrating_post.repository.retrofit_network.RetroNetwork;

import retrofit2.Call;

public class Repository {

    private RetroNetwork retroNetwork;

    public Repository(RetroNetwork retroNetwork) {
        this.retroNetwork = retroNetwork;
    }

    public Call<Post> getPost(String slug){
        return retroNetwork.getPost(slug);
    }

    public Call<Model> getLikers(String id){
        return retroNetwork.getLikers(id);
    }

    public Call<Model> getReposters(String id){
        return retroNetwork.getReposters(id);
    }

    public Call<Model> getCommentators(String id){
        return retroNetwork.getCommentators(id);
    }

    public Call<Model> getMentions(String id){
        return retroNetwork.getMentions(id);
    }

    public static void imageDownload(String url,ImageView image){
        PicassoNetwork.imageDownload(url,image);
    }
}
