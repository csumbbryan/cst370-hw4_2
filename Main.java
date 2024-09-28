/*
 * INSTRUCTION:
 *     This is a Java staring code for hw4_2.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Abstract: Describe the main ideas of the program.
 * Name: Write your name
 * Date: MM/DD/YYYY
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nodeCount = Integer.parseInt(scanner.nextLine());
        int edgeCount = Integer.parseInt(scanner.nextLine());
        ArrayList<List<Integer>> adjList = new ArrayList<>();

        //Read input and create adjacency list
        for (int i = 0; i < edgeCount; i++) {
            String line = scanner.nextLine();
            String[] strArr = line.split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);
            adjList.add(new ArrayList<>());
            adjList.get(node1).add(node2);
        }

        System.out.println(adjList);

        //Create initial in degree array

        ArrayList<Integer> inDegree = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            inDegree.add(0);
        }
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0 ; j < adjList.get(i).size(); j++) {
                inDegree.set(adjList.get(i).get(j), inDegree.get(adjList.get(i).get(j)) + 1);
            }
        }

        System.out.println(inDegree);

        // Develop your program here.
        // The following is just a sample statement and and you need to replace it with your code

        //Two Data Structures
        // "In Degree" - array of size = number of nodes
        // Number of edges coming into a node

        // Queue - store nodes in topological order

        // During each iteration - remove 1 node with 0 in degree from queue
        // Update in degree based on number of incoming edges after removal
        // If in degree is 0, add to queue
        // After all nodes have been added and removed from queue, job completed
    }
}

