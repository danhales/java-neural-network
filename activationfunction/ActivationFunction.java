package neuralnetwork.activationfunction;

/**
 * The ActivationFunction interface will allow us to customize the activation functions
 * in our neurons. It is assumed that the weighted sum is computed in the Neuron, then
 * passed to the ActivationFunction to apply a (usually non-linear) transformation.
 *
 * Any class that implements this interface will be able to be used as an activation
 * function in the neuron, justifying the need for an interface.
 */
 
 public interface ActivationFunction {
   /**
    * The ActivationFunction will apply a transformation to a weighted sum, which is 
    * computed from the outputs of the previous Layer and the weights stored in the Neuron.
    * @param input the weighted sum from the Neuron
    * @return the value when the transformation is applied to the weighted sum
    */
   public double evaluate(double input);
   
   /**
    * The ActivationFunction must have a defined derivative in order to backpropagate.
    * The evaluateDerivative method will take compute the derivative of the 
    * ActivationFunction, evaluated at the value of the weighted sum.
    * @param input the weighted sum from the Neuron
    * @return the value of the ActivationFunction's derivative, evaluated at the vaule 
    *         of the weighted sum
    */
   public double evaluateDerivative(double input);
 }