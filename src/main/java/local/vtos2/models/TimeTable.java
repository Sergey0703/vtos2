package local.vtos2.models;


import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table
public class TimeTable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="day")
    @Temporal(TemporalType.DATE)
    private Calendar day;

    @ManyToOne
    @JoinColumn(name="item_id1")
    private Item item;

    @ManyToOne
    @JoinColumn(name="item_id2")
    private Item item2;


    @ManyToOne
    @JoinColumn(name="item_id3")
    private Item item3;

    @ManyToOne
    @JoinColumn(name="item_id4")
    private Item item4;

    @ManyToOne
    @JoinColumn(name="item_id5")
    private Item item5;

    @ManyToOne
    @JoinColumn(name="item_id6")
    private Item item6;

    @ManyToOne
    @JoinColumn(name="item_id7")
    private Item item7;

    public Calendar getDay() {
        return day;
    }

    public void setDay(Calendar day) {
        this.day = day;
    }

    public Item getItem3() {
        return item3;
    }

    public void setItem3(Item item3) {
        this.item3 = item3;
    }

    public Item getItem4() {
        return item4;
    }

    public void setItem4(Item item4) {
        this.item4 = item4;
    }

    public Item getItem5() {
        return item5;
    }

    public void setItem5(Item item5) {
        this.item5 = item5;
    }

    public Item getItem6() {
        return item6;
    }

    public void setItem6(Item item6) {
        this.item6 = item6;
    }

    public Item getItem7() {
        return item7;
    }

    public void setItem7(Item item7) {
        this.item7 = item7;
    }

    @ManyToOne
    @JoinColumn(name="item_id8")
    private Item item8;
    public Item getItem8() {
        return item8;
    }

    public void setItem8(Item item8) {
        this.item8 = item8;
    }



    public TimeTable(){

    }

    public TimeTable(int id){
        this.id=id;
      //  this.item_id=item_id;
      //  this.day = day;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }


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
