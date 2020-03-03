package com.johnnghia.mvvmproject.models;

import android.util.Log;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.resource.SimpleResource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.sql.Array;
import java.util.Date;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class User {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int following;
    private int followed;
    private Date birthday;
    private Date createAt;
    private Date changeAt;
    private Array friends;

    private FirebaseAuth mAuth;
    private static FirebaseFirestore mDB;

    public User(String id, String name, String email, String phone, String address, int following, int followed, Date birthday, Date createAt, Date changeAt, Array friends) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.following = following;
        this.followed = followed;
        this.birthday = birthday;
        this.createAt = createAt;
        this.changeAt = changeAt;
        this.friends = friends;
        mAuth = FirebaseAuth.getInstance();
        mDB = FirebaseFirestore.getInstance();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollowed() {
        return followed;
    }

    public void setFollowed(int followed) {
        this.followed = followed;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getChangeAt() {
        return changeAt;
    }

    public void setChangeAt(Date changeAd) {
        this.changeAt = changeAd;
    }

    public Array getFriends() {
        return friends;
    }

    public void setFriends(Array friends) {
        this.friends = friends;
    }

    public void fetchData(){
        //Dieu kien thuc te
        //        if (id != mAuth.getUid()){

        if(true){
            DocumentReference docRef = mDB.collection("users").document(this.id);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        } else {
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });


        }
    }


    public void updateData(){
        // Validated before calling this

        //Dieu kien thuc te
        //if(id != null && id == mAuth.getUid()){


        //Dieu kien test (test 1: update thanh cong)
        if(true){
            mDB.collection("users")
                    .document(this.id)
                    .set(this, SetOptions.merge())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "DocumentSnapshot successfully written!");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error writing document", e);
                        }
                    });
        }
    }
}
