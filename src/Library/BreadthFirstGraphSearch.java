package Library;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arman
 */
public class BreadthFirstGraphSearch extends AbstractGraphSearch{

    @Override
    public Collection<Node> initFrontier(IProblem problem) {
        Queue<Node> q=new LinkedList<Node>();
        return q;
    }

    @Override
    public Node chooseLeafNode(Collection<Node> frontier1, IProblem problem) {
        return ((Queue<Node>)frontier1).poll();
    } 
}
