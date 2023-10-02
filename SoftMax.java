import java.util.List;


public class SoftMax {
    
    void activateList(List<Double> output){
        double sum = 0.0;
        for (int i = 0; i < output.size(); i++) {
            double x = Math.exp(output.get(i));//exponentiating the values
            output.add(i,x);
            sum += x;//getting aggregate of the double
        }
        for (int i = 0; i < output.size(); i++) {
            output.add(i,output.get(i)/sum);//normalizing the values
        }
    }
    void activateBatch(List<List<Double>> outputs){
        for (List<Double> list : outputs) {
            activateList(list);
        }
    }
}
