package ActivationFunctions;
import java.util.List;

public abstract class Activation {
    public void activateList(List<Double> output){}
    public void activateBatch(List<List<Double>> outputs){
        for (List<Double> list : outputs) {
            activateList(list);
        }
    }
}
