package Library;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arman
 */
import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractTreeSearch extends AbstractSearch {

    public Collection<Node> expand(Node node, IProblem problem) {
        Collection<Node> nodes = new ArrayList<Node>();
        Collection<Object> actions = problem.getActions(node.getState());
        for (Object action : actions) {
            Object next = problem.getNextState(node.getState(), action);
            if (next != null) {
                nodes.add(new Node(next, node, action, problem.getStepCost(node.getState(), action, next)));
            }
        }
        return nodes;
    }

    public abstract Collection<Node> initFrontier(IProblem problem);

    public abstract Node chooseLeafNode(Collection<Node> frontier, IProblem problem);
}
