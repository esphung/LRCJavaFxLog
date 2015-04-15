all:
	javac *.java
	jar cfm LRCQ.jar manifest.txt *.class *.css *.txt *.csv *.java *.png

run:
	java -jar LRCQ.jar

clean:
	rm -rf *.class
	rm -rf *.jar