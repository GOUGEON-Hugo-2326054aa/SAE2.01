L'objectif de la SAé est de développer un jeu d'échec similaire au jeu d'échec en ligne disponible sur le site https://www.chess.com/. L'interface graphique de l'application devra le plus possible respecter l'interface du site web (couleurs, polices, mise en page, etc.).

Pour simplifier, vous implémenterez uniquement les règles de déplacements des différentes pièces. 

L'application devra permettre de jouer contre un autre joueur "humain" sur la même machine, à tour de rôle (contrairement au site qui permet de jouer en ligne). Tous comme sur le site, vous donnerez la possibilité aux utilisateurs d'intégrer différentes limites de temps. Si le joueur dépasse cette limite de temps, une de ses pièces sera déplacée au hasard (mais sur une position valide). 

jeu mode solo

L'application devra permettre d'enregistrer les joueurs dans un fichier. Elle devra conserver pour chaque joueur le nom, le prénom, le nombre de parties jouées, et le nombre de parties gagnées. Ces statistiques seront accessibles dans l'interface de l'application.

Les parties seront aussi enregistrées (dans un fichier). Les joueurs pourront ainsi consulter leurs précédentes parties à partir de l'interface. Par ailleurs, une partie en cours pourra  être mise en pause (i.e. enregistrée dans un fichier temporaire), et rechargée plus tard par les joueurs afin d'être continuée. 

Vous intègrerez un mode "tournoi" permettant de s'affronter à plusieurs. Il s'agira d'un tournoi à élimination directe, comme illustré dans la figure suivante.

Tournoi à élimination direct avec 8 joueurs

L'application devra permettre de jouer seul "contre l'ordinateur". Pour cela, vous pourrez par exemple implémenter dans un premier temps un "bot" basique faisant aléatoirement des coups valides.

Au delà des aspects purement fonctionnels, votre application devra être développée en JavaFX et mettre en pratique toutes les techniques permettant de garantir la qualité du code. Ainsi, le code devra être commenté, versionné et documenté. Pour cela, vous utiliserez Javadoc et GitHub. L’architecture du code devra aussi mettre en avant la séparation entre l’interface graphique et le noyau de l’application. Pour cela, vous vous documenterez sur l’architecture MVC et essaierez de la mettre en place. Vous ferez de même pour les bonnes pratiques en matière d’ergonomie des interfaces graphiques. Pour ces deux derniers points, vous devrez donc faire un peu de recherche bibliographique. Dans votre rapport, vous veillerez donc à bien citer vos sources pour appuyer votre argumentaire.
Livrables
Evaluation de la SAé (coefficient 38) :

Code commenté et documenté (Javadoc) avec tests unitaires implémentés via un lien GitHub

Rapport (au format PDF) décrivant :
Le modèle MVC et les bonnes pratiques en ergonomie

Les diagrammes d’analyse et de conceptions, en justifiant de l’architecture du code finalement implémentée

Les maquettes graphiques réalisées (wireframes ou mockups)

La politique de tests implémentée, leur nombre et leur couverture

Les fonctionnalités implémentées pour répondre au besoin client

L’organisation de l’équipe, la répartition des tâches entre les membres et le pourcentage du projet réalisé par chacun

Présentation orale de 10 minutes avec 5 minutes de questions