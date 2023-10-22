package com.karatas.recyclerviewappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.karatas.recyclerviewappjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    //static Landmark selectedLandmark;
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //Data

        landmarkArrayList = new ArrayList<>();

        Landmark ankara = new Landmark("Ankara","TURKIYE",R.drawable.ankara);
        Landmark izmir = new Landmark("İzmir","TURKIYE",R.drawable.izmir);
        Landmark istanbul = new Landmark("İstanbul","TURKIYE",R.drawable.istanbul);
        Landmark osmancik = new Landmark("Osmancık","TURKIYE",R.drawable.osmancik);

        landmarkArrayList.add(ankara);
        landmarkArrayList.add(izmir);
        landmarkArrayList.add(istanbul);
        landmarkArrayList.add(osmancik);

        //RecyclerView

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);



        /*
        //Not Efficient
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colesseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colesseo);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

         */


        /*
        //ListView

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark-> landmark.name).collect(Collectors.toList()));

        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //System.out.println(landmarkNames.get(i));
                //System.out.println(countryNames.get(i));

                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(i));
                startActivity(intent);

            }
        });

         */

    }
}