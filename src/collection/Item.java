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
        System.out.println("��Ʒʹ�ú󣬿�����Ч��");
    }
 
    public boolean disposable() {
        return false;
    }
      
}