# ICP_Individual-Project
This program takes two locations in the world and finds the route between the two of them with the least amount of flights. It uses three data files from https://openflights.org/data.html - the airports, routes and airlines csv files. It makes use of eight classes: Airport class - This class creates an Airport object Airlines class- This class creates an Airlines object Routes class- This class creates a Routes object

Problem class - The Problem class represents the route finding problem to be solved, and its constructor takes in the starting and destination states. It has a method to check if a state is the destination and another method to generate all the airports that are reachable from a current state.

Node class - The Node class initializes a node object with an airport state, a parent node, a Route object to represent the action that was taken to get to the state and an initial path cost of zero which increases with every action taken. In this context, the path cost represents the number of flights taken to get to the destination, which is the optimization criteria for this program. The Node class has a method which generates the final solution path of actions taken to arrive at the destination.

ReadFile class - The ReadFile class essentially reads from each of the data files and assigns the values to respective hashmaps to allow easier accessing of the objects. It also has a method to read the input file and it stores the data in the file into source and destination String variables to be further used by the Problem class as starting and destination states

RouteFinding class - The RouteFinding class implements a breadth first algorithm on a Problem object passed into the method and returns the solution path. It also has a method which uses the solution path returned by the breadth first search method to write the path results to a file. The class also has a method to retrieve the file name from an absolute path where necessary, to aid in the naming of the corresponding output file.

Main class - The program is run from this class. Here, the paths to the input file and the data files to be read from are passed into the program.

To run the program, you must download the project and run the Main class. If you want to try other sources and destinations, create a txt file with the city and country of both the source and destination airports, and name it in the format "sourcecity-destinationcity".txt. An example input file named 'accra-winnepeg.txt' is in the folder and can serve as a template.
