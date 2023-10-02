import java.util.ArrayList;
import java.util.List;



public class DenseLayer {

    private int numberOfInputs;
    private int numberOfNeurons;
    private List<List<Double>> weights;
    private List<List<Double>> outputs;
    

    //constructor
    DenseLayer(int numberOfInputs,int numberOfNeurons){
        this.numberOfInputs = numberOfInputs;
        this.numberOfNeurons = numberOfNeurons;
        weights = new ArrayList<>();
        outputs = new ArrayList<>();
    }

    //generates weight with random values
    public void generateWeights(){
        for(int j = 0;j<numberOfNeurons;j++){
            List<Double> temp = new ArrayList<>(numberOfInputs);
            for (int i = 0; i < numberOfInputs; i++) {
                temp.add(Math.random());
            }
            weights.add(temp);
        }
    }

    //simple dot products of two vectors
    public double dot(List<Double> v1,List<Double> v2,boolean ReLU){
        double sum = 0.0d;
        for (int i = 0; i < v1.size(); i++) {
            sum+=v1.get(i)*v2.get(i);
        }
        return ReLU ?  (new ReLU().activate(sum)) : sum;
    }


    // calculating outputs for batch of inputs
    public void forward(List<List<Double>> inputs){
        for (List<Double> input : inputs) {
            List<Double> temp = new ArrayList<>();
            for (List<Double> weight : weights) {
                temp.add(dot(input,weight,false));
            }
            outputs.add(temp);
        }
    }


    //getters
    public List<List<Double>> getOutputs() {
        return outputs;
    }
}