package Library;


import java.util.ArrayList;
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
public abstract class AbstractGraphSearch extends AbstractSearch {

    protected Collection<Node> explored = new ArrayList<>();

    public Collection<Node> expand(Node node, IProblem problem) {
        explored.add(node);
        Collection<Node> nodes = new ArrayList<>();
        Collection<Object> actions = problem.getActions(node.getState());
        for (Object action : actions) {
            Object nextState = problem.getNextState(node.getState(), action);
            if (nextState != null) {
                Node nextNode = new Node(nextState, node, action, problem.getStepCost(node.getState(), action, nextState));
                if (!frontier.contains(nextNode) && !explored.contains(nextNode)) {
                    nodes.add(nextNode);
                }
            }
        }
        return nodes;
    }

    public abstract Collection<Node> initFrontier(IProblem problem);

    public abstract Node chooseLeafNode(Collection<Node> frontier, IProblem problem);

}
