import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException ;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.ObjectOutputStream;
import java.io.Externalizable;



public class Entity2D implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final int MAX_ITEMS = 10;
    public static int nb_generated = 0;
    private int id;
    private String name;
    private float x;
    private float y;
    private ArrayList<Integer> items;

    public Entity2D(String name, float x, float y){
        this.name = name;
        this. x = x ;
        this. y = y ;
        this. id = nb_generated ;
        nb_generated++;
        items = new ArrayList<Integer>() ;
    }
    public Entity2D(){
        this.name = ("Entity" + nb_generated);
        this. x = 0 ;
        this. y = 0 ;
        this. id = nb_generated ;
        nb_generated++;
        items = new ArrayList<Integer>() ;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeFloat(x);
        out.writeFloat(y);
        int tailleItems = items.size();
        out.writeInt(tailleItems);
        for (int i=0; i < tailleItems; i++){
            out.writeInt(items.get(i));
        }
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = in.readUTF();
        x = in.readFloat();
        y = in.readFloat();
        int taille = in.readInt();
        for (int i=0; i < taille; i++){
            items.set(i, in.readInt());
        }
    }
    
    /*private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    
    private void readObject(ObjectInputStream in) throws IOException,
        ClassNotFoundException {
        in.defaultReadObject();
    }*/

    public void putItem(int item){
        if (items.size() < MAX_ITEMS) {
            items.add(item);
        } else {
            System.out.println("Le nombre max d'items est atteint.");
        }
    }
        
}