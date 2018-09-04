package com.alex.greendaotest;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Alex on 2018/9/4.
 */

public class TestDaoOpe {
    /**
     * 添加数据至数据库
     *
     * @param context
     * @param bean
     */
    public static void insertData(Context context, TestBean bean) {
        DbManager.getDaoSession(context).getTestBeanDao().insert(bean);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<TestBean> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getTestBeanDao().insertInTx(list);
    }
    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param bean
     */
    public static void saveData(Context context, TestBean bean) {
        DbManager.getDaoSession(context).getTestBeanDao().save(bean);
    }
    /**
     * 删除数据至数据库
     *
     * @param context
     * @param bean 删除具体内容
     */
    public static void deleteData(Context context, TestBean bean) {
        DbManager.getDaoSession(context).getTestBeanDao().delete(bean);
    }
    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbManager.getDaoSession(context).getTestBeanDao().deleteByKey(id);
    }
    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getTestBeanDao().deleteAll();
    }
    /**
     * 更新数据库
     *
     * @param context
     * @param bean
     */
    public static void updateData(Context context, TestBean bean) {
        DbManager.getDaoSession(context).getTestBeanDao().update(bean);
    }
    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<TestBean> queryAll(Context context) {
        QueryBuilder<TestBean> builder = DbManager.getDaoSession(context).getTestBeanDao().queryBuilder();

        return builder.build().list();
    }



    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<TestBean> queryPaging( int pageSize, int pageNum,Context context){
        TestBeanDao studentDao = DbManager.getDaoSession(context).getTestBeanDao();
        List<TestBean> listMsg = studentDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }

}
