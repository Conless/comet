.PHONY: all
all: Compiler

.PHONY: Compiler
Compiler:
	mvn package
	mkdir -p bin
	cp target/*.jar bin/
	echo 'java -jar comet-0.1.0-alpha.jar' > bin/mxc
