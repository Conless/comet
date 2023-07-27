# Overview
## File Structure
This project is built by maven, so my source file is under [```src/main/```](src/main/). It contains the ```.g4``` grammar sources (under ```src/main/antlr```) and java sources (under ```src/main/java/dev/conless/comet```).

The main source code of the project is [```Compiler.java```](src/main/java/dev/conless/comet/Compiler.java), which calls functions in frontend and backend of the compiler, written in ```frontend/``` and ```backend/```.