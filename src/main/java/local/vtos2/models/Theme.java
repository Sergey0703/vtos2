package local.vtos2.models;

import javax.persistence.*;

@Entity
@Table
public class Theme {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @Column(name="name")
    private String name;

    @Column(name="content")
    private String content;

    @Column(columnDefinition="TEXT")
    private String text;

    public Theme() {

    }

    public int getId() {
        return id;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
