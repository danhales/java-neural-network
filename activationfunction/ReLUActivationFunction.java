package neuralnetwork.activationfunction;

/**
 * ReLUActivationFunction is a specialized case of of ParametricReLUActivationFunction,
 * where slope is equal to 0.
 * 
 * ReLUActivationFunction evaluates as follows:
 * input if input > 0
 * 0 if input <= 0
 *
 * Its derivative is defined as follows:
 * 1 if input > 0
 * 0 if input <= 0
 */
 
public class ReLUActivationFunction extends ParametricReLUActivationFunction {
   /**
    * Constructor calls superclass constructor, and passes 0 to slope.
    */
   public ReLUActivationFunction() {
      super(0);
   }
}