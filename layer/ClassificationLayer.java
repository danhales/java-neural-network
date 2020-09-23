package neuralnetwork.layer;
import neuralnetwork.layer.DenseLayer;
import neuralnetwork.activationfunction.ActivationFunction;
import neuralnetwork.activationfunction.Softmax;

// for debugging
import neuralnetwork.neuron.Neuron;
import neuralnetwork.test.NeuronTests;

/**
 * The ClassificationLayer class represents the final layer in a neural network.
 * It is essentially a wrapper for a DenseLayer, with an additional activation
 * function applied to the collection of outputs from every Neuron in the 
 * DenseLayer.
 */
 
public class ClassificationLayer {
   /**
    * The internal DenseLayer is used to compute the final values for each
    * of the classes, prior to being fed into softmax for prediction.
    * @param labels the list of labels (should be consistent with one-hot order)
    * @param numInputs the number of inputs (number of outputs from previous layer)
    * @param activationFunction the ActivationFunction to use on the internal layer
    */
   private DenseLayer layer;
   
   /**
    * The labels array contains the labels for the classes.
    */
   private String[] labels;
   
   public ClassificationLayer(String[] labels, 
                              int numInputs,
                              ActivationFunction activationFunction) {
      // store the labels
      this.labels = labels;
      
      // make the internal dense layer
      this.layer = new DenseLayer(labels.length, // number of neurons
                                  numInputs, // number of inputs to this layer
                                  activationFunction); // the ActivationFunction 
   }
   
   /**
    * Gets the outputs from layer's feedForward method, and feeds them into the
    * softmax function.
    * @param inputs the inputs from the previous layer.
    * @return the probability vector
    */
   public double[] evaluate(double[] inputs) {
      return Softmax.evaluate(this.layer.feedForward(inputs));
   }
   
   /**
    * Predicts the index of the correct classification.
    * @param inputs the inputs from the previous layer.
    * @return the index of the correct classification in labels array.
    */
   public int predict(double[] inputs) {
      double[] probabilities = evaluate(inputs);
      int maxIndex = 0;
      for (int i = 0; i < probabilities.length; i++) {
         if (probabilities[i] > probabilities[maxIndex]) {
            maxIndex = i;
         }
      }
      
      return maxIndex;
   }
   
   /**
    * Returns the predicted label (not the predicted index).
    * @param inputs the inputs from the previous layer
    * @return the name of the predicted class
    */
   public String predictLabel(double[] inputs) {
      return this.labels[predict(inputs)];
   }
   
   /**
    * Debugging method to show weights. Will be removed.
    */
   public void printDebug() {
      Neuron[] neurons = this.layer.getNeurons();
      
      for (int i = 0; i < neurons.length; i++) {
         NeuronTests.printNeuron(neurons[i]);
      }
   }
}