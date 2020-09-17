package neuralnetwork.neuron;
import neuralnetwork.activationfunction.ActivationFunction;

/**
 * The Perceptron class is the simplest neuron available. It contains an 
 * ActivationFunction and an array of weights, and is capable of propagating
 * by computing the weighted sum of the previous layer's inputs, then passing
 * it through its ActivationFunction. The Perceptron also needs to be able to
 * update the weights, which are computed using the ActivationFunction's
 * derivative as:
 * 
 * inputs[i] * ActivationFunction.evaluateDerivative(weightedSum)
 * 
 * To create a Perceptron, we only need specify how many weights it should have. 
 * If there are n Neurons in the previous layer, then there are n weights, 
 * along with a bias term. In this implementation, the bias term is ADDED to the 
 * weighted sum, so a negative value is necessary to reduce the value of the 
 * weighted sum.
 *
 * We also need to specify which ActivationFunction to use, either from the
 * available list, or from a customized class implementing the ActivationFunction
 * interface. The list of available ActivationFunction classes (in alphabetical order):
 *    - IdentityActivationFunction
 *    - LeakyReLUActivationFunction
 *    - LinearActivationFunction
 *    - ParametricReLUActivationFunction
 *    - ReLUActivationFunction
 *    - SigmoidActivationFunction
 *    - StepActivationFunction
 *    - SwishActivationFunction
 *    - TanhActivationFunction
 *
 * The bias term and weights can be adjusted or retrieved using the appropriate setters 
 * and getters. Weights are randomized by default, but can be set manually, e.g. to 
 * implement an existing model. If the bias term is not specified, it defaults to -1.
 */
 
public class Perceptron {
   /**
    * The weights to apply to the inputs.
    */
   private double[] weights;
   
   /** 
    * The ActivationFunction for this particular Perceptron.
    */
   private ActivationFunction activationFunction;
   
   /**
    * A bias term.
    */
   private double biasTerm;
   
   /**
    * Constructor requires the number of inputs (number of neurons in previous
    * layer) and an object that implements the ActivationFunction interface.
    * 
    * This constructor initializes all weights to random values between 0 and 1.
    * @param numInputs an int > 0; the number of neurons in the previous layer
    * @param activationFunction, instance of a class that implements the
    *        ActivationFunction interface
    */
   public Perceptron(int numInputs, ActivationFunction activationFunction) {
      weights = new double[numInputs];
      
      // Initialize the weights with random values.
      for (int i = 0; i < weights.length; i++) {
         weights[i] = Math.random();
      }
      
      // assign the ActivationFunction object to the private field
      this.activationFunction = activationFunction;
      
      // set the bias equal to -1.
      biasTerm = -1.0;
   }
   
   /**
    * preactivate method is called during the forward propagation and
    * backpropagation process. It computes the weighted sum (the dot product
    * of the weights vector and the inputs vector), and adds the bias term.
    * @param inputs an array of floats (inputs from prior layer)
    * @return the weighted sum of the inputs, plus the bias term
    */
   public double preactivate(double[] inputs) {
      double weightedSum = this.biasTerm;
      
      for (int i = 0; i < this.weights.length; i++) {
         weightedSum += this.weights[i] * inputs[i];
      }
      
      return weightedSum;
   }
   
   /**
    * propagate preactivates then feeds the weighted sum (with bias) into
    * the activation function.
    * @param inputs the inputs from the previous layer
    * @return the output value of the Neuron
    */
   public double propagate(double[] inputs) {
      return activationFunction.evaluate(preactivate(inputs));
   }
   
   /**
    * At some point, it may be useful to get the number of inputs, i.e. the length
    * of the array of weights.
    * @return the length of the weights array
    */
   public int getNumWeights() {
      return weights.length;
   }
    
   // Accessors and Mutators for fields.
    
   /**
    * setWeights accepts a specific set of weights, e.g. for implementing a
    * model that has already been trained. By default, this is a shallow copy.
    * @param weights an array of doubles of length numInputs
    */
   public void setWeights(double[] weights) {
      this.weights = weights;
   }

   /**
    * setWeightsDeepCopy accepts a specific set of weights, e.g. for implementing a
    * model that has already been trained. This method creates a deep copy of the
    * array.
    * @param weights an array of doubles of length numInputs
    */
   public void setWeightsDeepCopy(double[] weights) {
      this.weights = new double[weights.length];
      
      for (int i = 0; i < weights.length; i++) {
         this.weights[i] = weights[i];
      }
   }
   
   /**
    * getWeights() returns a deep copy of the weights array.
    * @return a deep copy of the weights array.
    */
   public double[] getWeights() {
      // make a new array of doubles to return
      double[] weightsCopy = new double[this.weights.length];
      
      // 
      for (int i = 0; i < this.weights.length; i++) {
         weightsCopy[i] = this.weights[i];
      }
      
      return weightsCopy;
   }
   
   /**
    * getActivationFunction returns a reference to the activationFunction
    * @return the a reference to activationFunction
    */
   public ActivationFunction getActivationFunction() {
      return this.activationFunction;
   }
   
   /**
    * setBiasTerm changes the value in biasTerm. The bias term is ADDED
    * to the weighted sum.
    * @param biasTerm the new bias term (a double)
    */
   public void setBiasTerm(double biasTerm) {
      this.biasTerm = biasTerm;
   }
   
   /**
    * getBiasTerm returns the bias term (the term that is added to the
    * weighted sum before it is transformed by the ActivationFunction)
    * @return the bias term
    */
   public double getBiasTerm() {
      return this.biasTerm;
   }
 }