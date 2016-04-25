package com.purityboy.greendaobuilder.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.yohov.teaworm.greendao.DaoMaster;
import com.yohov.teaworm.greendao.NoteDao;

/**
 * Created by John on 2016/4/25.
 * 因为原本greenDao中的onUpdate方法是删除之后再建，所以重写onUpdate方法
 */
public class UpdateDevOpenHelper extends DaoMaster.DevOpenHelper{

    public UpdateDevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //super.onUpgrade(db, oldVersion, newVersion);
        //dropAllTables(db, true);
        //onCreate(db);
        if(oldVersion == 1 && newVersion == 2) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by update all tables");
            boolean ifNotExists = false;
            //Leave old tables alone and only create ones that didn't exist
            //in the previous schema
            NoteDao.createTable(db, ifNotExists);
        } else {
            super.onUpgrade(db, oldVersion, newVersion);
        }
    }
}
