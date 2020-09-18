package neuralnetwork.layer;
import neuralnetwork.neuron.Perceptron;
import neuralnetwork.activationfunction.ActivationFunction;

/**
 * The Layer class will eventually be able to handle multiple types of inputs
 * (e.g. convolutional, dropout, etc.). For now, we'll just deal with a
 * DenseLayer.
 * A DenseLayer contains an array of Neuron objects (Perceptrons for now)
 * that each receive an input from every Neuron in the previous layer.
 * The layer handles the actual wiring up of neurons to the previous layer.
 */
 
public class Layer {
   /**
    * The Layer contains an array of Perceptrons.
    */
   private Perceptron[] perceptrons;
   
   /**
    * The constructor puts together the actual layer, which consists of
    * numPerceptrons Perceptron objects.
    * @param numPerceptrons the number of perceptrons in this layer
    * @param numInputs the number of inputs to feed to each Perceptron
    * @param activationFunction the ActivationFunction to use in each
    *        Perceptron in the array
    */
   public Layer(int numPerceptrons, int numInputs, 
                ActivationFunction activationFunction) {
      // declare the array of Perceptrons
      this.perceptrons = new Perceptron[numPerceptrons];
      
      // initialize each Perceptron in the array to have the same number
      // of inputs and the same ActivationFunction.
      for (int i = 0; i < perceptrons.length; i++) {
         this.perceptrons[i] = new Perceptron(numInputs, activationFunction);
      }
   }
   
   // setters and getters
   
   /**
    * getPerceptrons returns a reference to the array of Perceptrons.
    * @return a reference to the array of Perceptrons
    */
   public Perceptron[] getPerceptrons() {
      return this.perceptrons;
   }
}