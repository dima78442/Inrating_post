package com.dima.inrating_post.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dima.inrating_post.R;
import com.dima.inrating_post.repository.Model.CategoryModel;
import com.dima.inrating_post.repository.Model.Model.Datum;
import com.dima.inrating_post.repository.Model.PostModel.Post;
import com.dima.inrating_post.repository.Repository;
import com.dima.inrating_post.repository.retrofit_network.RetroNetwork;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostActivity extends AppCompatActivity implements mvpView{

    private ArrayList<CategoryModel> categoryModels = new ArrayList<CategoryModel>();

    private ArrayList<Datum> likers = new ArrayList<Datum>();
    private ArrayList<Datum> commentators = new ArrayList<Datum>();
    private ArrayList<Datum> reposters = new ArrayList<Datum>();
    private ArrayList<Datum> mentions = new ArrayList<Datum>();

    private PostRecyclerAdapter adapter;
    private PostActivityPresenter presenter;

    @BindView(R.id.my_recycler_view)
    RecyclerView my_recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_);
        ButterKnife.bind(this);

        createCategories();
        initPresenter();


        my_recycler_view.setHasFixedSize(true);
        adapter = new PostRecyclerAdapter(this, categoryModels,likers,commentators,mentions,reposters);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);


    }

    void initPresenter(){
        presenter = new PostActivityPresenter(new Repository(new RetroNetwork()));
        presenter.onAttach(this);
        presenter.getPost(RetroNetwork.slug);
        presenter.getLikers(RetroNetwork.id);
        presenter.getCommentators(RetroNetwork.id);
        presenter.getReposters(RetroNetwork.id);
        presenter.getMentions(RetroNetwork.id);
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

        categoryModels.get(1).setList(likers);
        categoryModels.get(2).setList(commentators);
        categoryModels.get(3).setList(mentions);
        categoryModels.get(4).setList(reposters);
    }

    @Override
    public void updatePost(Post post) {
        categoryModels.get(0).setNumber(post.getViewsCount());
        categoryModels.get(1).setNumber(post.getLikesCount());
        categoryModels.get(2).setNumber(post.getCommentsCount());
        categoryModels.get(3).setNumber(0);
        categoryModels.get(4).setNumber(post.getRepostsCount());
        categoryModels.get(5).setNumber(post.getBookmarksCount());
    }

    @Override
    public void updateLikers(ArrayList<Datum> likers) {
        this.likers.addAll(likers);
    }

    @Override
    public void updateCommentators(ArrayList<Datum> commentators) {
        this.commentators.addAll(commentators);
    }

    @Override
    public void updateReposters(ArrayList<Datum> reposters) {
        this.reposters.addAll(reposters);
    }

    @Override
    public void updateMentions(ArrayList<Datum> mentions) {
        this.mentions.addAll(mentions);
    }

    @Override
    public void updateUi() {
        adapter.notifyDataSetChanged();
        adapter.itemListDataAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}
