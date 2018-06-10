package com.google.android.gms.samples.vision.barcodereader;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Toolbar;

//import com.google.cloud.firestore.CollectionReference;
//import com.google.cloud.firestore.DocumentSnapshot;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.Query;
//import com.google.cloud.firestore.Query.Direction;
//import com.google.cloud.firestore.QuerySnapshot;
//import com.google.cloud.firestore.WriteResult;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class BookCategoryDisplayActivity extends Activity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_category_display);

        String category = getIntent().getStringExtra("category");
        Toolbar toolbar = (Toolbar) findViewById(R.id.categoryToolbar);
        toolbar.setTitle(category);

        CollectionReference books = db.collection("Books");
//        Query query =
        

    }

}
