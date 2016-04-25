package com.purityboy.greendaobuilder.helper;

import android.content.Context;

import com.yohov.teaworm.greendao.DaoMaster;
import com.yohov.teaworm.greendao.DaoSession;

/**
 * Created by John on 2016/4/25.
 */
public class DbCore {

    private static final String TAG = DbCore.class.getSimpleName();

    //默认的数据库名
    private static String DEFAULT_DB_NAME = "default.db";

    private Context context;
    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private String dbName = DEFAULT_DB_NAME;

    // DdCore实例
    private static DbCore instance;

    private DbCore() { }

    /** 获取实例 ,单例模式 */
    public static DbCore getInstance() {
        if (instance == null) {
            synchronized (DbCore.class){
                if (instance == null) {
                    instance = new DbCore();
                }
            }
        }
        return instance;
    }

    public void init(Context context) {
        this.init(context, null);
    }

    /***
     * 初始化，最好在Application中执行
     * @param context
     * @param dbName    数据库的名字
     */
    public void init(Context context, String dbName) {
        if (null == context)
            throw new IllegalArgumentException("context can't be null");
        this.context = context.getApplicationContext();
        this.dbName = dbName;
        if (null == dbName || dbName.trim().isEmpty())
            initDatabase(DEFAULT_DB_NAME);
        else
            initDatabase(dbName);
    }

     private void initDatabase(String dbName) {
         // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
         // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
         // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
         // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, dbName, null);
        UpdateDevOpenHelper helper = new UpdateDevOpenHelper(context, dbName, null);
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public DaoMaster getDaoMaster() {
        if (null == daoMaster) {
            UpdateDevOpenHelper helper = new UpdateDevOpenHelper(context, dbName, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        if (null == daoSession) {
            if (null == daoMaster)
                daoMaster = getDaoMaster();
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

}
