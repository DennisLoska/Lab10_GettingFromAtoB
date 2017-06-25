# Lab Report - Exercise 10: Getting from A to B
_Authors: Dennis Loska, Bernhard Zaborniak, Tony Dorfmeister, 20.06.2017_
<!--  PRELAB not requiered -->
## Assignment

## 1. Design and implement a data type WeightedGraph that uses either an adjacency list or an adjacency matrix. How are you going to store the weights?

Wir sind dem Beispiel von alexander gefolgt, die weights haben wir als parameter der Edges-klasse gespiechert

## 2. While one partner is doing this, the other one should write a class that reads a graph from a file. See notes on the file format and the example file below!

Die Syntax  source firstDesinationNode,weightTithis secondDestination,weight  ...und so weiter lasen wir in unserem programm mit dem String Tokenizer in der Mainmethode ein. Um das einlesen hat sich eine seperate Klasse gekümmert- der eingelesene String wird dam dem GraphenKonstruktor als parameter eingegeben. Beim erstellen des graphen wird er basierend auf der textdatei erstellt. Mit dem richtigen Syntax funktionierte dies gut beim Testen

## 3. Now write a method that will take a graph and two vertices and find the shortest path between the vertices. Make a method to print out the path in a readable format. What class will these methods belong to?

Der Djkstra alghorythmus ist bei uns eine Methode in der graphenklasse. Dieser besteht aus 2 Teilen. Zuerst markieren wir alle Vertices ausser unseren Anfang als "unvisited" - diers ist ein boolean Parameter in der vertex Klasse und wir geben jedem Vertex ausser unserem Anfang den Distance-Wert unendlich - ebenfalls ein Feld, die unentlichkeit schreiben wir fälschlicherweise mit der Integer.MAX_Value Methode.

Der zweite Teil ist es den ganzen graphen zu durchgehen und die Distance-Values verkleinern, falls dies möglich ist. Nach diesem Schritt kann man sich ein ZeilVertex aussuchen und der Distance-Wert, den dieser hat ist die kleinste Entfernung zwischen dem start zu diesem vertex.

Um den kürzesten Weg genau rauszufinden, haben wir den Alghorythmus leider noch nicht so weit. 

## 4. Meanwhile, your partner writes a method that takes a graph, picks two vertices at random, and finds the cheapest path between the two.

## 5. Starting from S Schöneweide Bhf (Berlin) compute the shortest travel times to the 4 Stations below.
