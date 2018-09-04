package com.alex.greendaotest;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * Created by Alex on 2018/9/4.
 */
@Entity
public class TestBean implements Serializable{
    private static final long serialVersionUID = 3950505384388353422L;
    @Id
    private long id;
    private String date;
    private int step;
    @Generated(hash = 987071077)
    public TestBean(long id, String date, int step) {
        this.id = id;
        this.date = date;
        this.step = step;
    }
    @Generated(hash = 2087637710)
    public TestBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getStep() {
        return this.step;
    }
    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", step=" + step +
                '}';
    }
}
