<#ftl encoding="utf-8">
<head>
    <link rel="stylesheet" href="style.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <title>MY Blog </title>
</head>

<body xmlns="http://www.w3.org/1999/html">
    <nav>
        <ul class = "menu">
            <li class="current"><a href = "/"> Blogs </a>
            </li>
            <li> <a href = "/inscription"> Inscription </a> 
            </li>
            <li> <a href = "/connexion"> Connexion </a></li>
        </ul>
        
    </nav>

    <#list articles as article>
        <div class = "art">
            <h2><span class="article_id">#${article.id}</span> ${article.name}</h2>
            <p>${article.content}</p>
            <strong><p class="author">Rédigé par ${article.author}
                le ${article.created_time}</p></strong>

            <details>
                <summary style ="color:blue">Lire les commentaires</summary>
            <p>
            <#list article.comment as comments>

            <strong><span class="comment_id">${comments.author}</span></strong><br>
            ${comments.content}</p>
        
            <p style = "font-style: italic">${comments.created_time}</p>
            
            </#list>
            
            </details>
            </p>
        </div>
            
    </#list>


    <footer class = "menufooter">
        <ul class = "menu">
            <li class="current"><a href = "/"> Blogs </a>
            </li>
            <li> <a href = "/inscription"> Inscription </a> 
            </li>
            <li> <a href = "/connexion"> Connexion </a></li>
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
