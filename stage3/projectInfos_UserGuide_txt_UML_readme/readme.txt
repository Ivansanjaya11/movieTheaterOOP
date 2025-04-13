Running this system on Terminal (we used Windows Powershell) requires a two-step process,
starting from the project repository root, write the following:
1. Compilation:
    javac -d out stage3\*.java stage3\util\*.java
2. Running:
    java -cp out Main