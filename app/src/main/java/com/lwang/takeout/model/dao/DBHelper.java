package com.lwang.takeout.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.lwang.takeout.app.App;
import com.lwang.takeout.model.dao.bean.AddressBean;
import com.lwang.takeout.model.dao.bean.UserBean;

import java.sql.SQLException;

/**
 * DBHelper.class
 *
 * @author lwang
 * @date 2017/12/25.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASENAME = "takeout.db";
    private static final int DATABASEVERSION = 1;
    private static DBHelper instance;

    /**
     * 单例模式
     * 双重校验机制
     */
    public static DBHelper getInstance() {

        if (instance == null){ //第一次校验：提高效率，不用排队
            synchronized (DBHelper.class){
                if (instance == null){ // 第二次校验：防止多线程过来时 对象多次创建
                    instance =  new DBHelper(App.getContext());
                    instance.getWritableDatabase();
                }
            }
        }
        return instance;
    }


    public DBHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, UserBean.class);
            TableUtils.createTable(connectionSource, AddressBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
