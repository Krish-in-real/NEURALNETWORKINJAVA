package ActivationFunctions;
import java.util.List;

public class ReLU extends Activation{
    
    public void activateList(List<Double> output){
        for (int i = 0; i < output.size(); i++) {
            output.add(i,reLU(output.get(i)));
        }
    }
    
    /**
     * Activation Function Calculation::
     * 
     * ReLU(x) = 0 ,if x<0
     *           x ,if x>=0
     * 
     * 
     */
    private double reLU(double s){
        return Math.max(s,0.0d);
    }
}
