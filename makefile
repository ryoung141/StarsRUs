default: project

project: backend frontend

frontend:
	javac ./src/frontend/*.java -d ./bin/.

backend: 
	# javac ./src/backend/*.java -d ./bin/.
	# javac ./src/backend/backend/models/*.java -d ./bin/.
	# javac ./src/backend/backend/controllers/*.java -d ./bin/.
	# javac -cp .:/src/backend ./src/backend/models/*.java -d ./bin/
	javac -cp .:/src/backend ./src/backend/*.java -d ./bin/

# controllers: 
	# javac -cp .:/src/backend ./src/backend/controllers/*.java -d ./bin/

clean:
	rm ./bin/*.class