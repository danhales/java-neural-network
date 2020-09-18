package neuralnetwork.test;
import neuralnetwork.layer.Layer;
import neuralnetwork.neuron.Perceptron;
import neuralnetwork.activationfunction.*;

public class LayerTests {
   public static void main(String[] args) {
      testConstructor();
   }
   
   public static void testConstructor() {
      Layer layer = new Layer(4, 5, new StepActivationFunction());
      Perceptron[] p = layer.getPerceptrons();
      
      for (int i = 0; i < p.length; i++) {
         System.out.println("Perceptron #" + (i+1));
         PerceptronTests.printPerceptron(p[i]);
      }
   }
}