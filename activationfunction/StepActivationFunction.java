package neuralnetwork.activationfunction;

/**
 * The StepActivationFunction class implements the ActivationFunction interface.
 * The function itself is given by:
 * 1 if input > 0
 * 0 otherwise
 *
 * Its derivative is 0 everywhere.
 */

public class StepActivationFunction implements ActivationFunction {
   /**
    * evaluate returns 1 if input > 0, 0 otherwise.
    * @param input the weighted sum from the Neuron
    * @return the function evaluated on the weighted sum
    */
   public double evaluate(double input) {
      if (input > 0) {
         return 1;
      } else {
         return 0;
      }
   }
   
   /**
    * evaluateDerivative always returns 0.
    * @param input the weighted sum from the Neuron
    * @return 0, always
    */
   public double evaluateDerivative(double input) {
      return 0;
   }
}