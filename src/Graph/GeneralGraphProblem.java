/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import Library.IProblem;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author arman
 */
public class GeneralGraphProblem implements IProblem {

    private GeneralGraphState initialState;
    private GeneralGraphState finalState;
    private ArrayList<GeneralGraphState> states = new ArrayList<>();
    private boolean reversible = false;
    private double[] heuristics;
    private double[][] costs;

    public void readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/metaData/" + fileName), Charset.defaultCharset());
            int lastExploredIndex = 0;

            ///////// States:
            while (true) {
                int spaceIndex = lines.get(1).indexOf(' ', lastExploredIndex);
                if (spaceIndex == (-1)) {
                    break;
                }
                String state = lines.get(1).substring(lastExploredIndex, spaceIndex);
                lastExploredIndex = spaceIndex + 1;
                states.add(new GeneralGraphState(state));
            }
            states.add(new GeneralGraphState(new String(lines.get(1).substring(lastExploredIndex))));
            initialState = new GeneralGraphState(lines.get(2).substring(lines.get(2).indexOf(" ") + 1));
            finalState = new GeneralGraphState(lines.get(3).substring(lines.get(3).indexOf(" ") + 1));
            heuristics = new double[states.size()];
            costs = new double[states.size()][states.size()];

            /////////// Costs:
            if (lines.get(6).equals("reversible true")) {
                reversible = true;
            }

            int lineCounter;
            for (lineCounter = 9; true; lineCounter++) {
                lastExploredIndex = 0;
                if (lines.get(lineCounter).equals("}")) {
                    break;
                }
                int spaceIndex = lines.get(lineCounter).indexOf(' ', lastExploredIndex);
                GeneralGraphState state1 = new GeneralGraphState(lines.get(lineCounter).substring(lastExploredIndex, spaceIndex));
                lastExploredIndex = spaceIndex + 1;
                spaceIndex = lines.get(lineCounter).indexOf(' ', lastExploredIndex);
                GeneralGraphState state2 = new GeneralGraphState(lines.get(lineCounter).substring(lastExploredIndex, spaceIndex));
                lastExploredIndex = spaceIndex + 1;
                double cost = Double.valueOf(lines.get(lineCounter).substring(lastExploredIndex));
                costs[states.indexOf(state1)][states.indexOf(state2)] = cost;
                if (reversible) {
                    costs[states.indexOf(state2)][states.indexOf(state1)] = cost;
                }
            }

            /////////// Heuristics:
            for (int i = lineCounter + 3; true; i++) {
                lastExploredIndex = 0;
                if (lines.get(i).equals("}")) {
                    break;
                }
                int spaceIndex = lines.get(i).indexOf(' ', lastExploredIndex);
                GeneralGraphState state = new GeneralGraphState(lines.get(i).substring(lastExploredIndex, spaceIndex));
                lastExploredIndex = spaceIndex + 1;
                double h = Double.valueOf(lines.get(i).substring(lastExploredIndex));
                heuristics[states.indexOf(state)] = h;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return ((GeneralGraphState) state).equals(finalState);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        GeneralGraphState gState = (GeneralGraphState) state;
        Collection<Object> actions = new ArrayList<>();
        for (int i = 0; i < states.size(); i++) {
            if (costs[states.indexOf(gState)][i] != 0) {
                actions.add(states.get(i));
            }
        }
        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        return action;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return costs[states.indexOf(start)][states.indexOf(dest)];
    }

    @Override
    public double getStateHeuristic(Object state) {
        return heuristics[states.indexOf(state)];
    }
}
