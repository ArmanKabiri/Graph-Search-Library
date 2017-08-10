package Graph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arman
 */
import Library.IProblem;
import java.util.ArrayList;
import java.util.Collection;

public class SimpleOrientedGraphProblem implements IProblem {

    SimpleGraphState initialState = new SimpleGraphState(SimpleGraphState.A);
    SimpleGraphState finalState = new SimpleGraphState(SimpleGraphState.H);

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ArrayList<Object> actions = new ArrayList<Object>();
        String s = ((SimpleGraphState) state).value;
        if (s.equals(SimpleGraphState.A)) {
            actions.add("go to B");
            actions.add("go to C");
        } else if (s.equals(SimpleGraphState.B)) {
            actions.add("go to D");
            actions.add("go to E");
        } else if (s.equals(SimpleGraphState.C)) {
            actions.add("go to D");
        } else if (s.equals(SimpleGraphState.D)) {
            actions.add("go to G");
        } else if (s.equals(SimpleGraphState.E)) {
            actions.add("go to F");
        } else if (s.equals(SimpleGraphState.F)) {
            actions.add("go to H");
        } else if (s.equals(SimpleGraphState.G)) {
            actions.add("go to M");
        } else if (s.equals(SimpleGraphState.M)) {
            actions.add("go to H");
        }
        else if (s.equals(SimpleGraphState.H)) {

        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("go to A")) return new SimpleGraphState(SimpleGraphState.A);
        if (action.equals("go to B")) return new SimpleGraphState(SimpleGraphState.B);
        if (action.equals("go to C")) return new SimpleGraphState(SimpleGraphState.C);
        if (action.equals("go to D")) return new SimpleGraphState(SimpleGraphState.D);
        if (action.equals("go to E")) return new SimpleGraphState(SimpleGraphState.E);
        if (action.equals("go to F")) return new SimpleGraphState(SimpleGraphState.F);
        if (action.equals("go to G")) return new SimpleGraphState(SimpleGraphState.G);
        if (action.equals("go to H")) return new SimpleGraphState(SimpleGraphState.H);
        if (action.equals("go to M")) return new SimpleGraphState(SimpleGraphState.M);
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

    @Override
    public double getStateHeuristic(Object state) {
        return 0;
    }
}