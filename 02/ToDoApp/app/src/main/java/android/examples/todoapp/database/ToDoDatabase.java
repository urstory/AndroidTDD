package android.examples.todoapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import kr.co.sunnyvale.android.database.AbstractDatabase;

/**
 * Created by kicks_000 on 2015-05-04.
 */
public class ToDoDatabase extends AbstractDatabase {
    public ToDoDatabase(Context context, String databaseName, int version) {
        super( context, databaseName, version );
    }

    @Override
    protected void create(SQLiteDatabase db) {
        db.execSQL( TABLE_TODO.SQL_CREATE );
    }

    @Override
    protected void upgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "drop table if exists " +  TABLE_TODO.TABLE_NAME );
        db.execSQL( TABLE_TODO.SQL_CREATE );
    }

    public final class TABLE_TODO implements BaseColumns {
        public static final String TABLE_NAME = "TODO";
        public static final String COLUMN_NAME_ID = "ID";
        public static final String COLUMN_NAME_DATE = "DATE";
        public static final String COLUMN_NAME_TITLE = "TITLE";
        public static final String COLUMN_NAME_STATUS = "STATUS";

        public static final String SQL_CREATE =
                "create table " + TABLE_NAME + "(" +
                        COLUMN_NAME_ID			+ " string primary key," +
                        COLUMN_NAME_DATE 		+ " text not null," +
                        COLUMN_NAME_TITLE	    + " text not null," +
                        COLUMN_NAME_STATUS		+ " integer not null" +
                        ")";
    }
}
