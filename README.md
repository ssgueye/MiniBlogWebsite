# TP Web-Serveur

## Généralités :

### Objectifs :
* Faire un mini-blog
    * Fonctionnalités... fonctionnelles :
        * Gestion des articles en CRUD (Create, Read, Update, Delete)
            * Titre, contenu, auteur, date de création ( + ce que vous voulez)
        * Système de commentaire en CRUD
            * Contenu, auteur, date de création, article associé ( + ce que vous voulez)
        * Gestion des utilisateurs (pas forcément en CRUD, à vous de voir ce qui est utile)
            * Nom d'utilisateur, mot de passe, isAdmin, isBanned ( + ce que vous voulez)
            * Merci de hasher le mot de passe en base !
        * Règles d'utilisation :
            * Seul un administrateur peut créer/éditer/supprimer un article
            * Un membre banni ne peut pas créer de commentaire
            * Seuls les personnes connectées peuvent envoyer un message
    * Fonctionnalités techniques :
        * Respect des verbes HTTP & des codes retour HTTP
        * Authentification (sans partir sur un truc super compliqué)
        * Persistance de la donnée
        * Interface utilisateur "conviviale" (une GUI)
        * Session sans état (pas de session côté serveur)
    * Et si vous avez du temps :
        * Fonctionnel :
            * Gérer des réponses à des commentaires (voir les sites LinuxFR ou 20Minutes pour des exemples)
            * Lister les articles d'un auteur
            * Ajouter un système de tag et de recherche par tag sur les articles
        * Technique :
            * Négociation de contenu (par exemple, ajoutez la possibilité de pouvoir récupérer & envoyer des données en JSON ou en XML)
            * Cache client et/ou serveur (et si vous ne pouvez pas le faire pour des raisons techniques, expliquez votre démarche)

### Règles du jeu
* Travail seul ou en binôme 
* Vous avez le droit de reprendre l'exemple fourni pour travailler... Ou repartir sur une base différente.
    * Vous pouvez choisir votre/vos langage(s) :
        * Pas de framework "haut-niveau"/"qui fait tout" : Laravel, Spring, Symphony etc sont à bannir
        * Java, Golang (<3), Node.js, Python, PHP, Golo, Vert.x, ...
        * Évitez les langages ésothériques et/ou volontairement stupides (Brainfuck, Whitespace, Befunge, et globalement tout ce qui est listé sur [https://esolangs.org/wiki/Language_list](https://esolangs.org/wiki/Language_list))
        * Pour le front : Soit du HTML/CSS classique, mais vous pouvez ajouter du JS ou utiliser un Framework (Vue.js, Angular, etc).
    * Vous pouvez choisir un SGBD autre que H2
        * Relationnel : MariaDB, MySQL, Postgres, SQLite, Oracle (non je rigole, ne prenez pas Oracle), ...
        * Document : MongoDb, RethinkDb, ...
    * Architecture MVC (comme dans le cours), ou micro-service, vous décidez :
        * Après tout, si vous aimez souffrir, pourquoi vous en empêcher ?
        * Si vous partez sur du micro-service, vous avez le droit de tricher en ajoutant des headers pour désactiver le CORS
        * Je suis ouvert à toute autre idée d'architecture loufoque, tant que vous pouvez la justifier !

### Travail à rendre :
* Du code (ça semble logique mais bon)
* Un court rapport
    * Pour indiquer les technologies utilisées et pourquoi vous les avez utilisées
    * Pour indiquer comment démarrer votre/vos programme(s)
    * Si vous avez eu du mal sur certains points, n'hésitez pas à l'indiquer
    * **Tout le monde doit justifier ses choix technos, même si vous utilisez l'exemple**

### Par où commencer ?

C'est, pour beaucoup, votre premier "vrai" projet un peu consistant. En général, on peut vite se sentir déborder par la liste de travail à faire. Voici quelques conseils pour ne pas s'égarer :

* Définissez vos choix technologiques : Quelle base de données ? Quelle architecture ? Quel code pour le serveur ? Si vous n'avez vraiment pas d'idée ou que vous stagnez, n'hésitez pas à demander de l'aide !
* Définissez ensuite votre modèle de données (avec UML, MCD, etc) : Comment structure l'information dans votre base de données, et dans votre programme ?
* Ensuite, il vous faudra définir les adresses sur lesquelles les ressources seront disponibles : où créer un article ? où récupérer la liste d'article ? etc
* Une fois ces trois étapes effectuées, vous aurez réalisé votre **cadrage fonctionnel**. L'heure sera donc venue de passer au code.
* Le plus simple sur cette partie est de fonctionner en "oignon-inversé" : on fait les strates les plus basses, et on remonte :
    * On commence par faire nos connexions à la base de données, nos tables, et nos entités
    * Puis, on va créer le code qui permet de récupérer un objet, vérifier ses critères, l'enregistrer/le modifier dans la base, etc
    * Ensuite, on s'occupe des contrôleurs (MVC et API), qui permet à l'utilisateur d'interagir via un navigateur Web ou via API
    * Enfin, on s'occupe de l'authentification

**Pour information, vous n'arriverez pas à faire du REST via l'interface Web : il existe de trop nombreuses limitations (par exemple, les navigateurs Web ne savent faire que du GET et du POST). Il est donc inutile de perdre trop de temps sur la "RESTisation" de cette partie. Focalisez vos efforts sur la partie API, avec la négociation de contenu, le respect du principe de collection, les codes HTTP, etc.**

## (Entre)Aide & Fonctionnement du cours
En raison de la pandémie de COVID-19 et de la fermeture du campus universitaire, les mesures suivantes ont été prises :

* Les cours n'auront pas lieu en synchrone : Avoir 34 personnes posant des questions en même temps est contre-productif.
* En lieu et place, une session de question-réponse aura lieu chaque mardi et jeudi, de 18h00 à 19h00, sur [https://visio.be-ys-and-you.com/QuestionsL3WS](https://visio.be-ys-and-you.com/QuestionsL3WS) 
* Vous pouvez poser toutes vos questions sur [https://ent.uca.fr/moodle/mod/forum/view.php?id=483797&forceview=1](https://ent.uca.fr/moodle/mod/forum/view.php?id=483797&forceview=1). Cela permet de faire bénéficier des réponses à tout le monde !
* Si vous pensez que la question est trop liée à votre code ou trop "sensible", vous pouvez envoyer un mail : [Florian.Forestier@etu.uca.fr](Florian.Forestier@etu.uca.fr) 

## Exemple ci-joint

L'exemple ci-joint vous offre une base pour débuter : Un contrôleur (la récupération de la liste des articles en mode MVC), un objet Article, une connexion à la base de données.

L'exemple utilise :

* FreeMarker pour le templating
* SparkJava pour le serveur Web
* Une base de données H2

Vous pouvez le démarrer avec la commande `./gradlew run`.

## Ressources & documentation utile :
* Le cours de Yannick Loiseau, bien évidemment ! À retrouver sur votre Moodle.
* [https://www.baeldung.com/jackson-xml-serialization-and-deserialization](https://www.baeldung.com/jackson-xml-serialization-and-deserialization)
* [https://www.baeldung.com/jackson-object-mapper-tutorial](https://www.baeldung.com/jackson-object-mapper-tutorial)
* [https://stackoverflow.com/questions/41319853/java-spark-framework-can-not-set-or-read-cookie](https://stackoverflow.com/questions/41319853/java-spark-framework-can-not-set-or-read-cookie)
* [https://jwt.io/introduction/](https://jwt.io/introduction/)
* [https://freemarker.apache.org/docs/ref_builtins_string.html](https://freemarker.apache.org/docs/ref_builtins_string.html)
* Et en général, Google est votre ami... (ou Lycos, si vous êtes vieux).
* Et, comme pour le Génie Logiciel, il y aura probablement des vidéos qui sortiront au fur et à mesure.

Bon courage à toutes et tous !
