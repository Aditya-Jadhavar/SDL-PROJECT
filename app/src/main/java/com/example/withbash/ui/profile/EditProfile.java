package com.example.withbash.ui.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.withbash.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class EditProfile extends AppCompatActivity {
    EditText profileFullName,profileEmail,profilePhone;
    ImageButton profileImageBtn;
    ImageView profileImage;
    Button saveBtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    StorageReference storageReference;
    private Uri filePath,ImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        storageReference = FirebaseStorage.getInstance().getReference();


        saveBtn = findViewById(R.id.savebtn);
        profileFullName = findViewById(R.id.editprfname);
        profileEmail = findViewById(R.id.editprfemail);
        profilePhone = findViewById(R.id.editprfphone);
        profileImageBtn = findViewById(R.id.editimageButton);
        profileImage = findViewById(R.id.editprfimg);


        Intent data = getIntent();
        String fullName = data.getStringExtra("fullName");
        String email = data.getStringExtra("email");
        String phone = data.getStringExtra("phone");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profileFullName.getText().toString().isEmpty() || profileEmail.getText().toString().isEmpty() || profilePhone.getText().toString().isEmpty()) {
                    Toast.makeText(EditProfile.this, "One or Many fields are Empty", Toast.LENGTH_SHORT).show();
                    return;
                }


                final String email = profileEmail.getText().toString();
                user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        DocumentReference docRef = fStore.collection("users").document(user.getUid());
                        Map<String, Object> edited = new HashMap<>();
                        edited.put("email", profileEmail.getText().toString());
                        edited.put("fName", profileFullName.getText().toString());
                        edited.put("phone", profilePhone.getText().toString());
                        docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(EditProfile.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Profile.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(EditProfile.this, "Failed to update" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditProfile.this, "Failed" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


        profileEmail.setText(email);
        profileFullName.setText(fullName);
        profilePhone.setText(phone);










        profileImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

//        saveBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                uploadImageToFirebase(ImageUri);
//                uploadImage();
//            }
//        });


    }

    private void chooseImage() {
//        Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(openGallery, 1);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Image"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Aditya"," "+requestCode+" "+requestCode+" "+data.getData());
        if (requestCode == 1 && requestCode == RESULT_OK  && data!= null){
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                profileImage.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        if (requestCode == 1){
//            if (resultCode == RESULT_OK){
//                ImageUri = data.getData();
//                Log.d("Aditya","Result Code is"+resultCode+ImageUri);
//
//                profileImage.setImageURI(ImageUri);
//                uploadImageToFirebase(imageUri);
//            }
//        }
    }


    private void uploadImageToFirebase(Uri imageUri){
        Log.d("Aditya","Result Code is"+ImageUri);

        StorageReference fileRef = storageReference.child("profile.jpg");
        Log.d("Aditya","Result Code is"+imageUri);


        fileRef.putFile(imageUri).addOnSuccessListener(taskSnapshot -> {
            Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();
            fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.get().load(uri).into(profileImage);
                }
            });
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EditProfile.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Aditya","Result Code is"+e.getMessage());

            }
        });

        Log.d("Aditya","Failed at last");

    }


        private void uploadImage() {

        if (filePath != null){

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            StorageReference reference = storageReference.child("users/"+user.getUid()+"/profile");
            Log.d("Aditya","Result Code is"+filePath);

            reference.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    Toast.makeText(EditProfile.this, "Image Uploaded", Toast.LENGTH_SHORT).show();

                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                    double progress = (100.0*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                    progressDialog.setMessage("Uploaded"+(int)progress+"%");
                }
            });

        }

    }



}