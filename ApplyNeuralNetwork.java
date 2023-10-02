import java.util.ArrayList;
import java.util.List;
import ActivationFunctions.ReLU;
import ActivationFunctions.SoftMax;

public class ApplyNeuralNetwork {
    //the values will be like [NumberOfInputNodes, NumberOfHiddenNodes1, NumberOfHiddenNodes2, .... NumberOfOutputNodes]
    private List<Integer> nodesList;
    private List<DenseLayer> dLayers;
    ApplyNeuralNetwork(List<Integer> nodesList){
        this.nodesList = nodesList;
    }
    void setPlaceholder(){
        for(int i = 1;i<nodesList.size();i++){
            dLayers.add(new DenseLayer(nodesList.get(i-1), nodesList.get(i)));
            if(i!=nodesList.size()-1)
                dLayers.get(i).setActivation(new ReLU());
            else
                dLayers.get(i).setActivation(new SoftMax());
        }
        //dLayers output activation  = softmax;
    }
    List<List<List<Double>>> splitIntoBatches(List<List<Double>> input,int batchSize){
        int c = 0;
        List<List<List<Double>>> output = new ArrayList<>();
        List<List<Double>> temp = new ArrayList<>();;
        for(int i = 0;i<input.size();i++){
            temp.add(input.get(i));
            c++;
            if(c==batchSize){
                output.add(temp);
                temp = new ArrayList<>();
                c=0;
            }
        }
        if(c!=0)
            output.add(temp);
        return output;
    }
    
    
    List<List<Double>> computeBatch(List<List<Double>> inputs,int batchSize){
        List<List<List<Double>>> inputBatches = splitIntoBatches(inputs, batchSize);
        List<List<Double>> output = new ArrayList<>();
        for (List<List<Double>> inputBatch : inputBatches) {
            output.addAll(computeIndividualBatch(inputBatch));
        }
        return output;
    }
    
    
    
    List<List<Double>> computeIndividualBatch(List<List<Double>> inputs){
        dLayers.get(0).forward(inputs);
        List<List<Double>> output = dLayers.get(0).getOutputs();
        for(int i = 1;i<dLayers.size();i++){
            dLayers.get(i).forward(output);
            output = dLayers.get(i).getOutputs();
        }
        return output;
    }
}
