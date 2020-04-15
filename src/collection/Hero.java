package collection;
 
public class Hero {
    public String name;
    public int hp;
    
    public Hero(String name) {
    	this.name = name;
    }
 
    public Hero(String name , int hp) {
    	this.name = name;
    	this.hp = hp;
    }
 
    public String toString(){
    	return "[" + "name: " + name + " hp: " + hp + "]" + "\n";
    }
}