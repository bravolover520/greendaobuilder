package com.purityboy.greendaobuilder.helper;

import com.purityboy.greendaobuilder.helper.service.NoteService;
import com.yohov.teaworm.greendao.NoteDao;


/**
 * Created by John on 2016/4/25.
 */
public class DbHelper {

    private static NoteService noteService;
    private static DbHelper instance;

    private DbHelper() {}

    /** 获取实例 ,单例模式 */
    public static DbHelper getInstance() {
        if (instance == null) {
            synchronized (DbHelper.class){
                if (instance == null) {
                    instance = new DbHelper();
                }
            }
        }
        return instance;
    }

    private NoteDao getNoteDao() {
        return DbCore.getInstance().getDaoSession().getNoteDao();
    }

    public NoteService getNoteService() {
        if (null == noteService)
            noteService = new NoteService(getNoteDao());
        return noteService;
    }
}
