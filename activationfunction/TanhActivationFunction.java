package neuralnetwork.activationfunction;

/**
 * The TanhActivationFunction class transforms the weighted sum with the hyperbolic
 * tangent function (tanh), given by by the following definition:
 
 * f(x) = tanh(x)
 *
 * The derivative of tanh is given by the following definition:
 * 
 * f'(x) = 1 / (cosh(x))^2
 */
 
public class TanhActivationFunction implements ActivationFunction {
   /**
    * evaluate method is given by:
    * tanh(input)
    *
    * @param input the weighted sum from the Neuron
    * @return the transformed weighted sum
    */
   public double evaluate(double input) {
      return Math.tanh(input);
   }
   
   /**
    * evaluateDerivative method is given by the following definition:
    *
    * 1 / (cosh(input))^2
    *
    * @param input the weighted sum from the Neuron
    * @return the value of the derivative evaluated at the weighted sum                    
    */
   public double evaluateDerivative(double input) {
      return 1 / Math.pow(Math.cosh(input), 2);
   }
}