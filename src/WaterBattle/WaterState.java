package WaterBattle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arman
 */
public class WaterState {

    public int A, B;

    public WaterState(int A, int B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof WaterState) {
            return (((WaterState) o).A == this.A && ((WaterState) o).B == this.B);
        }
        return false;
    }

    @Override
    public String toString() {
        return "A: "+A+" B: "+B;
    }
    
    
}
