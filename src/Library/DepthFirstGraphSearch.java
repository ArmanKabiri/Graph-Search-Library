package Library;


import java.util.Collection;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arman
 */
public class DepthFirstGraphSearch extends AbstractGraphSearch{
    
    @Override
    public Collection<Node> initFrontier(IProblem problem) {
        return new Stack<Node>();
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, IProblem problem) {
        return ((Stack<Node>) frontier).pop();
    }
}
