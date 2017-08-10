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

import java.util.Collection;
import java.util.Stack;

public class DepthFirstTreeSearch extends AbstractTreeSearch {

    @Override
    public Collection<Node> initFrontier(IProblem problem) {
        return new Stack<Node>();
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier, IProblem problem) {
        return ((Stack<Node>) frontier).pop();
    }
}