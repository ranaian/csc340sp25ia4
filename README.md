# Birds API
## Description
simple CRUD API for Bird objects
### Version
1.0

## API Endpoints:

base URL: [`http://localhost:8080/birds`](http://localhost:8080/birds)

### [`/all`](http://localhost:8080/birds/all) (GET)
gets a list of all birds in the database

#### Response: a JSON array of bird objects
```
[
    {
        "birdId": 1,
        "name": "Hypothetical Pigeon",
        "description": "a bird that may or may not exist",
        "family": "Columbidae",
        "species": "Columba Livia Hypothetical"
    },
    {
        "birdId": 2,
        "name": "Theoretical Pigeon",
        "description": "a bird that could exist",
        "family": "Columbidae",
        "species": "Columba Livia Theoretical"
    },
    {
        "birdId": 3,
        "name": "Common Raven",
        "description": "A large black corvid",
        "family": "Corvidae",
        "species": "Corvus Corax"
    },
    {
        "birdId": 4,
        "name": "Probable Eagle",
        "description": "Actually an Osprey, a species of predatory bird unrelated to Eagles and Hawks",
        "family": "Pandionidae",
        "species": "Pandion Haliaetus"
    }
]
```
### [`/{birdId}`](http://localhost:8080/birds/1) (GET)
Gets an individual bird. Each bird in the database is automatically assigned a numerical `birdId`
#### Parameters
- Path Variable: `birdId` &lt;integer&gt; - Required

##### Response - a single bird
```
{
    "birdId": 1,
    "name": "Hypothetical Pigeon",
    "description": "a bird that may or may not exist",
    "family": "Columbidae",
    "species": "Columba Livia Hypothetical"
}
```

### [`/name`](http://localhost:8080/birds/name?search=Pigeon) (GET)
gets a list of birds whose names contain the given string
#### Parameters
- Path Variable: `name` &lt;String&gt; - Required

#### Response - a list of birds
```
[
    {
        "birdId": 1,
        "name": "Hypothetical Pigeon",
        "description": "a bird that may or may not exist",
        "family": "Columbidae",
        "species": "Columba Livia Hypothetical"
    },
    {
        "birdId": 2,
        "name": "Theoretical Pigeon",
        "description": "a bird that could exist",
        "family": "Columbidae",
        "species": "Columba Livia Theoretical"
    }
]
```

### [`/family/{family}](http://localhost:8080/birds/family/Columbidae) (GET)
gets a list of birds belonging to the same given scientific family
#### Parameters
- Path Variable: `family` &lt;String&gt; - Required

#### Response - a list of birds
```
[
    {
        "birdId": 1,
        "name": "Hypothetical Pigeon",
        "description": "a bird that may or may not exist",
        "family": "Columbidae",
        "species": "Columba Livia Hypothetical"
    },
    {
        "birdId": 2,
        "name": "Theoretical Pigeon",
        "description": "a bird that could exist",
        "family": "Columbidae",
        "species": "Columba Livia Theoretical"
    }
]
```

### [`/new`](localhost:8080/birds/new) (POST)
creates a new Bird object. Make it a good one!
#### Request Body
A Bird object. The birdId variable is automatically assigned and not included in the request
```
{ "name": "American Crow",
"family": "Corvidae",
"species": "Corvus Brachyrhyncos",
"description": "A large corvid with all-black plumage and iridescent feathers"
}
```
#### Response
The updated list of Birds
```
[
    {
        "birdId": 1,
        "name": "Hypothetical Pigeon",
        "description": "a bird that may or may not exist",
        "family": "Columbidae",
        "species": "Columba Livia Hypothetical"
    },
    {
        "birdId": 2,
        "name": "Theoretical Pigeon",
        "description": "a bird that could exist",
        "family": "Columbidae",
        "species": "Columba Livia Theoretical"
    },
    {
        "birdId": 3,
        "name": "Common Raven",
        "description": "A large black corvid",
        "family": "Corvidae",
        "species": "Corvus Corax"
    },
    {
        "birdId": 4,
        "name": "Probable Eagle",
        "description": "Actually an Osprey, a species of predatory bird unrelated to Eagles and Hawks",
        "family": "Pandionidae",
        "species": "Pandion Haliaetus"
    },
    {
        "birdId": 5,
        "name": "American Crow",
        "description": "A large corvid with all-black plumage and iridescent feathers",
        "family": "Corvidae",
        "species": "Corvus Brachyrhyncos"
    }
]
```

### [`/update/{birdId}(http://localhost:8080/birds/update/1) (PUT)
Update an existing Bird

#### Parameters
- Path Variable `birdId` &lt;Integer&gt; - Required

#### Request Body
a Bird object with the desired updates
```
{
    "name": "Hypothetical Pigeon",
    "description": "a bird that might or might not exist",
    "family": "Columbidae",
    "species": "Columba Livia Hypothetical"
}
```
#### Response
The updated Bird object
```
{
    "birdId": 1,
    "name": "Hypothetical Pigeon",
    "description": "a bird that might or might not exist",
    "family": "Columbidae",
    "species": "Columba Livia Hypothetical"
}
```

### [`/delete/{birdId}`](http://localhost:8080/birds/delete/4) (DELETE)
Delete an existing bird (you monster)

#### Parameters
- Path Variable `birdId` &lt;Integer&gt; - Required

#### Response 
The updated list of Birds
```
[
    {
        "birdId": 1,
        "name": "Hypothetical Pigeon",
        "description": "a bird that might or might not exist",
        "family": "Columbidae",
        "species": "Columba Livia Hypothetical"
    },
    {
        "birdId": 2,
        "name": "Theoretical Pigeon",
        "description": "a bird that could exist",
        "family": "Columbidae",
        "species": "Columba Livia Theoretical"
    },
    {
        "birdId": 3,
        "name": "Common Raven",
        "description": "A large black corvid",
        "family": "Corvidae",
        "species": "Corvus Corax"
    },
    {
        "birdId": 5,
        "name": "American Crow",
        "description": "A large corvid with all-black plumage and iridescent feathers",
        "family": "Corvidae",
        "species": "Corvus Brachyrhyncos"
    }
]
```
