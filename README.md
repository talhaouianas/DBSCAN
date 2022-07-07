# DBSCAN

DBSCAN a été proposé par Martin Ester et al. En 1996.Le DBSCAN est un algorithme de segmentation par densité qui fonctionne sur l'hypothèse que les clusters sont des zones denses dans l'espace séparées par des zones de plus faible densité.
Il regroupe les points de données d’une zone dense dans un seul cluster.
Le DBSCAN est caractériser par sa robustesse aux valeurs aberrantes et qu’Il ne nécessite pas que le nombre de clusters soit indiqué à l'avance, contrairement à K-Means, où nous devons spécifier le nombre de centroïdes.

# l'algorithme à les éléments clefs suivants:

● Epsilon (ou bien rayon): une distance qu’on spécifie, elle représente le rayon où on peut chercher les voisins d’un point donné.

● Minimum (m): une valeur qu’on spécifiée, elle représente le nombre minimal de voisins qu’on doit avoir pour classifier un point comme core.

● un point core: un point qui a plus de m voisins.

● un point frontière: un point voisin d’un point core.

● un point bruit: un point qui n’est pas au voisinage d’un point core, et qui n’a pas m> de voisins.

● accessibilité: on dit que b est accessible par a, et on note a>b, si b est un voisin de a (la distance entre a et b est inférieure à epsilon.

● connectivité: on dit que a et b sont connectés si on a: a>p1>p2>...>pn>b

# Comment est cet algorithme différent:

on comparant cet algorithme a K-means, on trouve les différences suivantes:

● Contrairement à K-means, DBSCAN n’a pas besoin de segmenter tous les points, les points qui sont loins des autres sont classifiés comme bruit.

● K-means a besoin de savoir à combien on veut séparer nos données, DBSCAN non.

● DBSCAN a une meilleur habilité de détecter des grappes de formes aléatoires, comme on voit dans la figure ci dessous.

# Étapes de l'algorithme DBSCAN:

1. L'algorithme commence par un point arbitraire qui n'a pas été visité et ses informations de voisinage sont extraites du paramètre ϵ. 
2. Si ce point contient MinPts dans le voisinage ϵ, la formation de cluster commence. Sinon, le point est étiqueté comme bruit. Ce point peut être trouvé plus tard dans le voisinage ϵ d'un point différent et peut donc faire partie du cluster.
3. Si un point s'avère être un point central, les points situés dans le voisinage ϵ font également partie du cluster. Ainsi, tous les points trouvés dans le voisinage ϵ sont ajoutés, ainsi que leur propre voisinage ϵ, s'ils sont également des points centraux.
4. Le processus ci-dessus se poursuit jusqu'à ce que le cluster connecté par densité soit complètement trouvé.
5. Le processus redémarre avec un nouveau point qui peut faire partie d'un nouveau cluster ou étiqueté comme bruit.

# Pour calculer la distance entre le mot on utiliser Algorithme de levenshtein:
cette algorithme nous permet de calculer la distance entre deux chaînes de caractères, des mots, noms etc mais pas des phrases. Cette fonction prends deux chaînes de caractères, elle retourne 0 si ils sont identique, si non le nombre minimum de modifications (ajout, suppression ou substitution d’un caractère ) requis pour les rendre identiques.

# Exemple

la distance entre HONDA et HYUNDAI est égale à 3.

avec HYUNDAI on supprime Y, on substitue U par O, finalement on supprime I.

ou bien, avec HONDA, on ajoute Y, on substitue O par U, on ajoute I.

# Sources

Pseudocode of the DBSCAN algorithm :

https://www.researchgate.net/figure/Pseudocode-of-the-DBSCAN-algorithm_fig2_325059373

Algorithme de levenshtein:

https://www.youtube.com/watch?v=O8w9c20OIyg




