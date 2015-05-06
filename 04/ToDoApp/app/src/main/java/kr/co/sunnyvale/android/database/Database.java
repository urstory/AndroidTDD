package kr.co.sunnyvale.android.database;

import android.database.sqlite.SQLiteDatabase;

public interface Database {
	public abstract SQLiteDatabase getDatabase();
}
