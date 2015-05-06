package android.examples.todoapp.app;

import android.app.Application;
import android.examples.todoapp.database.ToDoDatabase;

import kr.co.sunnyvale.android.database.Database;

/**
 * Created by kicks_000 on 2015-05-04.
 */
public class ToDoApplication extends Application {
    Database database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = new ToDoDatabase(  getApplicationContext(), "todo.db", 4 );
    }

    public Database getDatabase() {
        return database;
    }
}
