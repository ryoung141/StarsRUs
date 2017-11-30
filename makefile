default: project

project: backend frontend

frontend:
	javac ./src/frontend/*.java -d ./bin/.

backend: 
	javac ./src/backend/*.java -d ./bin/.
	javac ./src/backend/models/*.java -d ./bin/.

clean:
	rm ./bin/*.class