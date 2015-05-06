package android.examples.todoapp.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.examples.todoapp.database.ToDoDatabase;
import android.examples.todoapp.domain.ToDo;

import java.util.ArrayList;
import java.util.List;

import kr.co.sunnyvale.android.database.Database;

/**
 * Created by kicks_000 on 2015-05-04.
 */
public class ToDoDao {
    private Database database;

    public ToDoDao( Database database ) {   // 구현체보다는 인터페이스!
        this.database = database;
    }

    public boolean insert( ToDo todo ) {
        SQLiteDatabase db = database.getDatabase();

        ContentValues values = new ContentValues();
        values.put(ToDoDatabase.TABLE_TODO.COLUMN_NAME_DATE, todo.getDate());
        values.put(ToDoDatabase.TABLE_TODO.COLUMN_NAME_TITLE, todo.getTitle());
        values.put(ToDoDatabase.TABLE_TODO.COLUMN_NAME_STATUS, todo.getStatus());

        return db.insert( ToDoDatabase.TABLE_TODO.TABLE_NAME, null, values ) > 0;
    }

    // 전부 다 지움
    public int delete() {
        SQLiteDatabase db = database.getDatabase();
        return db.delete( ToDoDatabase.TABLE_TODO.TABLE_NAME, null, null );
    }

    public List<ToDo> gatAllToDo() {
        SQLiteDatabase db = database.getDatabase();
        Cursor cursor = db.query(
                ToDoDatabase.TABLE_TODO.TABLE_NAME,
                new String[] {
                        ToDoDatabase.TABLE_TODO.COLUMN_NAME_ID,
                        ToDoDatabase.TABLE_TODO.COLUMN_NAME_DATE,
                        ToDoDatabase.TABLE_TODO.COLUMN_NAME_TITLE,
                        ToDoDatabase.TABLE_TODO.COLUMN_NAME_STATUS },
                null,
                null,
                null,
                null,
                null );

        List<ToDo> list = new ArrayList<ToDo>();

        while( cursor.moveToNext() ) {

            Long id = cursor.getLong(cursor.getColumnIndex(ToDoDatabase.TABLE_TODO.COLUMN_NAME_ID));
            String date = cursor.getString(cursor.getColumnIndex(ToDoDatabase.TABLE_TODO.COLUMN_NAME_DATE));
            String title = cursor.getString( cursor.getColumnIndex(ToDoDatabase.TABLE_TODO.COLUMN_NAME_TITLE));
            String status = cursor.getString(cursor.getColumnIndex(ToDoDatabase.TABLE_TODO.COLUMN_NAME_STATUS));

            ToDo todo = new ToDo();
            todo.setId(id);
            todo.setDate(date);
            todo.setTitle(title);
            todo.setStatus( status );

            list.add( todo );
        }

        return list;
    }
}
