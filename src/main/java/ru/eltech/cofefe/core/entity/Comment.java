package main.java.ru.eltech.cofefe.core.entity;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Юлия on 30.11.2014.
 */
@Entity
@Table(name = "comments")
@NamedQuery(name = "Comment.getAll", query = "SELECT k from Comment k ")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "text")
    @Type(type = "text")
    private String text;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText(){ return text; }

    public void setText(String text) { this.text = text; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' + '}';
    }
}
