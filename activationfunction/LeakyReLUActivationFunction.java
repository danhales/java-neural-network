package neuralnetwork.activationfunction;

/**
 * The LeakyReLUActivationFunction class is a special case of the 
 * ParametricReluActivationFunction class, where slope is 0.01.
 * 
 * Evaluates as follows:
 * input if input > 0
 * 0.01 * input if input <= 0
 *
 * Derivative evaluates as follows:
 * 1 if input > 0
 * 0.01 if input <= 0
 */
 
public class LeakyReLUActivationFunction extends ParametricReLUActivationFunction {
   /**
    * Calls the superclass constructor, passing 0.01.
    */
   public LeakyReLUActivationFunction() {
      super(0.01);
   }
}