package android.examples.todoapp.database;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by kicks_000 on 2015-05-02
 */
public class DatabaseTest  extends ApplicationTestCase<Application>  {

    private final String dbName = "todo.db";
    private final int version = 4;

    private ToDoDatabase database;

    public DatabaseTest() {
        super( Application.class );
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        //database = new ToDoDatabase( getContext(), dbName,  1 );
        database = new ToDoDatabase( getContext(), dbName, version );
    }

    public void testCreateDatabase() throws Exception {
        assertNotNull(database.getDatabase());
    }

    public void testUpgradeDatabase() throws Exception {
        ToDoDatabase database = new ToDoDatabase( getContext(), dbName, version );
        assertEquals( "업그레이드 버젼", 4, database.getDatabase().getVersion() );
    }

}
