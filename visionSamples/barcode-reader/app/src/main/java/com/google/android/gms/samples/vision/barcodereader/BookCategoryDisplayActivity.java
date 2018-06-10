package com.google.android.gms.samples.vision.barcodereader;

import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

//import com.google.cloud.firestore.CollectionReference;
//import com.google.cloud.firestore.DocumentSnapshot;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.Query;
//import com.google.cloud.firestore.Query.Direction;
//import com.google.cloud.firestore.QuerySnapshot;
//import com.google.cloud.firestore.WriteResult;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class BookCategoryDisplayActivity extends Activity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_category_display);

        String category = getIntent().getStringExtra("category");
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.categoryToolbar);
        toolbar.setTitle(category);

        db.collection("Categories").document(category).collection("Books").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                    List<DocumentSnapshot> documents = task.getResult().getDocuments();
                    String [] documentArray = new String [documents.size()];
                    for(int i = 0; i < documents.size(); i++){
                        documentArray[i] = documents.get(i).getData().get("title").toString();
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, documentArray);
                    ListView listView = (ListView) findViewById(R.id.bookCategoryList);
                    listView.setAdapter(adapter);
                }
            }
        });



    }

}
