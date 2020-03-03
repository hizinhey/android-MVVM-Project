package com.johnnghia.mvvmproject.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.johnnghia.mvvmproject.R;
import com.johnnghia.mvvmproject.databinding.BlogMainBinding;
import com.johnnghia.mvvmproject.viewmodels.UserViewModel;
import com.johnnghia.mvvmproject.databinding.HeaderNavigationLeftBinding;
import com.johnnghia.mvvmproject.views.fragments.HomeFragment;
import com.johnnghia.mvvmproject.views.fragments.MessageFragment;
import com.johnnghia.mvvmproject.views.fragments.NotificationFragment;
import com.johnnghia.mvvmproject.views.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private UserViewModel userViewModel;
    private HeaderNavigationLeftBinding navBinding;
    private BlogMainBinding binding;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.blog_main);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bindingToolBar();
        initDataBinding();
        loadFragment(new HomeFragment());
    }

    public void initDataBinding() {
        navBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.header_navigation_left, binding.navigation, false);

        View viewHeader = binding.navigation.getHeaderView(0);
        navBinding = HeaderNavigationLeftBinding.bind(viewHeader);

        userViewModel = new UserViewModel();
        navBinding.setUser(userViewModel);
        binding.setUser(userViewModel);
    }

    public void bindingToolBar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.outline_menu_24);
    }


    // Cấu trúc này không đảm nhiệm MVVM
    //TODO: Điều chỉnh thành cấu trúc MVVM
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_home:
                    toolbar.setTitle("Home");
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_search:
                    toolbar.setTitle("Search");
                    fragment = new SearchFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_notification:
                    toolbar.setTitle("Notification");
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.action_mess:
                    toolbar.setTitle("Message");
                    fragment = new MessageFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_fragment, fragment);
        ft.commit();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
