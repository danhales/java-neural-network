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
 
public class DenseLayer {
   /**
    * The DenseLayer contains an array of Perceptrons.
    */
   private Perceptron[] perceptrons;
   
   /**
    * The constructor puts together the actual dense layer, which consists of
    * numPerceptrons Perceptron objects.
    * @param numPerceptrons the number of perceptrons in this layer
    * @param numInputs the number of inputs to feed to each Perceptron
    * @param activationFunction the ActivationFunction to use in each
    *        Perceptron in the array
    */
   public DenseLayer(int numPerceptrons, int numInputs, 
                     ActivationFunction activationFunction) {
      // declare the array of Perceptrons
      this.perceptrons = new Perceptron[numPerceptrons];
      
      // initialize each Perceptron in the array to have the same number
      // of inputs and the same ActivationFunction.
      for (int i = 0; i < perceptrons.length; i++) {
         this.perceptrons[i] = new Perceptron(numInputs, activationFunction);
      }
   }
   
   /**
    * feedForward method is the main mechanism of action for the Layer class.
    * An array of inputs (equal to the number of Perceptrons in the previous
    * Layer object) is fed into the method, which distributes the inputs to
    * each Perceptron in the layer. The Perceptrons compute the weighted sums
    * of the inputs (according to their own individual weights), then each
    * produces an output with its activate method. These outputs are collected
    * in an array of doubles, which is returned by the method.
    * @param inputs an array of doubles from the previous layer
    * @return the outputs from all perceptrons in this layer.
    */
   public double[] feedForward(double[] inputs) {
      // create an array of doubles to hold the outputs
      double[] outputs = new double[this.perceptrons.length];
      
      // feed the inputs to each Perceptron and store its output in the array
      for (int i = 0; i < this.perceptrons.length; i++) {
         outputs[i] = this.perceptrons[i].activate(inputs);
      }
      
      // return the outputs
      return outputs;
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