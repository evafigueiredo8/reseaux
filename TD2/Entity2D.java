import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException ;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

    public void VoirEntity(){
        System.out.println("ID : "+ id + "Nom : "+name);
    }

    public void ModifierNom(String name){
        this.name = name;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    
    private void readObject(ObjectInputStream in) throws IOException,
        ClassNotFoundException {
        in.defaultReadObject();
    }

    public static void main(String[] args ) {
        Entity2D ent_1 = new Entity2D ( " test1 " , 0.0f , 0.0f);
        ent_1.putItem(5);
        ent_1.putItem(7);
        ent_1.putItem(−1);
        ObjectOutputStream oos = null;
        
        // Writing into a file
        try{
            FileOutputStream fichier = new FileOutputStream( "donnees.ser");
            oos = newObjectOutputStream(fichier);
            oos.writeObject(ent_1);
            oos.flush();
            oos.close();
            fichier.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        File saved = new File ( "donnees.ser");
        System.out.println("Taille du fichier : " + saved.length() + " octets" ) ;

        
}