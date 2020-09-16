package neuralnetwork.activationfunction;

/**
 * The SigmoidActivationFunction class implements the ActivationFunction interface,
 * and applies the logistic function to its inputs.
 *
 * Evaluates as follows, where exp is the exponential function with base e = 2.718...
 * 1 / (1 + exp(-1 * input))
 *
 * Derivative evaluates as follows, where exp is the exponential function with base
 * e = 2.718...
 *
 * exp(x) / (1+exp(x))^2
 */
 
public class SigmoidActivationFunction implements ActivationFunction {
   /**
    * evaluate method takes an input x, and returns 1 / (1 + exp(-x)), where exp
    * is the exponential function with base e = 2.718...
    * @param input the weighted sum from the Neuron
    * @return the value of the function evaluated on the weighted sum
    */
    public double evaluate(double input) {
      return 1 / (1 + Math.exp(-input));
    }
    
    /**
     * evaluateDerivative method takes an input x, and returns
     * exp(x) / (1 + exp(x))^2
     * @param input the weighted sum from the Neuron
     * @return the value of the derivative evaluated on the weighted sum
     */
    public double evaluateDerivative(double input) {
      return Math.exp(input) / Math.pow(1 + Math.exp(input), 2);
    }
}