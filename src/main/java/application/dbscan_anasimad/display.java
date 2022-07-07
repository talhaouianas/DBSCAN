package application.dbscan_anasimad;

import java.io.IOException;
import java.util.Arrays;
/*Cette classe display est utilisée pour l'affichage des résultats du dbscan */
public class display {
    public static String[] afficher(String link, String distance_func, double epsilon, double minpoints) throws IOException, Exception {

        String tab1 = "";
        String tab2 = "";
        String tab3 = "";
        String tab4 = "";


        Data dt = new Data(link);

        tab2 += (dt.affichage_distances(distance_func));

        DBSCAN db = new DBSCAN();

        tab1 += (db.dbscan(dt, epsilon, minpoints, distance_func)) + "\n\n";

        tab1 += ("           SUMMARY            \n\n");
        tab1 += (">> FOUND  " + db.clusters.size() + " clusters\n\n");

        for (int i = 0; i < db.clusters.size(); i++) {
            tab1 += (">>> Cluster id " + i + " has " + db.clusters.get(i).points.size() + " points\n");
        }

        tab1 += ("\n\n>>FOUND  " + db.noise.size() + " noise points\n");

        tab3 += ("\n           Clusters            \n\n");

        for (int i = 0; i < db.clusters.size(); i++) {
            tab3 += ("Cluster " + i + " :  (" + db.clusters.get(i).points.size() + " elements)\n\n");
            for (int j = 0; j < db.clusters.get(i).points.size(); j++) {
                tab3 += (Arrays.toString(db.clusters.get(i).points.get(j)) + "\n");
            }
            tab3 += "\n\n";
        }
        tab4 += ("\n           Noises      \n\n");
        tab4 += ("( " + db.noise.size() + " elements)\n\n");
        for (int i = 0; i < db.noise.size(); i++) {
            tab4 += (Arrays.toString(db.noise.get(i)) + "\n");

        }
        String[] tabs = {tab1, tab2, tab3, tab4};
return tabs;
    }
}
