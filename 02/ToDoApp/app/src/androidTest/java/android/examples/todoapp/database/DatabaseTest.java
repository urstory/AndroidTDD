package android.examples.todoapp.database;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by kicks_000 on 2015-05-04.
 */
public class DatabaseTest  extends ApplicationTestCase<Application>  {

    private ToDoDatabase database;

    public DatabaseTest() {
        super( Application.class );
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        database = new ToDoDatabase( getContext(), "todo.db",  1 );
    }

    public void testCreateDatabase() throws Exception {
        assertNotNull(database.getDatabase());
    }

    public void testUpgradeDatabase() throws Exception {
        ToDoDatabase database = new ToDoDatabase( getContext(), "todo.db", 2 );
        assertEquals( "업그레이드 버젼", 2, database.getDatabase().getVersion() );
    }

}
