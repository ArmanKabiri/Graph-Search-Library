package Main;

import Graph.GeneralGraphProblem;
import Graph.SimpleOrientedGraphProblem;
import Library.AStartTreeSearch;
import Library.BreadthFirstGraphSearch;
import Library.BreadthFirstTreeSearch;
import Shepherd.ShepherdProblem;
import Shepherd.ShepherdState;
import WaterBattle.WaterProblem;
import WaterBattle.WaterState;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arman
 */
public class SimpleTest {

    public static void main(String[] args) {
        SimpleOrientedGraphProblem p1 = new SimpleOrientedGraphProblem();
        WaterProblem wProblem=new  WaterProblem(15, 5, new WaterState(12, 3), new WaterState(0, 5));
        ShepherdProblem shProblem=new ShepherdProblem(new ShepherdState(-1, -1, -1, -1),new ShepherdState(1, 1, 1, 1));
        GeneralGraphProblem graphGeneralProblem=new GeneralGraphProblem();
        graphGeneralProblem.readFromFile("g1.txt");
        
        
//        System.out.println(new BreadthFirstGraphSearch().solve(p1).pathToString());
        System.out.println(new BreadthFirstGraphSearch().solve(wProblem).pathToString());
//          System.out.println(new AStartTreeSearch().solve(shProblem).pathToString());
//        System.out.println(new AStartTreeSearch().solve(p1).pathToString());
//        System.out.println(new AStartTreeSearch().solve(graphGeneralProblem).pathToString());
    }
}
