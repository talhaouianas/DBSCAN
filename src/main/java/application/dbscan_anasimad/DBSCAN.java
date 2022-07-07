
package application.dbscan_anasimad;

import java.io.IOException;
import java.util.ArrayList;




public class DBSCAN {
    /* l'attribut data pour sauvegarder la liste des instances*/
    Data data;
    /* la liste clusters pour sauvegarder la liste des clusters*/
    ArrayList<Cluster> clusters = new ArrayList<Cluster>();
    /* la liste instances pour sauvegarder la liste des instances*/
    ArrayList<String[]> instances;
    /* la liste instances pour sauvegarder la liste des points déjà visiter */
    ArrayList<String[]> visited = new ArrayList<String[]>();
    /* la liste noise pour sauvegarder la liste des points noises*/
    ArrayList<String[]> noise = new ArrayList<String[]>();


    /* la fonction return voisins prend en argument un point et
    retourne la liste de ses voisins par rapport à l'epsilon choisi */

    public ArrayList<String[]> return_voisins(Data dt, double e, String[] point, String distance_function) throws IOException{

        String[] instance = point;
        ArrayList<String[]> voisins = new ArrayList<String[]>();

        for(int i=0;i<dt.instances.size();i++){

            String[] x = dt.instances.get(i);

            if(dt.distance(instance, x, distance_function)< e){
                voisins.add(x);}
        }
        return voisins;
    }

     /* la fonction developper_cluster utiliser pour ajouter d'autres points au cluster argument */
    public void developper_cluster(int index, ArrayList<String[]> voisins, Cluster c, double e, double MinPts, String distance_function ) throws IOException{

        String[] point = instances.get(index);

        System.out.println("developper_cluster "+index);

        c.add(point);

        for(int i = 0; i< voisins.size(); i++){

                        point = voisins.get(i);
//si le point n'est pas visité retourné ses voisins
                        if(!visited.contains(point)){
                            visited.add(point);
                            ArrayList<String[]> voisins2 = return_voisins(data, e, point, distance_function);
//si le nombre de voisins > MinPts c-a-d un point core ajouter les voisins du point voisin aux voisins du point initiale
                            if(voisins2.size()> MinPts){
                                voisins.addAll(voisins2);}
                        }
//ensuite si le points n'appartient a acune cluster ajouter le au cluster c
                        boolean appartient = false;
                        for(Cluster cl:clusters){

                            if(cl.points.contains(point)){   appartient =true ;}

                                    }

                        if(appartient ==false){
                            c.add(point);
                        }
        }
    }

    /*utiliser pour classifier les points en points core ou noise ensuite appelé la fonction développer_cluster*/
    public String dbscan(Data dt, double e, double MinPts, String distance_function) throws IOException{

        this.instances = dt.instances;
        this.data = dt;
        String result="";
        result+=("\n\n");
        result+=("-- CLUSTERING :    "+instances.size()+"    INSTANCES WITH DBSCAN --\n\n");
        result+=("-- PARAMS: \n\n\t+EPS:"+ e +" \t+MINPTS: "+ MinPts +" \tDISTANCE FUNCTION : "+distance_function+" --\n\n");
        result+=("---------------------------------------");

        for(int i=0;i<instances.size();i++){

                    String[] point = instances.get(i);

                    if(visited.contains(point)){ continue;}

                    visited.add(point);

                    ArrayList<String[]> voisins = return_voisins(dt, e,point, distance_function);
                    //si point noise ou points border ajouter le a la listz noise
                    if(voisins.size()< MinPts){ noise.add(point);}
                    //else si point core cree cluster et developer le
                    else{
                        Cluster c = new Cluster();
                        clusters.add(c);
                        developper_cluster(i, voisins, c, e, MinPts, distance_function);
                    }
        }
   return result; }
}
