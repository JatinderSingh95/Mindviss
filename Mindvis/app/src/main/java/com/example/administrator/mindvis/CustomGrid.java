package com.example.administrator.mindvis;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomGrid extends BaseAdapter{
    private Context mContext;
    ImageLoader imageLoader;
    private final ArrayList<String> web;
    private final ArrayList<String> Imageid;

    public CustomGrid(Context c, ArrayList<String> web, ArrayList<String> Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.mindvis)
                    .cacheInMemory(true)
                    .cacheOnDisc(true)
                    .build();
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_grid, null);

            TextView textView = (TextView) grid.findViewById(R.id.txtname);
            ImageView imageView = (ImageView)grid.findViewById(R.id.img_c);
            imageLoader.displayImage(Imageid.get(position), imageView, options);
            textView.setText(web.get(position));
//            Picasso.with(mContext)
//                    .load(String.valueOf(Imageid))
//                    .into(imageView);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}