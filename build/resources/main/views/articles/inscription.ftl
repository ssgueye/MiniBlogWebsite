<#ftl encoding="utf-8">
<head>
    <link rel="stylesheet" href="style.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>My Blog</title>
</head>
<body xmlns="http://www.w3.org/1999/html">
    <nav>
        <ul class = "menu">
            <li><a href = "/"> Blogs </a>
            </li>
            <li class="current"> <a href = "inscription"> Inscription </a> 
            </li>
            <li> <a href = "connexion"> Connexion </a></li>
        </ul>
    </nav>

    <p><h2>Veuillez vous inscrire...</h2></p>

    <form  id="connexion" name="connexion" method="POST" action="/register" >
        <div class="news">
            <div class="mb-3">
                <label class = "form_col" for="name">Nom:</label><br> <input type="text" name="name" id="name" placeholder = "GUEYE" required>
			</div>
            <div class="mb-3">
                <label class = "form_col" for="prenom">Prénom:</label><br> <input type="text" name="prenom" id="prenom" placeholder = "Serigne Saliou" required>
			</div>
            <div class="mb-3">
                <label class = "form_col" for="email">E-mail:</label><br> <input type="email" name="email" id="email" placeholder = "ssgueye@gmail.com" required>
			</div>

            <div class="mb-3">
                <label class = "form_col" for="user_name">Nom d'utilisateur:</label><br> <input type="text" name="user_name" id="user_name" placeholder = "ssgueye" required>
			</div>
            <div class="mb-3">
                <label class = "form_col" for="password">Mot de passe:</label><br> <input type="password" name="password" id="password" required>
            </div>

            <button type="submit" class="btn btn-primary">S'inscrire</button>
       
        </div>
        
    </form>

    <footer class = "menufooter">
        <ul class = "menu">
            <li><a href = "/"> Blogs </a>
            </li>
            <li class="current"> <a href = "inscription"> Inscription </a> 
            </li>
            <li> <a href = "connexion"> Connexion </a></li>
        </ul>

        <a href="#"><img  width= "40" height= "40" src="https://www.ain-krav-maga.fr/wp-content/uploads/2018/09/logo-facebook.png" alt="logo-facebook">
        </a> 
        <a href="#"><img  width= "40" height= "40" src="https://png.pngtree.com/element_our/md/20180518/md_5aff6089d3e02.png" alt="logo">
        </a> 
        <a href="#"><img  width= "40" height= "40" src="http://www.ose-france.org/wp-content/uploads/2019/02/Logo-Twitter-rond.png" alt="logo">
        </a> 
        <a href="#"><img  width= "40" height= "40" src="https://followmyvote.com/wp-content/uploads/2015/06/linkedin-logo.png" alt="logo">
        </a> 
        <a href="#"><img  width= "40" height= "40" src="https://png.pngtree.com/element_our/md/20180506/md_5aeee59ed7b9c.png" alt="logo">
        </a> 
            <br> 
        <a href="#"><img  width= "100" height= "40" src="http://www.salonsimi.com/wp-content/uploads/2018/11/APP-STORE.png" alt="logo">
        </a> 
        <a href="#"><img  width= "100" height= "40" src="https://i.imgur.com/YIeI1BU.png?1" alt="logo">
        </a>
        <p class ="copyright"><strong>©Copyright My Blog 2020 - All right reserved</strong>
        </p>

    </footer>

</body>

</html>

