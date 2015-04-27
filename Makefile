all:
	javac *.java
	jar cfm LRCQ.jar manifest.txt *.class *.css *.txt *.csv *.java

run:
	java -jar LRCQ.jar

clean:
	rm -rf *.class
	rm -rf *.jar