To run vertx rx with webclient example please have following dependencies

        Java 11 installed


Pull the latest code and run below command to compile code

        mvn clean install


After code is compiled successfully, Run the application


		java -jar target/vertx_rxwebclient-1.0-SNAPSHOT-fat.jar


Http curl Reqeust and Response

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

Happy coding :)