package com.sky.learnandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sky.learnandroid.lifecycler.LifeCyclerActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final static List<String> learnListStrs = Arrays.asList(
            "LifeCycler");

    private RecyclerView mRvLearnList;
    private LearnListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvLearnList = (RecyclerView) findViewById(R.id.rv_learn_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvLearnList.setLayoutManager(linearLayoutManager);
        mAdapter = new LearnListAdapter(learnListStrs);
        mAdapter.setListener(new LearnListAdapter.LearnListAdapterListener() {
            @Override
            public void onItemClicked(int position) {
                switch (position) {
                    case 0:
                        LifeCyclerActivity.startLifeCyclerActivity(MainActivity.this);
                        break;
                }
            }
        });
        mRvLearnList.setAdapter(mAdapter);
    }

    private static class LearnListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<String> mLearnListStrs;
        private LearnListAdapterListener mListener;

        public LearnListAdapter(List<String> learnListStrs) {
            mLearnListStrs = learnListStrs;
        }

        public void setListener(LearnListAdapterListener listener) {
            mListener = listener;
        }

        @Override
        public int getItemCount() {
            return mLearnListStrs.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_learn_item, parent, false);
            ViewHolderLearnItem viewHolderLearnItem = new ViewHolderLearnItem(view);
            return viewHolderLearnItem;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ViewHolderLearnItem viewHolderLearnItem = (ViewHolderLearnItem) holder;
            viewHolderLearnItem.setTitle(mLearnListStrs.get(position));

            viewHolderLearnItem.tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        mListener.onItemClicked(position);
                    }
                }
            });
        }

        interface LearnListAdapterListener {
            void onItemClicked(int position);
        }
    }

    private static class ViewHolderLearnItem extends RecyclerView.ViewHolder {
        private TextView tvTitle;

        public ViewHolderLearnItem(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }

        public void setTitle(String title) {
            tvTitle.setText(title);
        }


    }
}
