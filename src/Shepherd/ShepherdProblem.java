package Shepherd;

import Library.IProblem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author arman
 */
public class ShepherdProblem implements IProblem {

    private ShepherdState initialState;
    private ShepherdState finalState;

    public ShepherdProblem(ShepherdState initialState, ShepherdState finalState) {
        this.initialState = initialState;
        this.finalState = finalState;
    }

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        ShepherdState shState = (ShepherdState) state;
        return shState.equals(new ShepherdState((byte) 1, (byte) 1, (byte) 1, (byte) 1));
    }

    @Override
    public Collection<Object> getActions(Object state) {
        ShepherdState shState = (ShepherdState) state;
        Collection<Object> actions = new ArrayList<>();
        ArrayList<Object> itemsToMove = new ArrayList<>();

        itemsToMove.add(ShepherdState.SHEPHERD);
        actions.add(itemsToMove.clone());
        itemsToMove.clear();

        if (shState.locations.get(ShepherdState.SHEEP) == shState.locations.get(ShepherdState.SHEPHERD)) {
            itemsToMove.add(ShepherdState.SHEEP);
            itemsToMove.add(ShepherdState.SHEPHERD);
            actions.add(itemsToMove.clone());
            itemsToMove.clear();
        }

        if (shState.locations.get(ShepherdState.WOLF) == shState.locations.get(ShepherdState.SHEPHERD)) {
            itemsToMove.add(ShepherdState.WOLF);
            itemsToMove.add(ShepherdState.SHEPHERD);
            actions.add(itemsToMove.clone());
            itemsToMove.clear();
        }

        if (shState.locations.get(ShepherdState.GRASS) == shState.locations.get(ShepherdState.SHEPHERD)) {
            itemsToMove.add(ShepherdState.GRASS);
            itemsToMove.add(ShepherdState.SHEPHERD);
            actions.add(itemsToMove.clone());
            itemsToMove.clear();
        }

        return actions;

    }

    @Override
    public Object getNextState(Object state, Object act) {
        ShepherdState shState = (ShepherdState) state;

        try {
            ShepherdState nextState = (ShepherdState) shState.clone();
            ArrayList<Object> action = (ArrayList<Object>) act;

            for (Object a : action) {
                if (a == ShepherdState.GRASS) {
                    nextState.moveItem(ShepherdState.GRASS);
                }
                if (a == ShepherdState.SHEEP) {
                    nextState.moveItem(ShepherdState.SHEEP);
                }
                if (a == ShepherdState.SHEPHERD) {
                    nextState.moveItem(ShepherdState.SHEPHERD);
                }
                if (a == ShepherdState.WOLF) {
                    nextState.moveItem(ShepherdState.WOLF);
                }
            }
            if (isStateSafe(nextState)) {
                return nextState;
            } else {
                return null;
            }

        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ShepherdProblem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

    @Override
    public double getStateHeuristic(Object state) {
        ShepherdState shState = (ShepherdState) state;
        int h=0;
        h=Collections.frequency(shState.locations.values(), (byte)-1);
        return h;
    }

    private boolean isStateSafe(ShepherdState s) {
        if (s.locations.get(ShepherdState.GRASS) == s.locations.get(ShepherdState.SHEEP)
                && s.locations.get(ShepherdState.SHEEP) != s.locations.get(ShepherdState.SHEPHERD)) {
            return false;
        }
        if (s.locations.get(ShepherdState.WOLF) == s.locations.get(ShepherdState.SHEEP)
                && s.locations.get(ShepherdState.SHEEP) != s.locations.get(ShepherdState.SHEPHERD)) {
            return false;
        }
        return true;
    }
}
