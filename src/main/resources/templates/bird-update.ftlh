<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/style.css" />
    <title>Update an existing bird</title>
</head>
<body>
<h1>Update a Bird</h1>
<nav class="navbar">
    <ul>
        <li><a href="/birds/all">Home</a></li>
        <li><a href="/birds/about">About</a></li>
        <!--<li><a href="bird-details.ftlh">Details</a></li>-->
        <li><a href="/birds/new">New Bird</a></li>
        <!--<li><a href="bird-update.ftlh">Update Bird</a> </li>-->
    </ul>
</nav>
<form id="update-bird" action="/birds/update/${bird.birdId}" method="post">

    <label for="name">Bird name: </label><input type="text" id="name" name="name" value="${bird.name}"><br>
    <label for="family">Family: </label><input type="text" id="family" name="family" value="${bird.family}"><br>
    <label for="species">Species: </label><input type="text" id="species" name="species" value="${bird.species}"><br>
    <label for="description">Description: </label><textarea type="text" id="description" name="description" placeholder="${bird.description}"></textarea><br>
    <input type="reset"><br>
    <input type="submit">

</form>
</body>
</html>