package neuralnetwork.activationfunction;

/**
 * The IdentityActivationFunction class extends the LinearActivationFunction class,
 * with the slope being equal to 1.
 *
 * This evaluates inputs using the identity function f(x) = x.
 *
 * This is a special case of the LinearActivationFunction, where slope = 1.
 */
 
public class IdentityActivationFunction extends LinearActivationFunction {
   /**
    * Constructor takes no arguments, and passes 1 to the superclass constructor.
    */
   public IdentityActivationFunction() {
      super(1);
   }
}