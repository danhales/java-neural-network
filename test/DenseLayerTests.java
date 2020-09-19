package neuralnetwork.test;
import neuralnetwork.layer.DenseLayer;
import neuralnetwork.neuron.Perceptron;
import neuralnetwork.activationfunction.*;

public class DenseLayerTests {
   public static void main(String[] args) {
      // testConstructor();
      testFeedForward();
   }
   
   public static void testConstructor() {
      System.out.println("========== testConstructor ==========");
      DenseLayer layer = new DenseLayer(4, 5, new StepActivationFunction());
      Perceptron[] p = layer.getPerceptrons();
      
      for (int i = 0; i < p.length; i++) {
         System.out.println("Perceptron #" + (i+1));
         PerceptronTests.printPerceptron(p[i]);
      }
      System.out.println();
   }
   
   public static void testFeedForward() {
      System.out.println("========== testFeedForward ==========");      
      DenseLayer layer = new DenseLayer(2, 3, new StepActivationFunction());
      Perceptron[] p = layer.getPerceptrons();
      
      for (int i = 0; i < p.length; i++) {
         System.out.println("Perceptron #" + (i+1));
         PerceptronTests.printPerceptron(p[i]);
      }
      
      double[] inputs = {1,-2,3};
      
      System.out.println("Feeding [1,2,3] to the Perceptrons...");
      double[] outputs = layer.feedForward(inputs);
      
      System.out.println("Outputs:");
      
      for (int i = 0; i < outputs.length; i++) {
         System.out.println("Output from perceptron #" + (i+1) + ": " + outputs[i]);
      }
   }
}