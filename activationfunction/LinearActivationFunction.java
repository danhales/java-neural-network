package neuralnetwork.activationfunction;

/**
 * The LinearActivationFunction class is not particularly useful in practice, but
 * will be very useful in the development of this package, as the outputs will be
 * easily computed from the inputs.
 *
 * With slope m and input x, this activation function is given by f(x) = m*x
 */
 
public class LinearActivationFunction implements ActivationFunction{
   /**
    * The slope of the Linear function (any real number)
    */
   private double slope;
    
   /**
    * When creating a Neuron that uses a LinearActivationFunction, it is necessary
    * to specify the slope of the line. The constructor takes the slope of the line.
    * @param slope a real number
    */
   public LinearActivationFunction(double slope) {
      this.slope = slope;
   }
   
   /**
    * evaluate simply returns the value that is passed.
    * @param input the value of the weighted sum
    * @return the value of the transformed sum
    */
   public double evaluate(double input) {
      return slope * input;
   }
   
   /**
    * evaluateDerivative returns the value of the derivative at the value of the
    * weighted sum.
    *
    * This method is called during backpropagation.  
    * 
    * @param input the weighted sum, computed in the Neuron
    * @return the value of the derivative evaluated at the value of the weighted sum  
    */
   public double evaluateDerivative(double input) {
      return slope;
   }
}