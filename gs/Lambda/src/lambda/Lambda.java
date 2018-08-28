/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

/**
 *
 * @author 180827Gpo.Salinas
 */
@FunctionalInterface
interface I {

    int operation(int a, int b);
}

class Calcula implements I {

    @Override
    public int operation(int a, int b) {
        return a + b;
    }

}

public class Lambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        I i = new Calcula();
        I o = (a,b) -> a + b;
        System.out.println(o.operation(3, 4));

    }

}
