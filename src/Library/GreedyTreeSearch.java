/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author arman
 */
public class GreedyTreeSearch extends AbstractTreeSearch {

    @Override
    public Collection<Node> initFrontier(final IProblem problem) {
        Comparator<Node> comparator = new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                double f1 = problem.getStateHeuristic(o1.getState());
                double f2 = problem.getStateHeuristic(o2.getState());
                if (f1 > f2) {
                    return 1;
                } else if (f1 < f2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        PriorityQueue<Node> f = new PriorityQueue<>(1, comparator);
        return f;
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, IProblem problem) {
        PriorityQueue<Node> f = (PriorityQueue<Node>) frontier;
        return f.poll();
    }
}
