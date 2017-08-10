/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author arman
 */
public class GeneralGraphState {

    public String value;

    public GeneralGraphState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof GeneralGraphState) {
            return ((GeneralGraphState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }
}
