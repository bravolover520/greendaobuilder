package com.purityboy.greendaobuilder.helper.service;

import com.purityboy.greendaobuilder.helper.DbService;
import com.yohov.teaworm.greendao.Note;

import de.greenrobot.dao.AbstractDao;

/**
 * Created by John on 2016/4/25.
 */
public class NoteService extends DbService<Note, Long> {

    public NoteService(AbstractDao dao) {
        super(dao);
    }
}
