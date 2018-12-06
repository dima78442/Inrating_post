package com.dima.inrating_post.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dima.inrating_post.R;
import com.dima.inrating_post.repository.Model.CategoryModel;
import com.dima.inrating_post.repository.Model.PostModel.Post;

import java.util.ArrayList;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.ItemRowHolder> {

    private ArrayList<CategoryModel> dataList;
    private Context mContext;

    public PostRecyclerAdapter(Context context, ArrayList<CategoryModel> dataList) {
        this.dataList = dataList;
        mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.section_card, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getTitle();

        //ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();

        itemRowHolder.title_section.setText(sectionName);

        /*SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

        itemRowHolder.inner_recycler.setHasFixedSize(true);
        itemRowHolder.inner_recycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.inner_recycler.setAdapter(itemListDataAdapter);*/

    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView title_section;
        protected TextView title_num;
        protected TextView title_expand_num;
        protected ImageView section_image;
        protected ImageView expand_image;
        protected RecyclerView inner_recycler;



        public ItemRowHolder(View view) {
            super(view);

            this.title_section = (TextView) view.findViewById(R.id.itemTitle);
            this.title_num = (TextView) view.findViewById(R.id.itemTitle3);
            this.title_expand_num = (TextView) view.findViewById(R.id.itemTitle4);
            this.inner_recycler = (RecyclerView) view.findViewById(R.id.recycler_view_list);
            this.section_image = (ImageView)view.findViewById(R.id.imageView);
            this.expand_image = (ImageView)view.findViewById(R.id.imageView2);

        }

    }

}