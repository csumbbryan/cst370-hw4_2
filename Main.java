/*
 * INSTRUCTION:
 *     This is a Java staring code for hw4_2.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Abstract: Program accepts a graph in the form of num of nodes, edges, and edge pairs. It
 * then outputs the initial in-degree of each node, along with the topological order of the graph
 * Name: Bryan Zanoli
 * Date: 10/01/2024
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nodeCount = Integer.parseInt(scanner.nextLine().split(" ")[0]);
        int edgeCount = Integer.parseInt(scanner.nextLine());
        ArrayList<List<Integer>> adjList = new ArrayList<>();
        ArrayList<Integer> inDegree = new ArrayList<>();
        ArrayList<Integer> workingQueue = new ArrayList<>();
        ArrayList<Integer> finalQueue = new ArrayList<>();

        for (int i = 0; i < nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            String line = scanner.nextLine();
            String[] strArr = line.split(" ");
            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);

            adjList.get(node1).add(node2);
        }

        //Create initial in degree array
        for (int i = 0; i < nodeCount; i++) {
            inDegree.add(0);
        }
        for (int i = 0; i < nodeCount; i++) {
            for (int j = 0 ; j < adjList.get(i).size(); j++) {
                inDegree.set(adjList.get(i).get(j), inDegree.get(adjList.get(i).get(j)) + 1);
            }
        }

        //System.out.println(inDegree);
        for (int i = 0; i < nodeCount; i++) {
            System.out.println("In-degree[" + i + "]:" + inDegree.get(i));
        }

        //Cycle through queues
        int nodeRemaining = nodeCount;
        boolean cycleDetected = false;
        while(nodeRemaining > 0) {
            for (int i = 0; i < nodeCount; i++) {
                if (inDegree.get(i) == 0) {
                    workingQueue.add(i);
                    System.out.println("Working Queue: " + workingQueue);
                    inDegree.set(i, -1);
                    nodeRemaining--;
                }
            }
            if(nodeRemaining > 0 && workingQueue.isEmpty()) {
                cycleDetected = true;
                break;
            }
            if(!workingQueue.isEmpty()) {
            //while (!workingQueue.isEmpty()) {
                int node = workingQueue.get(0);
                System.out.println("Node: " + node);
                workingQueue.remove(0);
                finalQueue.add(node);

                System.out.println("Final Queue: " + finalQueue);
                for (int j = 0; j < adjList.get(node).size(); j++) {
                    System.out.println("Adj Node: " + adjList.get(node).get(j));
                    inDegree.set(adjList.get(node).get(j), inDegree.get(adjList.get(node).get(j)) - 1);
                }
            }
        }

        String output = "";
        if(cycleDetected) {
            output += "No Order:";
        } else {
            output += "Order:";
            for (int i = 0; i < finalQueue.size() - 1; i++) {
                output += finalQueue.get(i) + "->";
            }
            output += finalQueue.get(finalQueue.size() - 1);
        }
        System.out.println(output);
    }
}

