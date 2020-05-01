package com.example.myapplication10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class Feedback extends AppCompatActivity {

    private static final String TAG = "d";
    private Button mbtnSbm;
    private EditText text;

    public Feedback() throws FileNotFoundException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        mbtnSbm = findViewById(R.id.sbm);
        text = findViewById(R.id.text1);
        final String s = text.getText().toString();
        mbtnSbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FirebaseStorage storage = FirebaseStorage.getInstance();
//                StorageReference storageRef = storage.getReference();
//                StorageReference fbRef = storageRef.child("Feedback");
//                try {
//                    InputStream stream = new FileInputStream(s);
//                    fbRef.putStream(stream);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> feedback = new HashMap<>();
                feedback.put("feedback", s);
                db.collection("Feedback").add(feedback).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
                Toast.makeText(Feedback.this, "Upload feedback successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}