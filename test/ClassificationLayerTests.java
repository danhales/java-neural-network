package neuralnetwork.test;
import neuralnetwork.layer.ClassificationLayer;
import neuralnetwork.activationfunction.*;
import neuralnetwork.neuron.Neuron;

public class ClassificationLayerTests {
   public static void main(String[] args) {
      testConstructor();
   }
   
   public static void testConstructor() {
      String[] labels = {"one", "two", "three"};
      ClassificationLayer cl = new ClassificationLayer(labels,
                                                       3,
                                                       new IdentityActivationFunction());
      double[] inputs = {1, -1, 0};
      System.out.println("Evaluate:");
      double[] predictions = cl.evaluate(inputs);
      
      for (int i = 0; i < predictions.length; i++) {
         System.out.println(predictions[i]);
      }
      
      System.out.println(cl.predictLabel(inputs));
      
      // cl.printDebug();
   }
}