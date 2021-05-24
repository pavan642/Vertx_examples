Vertx webclient example

mvn clean install

java -jar target/vertx_rxwebclient-1.0-SNAPSHOT-fat.jar

curl --location --request GET 'http://localhost:8083/jokes' \
--header 'Content-Type: application/json'

{
"error": false,
"category": "Programming",
"type": "twopart",
"setup": "why do python programmers wear glasses?",
"delivery": "Because they can't C.",
"flags": {
"nsfw": false,
"religious": false,
"political": false,
"racist": false,
"sexist": false,
"explicit": false
},
"safe": true,
"id": 294,
"lang": "en"
}