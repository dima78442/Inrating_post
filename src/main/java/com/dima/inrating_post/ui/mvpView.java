package com.dima.inrating_post.ui;

import com.dima.inrating_post.repository.Model.Model.Datum;
import com.dima.inrating_post.repository.Model.PostModel.Post;

import java.util.ArrayList;

public interface mvpView {

    void updatePost(Post post);
    void updateLikers(ArrayList<Datum> likers);
    void updateCommentators(ArrayList<Datum> commentators);
    void updateReposters(ArrayList<Datum> reposters);
    void updateMentions(ArrayList<Datum> mentions);
    void updateUi();

}
