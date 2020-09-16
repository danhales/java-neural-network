package neuralnetwork.activationfunction;
import neuralnetwork.activationfunction.ActivationFunction;

/**
 * The ParametricReLUActivationFunction class transforms the weighted sum with a
 * parametrized version of the ReLU function, given by the following piecewise
 * definition, for real values m:
 *
 * f(x) = x if x > 0
 *        mx if x <= 0
 *
 * The derivative of the ParametricReLU function is given by He, Zhang, Ren, and 
 * Sun (https://arxiv.org/abs/1502.01852) as:
 * 
 * f'(x) = 1 if x > 0
 *         m if x <= 0
 */
 
public class ParametricReLUActivationFunction implements ActivationFunction {
   /**
    * The slope when x < 0
    */
   private double slope;
   
   /**
    * Constructor takes a value for the slope when x < 0. 
    * @param slope the slope of the function for negative values (nonnegative)
    */
   public ParametricReLUActivationFunction(double slope) {
      this.slope = slope;
   }
   
   /**
    * evaluate method is given by the following piecewise definition:
    *
    * input if input > 0
    * slope * input if input <= 0
    *
    * @param input the weighted sum from the Neuron
    * @return the transformed weighted sum
    */
   public double evaluate(double input) {
      if (input <= 0) {
         return slope * input;
      } else {
         return input;
      }
   }
   
   /**
    * evaluateDerivative method is given by the following piecewise definition:
    * 1 if input > 0
    * slope if input <= 0
    * @param input the weighted sum from the Neuron
    * @return the value of the derivative evaluated at the weighted sum                    
    */
   public double evaluateDerivative(double input) {
      if (input <= 0) {
         return slope;
      } else {
         return 1;
      }
   }
}