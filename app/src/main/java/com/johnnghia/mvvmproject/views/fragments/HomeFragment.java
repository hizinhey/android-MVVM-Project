package com.johnnghia.mvvmproject.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.johnnghia.mvvmproject.R;
import com.johnnghia.mvvmproject.adapters.BlogsAdapter;
import com.johnnghia.mvvmproject.databinding.BlogFragmentBinding;
import com.johnnghia.mvvmproject.viewmodels.BlogUserViewModel;

public class HomeFragment extends Fragment {
    private BlogFragmentBinding binding;
    private BlogUserViewModel blogUserViewModel;

    private RecyclerView recyclerView;
    private BlogsAdapter blogsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        blogUserViewModel = new BlogUserViewModel();

        binding = DataBindingUtil.inflate(inflater, R.layout.blog_fragment, container, false);
        binding.setBlogs(blogUserViewModel);

        binding.setLifecycleOwner(this);

        blogsAdapter = new BlogsAdapter(blogUserViewModel.userbBlogs.getValue().list);
        binding.blogFragmentRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.blogFragmentRv.setAdapter(blogsAdapter);
        binding.blogFragmentRv.addItemDecoration(new DividerItemDecoration(binding.blogFragmentRv.getContext(), DividerItemDecoration.VERTICAL));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
