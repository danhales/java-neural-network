package neuralnetwork.test;
import neuralnetwork.neuron.Perceptron;
import neuralnetwork.activationfunction.*;

/**
 * Class for testing the Perceptron class.
 */
 
public class PerceptronTests {
   public static void main(String[] args)
   {
      // testConstructor();
      // testGetNumWeights();
      // testSetWeights();
      // testSetWeightsDeepCopy();
      // testSetBiasTerm();
      // testPreactivate();
      testActivate();
   }
   
   public static void printPerceptron(Perceptron p)
   {
      double[] weights = p.getWeights();
      double biasTerm = p.getBiasTerm();
      ActivationFunction activationFunction = p.getActivationFunction();
      
      System.out.println("Weights: ");
      for (int i = 0; i < weights.length; i++) {
         System.out.println(weights[i]);
      }
      
      System.out.println("\nBias term:\n" + biasTerm + "\n");
      
      System.out.println("ActivationFunction:\n" 
                         + activationFunction.getClass().getName()
                         + "\n");
   }
   
   public static void testConstructor()
   {
      System.out.println("========== testConstructor ==========\n");
      Perceptron perceptron = new Perceptron(5, new StepActivationFunction());
      printPerceptron(perceptron);
      System.out.println();
   }
   
   public static void testGetNumWeights()
   {
      System.out.println("========== testGetNumWeights ==========\n");
      int numWeights = 5;
      Perceptron perceptron = new Perceptron(numWeights, new StepActivationFunction());
      System.out.println("Number of weights expected: " + numWeights);
      System.out.println("Number of weights observed: " + perceptron.getNumWeights());
      System.out.println();
   }
   
   public static void testSetWeights() {
      System.out.println("========== testSetWeights ==========\n");
      Perceptron perceptron = new Perceptron(3, new StepActivationFunction());
      System.out.println("Before weights changed:");
      printPerceptron(perceptron);
      double[] newWeights = new double[] {1, 2, 3};
      
      System.out.println("After weights changed:");
      perceptron.setWeights(newWeights);
      printPerceptron(perceptron);
   }

   public static void testSetWeightsDeepCopy() {
      System.out.println("========== testSetWeightsDeepCopy ==========\n");
      Perceptron perceptron = new Perceptron(3, new StepActivationFunction());
      System.out.println("Before weights changed:");
      printPerceptron(perceptron);
      double[] newWeights = new double[] {1, 2, 3};
      
      System.out.println("After weights changed:");
      perceptron.setWeightsDeepCopy(newWeights);
      printPerceptron(perceptron);
   }
   
   public static void testSetBiasTerm() {
      System.out.println("========== testSetBiasTerm ==========\n");
      Perceptron perceptron = new Perceptron(3, new StepActivationFunction());
      System.out.println("Before setting biasTerm:");
      printPerceptron(perceptron);
      System.out.println("After setting biasTerm");
      perceptron.setBiasTerm(100);
      printPerceptron(perceptron);
   }
   
   public static void testPreactivate() {
      System.out.println("========== testPreactivate ==========\n");
      Perceptron perceptron = new Perceptron(2, new ReLUActivationFunction());
      printPerceptron(perceptron);
      double[] inputs = {1, -1};
      System.out.println("Preactivation (passed {1, -1} as inputs");
      System.out.println(perceptron.preactivate(inputs));
   }
   
   public static void testActivate() {
      System.out.println("========== testActivate ==========\n");
      Perceptron[] p = new Perceptron[9];

      p[0] = new Perceptron(2, new IdentityActivationFunction());
      p[1] = new Perceptron(2, new LeakyReLUActivationFunction());
      p[2] = new Perceptron(2, new LinearActivationFunction(10));
      p[3] = new Perceptron(2, new ParametricReLUActivationFunction(10));
      p[4] = new Perceptron(2, new ReLUActivationFunction());
      p[5] = new Perceptron(2, new SigmoidActivationFunction());
      p[6] = new Perceptron(2, new StepActivationFunction());
      p[7] = new Perceptron(2, new SwishActivationFunction());
      p[8] = new Perceptron(2, new TanhActivationFunction());
      
      double[] inputs = {1, -1};
      double[] weights = {0.5, 0.5};
      
      for (int i = 0; i < p.length; i++) {
         System.out.printf("p[%d]\n\n", i);
         p[i].setWeights(weights);
         printPerceptron(p[i]);
         System.out.printf("Output: %.3f\n\n", p[i].activate(inputs));
      }
      
      System.out.println();
   }
}