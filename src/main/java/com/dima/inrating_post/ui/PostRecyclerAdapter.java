package com.dima.inrating_post.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dima.inrating_post.R;
import com.dima.inrating_post.repository.Model.CategoryModel;
import com.dima.inrating_post.repository.Model.Model.Datum;

import java.util.ArrayList;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.ItemRowHolder> {

    private ArrayList<CategoryModel> dataList;
    private Context mContext;
    public SectionListDataAdapter itemListDataAdapter;
    private ArrayList<Datum> likers;
    private ArrayList<Datum> commentators;
    private ArrayList<Datum> mentions;
    private ArrayList<Datum> reposters;

    public PostRecyclerAdapter(Context context, ArrayList<CategoryModel> dataList,
                               ArrayList<Datum> likers,ArrayList<Datum> commentators,
                               ArrayList<Datum> mentions, ArrayList<Datum> reposters) {
        this.dataList = dataList;
        mContext = context;
        this.likers = likers;
        this.commentators = commentators;
        this.mentions = mentions;
        this.reposters = reposters;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.section_card, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getName();
        final int number = dataList.get(i).getNumber();
        int expand = number - 5  > 0 ? number - 5 : 0;

        itemRowHolder.title_section.setText(sectionName + " " + String.valueOf(number));
        itemRowHolder.title_expand_num.setText(String.valueOf(expand));

        switcher(i,itemRowHolder);

        itemRowHolder.inner_recycler.setHasFixedSize(true);
        itemRowHolder.inner_recycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.inner_recycler.setAdapter(itemListDataAdapter);

    }

    private void switcher(int i,ItemRowHolder itemRowHolder) {
        switch (i){
            case 0:
                itemListDataAdapter = new SectionListDataAdapter(mContext,null);
                itemRowHolder.section_image.setBackground(mContext.getDrawable(R.drawable.baseline_visibility_black_18dp));
                break;
            case 1:
                itemListDataAdapter = new SectionListDataAdapter(mContext,likers);
                itemRowHolder.section_image.setBackground(mContext.getDrawable(R.drawable.baseline_thumb_up_black_18dp));
                break;
            case 2:
                itemListDataAdapter = new SectionListDataAdapter(mContext,commentators);
                itemRowHolder.section_image.setBackground(mContext.getDrawable(R.drawable.baseline_chat_bubble_outline_black_18dp));
                break;
            case 3:
                itemListDataAdapter = new SectionListDataAdapter(mContext,mentions);
                itemRowHolder.section_image.setBackground(mContext.getDrawable(R.drawable.baseline_person_outline_black_18dp));
                break;
            case 4:
                itemListDataAdapter = new SectionListDataAdapter(mContext,reposters);
                itemRowHolder.section_image.setBackground(mContext.getDrawable(R.drawable.baseline_share_black_18dp));
                break;
            case 5:
                itemListDataAdapter = new SectionListDataAdapter(mContext,null);
                itemRowHolder.section_image.setBackground(mContext.getDrawable(R.drawable.baseline_collections_bookmark_black_18dp));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView title_section;
        protected TextView title_expand_num;
        protected ImageView section_image;
        protected ImageView expand_image;
        protected RecyclerView inner_recycler;



        public ItemRowHolder(View view) {
            super(view);

            this.title_section = (TextView) view.findViewById(R.id.itemTitle);
            this.title_expand_num = (TextView) view.findViewById(R.id.itemTitle4);
            this.inner_recycler = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.section_image = (ImageView)view.findViewById(R.id.imageView);
            this.expand_image = (ImageView)view.findViewById(R.id.imageView2);

        }

    }

}