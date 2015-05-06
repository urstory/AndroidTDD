package android.examples.todoapp.domain;

/**
 * Created by kicks_000 on 2015-05-04.
 */
public class ToDo {

    private Long id;
    private String date;
    private String title;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        ToDo todo = (ToDo)o;
        return ( date.equals( todo.getDate() ) && title.equals( todo.getTitle() ) && status.equals( todo.getStatus() ) );
    }
}
