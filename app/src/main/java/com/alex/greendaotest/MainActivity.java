package com.alex.greendaotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.btn_query_all)
    Button btnQueryAll;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind( this ) ;
        initData();
    }

    private List<TestBean> mTestBeanList = new ArrayList<>();

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < 100; i++) {
            TestBean bean = new TestBean((long) i, "huang" + i, i);
            mTestBeanList.add(bean);
        }
    }

    int page;

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.btn_query_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                TestDaoOpe.insertData(this, mTestBeanList);
                break;
            case R.id.button2:
                 TestBean testBean = new TestBean((long) 5, "haung" + 5, 25);
                /**
                 * 根据特定的对象删除
                 */
                TestDaoOpe.deleteData(this, testBean);
                /**
                 * 根据主键删除
                 */
                TestDaoOpe.deleteByKeyData(this, 7);
                TestDaoOpe.deleteAllData(this);
                break;
            case R.id.button3:
                testBean = new TestBean((long) 2, "caojin", 1314);
                TestDaoOpe.updateData(this, testBean);
                break;
            case R.id.button4:
                List<TestBean> testBeans = TestDaoOpe.queryAll(this);
                tvContent.setText(testBeans.toString());
                for (int i = 0; i < testBeans.size(); i++) {
                    Log.i("Log", testBeans.get(i).getDate());
                }
                break;
            case R.id.button5:
                TestDaoOpe.deleteAllData(this);
                break;
            case R.id.btn_query_all:
                List<TestBean> testBeans1 = TestDaoOpe.queryPaging(page, 20, this);

                if (testBeans1.size() == 0) {
                    Toast.makeText(this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                }
                for (TestBean st : testBeans1) {
                    Log.e("TAG", "onViewClicked: ==" + st);
                    Log.e("TAG", "onViewClicked: == num = " + st.getDate());
                }
                page++;
                tvContent.setText(testBeans1.toString());
                break;
        }
    }




}
