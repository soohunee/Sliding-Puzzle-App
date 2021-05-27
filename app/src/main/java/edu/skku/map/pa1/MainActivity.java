package edu.skku.map.pa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button shuffle = findViewById(R.id.shuffle);
        GridView gridView = findViewById(R.id.gridView);
        Bitmap org = BitmapFactory.decodeResource(getResources(), R.drawable.puzzle);
        Bitmap blank = BitmapFactory.decodeResource(getResources(), R.drawable.blank);
        int org_l = org.getWidth();
        int cropped_l = org_l / 3;
        Bitmap cropped_311 = Bitmap.createBitmap(org, 0, 0, cropped_l, cropped_l);
        Bitmap cropped_312 = Bitmap.createBitmap(org, cropped_l, 0, cropped_l, cropped_l);
        Bitmap cropped_313 = Bitmap.createBitmap(org, 2 * cropped_l, 0, cropped_l, cropped_l);
        Bitmap cropped_321 = Bitmap.createBitmap(org, 0, cropped_l, cropped_l, cropped_l);
        Bitmap cropped_322 = Bitmap.createBitmap(org, cropped_l, cropped_l, cropped_l, cropped_l);
        Bitmap cropped_323 = Bitmap.createBitmap(org, 2 * cropped_l, cropped_l, cropped_l, cropped_l);
        Bitmap cropped_331 = Bitmap.createBitmap(org, 0, 2 * cropped_l, cropped_l, cropped_l);
        Bitmap cropped_332 = Bitmap.createBitmap(org, cropped_l, 2 * cropped_l, cropped_l, cropped_l);

        final Bitmap[] grid3by3 = new Bitmap[]{
                cropped_311, cropped_312, cropped_313, cropped_321, cropped_322, cropped_323,
                cropped_331, cropped_332, blank
        };


        int cropped_4l = org_l / 4;
        Bitmap cropped_411 = Bitmap.createBitmap(org, 0, 0, cropped_4l, cropped_4l);
        Bitmap cropped_412 = Bitmap.createBitmap(org, cropped_4l, 0, cropped_4l, cropped_4l);
        Bitmap cropped_413 = Bitmap.createBitmap(org, 2 * cropped_4l, 0, cropped_4l, cropped_4l);
        Bitmap cropped_414 = Bitmap.createBitmap(org, 3 * cropped_4l, 0, cropped_4l, cropped_4l);
        Bitmap cropped_421 = Bitmap.createBitmap(org, 0, cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_422 = Bitmap.createBitmap(org, cropped_4l, cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_423 = Bitmap.createBitmap(org, 2 * cropped_4l, cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_424 = Bitmap.createBitmap(org, 3 * cropped_4l, cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_431 = Bitmap.createBitmap(org, 0, 2 * cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_432 = Bitmap.createBitmap(org, cropped_4l, 2 * cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_433 = Bitmap.createBitmap(org, 2 * cropped_4l, 2 * cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_434 = Bitmap.createBitmap(org, 3 * cropped_4l, 2 * cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_441 = Bitmap.createBitmap(org, 0, 3 * cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_442 = Bitmap.createBitmap(org, cropped_4l, 3 * cropped_4l, cropped_4l, cropped_4l);
        Bitmap cropped_443 = Bitmap.createBitmap(org, 2 * cropped_4l, 3 * cropped_4l, cropped_4l, cropped_4l);
        Bitmap[] grid4by4 = new Bitmap[]{
                cropped_411, cropped_412, cropped_413, cropped_414, cropped_421, cropped_422,
                cropped_423, cropped_424, cropped_431, cropped_432, cropped_433, cropped_434,
                cropped_441, cropped_442, cropped_443, blank
        };
        Bitmap[] correct_3 = grid3by3.clone();
        Bitmap[] correct_4 = grid4by4.clone();
        GridAdapter gridAdapter_3 = new GridAdapter(this, grid3by3, 0);
        GridAdapter gridAdapter_4 = new GridAdapter(this, grid4by4, 1);
        gridView.setAdapter(gridAdapter_3);
        three.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gridView.getNumColumns() == 4) {
                    gridView.setNumColumns(3);
                    gridView.setAdapter(gridAdapter_3);
                } else {
                    for (int i = 0; i < 9; i++) {
                        Arrays.asList(grid3by3).set(i, correct_3[i]);
                    }
                    gridAdapter_3.notifyDataSetChanged();
                }
            }
        });
        four.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gridView.getNumColumns() == 3) {
                    gridView.setNumColumns(4);
                    gridView.setAdapter(gridAdapter_4);
                } else {
                    for (int i = 0; i < 16; i++) {
                        Arrays.asList(grid4by4).set(i, correct_4[i]);
                    }
                    gridAdapter_4.notifyDataSetChanged();
                }

            }
        });
        shuffle.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gridView.getNumColumns() == 3) {
                    Collections.shuffle(Arrays.asList(grid3by3));
                    gridAdapter_3.notifyDataSetChanged();
                } else {
                    Collections.shuffle(Arrays.asList(grid4by4));
                    gridAdapter_4.notifyDataSetChanged();
                }
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = 0;
                if (gridView.getNumColumns() == 3) { //3by3 puzzle
                    for (int i = 0; i < 9; i++) {
                        if (grid3by3[i] == blank)
                            index = i;
                    }
                    if (position == index - 1 || position == index + 1 || position == index + 3 || position == index - 3) {
                        Collections.swap(Arrays.asList(grid3by3), position, index);
                        gridAdapter_3.notifyDataSetChanged();
                    }
                    if (grid3by3[0] == cropped_311 && grid3by3[1] == cropped_312 && grid3by3[2] == cropped_313
                            && grid3by3[3] == cropped_321 && grid3by3[4] == cropped_322 && grid3by3[5] == cropped_323
                            && grid3by3[6] == cropped_331 && grid3by3[7] == cropped_332 && grid3by3[8] == blank) {
                        Toast.makeText(getApplicationContext(), "FINISH!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    for (int i = 0; i < 16; i++) { //4by4 puzzle
                        if (grid4by4[i] == blank)
                            index = i;
                    }
                    if (position == index - 1 || position == index + 1 || position == index + 4 || position == index - 4) {
                        Collections.swap(Arrays.asList(grid4by4), position, index);
                        gridAdapter_4.notifyDataSetChanged();
                    }
                    if (grid4by4[0] == cropped_411 && grid4by4[1] == cropped_412 && grid4by4[2] == cropped_413 && grid4by4[3] == cropped_414
                            && grid4by4[4] == cropped_421 && grid4by4[5] == cropped_422 && grid4by4[6] == cropped_423 && grid4by4[7] == cropped_424
                            && grid4by4[8] == cropped_431 && grid4by4[9] == cropped_432 && grid4by4[10] == cropped_433 && grid4by4[11] == cropped_434
                            && grid4by4[12] == cropped_441 && grid4by4[13] == cropped_442 && grid4by4[14] == cropped_443 && grid4by4[15] == blank) {
                        Toast.makeText(getApplicationContext(), "FINISH!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}

