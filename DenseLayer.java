import java.util.ArrayList;
import java.util.List;
import ActivationFunctions.Activation;



public class DenseLayer {

    private int numberOfInputs;
    private int numberOfNeurons;
    private List<List<Double>> weights;
    private List<List<Double>> outputs;
    private List<Integer> biases;
    private Activation activate;
    //constructor
    DenseLayer(int numberOfInputs,int numberOfNeurons){
        this.numberOfInputs = numberOfInputs;
        this.numberOfNeurons = numberOfNeurons;
        biases = new ArrayList<>(numberOfNeurons);
        weights = new ArrayList<>();
        outputs = new ArrayList<>();
        this.activate = null;
    }
    public void setActivation(Activation object){
        activate = object;
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
    public double dot(List<Double> v1,List<Double> v2){
        double sum = 0.0d;
        for (int i = 0; i < v1.size(); i++) {
            sum+=v1.get(i)*v2.get(i);
        }
        return sum;
    }


    // calculating outputs for batch of inputs
    public void forward(List<List<Double>> inputs){
        for (List<Double> input : inputs) {
            int i = 0;
            List<Double> temp = new ArrayList<>();
            for (List<Double> weight : weights) {
                temp.add(dot(input,weight)+biases.get(i++));
            }
            outputs.add(temp);
        }
    }


    //getters
    public List<List<Double>> getOutputs() {
        if(activate!=null)
            activate.activateBatch(outputs);
        return outputs;
    }
}