package Library;


import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arman
 */
public abstract class AbstractSearch {
    protected Collection<Node> frontier;
    public Node solve(IProblem problem){
        System.out.println("Solving...");
        frontier = initFrontier(problem);
        frontier.addAll(expand(new Node(problem.getInitialState()), problem));
        System.out.println("Starting frontier is " + frontier);
        boolean done = false;
        Node solution = null;
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");
                done = true;
            } else {
                Node node = chooseLeafNode(frontier, problem);
//                System.out.println("Inspecting node " + node);
                if (problem.isGoal(node.getState())) {
                    System.out.println("Goal node reached => SUCCESS");
                    solution = node;
                    done = true;
                } else {
                    frontier.addAll(expand(node, problem));
                    //System.out.printf("Expanding node, frontier is " + frontier);
                }
            }
        }
        return solution;
    }
    
    public abstract Collection<Node> expand(Node node, IProblem problem);
    public abstract Collection<Node> initFrontier(IProblem problem);
    public abstract Node chooseLeafNode(Collection<Node> frontier, IProblem problem);
}
