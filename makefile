default: project

project: backend frontend

frontend:
	javac ./src/backend/*.java -d ./bin/.

backend: 
	javac ./src/backend/*.java -d ./bin/.

clean:
	rm ./bin/*.class