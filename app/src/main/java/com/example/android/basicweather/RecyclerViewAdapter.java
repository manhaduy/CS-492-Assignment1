package com.example.android.basicweather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;
    private ArrayList<String> mImagesContent = new ArrayList<>();
    private OnTodoCheckedChangeListener mListener;
    private boolean clicked = false;
    private Toast mToast;

    public interface OnTodoCheckedChangeListener {
        void onTodoCheckedChanged(String todoText, boolean isChecked);
    }


    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images, ArrayList<String> imagesContent,OnTodoCheckedChangeListener listener, Toast Toast) {
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
        mListener = listener;
        mImagesContent = imagesContent;
        mToast = Toast;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, ":onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
   //             String imageContent = mImagesContent.getText().toString();
                Log.d(TAG, ":onClick: clicked on: " + mImageNames.get(position));
                if (mToast != null) {
                    mToast.cancel();
                  //  clicked = false;
                }
                mToast = Toast.makeText(mContext, mImagesContent.get(position), Toast.LENGTH_SHORT);
                mToast.show();
              //  clicked = true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            mToast = null;


        /*    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String todoText = mTodoList.get(getAdapterPosition());
                    mListener.onTodoCheckedChanged(todoText, isChecked);
                }
            });
         */


        }
    }
}
