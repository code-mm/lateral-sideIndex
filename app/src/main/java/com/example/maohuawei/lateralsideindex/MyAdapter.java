package com.example.maohuawei.lateralsideindex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private Context context;


    private List<Person> list;


    public MyAdapter(Context context, List<Person> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


        String name = list.get(i).getName();
        String word = list.get(i).getPinyin().substring(0, 1);


        if (word.toCharArray()[0] < 'A' || word.toCharArray()[0] > 'Z') {

            viewHolder.textViewWord.setText("#");
            viewHolder.textView.setText(name);

        } else {

            viewHolder.textViewWord.setText(word);
            viewHolder.textView.setText(name);

        }
        if (i == 0) {

            viewHolder.textViewWord.setVisibility(View.VISIBLE);

        } else {
            //得到前一个位置对应的字母，如果当前的字母和上一个相同，隐藏；否则就显示
            String preWord = list.get(i - 1).getPinyin().substring(0, 1);

            // 判断字母是否相同
            if (word.equals(preWord)) {
                // 相同隐藏
                viewHolder.textViewWord.setVisibility(View.GONE);
            } else {
                // 不同显示
                viewHolder.textViewWord.setVisibility(View.VISIBLE);
            }

            // 对#的处理
            if (preWord.toCharArray()[0] < 'A' || preWord.toCharArray()[0] > 'Z') {
                preWord = "#";
                if (word.toCharArray()[0] < 'A' || word.toCharArray()[0] > 'Z') {
                    word = "#";
                    if (word.equals(preWord)) {
                        viewHolder.textViewWord.setVisibility(View.GONE);
                    } else {
                        viewHolder.textViewWord.setVisibility(View.VISIBLE);
                    }
                }
            }

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView textViewWord;
        private TextView textView;


        public ViewHolder(View view) {
            super(view);

            textViewWord = view.findViewById(R.id.textViewWord);
            textView = view.findViewById(R.id.textView);

        }
    }

}
