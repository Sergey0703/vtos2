package local.vtos2.models;

//import lombok.Data;

//port lombok.Data;

import javax.persistence.*;

@Entity
@Table
public class TimeTable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="item_id")

    private Item item;

    //private int item_id;
    //private String name;
    //private String description;

    public TimeTable(){

    }

    public TimeTable(int id){
        this.id=id;
      //  this.item_id=item_id;
    }

   /*  public TimeTable(int id, int item_id){
        this.id=id;
        this.item_id=item_id;
    }
    */

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }

  //  public void setItemId(int item_id){
  //      this.item_id=item_id;
  //  }

  //  public int getItemId(){
  //      return this.item_id;
  //  }

    public void setItem(Item item) {this.item=item;}

    public Item getItem(){return item;}

    public void saveTimeTable(int id, Item it){
        //TimeTable.add();
       // Item it=new Item(item_id);
       // TimeTable tTable=new TimeTable(id+1);
       // tTable.setItem(it);
       // System.out.println("id="+tTable.getId()+" itemN="+it.getName()+" t="+tTable.item.getName());
    }
    /*public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    } */

}
