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
    ArrayList<String>arrayname;
    ArrayList<String>arrayimg;

    public CustomGrid(Context c, ArrayList<String> arrayname, ArrayList<String> arrayimg) {
        mContext = c;
        this.arrayimg = arrayimg;
        this.arrayname = arrayname;
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayimg.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arrayimg.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
      //  View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {


            //grid = new View(mContext);
           // grid = inflater.inflate(R.layout.custom_grid, null);
            convertView = inflater.inflate(R.layout.custom_grid, null);
            holder = new ViewHolder();
            holder. textview = (TextView) convertView.findViewById(R.id.txtname);
            holder. imageView = (ImageView)convertView.findViewById(R.id.img_c);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        imageLoader.displayImage(arrayimg.get(position), holder.imageView);
        holder.textview.setText(arrayname.get(position));

        return convertView;
    }

    static class ViewHolder {
        TextView textview;
        ImageView imageView;
    }

}
//
//        } else {
//            grid = (View) convertView;
//        }
//
//        return grid;
//    }
//}