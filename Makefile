.PHONY: all
all: Compiler

.PHONY: Compiler
Compiler:
	llc --march=risv32 src/main/c/builtIn.ll -o bin/builtIn.s
	mvn package
	mkdir -p bin
	cp target/*.jar bin/
	echo 'java -jar "$(dirname $0)/comet-0.1.0-alpha.jar"' > bin/mxc
	chmod +x bin/mxc
