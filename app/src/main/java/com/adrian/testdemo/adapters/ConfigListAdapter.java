package com.adrian.testdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adrian.testdemo.R;
import com.adrian.testdemo.models.ConfigInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranqing on 2017/5/8.
 */

public class ConfigListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, View.OnLongClickListener {

    private Context mContext;
    private List<ConfigInfo> datas;//数据

    //自定义监听事件
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view);

        void onItemLongClick(View view);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public ConfigListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public ConfigListAdapter(Context mContext, List<ConfigInfo> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_config, parent, false);
        ConfigViewHolder holder = new ConfigViewHolder(view);

        view.setOnClickListener(this);
        view.setOnLongClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ConfigInfo info = datas.get(position);
        Log.e("TAG", "size:" + datas.size() + " pos:" + position + " ConfigInfo:" + info.toString());
        ((ConfigViewHolder) holder).mNameTV.setText(info.name);
        ((ConfigViewHolder) holder).mDetailTV.setText(info.detail);
        if (!TextUtils.isEmpty(info.tips)) {
            ((ConfigViewHolder) holder).mTipsTV.setText("备注:" + info.tips);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    public void addItem(ConfigInfo item) {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        datas.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(int pos) {
        if (datas != null && datas.size() > 0) {
            datas.remove(pos);
            notifyDataSetChanged();
        }
    }

    public void addAllConfigs(List<ConfigInfo> list) {
        datas = list;
        notifyDataSetChanged();
    }

    class ConfigViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameTV;
        private TextView mDetailTV;
        private TextView mTipsTV;

        public ConfigViewHolder(View itemView) {
            super(itemView);
            mNameTV = (TextView) itemView.findViewById(R.id.tv_name);
            mDetailTV = (TextView) itemView.findViewById(R.id.tv_detail);
            mTipsTV = (TextView) itemView.findViewById(R.id.tv_tips);
        }
    }
}
