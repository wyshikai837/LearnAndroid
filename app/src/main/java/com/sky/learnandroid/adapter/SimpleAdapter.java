package com.sky.learnandroid.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sky.learnandroid.R;

import java.util.List;

/**
 * Created by shikai on 2018/9/6.
 */

public class SimpleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mStrs;
    private SimpleAdapterListener mListener;

    public SimpleAdapter(List<String> strs) {
        mStrs = strs;
    }

    public void setListener(SimpleAdapterListener listener) {
        mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mStrs.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_simple_item, parent, false);
        ViewHolderSimpleItem viewHolderSimpleItem = new ViewHolderSimpleItem(view);
        return viewHolderSimpleItem;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolderSimpleItem viewHolderSimpleItem = (ViewHolderSimpleItem) holder;
        viewHolderSimpleItem.setTitle(mStrs.get(position));

        viewHolderSimpleItem.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClicked(position);
                }
            }
        });
    }

    public interface SimpleAdapterListener {
        void onItemClicked(int position);
    }

    private static class ViewHolderSimpleItem extends RecyclerView.ViewHolder {
        private TextView tvTitle;

        public ViewHolderSimpleItem(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }

        public void setTitle(String title) {
            tvTitle.setText(title);
        }


    }
}
