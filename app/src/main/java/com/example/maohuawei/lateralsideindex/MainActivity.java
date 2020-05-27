package com.example.maohuawei.lateralsideindex;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private IndexView indexView;

    private RecyclerView recyclerView;

    private List<Person> list;

    private TextView textView;

    private LinearLayoutManager linearLayoutManager;


    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        initData();


        MyAdapter adapter = new MyAdapter(this, list);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);


        indexView.setOnIndexChangeListener(new IndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String word) {

                updateWord(word);
                updateListView(word);

            }
        });


    }

    private void updateWord(String word) {


        // 设置显示
        textView.setVisibility(View.VISIBLE);
        // 设置文本
        textView.setText(word);
        // 删除消息
        handler.removeCallbacksAndMessages(null);
        // 更新
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //隐藏
                textView.setVisibility(View.GONE);
            }
            //三秒钟后隐藏
        }, 500);

    }


    /**
     * 设置RecyclerView 到指定位置
     *
     * @param manager
     * @param n
     */
    public static void MoveToPosition(LinearLayoutManager manager, int n) {
        manager.scrollToPositionWithOffset(n, 0);
        manager.setStackFromEnd(true);
    }

    /**
     * @param word
     */
    private void updateListView(String word) {
        for (int i = 0; i < list.size(); i++) {
            String listWord = list.get(i).getPinyin().substring(0, 1);

            if (word.equals("#")) {
                MoveToPosition(linearLayoutManager, 0);
            }

            if (word.equals(listWord)) {

                MoveToPosition(linearLayoutManager, i);
                return;
            }
        }
    }

    private void initView() {

        indexView = findViewById(R.id.indexView);
        recyclerView = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.textView);

    }


    private void initData() {

        list = new ArrayList<>();

        list.add(new Person("诸葛亮", "18935398186"));
        list.add(new Person("安其拉", "18935398186"));
        list.add(new Person("白起", "18935398186"));
        list.add(new Person("不知火舞", "18935398186"));
        list.add(new Person("妲己", "18935398186"));
        list.add(new Person("狄仁杰", "18935398186"));
        list.add(new Person("典韦", "18935398186"));
        list.add(new Person("韩信", "18935398186"));
        list.add(new Person("老夫子", "18935398186"));
        list.add(new Person("刘邦", "18935398186"));
        list.add(new Person("干将莫邪", "18935398186"));
        list.add(new Person("刘禅", "18935398186"));
        list.add(new Person("鲁班七号", "18935398186"));
        list.add(new Person("墨子", "18935398186"));
        list.add(new Person("孙膑", "18935398186"));
        list.add(new Person("孙尚香", "18935398186"));
        list.add(new Person("孙悟空", "18935398186"));
        list.add(new Person("项羽", "18935398186"));
        list.add(new Person("亚瑟", "18935398186"));
        list.add(new Person("周瑜", "18935398186"));
        list.add(new Person("庄周", "18935398186"));
        list.add(new Person("蔡文姬", "18935398186"));
        list.add(new Person("甄姬", "18935398186"));
        list.add(new Person("廉颇", "18935398186"));
        list.add(new Person("程咬金", "18935398186"));
        list.add(new Person("后羿", "18935398186"));
        list.add(new Person("扁鹊", "18935398186"));
        list.add(new Person("大乔", "18935398186"));
        list.add(new Person("钟无艳", "18935398186"));
        list.add(new Person("小乔", "18935398186"));
        list.add(new Person("王昭君", "18935398186"));
        list.add(new Person("虞姬", "18935398186"));
        list.add(new Person("李元芳", "18935398186"));
        list.add(new Person("张飞", "18935398186"));
        list.add(new Person("刘备", "18935398186"));
        list.add(new Person("牛魔", "18935398186"));
        list.add(new Person("张良", "18935398186"));
        list.add(new Person("兰陵王", "18935398186"));
        list.add(new Person("露娜", "18935398186"));
        list.add(new Person("貂蝉", "18935398186"));
        list.add(new Person("达摩", "18935398186"));
        list.add(new Person("曹操", "18935398186"));
        list.add(new Person("芈月", "18935398186"));
        list.add(new Person("荆轲", "18935398186"));
        list.add(new Person("高渐离", "18935398186"));
        list.add(new Person("钟馗", "18935398186"));
        list.add(new Person("花木兰", "18935398186"));
        list.add(new Person("关羽", "18935398186"));
        list.add(new Person("李白", "18935398186"));
        list.add(new Person("宫本武藏", "18935398186"));
        list.add(new Person("吕布", "18935398186"));
        list.add(new Person("嬴政", "18935398186"));
        list.add(new Person("娜可露露", "18935398186"));
        list.add(new Person("武则天", "18935398186"));
        list.add(new Person("赵云", "18935398186"));
        list.add(new Person("姜子牙", "18935398186"));
        list.add(new Person("女娲", "18935398186"));
        list.add(new Person("梦琪", "18935398186"));
        list.add(new Person("!MitQll", "18935398186"));
        list.add(new Person("@MitQll", "18935398186"));
        list.add(new Person("%MitQll", "18935398186"));
        //排序
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person lhs, Person rhs) {
                return lhs.getPinyin().compareTo(rhs.getPinyin());
            }
        });


    }

}
