package com.dima.inrating_post.ui;

import android.widget.ImageView;

import com.dima.inrating_post.repository.Model.Model.Datum;
import com.dima.inrating_post.repository.Model.Model.Model;
import com.dima.inrating_post.repository.Model.PostModel.Post;
import com.dima.inrating_post.repository.Repository;
import com.dima.inrating_post.repository.picasso_network.PicassoNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivityPresenter {

    private mvpView mvpView;
    private Repository repository;

    public PostActivityPresenter(Repository repository) {
        this.repository = repository
    }

    public void onAttach(mvpView mvpView) {
        this.mvpView = mvpView;
    }

    public void onDetach() {
        mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }


    public Post getPost(String slug){
        repository.getPost(slug).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (isViewAttached()) {
                    mvpView.updatePost(response.body());
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void getLikers(String id){
        repository.getLikers(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (isViewAttached()) {
                    mvpView.updateLikers(new ArrayList<Datum>(response.body().getData()));
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    public void getReposters(String id){
        repository.getReposters(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (isViewAttached()) {
                    mvpView.updateReposters(new ArrayList<Datum>(response.body().getData()));
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    public void getCommentators(String id){
        repository.getCommentators(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (isViewAttached()) {
                    mvpView.updateCommentators(new ArrayList<Datum>(response.body().getData()));
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }

    public void getMentions(String id){
        repository.getMentions(id).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (isViewAttached()) {
                    mvpView.updateMentions(new ArrayList<Datum>(response.body().getData()));
                    mvpView.updateUi();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });
    }


    public static void imageDownload(String url,ImageView image){
        PicassoNetwork.imageDownload(url,image);
    }
}
