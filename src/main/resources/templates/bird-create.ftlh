<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../static/css/style.css" />
    <title>Create a new bird</title>
</head>
<body>
<h1>New Bird</h1>
<nav class="navbar">
    <ul>
        <li><a href="bird-list.ftlh">Home</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="bird-details.ftlh">Details</a></li>
        <li><a href="bird-create.ftlh">New Bird</a></li>
        <li><a href="bird-update.ftlh">Update Bird</a> </li>
    </ul>
</nav>
    <form id="new-bird" action="localhost:8080/birds/new" method="post">

        <label for="name">Bird name: </label><input type="text" id="name" name="name"><br/>
        <label for="family">Family: </label><input type="text" id="family" name="family"><br/>
        <label for="species">Species: </label><input type="text" id="species" name="species"><br/>
        <label for="description">Description: </label><textarea type="text" id="description" name="description"></textarea><br/>
        <input type="reset"><br/>
        <input type="submit">

    </form>
</body>
</html>