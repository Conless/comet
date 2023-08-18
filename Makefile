.PHONY: all
all: Compiler

.PHONY: Compiler
Compiler:
	mvn package
	mkdir -p bin
	cp target/*.jar bin/
	chmod +x bin/mxc
