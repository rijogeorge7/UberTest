package com.rijo.ubertest.ui.startUpScreen.adpters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rijo.ubertest.R;
import com.rijo.ubertest.dataRepository.domain.Images;

/**
 * Created by rijogeorge on 10/6/17.
 */

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.ViewHolder>{

    private Images images;
    private Context context;

    public ImageRecyclerAdapter(Images images,Context context) {
        this.images = images;
        this.context=context;
    }

    @Override
    public ImageRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_raw, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageRecyclerAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load("http://farm"+images.getPhotos().getPhoto().get(position).getFarm() +".static.flickr.com/"+images.getPhotos().getPhoto().get(position).getServer()
                        +"/"+images.getPhotos().getPhoto().get(position).getId()+"_"+images.getPhotos().getPhoto().get(position).getSecret()+".jpg")
                .into(holder.image1);
    }

    @Override
    public int getItemCount() {
        return images.getPhotos().getPhoto().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image1;
        public ViewHolder(View itemView) {
            super(itemView);
            image1=(ImageView)itemView.findViewById(R.id.imageView1);
        }
    }
}
