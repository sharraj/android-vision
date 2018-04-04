package com.google.android.gms.samples.vision.barcodereader;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by saarthaksharma on 4/3/18.
 */

public class BookDatabase {

    final static FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static void pushRecord(BookRecord book) {


    // Create a book DB entry
    Map<String, Object> bookDbEntry = new HashMap<>();
        bookDbEntry.put("isbn", book.isbn);
        bookDbEntry.put("title", book.title);
        bookDbEntry.put("authors", book.authors);
        bookDbEntry.put("categories", book.categories);
        bookDbEntry.put("description", book.descr);

    // Add a new document with a generated ID
    db.collection("Books")
            .add(bookDbEntry)
            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
        @Override
        public void onSuccess (DocumentReference documentReference){
            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
        }
    })
            .addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure (@NonNull Exception e){
            Log.w(TAG, "Error adding document", e);
        }
    });
  }

    public static void readRecord(){
        Log.d(TAG, "executing BookDatabase.readRecord()");
        db.collection("Books")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
