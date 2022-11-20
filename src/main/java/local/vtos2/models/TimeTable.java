package local.vtos2.models;

//import lombok.Data;

//port lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TimeTable {
    @Id
    @Column(name="lesson_id")
    private int lesson_id;
    @Column(name="item_id")
    private int item_id;
    //private String name;
    //private String description;

    public TimeTable(){

    }

    public TimeTable(int lesson_id, int item_id){
        this.lesson_id=lesson_id;
        this.item_id=item_id;
    }

    public void setLessonId(int lesson_id){
        this.lesson_id=lesson_id;
    }

    public int getLessonId(){
        return this.lesson_id;
    }

    public void setItemId(int item_id){
        this.item_id=item_id;
    }

    public int getItemId(){
        return this.item_id;
    }
    /*public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    } */

}
