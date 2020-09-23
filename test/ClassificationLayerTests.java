package neuralnetwork.test;
import neuralnetwork.layer.ClassificationLayer;
import neuralnetwork.activationfunction.*;

public class ClassificationLayerTests {
   public static void main(String[] args) {
      testConstructor();
   }
   
   public static void testConstructor() {
      String[] labels = {"one", "two", "three"};
      ClassificationLayer cl = new ClassificationLayer(labels,
                                                       3,
                                                       new IdentityActivationFunction());
      double[] inputs1 =  {100, 0, 0}; 
      double[] inputs2 =  {0, 100, 0};
      double[] inputs3 =  {0, 0, 100};  
      
      System.out.println(cl.predictLabel(inputs1));
      System.out.println(cl.predictLabel(inputs2));
      System.out.println(cl.predictLabel(inputs3));
      System.out.println();
                                                    
      cl.printDebug();
   }
}