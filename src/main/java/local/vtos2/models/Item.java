package local.vtos2.models;

//import lombok.Data;

//import lombok.Data;

import javax.persistence.*;

@Entity
@Table
public class Item {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    //private String description;

    public Item(){

    }

    public Item(int id){
        this.id=id;
    }
    public Item(String name){
        this.name=name;
    }
    public Item(int id, String name){
        this.id=id;
        this.name=name;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

}
