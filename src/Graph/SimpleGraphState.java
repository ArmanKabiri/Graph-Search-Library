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

public class SimpleGraphState{
    public final static String A = "A";
    public final static String B = "B";
    public final static String C = "C";
    public final static String D = "D";
    public final static String E = "E";
    public final static String F = "F";
    public final static String G = "G";
    public final static String H = "H";
    public final static String M = "M";

    public String value;

    public SimpleGraphState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof SimpleGraphState) {
            return ((SimpleGraphState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }
}