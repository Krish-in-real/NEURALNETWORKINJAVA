import java.util.List;

public class ApplyNeuralNetwork {
    //the values will be like [NumberOfInputNodes, NumberOfHiddenNodes1, NumberOfHiddenNodes2, .... NumberOfOutputNodes]
    private List<Integer> nodesList;
    private List<DenseLayer> dLayers;
    ApplyNeuralNetwork(List<Integer> nodesList){
        this.nodesList = nodesList;
    }
    void setPlaceholder(){
        //creates the place holder
    }
}
