package android.examples.todoapp.ui;

import android.content.Context;
import android.examples.todoapp.R;
import android.examples.todoapp.domain.ToDo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kicks_000 on 2015-05-04.
 */
public class ToDoListAdapter extends ArrayAdapter<ToDo> {
    private LayoutInflater mInflater;

    public ToDoListAdapter(Context context) {
        super( context, R.layout.row_todo_list );

        mInflater = LayoutInflater.from( context );
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent ) {
        View view = convertView;
        if( view == null ) {
           view = mInflater.inflate( R.layout.row_todo_list, parent, false );
        }

        ToDo todo = getItem( position );

        TextView tv1 = (TextView)view.findViewById( R.id.TextView01 );
        tv1.setText( todo.getDate() );

        TextView tv2 = (TextView)view.findViewById( R.id.TextView02 );
        tv2.setText( todo.getTitle() );

        TextView tv3 = (TextView)view.findViewById( R.id.TextView03 );
        tv3.setText( todo.getStatus() );

        return view;
    }

    public void setData( List<ToDo> list ) {
        if( list == null ) {
            return;
        }

        for( ToDo todo : list ) {
            add( todo );
        }
    }
}