package neuralnetwork.activationfunction;

/**
 * SoftmaxFunction class is technically an activation function, but does not
 * implement the ActivationFunction interface. It is a utility class that provides
 * softmax functionality wherever it might be needed.
 * 
 * For a vector X, we define:
 * denominator(X) = sum(exp(X[i])), the sum of all entries in X, exponentiated
 * softmax(X) = { exp(X[i]) / denominator(X)  for i = 0, 1, ..., X.length - 1}
 *
 * The output of softmax is a vector whose entries are a probability distribution
 * over the classes, i.e. output[0] represents the probability of the input
 * corresponding to the first class, output[1] represents the probability of the
 * input corresponding to the second class, and so on.
 *
 * TODO: Add method for getting the partial derivatives for backpropagation.
 */
 
public class Softmax {
   /**
    * the evaluate method accepts an array of doubles (the raw values for each
    * class) and applies the softmax function to them.
    * @param inputs the inputs prior to softmax
    * @return an array of outputs from the softmax function; a probability
    *          distribution for the classes
    */
   public static double[] evaluate(double[] inputs) {
      double denominator = getDenominator(inputs);
      
      double[] outputs = new double[inputs.length];
      
      for (int i = 0; i < inputs.length; i++) {
         outputs[i] = Math.exp(inputs[i]) / denominator;
      }
      
      return outputs;
   }
   
   /**
    * The denominator is the sum of all exponentiated terms in the input vector.
    * @param inputs an array of inputs
    * @return the sum of the exponentiated elements in inputs
    */
   public static double getDenominator(double[] inputs) {
      double sum = 0;
      
      for (int i = 0; i < inputs.length; i++) {
         sum += Math.exp(inputs[i]);
      }
      
      return sum;
   }
}