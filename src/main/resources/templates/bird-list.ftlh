<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/style.css" />
    <title>Some Good Birds</title>

</head>

<body>
<h1>Some good birds, According to Veronica Nahser</h1>
<nav class="navbar">
    <ul>
        <li><a href="/birds/all">Home</a></li>
        <li><a href="/birds/about">About</a></li>
        <!--<li><a href="/birds/details">Details</a></li>-->
        <li><a href="/birds/new">New Bird</a></li>
        <!-- <li><a href="/birds/update">Update Bird</a> </li>-->
    </ul>
</nav>

<main>
<!--    <img-->
<!--            src="https://upload.wikimedia.org/wikipedia/commons/5/56/Harpia_harpyja_-Sao_Paulo_Zoo%2C_Brasil_-adult-8a.jpg"-->
<!--            alt="Adult Harpy Eagle, Sao Paulo Zoo"-->
<!--    /><br />-->
<!--    <pre>-->
<!--            The Harpy Eagle is native to Central and South America, and it is one of the largest living species of eagle.-->
<!--            It typically inhabits the upper canopy of lowland rainforests, and environment loss has lead to it nearly vanishing from much of Central America.<br>-->
<!--        </pre>-->
<!--    <img-->
<!--            src="https://upload.wikimedia.org/wikipedia/commons/9/97/Osprey_mg_9605_%28cropped%29.jpg"-->
<!--            alt="American Osprey"-->
<!--    /><br />-->
<!--    <pre>-->
<!--            Ospreys are an order of large, fish-eating raptors.-->
<!--            Although they are found on all continents except Antarctica, Ospreys only have four recognized subspecies and are classified as a single species.<br>-->
<!--        </pre>-->
<!--    <img-->
<!--            src="https://upload.wikimedia.org/wikipedia/commons/5/50/Corvus_corax_ad_berlin_090516.jpg"-->
<!--            alt="Corvus Corax, Berlin"-->
<!--    /><br />-->
<!--    <pre>-->
<!--            Ravens are widely believed to be the best birds of all time, because of how cool they are. <a href="details.html" >[Learn More!]</a><br />-->
<!--            <br>-->
<!--        </pre>-->
<!--    <img-->
<!--            src="https://upload.wikimedia.org/wikipedia/commons/f/fa/Shrike_Loggerhead_JG.jpg"-->
<!--            alt="Loggerhead Shrike"-->
<!--    /><br />-->
<!--    <pre>-->
<!--            The Loggerhead Shrike is a small predatory bird and it is the only shrike native to North America.-->
<!--            Because of their small size, they are known for impaling their prey on spikes or thorns to hold it in place while they eat.<br>-->
<!--        </pre>-->
<!--    <img-->
<!--            src="https://upload.wikimedia.org/wikipedia/commons/8/85/Common_Hill-Myna.jpg"-->
<!--            alt="Common_Hill-Myna"-->
<!--    /><br />-->
<!--    <pre>-->
<!--            The Common Hill-Myna, sometimes called the Hill Myna or Mynah Bird, is a type of Starling native to South and Southeast Asia.-->
<!--            They are a popular "Talking Bird", being able to mimic many everyday sounds with accuracy and clarity not typically attributed to-->
<!--            other talking birds, such as parrots and corvids.<br>-->
<!--        </pre>-->
    <div class="container">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Family</th>
                <th>Species</th>
                <th>Actions</th>
            </tr>
            <#list birdList as bird>
            <tr>
                <td>${bird.birdId}</td>
                <!--    <td><a href="/birds/${bird.birdId}">${bird.birdId}</a></td> -->
                <td>${bird.name}</td>
                <td><a href="/birds/family/${bird.family}">${bird.family}</a></td>
                <td><a href="/birds/details/${bird.birdId}">${bird.species}</a></td>
                <td>
                    <a href="/birds/update/${bird.birdId}" class="btn btn-secondary">update</a>
                    <a href="/birds/delete/${bird.birdId}" class="btn btn-danger">delete</a>
                </td>
            </tr>
            </#list>
        </table>
    </div>
</main>
</body>
</html>
