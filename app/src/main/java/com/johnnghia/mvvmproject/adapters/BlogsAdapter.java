package com.johnnghia.mvvmproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.johnnghia.mvvmproject.R;
import com.johnnghia.mvvmproject.databinding.ItemListBlogsBinding;
import com.johnnghia.mvvmproject.models.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogsAdapter extends RecyclerView.Adapter<BlogsAdapter.MyViewHolder> {
    private List<Blog> blogs;

    public BlogsAdapter(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setBinding(blogs.get(position), position);
    }

    @NonNull
    @Override
    public BlogsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBlogsBinding itemListBlogsBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_list_blogs, parent, false);

        return new MyViewHolder(itemListBlogsBinding);
    }


    @Override
    public int getItemCount() {
        return blogs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MutableLiveData<String> nameUser = new MutableLiveData<>();
        public MutableLiveData<String> detailBlog = new MutableLiveData<>();
        public MutableLiveData<String> date = new MutableLiveData<>();
        public MutableLiveData<String> like = new MutableLiveData<>();
        public MutableLiveData<String> dislike = new MutableLiveData<>();
        public MutableLiveData<String> favorite = new MutableLiveData<>();
        public MutableLiveData<String> viewer = new MutableLiveData<>();

        private ItemListBlogsBinding itemListBlogsBinding;

        public MyViewHolder(ItemListBlogsBinding itemListBlogsBinding) {
            super(itemListBlogsBinding.getRoot());
            this.itemListBlogsBinding = itemListBlogsBinding;
        }

        public void setBinding(Blog blog, int position) {
            if (itemListBlogsBinding.getViewHolder() == null) {
                itemListBlogsBinding.setViewHolder(this);
            }
            nameUser.setValue(blog.getIdAuthor());
            detailBlog.setValue(blog.getDetail());
            date.setValue(blog.getCreateAt().toString());
            like.setValue(Integer.toString(blog.getLike()));
            dislike.setValue(Integer.toString(blog.getDislike()));
            favorite.setValue(Integer.toString(blog.getFavorite()));
            viewer.setValue(Integer.toString(blog.getView()));
        }

    }
}
