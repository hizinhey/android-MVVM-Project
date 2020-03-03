package com.johnnghia.mvvmproject.viewmodels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.johnnghia.mvvmproject.models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UserViewModel{
    public MutableLiveData<User> user;

    public UserViewModel(){
        getTestUser();
    }

    public void fetchUser(){
        //TODO: get user from repository
    }

    public void getTestUser(){
        try {
            User test = new User("5jlgtu1X03hDsJxRv68V1HOckQs2",
                        "IHGz",
                    "nghiangominh99@gmail.com",
                    "0123456780",
                    "TP HCM",
                    0,
                    0,
                    new SimpleDateFormat("dd/MM/yyyy", Locale.US).parse("16/06/1999"),
                    new Date(),
                    new Date(),
                    null);

            Log.e("User info", test.getName());

            user = new MutableLiveData<User>();

            user.setValue(test);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
