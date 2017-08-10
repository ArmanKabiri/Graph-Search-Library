package WaterBattle;


import Library.IProblem;
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
public class WaterProblem implements IProblem {

    private int AFullCapacity;
    private int BFullCapacity;
    private WaterState initialState;
    private WaterState finalState;

    public WaterProblem(int AFullCapacity, int BFullCapacity, WaterState initialState, WaterState finalState) {
        this.AFullCapacity = AFullCapacity;
        this.BFullCapacity = BFullCapacity;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return finalState.equals(state);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        WaterState wState = (WaterState) state;
        Collection<Object> actions = new ArrayList<>();
        if (wState.A > 0) {
            actions.add("empty A");
            if (wState.B < BFullCapacity) {
                actions.add("A to B");
            }
        }
        if (wState.B > 0) {
            actions.add("empty B");
            if (wState.A < AFullCapacity) {
                actions.add("B to A");
            }
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        WaterState wState = (WaterState) state;
        if (action.equals("empty A")) {
            return new WaterState(0, wState.B);
        } else if (action.equals("empty B")) {
            return new WaterState(wState.A, 0);
        } else if (action.equals("A to B")) {
            if (wState.A <= (BFullCapacity - wState.B)) {
                return new WaterState(0, wState.B + wState.A);
            } else {
                return new WaterState(wState.A - (BFullCapacity - wState.B), BFullCapacity);
            }
        } else if (action.equals("B to A")) {
            if (wState.B <= (AFullCapacity - wState.A)) {
                return new WaterState(wState.B + wState.A, 0);
            } else {
                return new WaterState(AFullCapacity, wState.B - (AFullCapacity - wState.A));
            }
        }
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
