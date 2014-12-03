package main.java.ru.eltech.cofefe.core.entity;
import org.hibernate.annotations.Type;
import javax.persistence.*;


/**
 * Created by destely on 19.10.2014.
 */
@Entity
@Table(name = "cofefeProducts")
@NamedQuery(name = "Cofefe.getAll", query = "SELECT c from Cofefe c")
//Запрос к сущности Cofefe; получение всех продуктов
public class Cofefe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title", length = 32)
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "shortDescription")
    private String shortDescription;

    @Column(name = "Description")
    @Type(type = "text")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Cofefe{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
               // ", description='" + description + '\'' +
                '}';
    }

}
