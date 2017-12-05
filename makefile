default: project

project: backend frontend

frontend:
	javac -cp .:/src/frontend:/src/backend ./src/frontend/*.java -d ./bin/.

backend: 
	javac -cp .:/src/backend:/src/lib/mysql-connector-java-5.1.45-bin.jar ./src/backend/*.java -d ./bin/

clean:
	rm ./bin/*.class