package collection;
 
public class Item implements LOL {
    String name;
    int price;
      
    public Item(){
          
    }
      
    public Item(String name){
        this.name = name;
    }
      
    public void effect(){
        System.out.println("物品使用后，可以有效果");
    }
 
    public boolean disposable() {
        return false;
    }
      
}