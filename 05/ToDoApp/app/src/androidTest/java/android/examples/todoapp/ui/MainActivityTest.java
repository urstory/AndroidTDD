package android.examples.todoapp.ui;

import android.app.ListActivity;
import android.examples.todoapp.app.ToDoApplication;
import android.examples.todoapp.dao.ToDoDao;
import android.examples.todoapp.domain.ToDo;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

/**
 * Created by kicks_000 on 2015-05-04.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private ListActivity activity;
    private ToDoDao dao;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();

        // dao 생성
        ToDoApplication application =   (ToDoApplication)activity.getApplicationContext();
        dao = new ToDoDao( application.getDatabase() );
        // 전부 삭제
        dao.delete();
        // 테스트 데이터 생성
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


        // OnStart를 실행 시킨다.
        // 즉, 액티비티 생명 주기중 onStart() 상태를 테스트 해 볼 수 있다.
        // 여기서는 필요 없음
        //getInstrumentation().callActivityOnStart(activity);
    }

//   public void testHelloString(){
//        Activity activity = getActivity();
//        TextView tv = (TextView) activity.findViewById( R.id.TextView1 );
//        assertNotNull( tv );
//        assertEquals(activity.getText(R.string.hello_world), tv.getText().toString());
//    }

    public void testListView() {
        //ListActivity activity = getActivity();
        ListView lv = activity.getListView();
        assertNotNull(lv);
    }

    public void testListAdapter() {
        //ListActivity activity = getActivity();

//        ToDoListAdapter listAdapter = new ToDoListAdapter( activity );
//        activity.setListAdapter( listAdapter );

        assertNotNull( activity.getListAdapter() );
    }

    public void testDatabase() {
        ToDoApplication application =   (ToDoApplication)activity.getApplicationContext();
        assertNotNull("전역 객체 애플리케이션에서 Database 객체 가져오기", application.getDatabase());
    }

    public void testFetchToDoList() {
        // UI를 변경하는 테스트 이므로
        // Only the original thread that created a view hierarchy can touch its views 가 발생한다.
        // Main Thread에서 작동하게 한다.
        // 그리고  ListView에 아이템이 다 그려질 때 까지 기다려 후에 혹시 있을 지 모를 클릭 테스트도 대비 한다.
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                ((MainActivity)activity).fetchToDoList();
            }
        });
        getInstrumentation().waitForIdleSync();
    }
}