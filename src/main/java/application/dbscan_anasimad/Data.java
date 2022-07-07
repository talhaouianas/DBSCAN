
package application.dbscan_anasimad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

    /* la classe Data utiliser pour enregister les donnes de la Base de Données dans une liste instances */
public class Data {
    ArrayList<String[]> instances;

    public Data(String path) throws IOException{
        csv_to_instances(path);
    }
    /* la fonction csv_to_instances permet l'enregistrement des donnes d'un fichier CSV
    dans la liste des instances de la classe Data */
    public void csv_to_instances(String path) throws FileNotFoundException, IOException{
        instances = new ArrayList<String[]>();
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String line;
        while((line=bf.readLine())!=null){
            instances.add(line.split(","));
        }
    }
   /* la fonction quantitative_euclidean permet le calcule de la distance euclidienne
    entre deux vecteurs de donnes quantitatives*/
    public double quantitative_euclidean(String[] inst1, String[] inst2){
        double result=0;
        double dis;
        for(int i=0;i<inst1.length;i++){
           try{
            dis = Double.parseDouble(inst1[i])-Double.parseDouble(inst2[i]);
            dis = dis*dis;
            result+=dis;
           }catch(Exception e){}
        }
        result = Math.sqrt(result);
        return result;
    }
    /* la fonction qualitative_euclidean permet le calcule de la distance euclidienne
    entre deux vecteurs de donnes qualitatives*/
    public double qualitative_euclidean(String[] inst1, String[] inst2){
        double result=0;
        double dis;
        for(int i=0;i<inst1.length;i++){
            try{
                if (inst1[i].equals(inst2[i]))dis=0;
                else dis=1;

                dis = dis*dis;
                result+=dis;
            }catch(Exception e){}
        }
        result = Math.sqrt(result);
        return result;
    }

    /* la fonction levenshtein permet le calcule de la distance entre deux vecteurs de donnes qualitatives
    ou bien des chaines de caractères en se basant sur la méthode levenshtein*/

    public double levenshtein(String[] inst1, String[] inst2) throws IOException{
        StringDistances oo = new StringDistances();
        double result=0;
        for(int i=0;i<inst1.length;i++){
            result+=StringDistances.calculatelv(inst1[i],inst2[i]);
        }
        return result;
    }

     /* la fonction distance prend en arguments le nom de la fonction à utiliser pour calculer la distance
      et les deux vecteurs de donnes*/
    public double distance(String[] inst1, String[] inst2, String distance_function) throws IOException{
        double result=0;
        if(distance_function.equals("quantitative_euclidean")){
            result = quantitative_euclidean(inst1,inst2);
        }

        else if(distance_function.equals("levenshtein")){
            result = levenshtein(inst1, inst2);
        }
        else if(distance_function.equals("qualitative_euclidean")){
            result = levenshtein(inst1, inst2);
        }
        return result;
    }

  /* la fonction affichage_distances affiche une matrice des distances entre tous les instances de la base de données*/
     public String affichage_distances(String distance_function) throws IOException{
        String result="",res="";
        res+="\n Distance Matrix  :\n\n";
        double max=0, min=1000, average=0, d;
        for(int i=0;i<instances.size();i++){
            for(int j=0;j<instances.size();j++){
                

                d = distance(instances.get(i),instances.get(j), distance_function);
                res+=(int)(d)+"    ";
                if(d>max){max=d;}
                if(d<min){min=d;}
                average+=d;
            }
            res+="\n";
        }
        average=average/instances.size();
        average=average/instances.size();
        result+="\nNumber of instances = "+instances.size();
         result+="\nMax distance: "+max;
         result+="\nMin distance: "+min;
         result+="\nAverage distance: "+average;
         result+="\n\n--------------------------------";
         result+="\n";
         result+=res;
         result+="\n\n";

     return result;
    }
    

}
