package neuralnetwork.activationfunction;

/**
 * The Swish activation function implements the ActivationFunction interface.
 * The function itself is given by x * sigmoid(x), where sigmoid
 * is the logistic function, as defined in the following paper:
 * https://arxiv.org/abs/1710.05941v1
 */

public class SwishActivationFunction implements ActivationFunction {
   /**
    * Evaluate method is given by:
    * x * sigmoid(x)
    * where sigmoid is the logistic function, 1 / (1 + exp(-x))
    * @param input the weighted sum from the Neuron
    * @return the value of the function evaluated on the weighted sum
    */
   public double evaluate(double input) {
      return input / (1 + Math.exp(-input));
   }
   
   /**
    * evaluateDerivative method is given by the following, for input x:
    *
    * evaluate(x) + (1 - evaluate(x)) / (1 + exp(-x))
    *
    * @param input the weighted sum from the Neuron
    * @return the value of the derivative evaluated at the weighted sum                    
    */
   public double evaluateDerivative(double input) {
      return evaluate(input) + (1 - evaluate(input)) 
             / (1 + Math.exp(-input));
   }
}