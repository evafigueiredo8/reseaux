import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;


public class TestEntity2D {

    public static void main(String[] args ) {
        Entity2D ent_1 = new Entity2D ( " test1 " , 0.0f , 0.0f);
        ent_1.putItem(5);
        ent_1.putItem(7);
        ent_1.putItem(-1);
        ObjectOutputStream oos = null;
        
        // Writing into a file
        try{
            FileOutputStream fichier = new FileOutputStream("donnees.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(ent_1);
            oos.flush();
            oos.close();
            fichier.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        File saved = new File ( "donnees.ser");
        System.out.println("Taille du fichier : " + saved.length() + " octets" ) ;
    }

}