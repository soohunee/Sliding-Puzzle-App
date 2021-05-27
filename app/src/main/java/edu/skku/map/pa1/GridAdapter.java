package edu.skku.map.pa1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context context;
    Bitmap bitmaps[];
    int mode;
    public GridAdapter(Context ctx, Bitmap arr[], int m){
        context = ctx;
        bitmaps = arr;
        mode = m;
    }

    @Override
    public int getCount() {
        return bitmaps.length;
    }

    @Override
    public Object getItem(int position) {
        return bitmaps[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (mode == 0){
            if (view == null)
            {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.grid_layout, viewGroup, false);
            }
            ImageView imageView = view.findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmaps[i]);
            return view;
        }
        else{
            if (view == null)
            {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.grid_layout_4, viewGroup, false);
            }
            ImageView imageView = view.findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmaps[i]);
            return view;
        }

    }
}