import java.util.List;

public class ReLU {
    double activate(double s){
        return Math.max(s,0.0d);
    }
    void activateList(List<Double> output){
        for (int i = 0; i < output.size(); i++) {
            output.add(i,activate(output.get(i)));
        }
    }
    void activateBatch(List<List<Double>> outputs){
        for (List<Double> list : outputs) {
            activateList(list);
        }
    }
}
