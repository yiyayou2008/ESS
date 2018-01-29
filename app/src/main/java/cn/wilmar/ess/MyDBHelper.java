package cn.wilmar.ess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

//创建数据库
public class MyDBHelper extends SQLiteOpenHelper {

    //t_EQ建表SQL语句
    public static final String CREATE_t_EQ = "create table t_EQ ("
            + "EQID text primary key, "
            + "EQName text)";
    //t_EQDesc建表语句
    public static final String CREATE_t_EQDesc = "create table t_EQDesc ("
            + "SpareID text, "
            + "SpareName text, "
            + "SAPID text, "
            + "Photo BLOB, "
            + "EQID text)";

    private Context mContext;

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        //分别创建t_EQ和t_EQDesc两张数据表
        db.execSQL(CREATE_t_EQ);
        db.execSQL(CREATE_t_EQDesc);
        Toast.makeText(mContext, "t_EQ & t_EQDesc数据表创建成功！", Toast.LENGTH_SHORT).show();
        //关闭数据库
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
