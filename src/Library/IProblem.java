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

public interface IProblem {
    public Object getInitialState();
    public boolean isGoal(Object state);
    public Collection<Object> getActions(Object state);
    public Object getNextState(Object state,Object action);
    public double getStepCost(Object start, Object action, Object dest);
    public double getStateHeuristic(Object state);
}