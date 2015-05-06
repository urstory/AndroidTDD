package android.examples.todoapp.ui;

import android.app.ListActivity;
import android.examples.todoapp.R;
import android.examples.todoapp.app.ToDoApplication;
import android.examples.todoapp.dao.ToDoDao;
import android.examples.todoapp.domain.ToDo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

public class MainActivity extends ListActivity {

    private ToDoListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView tv = (TextView) findViewById( R.id.TextView1 );
        // tv.setText( "Hello Android TDD!" );

        listAdapter = new ToDoListAdapter( this );
        setListAdapter(listAdapter);

        registerForContextMenu(getListView());

        fetchToDoList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        String title = ((ToDo) listAdapter.getItem(info.position)).getTitle();
        menu.setHeaderTitle(title);

        getMenuInflater().inflate(R.menu.menu_listitem, menu);
        //menu.add(Menu.NONE, MENU_CONTEXT_DELETE_ID, Menu.NONE, "DELETE_TEXT");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void fetchToDoList() {
        ToDoApplication application =   (ToDoApplication)getApplicationContext();

        // DAO 생성
        ToDoDao dao = new ToDoDao(  application.getDatabase() );

        // list 가져오기
        List<ToDo> list = dao.gatAllToDo();

        // 데이터 추가
        listAdapter.setData( list );
    }
}
