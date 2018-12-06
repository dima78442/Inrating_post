package com.dima.inrating_post.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dima.inrating_post.R;
import com.dima.inrating_post.repository.Model.CategoryModel;
import com.dima.inrating_post.repository.Model.Model.Datum;
import com.dima.inrating_post.repository.Model.PostModel.Post;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity implements mvpView{

    private Post post;
    private ArrayList<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
    private ArrayList<Datum> likers = new ArrayList<Datum>();
    private ArrayList<Datum> commentators = new ArrayList<Datum>();
    private ArrayList<Datum> reposters = new ArrayList<Datum>();
    private ArrayList<Datum> mentions = new ArrayList<Datum>();
    private PostRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_);

        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        adapter = new PostRecyclerAdapter(this, categoryModels);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);


    }

    private void createCategories(){
        for (int i = 0; i < 6; i++) {
            categoryModels.add(new CategoryModel());
        }
        categoryModels.get(0).setName("Просмотры");
        categoryModels.get(1).setName("Лайки");
        categoryModels.get(2).setName("Комментаторы");
        categoryModels.get(3).setName("Отметки");
        categoryModels.get(4).setName("Репосты");
        categoryModels.get(5).setName("Закладки");

        categoryModels.get(0).setNumber(post.getViewsCount());
        categoryModels.get(1).setNumber(post.getLikesCount());
        categoryModels.get(2).setNumber(post.getCommentsCount());
        categoryModels.get(3).setNumber(1);
        categoryModels.get(4).setNumber(post.getRepostsCount());
        categoryModels.get(5).setNumber(post.getBookmarksCount());

        categoryModels.get(1).setList(likers);
        categoryModels.get(2).setList(commentators);
        categoryModels.get(3).setList(mentions);
        categoryModels.get(4).setList(reposters);
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void updateLikers(ArrayList<Datum> likers) {

    }

    @Override
    public void updateCommentators(ArrayList<Datum> commentators) {

    }

    @Override
    public void updateReposters(ArrayList<Datum> reposters) {

    }

    @Override
    public void updateMentions(ArrayList<Datum> mentions) {

    }

    @Override
    public void updateUi() {

    }
}
