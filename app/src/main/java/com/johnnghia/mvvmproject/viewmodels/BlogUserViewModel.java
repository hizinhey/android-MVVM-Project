package com.johnnghia.mvvmproject.viewmodels;

import androidx.lifecycle.MutableLiveData;

import com.johnnghia.mvvmproject.models.Blog;
import com.johnnghia.mvvmproject.models.BlogResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogUserViewModel {
    public MutableLiveData<BlogResponse> userbBlogs;

    public BlogUserViewModel(){
        userbBlogs = new MutableLiveData<>();
        //fetchBlog();
        getTestBlog();
    }

    //public void fetchBlog();

    void getTestBlog(){
        Blog blog1, blog2, blog3;
        blog1 = new Blog("blog001",
                "Đây là blog đầu tiên, mong mọi người có một ngày tốt lành.",
                "IGHz",
                0,
                0,
                0,
                new Date(),
                new Date(),
                1,
                "doisong");

        blog2 = new Blog("blog002",
                "Đây là blog thứ 2, mong mọi người có một ngày tốt lành.",
                "IGHz",
                0,
                0,
                0,
                new Date(),
                new Date(),
                1,
                "doisong");

        blog3 = new Blog("blog003",
                "Đây là blog thứ 3, mong mọi người có một ngày tốt lành.",
                "IGHz",
                0,
                0,
                0,
                new Date(),
                new Date(),
                1,
                "doisong");

        List<Blog> list = new ArrayList<>();
        list.add(blog1);
        list.add(blog2);
        list.add(blog3);
        list.add(blog1);
        list.add(blog2);
        list.add(blog3);
        list.add(blog1);
        list.add(blog2);
        list.add(blog3);
        list.add(blog1);
        list.add(blog2);
        list.add(blog3);
        BlogResponse listBlog = new BlogResponse(list);

        userbBlogs.setValue(listBlog);
    }
}
