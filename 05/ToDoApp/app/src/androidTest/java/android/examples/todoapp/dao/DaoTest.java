package android.examples.todoapp.dao;

import android.app.Application;
import android.examples.todoapp.database.ToDoDatabase;
import android.examples.todoapp.domain.ToDo;
import android.test.ApplicationTestCase;

import java.util.List;

/**
 * Created by kicks_000 on 2015-05-02.
 */
public class DaoTest extends ApplicationTestCase<Application> {
    private ToDoDao dao;

    public DaoTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // 데이터베이스 생성
        ToDoDatabase database = new ToDoDatabase( getContext(), "todo.db", 4 );  // DatabaseTest와 중복이 일어나므로 이름과 버젼은 나중에 Configuration 클래스로 리팩토링 할 것

        // DAO 생성 ,  정제과정에서 싱글톤으로 리팩토링 할 것
        dao = new ToDoDao( database );

        // 전부 삭제
        dao.delete();
    }

    public void testDao() throws Exception {
        //ToDoDao dao = new ToDoDao();
    }

    public void testCreateToDo() throws Exception {
        //ToDoDao dao = new ToDoDao();

        ToDo todo = new ToDo();
        todo.setDate( "2015-05-03" );
        todo.setTitle("방청소");
        todo.setStatus("Not Done");

        assertEquals("ToDo 생성", true, dao.insert(todo));
    }

    public void testReadTodo() throws Exception {
        ToDo todo1 = new ToDo();
        todo1.setDate("2015-05-03");
        todo1.setTitle("방청소");
        todo1.setStatus("Not Done");

        assertEquals("ToDo1 생성", true, dao.insert(todo1));

        ToDo todo2 = new ToDo();
        todo2.setDate("2015-05-03");
        todo2.setTitle("부엌청소");
        todo2.setStatus("Not Done");

        assertEquals("ToDo2 생성", true, dao.insert(todo2));

        List<ToDo> list = dao.gatAllToDo();

        assertEquals( "todo1 비교", true, list.get( 0 ).equals( todo1 ) );
        assertEquals( "todo1 비교", true, list.get( 1 ).equals( todo2 ) );

    }
}