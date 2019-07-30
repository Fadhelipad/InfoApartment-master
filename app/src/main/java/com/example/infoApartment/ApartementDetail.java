package com.example.infoApartment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infoApartment.Model.Category;
import com.example.infoApartment.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ApartementDetail extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference category;


    TextView txtName;
    TextView txtdescription;
    TextView txtfasilitas;
    TextView txtspesifikasi;
    ImageView category_image;
    FloatingActionButton btndetail;
    CollapsingToolbarLayout collapsingToolbarLayout;
    String categoryId = "";
    FirebaseRecyclerAdapter<Category, MenuViewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartement_detail);


        //Firebase
        database = FirebaseDatabase.getInstance();
        category = database.getReference("Category");




                //Init View
                btndetail = (FloatingActionButton) findViewById(R.id.btndetail);
                txtName = (TextView) findViewById(R.id.kavling_name);
                txtdescription = (TextView) findViewById(R.id.kavling_description);
                  txtfasilitas = (TextView) findViewById(R.id.kavling_fasilitas);
                 txtspesifikasi = (TextView) findViewById(R.id.kavling_spesifikasi);
                category_image = (ImageView) findViewById(R.id.img_kavling);



                collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);

                if (getIntent() != null)
                    categoryId = getIntent().getStringExtra("CategoryId");
                if (!categoryId.isEmpty()) {

                    getdataCategory(categoryId);
                }

            }

            private void getdataCategory(String categoryId) {
                category.child(categoryId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        final Category category = dataSnapshot.getValue(Category.class);


                        //masukan gambar
                        Picasso.with(getBaseContext()).load(category.getImage())
                                .into(category_image);


                        collapsingToolbarLayout.setTitle(category.getNama());

                        txtName.setText(category.getNama());
                        txtdescription.setText(category.getDescription());
                        txtfasilitas.setText(category.getFasilitas());
                        txtspesifikasi.setText(category.getSpesifikasi());

                        FloatingActionButton fab = findViewById(R.id.btndetail);
                        fab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(category.getLinkWeb()));
                                startActivity(intent);
                            }

                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });
            }

        }
    


