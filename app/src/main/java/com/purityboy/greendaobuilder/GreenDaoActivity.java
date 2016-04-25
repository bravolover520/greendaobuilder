package com.purityboy.greendaobuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.purityboy.greendaobuilder.helper.DbCore;
import com.purityboy.greendaobuilder.helper.DbHelper;
import com.purityboy.greendaobuilder.helper.IDbService;
import com.yohov.teaworm.greendao.Note;
import com.yohov.teaworm.greendao.NoteDao;

import java.util.Date;
import java.util.List;

/**
 * 指导链接
 * https://github.com/greenrobot/greenDAO
 * http://greenrobot.org/greendao/documentation/
 * http://www.open-open.com/lib/view/open1438065400878.html
 *
 * Database Encryption 从2.2版本之后支持数据库加密
 * http://greenrobot.org/greendao/documentation/database-encryption/
 *
 * “greendao-encryption” replaces “greendao”
 *  Android’s SQLiteOpenHelper cannot be used because it returns Android’s unencrypted databases. Instead, greenDAO’s EncryptedDatabaseOpenHelper works with encrypted databases and replaces the standard SQLiteOpenHelper.
 */
public class GreenDaoActivity extends AppCompatActivity {

    private IDbService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);

//        DbCore.getInstance().init(GreenDaoActivity.this, "myDb");

        Note note = new Note();
        note.setText("neirong");
        note.setComment("pinglun");
        note.setDate(new Date());

        service = DbHelper.getInstance().getNoteService();
        service.save(note);

        List<Note> ts = service.queryAll();

        for (Note n : ts) {
            System.out.println(n.getText());
        }

        /**
         * list()       所有实体载入内存，以ArrayList形式返回，使用最简单。
         * listLazy()       实体按需加载到内存。当列表中的其中一个元素第一次被访问，它会被加载并缓存备将来使用。使用完必须关闭。
         * listLazyUncached()       一个“虚拟”的实体列表：任何访问列表中的元素都会从数据库中读取。使用完必须关闭。
         * listIterator()       可迭代访问结果集，按需加载数据，数据不缓存。使用完必须关闭
         */

        //Query类代表着一个查询，可被执行多次。但使用QueryBuilder的方法之一（如list()）获取一个结果时，QueryBuilder内部就是使用Query类。如果要多次执行相同的请求，可调用QueryBulder的build()方法创建一个查询而非执行它。
        service.queryBuilder().where(NoteDao.Properties.Id.eq(Integer.valueOf(1)))
                .orderAsc(NoteDao.Properties.Date)
                .list();
    }
}
