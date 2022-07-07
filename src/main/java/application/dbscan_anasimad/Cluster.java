
package application.dbscan_anasimad;

import java.util.ArrayList;

/* la classe Cluster utilisait pour identifier les clusters par un id
avec une liste des points qui appartient au cluster  */
public class Cluster{
    ArrayList<String[]> points;
    int id;
    /* la fonction Cluster initialise la liste des points*/
    public Cluster(){
        points = new ArrayList<String[]>();
    }
    /* la fonction add ajoute à la liste le point passe comme argument */
    public void add(String[] point){
        points.add(point);
    }

}
