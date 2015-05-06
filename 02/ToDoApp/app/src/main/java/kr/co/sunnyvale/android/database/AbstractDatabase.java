package kr.co.sunnyvale.android.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public abstract class AbstractDatabase implements Database {
	
	SQLiteDatabase db;
	
	public AbstractDatabase( Context context, String databaseName, int version ) {
		SQLiteOpenHelper openHelper = new DatabaseHelper( context, databaseName, null, version );
		db = openHelper.getWritableDatabase();
	}
	
	@Override
	public SQLiteDatabase getDatabase() {
		return db;
	}
	
	protected abstract void create( SQLiteDatabase db );
	protected abstract void upgrade( SQLiteDatabase db, int oldVersion, int newVersion );
	
	private class DatabaseHelper extends SQLiteOpenHelper {
		public DatabaseHelper( Context context, String name, CursorFactory factory, int version ) {
			super( context, name, factory, version );
		}

		@Override
		public void onCreate( SQLiteDatabase db ) {
			Log.i( "AbstractRepository", "[ onCreate : create database ]" );
			create( db );
		}

		@Override
		public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
			Log.i( "AbstractRepository", "[ onUpgrade : upgrade(" + oldVersion +  " => " + newVersion + ") database ]" );
			upgrade( db, oldVersion, newVersion );
		}
	}
}
