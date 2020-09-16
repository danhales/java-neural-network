package neuralnetwork.test;
import neuralnetwork.activationfunction.ActivationFunction;
import neuralnetwork.activationfunction.LinearActivationFunction;
import neuralnetwork.activationfunction.IdentityActivationFunction;
import neuralnetwork.activationfunction.ParametricReLUActivationFunction;
import neuralnetwork.activationfunction.ReLUActivationFunction;
import neuralnetwork.activationfunction.LeakyReLUActivationFunction;
import neuralnetwork.activationfunction.SigmoidActivationFunction;

public class ActivationFunctionTests
{
   public static void main(String[] args)
   {
      testLinearActivationFunction();
      testIdentityActivationFunction();
      testParametricReLUActivationFunction();
      testReLUActivationFunction();
      testLeakyReLUActivationFunction();
      testSigmoidActivationFunction();
   }
   
   public static void evaluate(ActivationFunction f)
   {
      double value = 10.0;
      System.out.println("f(" + value + ") = " + f.evaluate(value));
      System.out.println("f(" + (-1*value) + ") = " + f.evaluate(-1*value));
      System.out.println("f'(" + value + ") = " + f.evaluateDerivative(value));
      System.out.println("f'(" + (-1*value) + ") = " + f.evaluateDerivative(-1*value));
      System.out.println();
   }
   
   public static void testLinearActivationFunction()
   {
      System.out.println("LinearActivationFunction(3)");
      ActivationFunction linear = new LinearActivationFunction(3);
      evaluate(linear);
   }
   
   public static void testIdentityActivationFunction()
   {
      System.out.println("IdentityActivationFunction");
      ActivationFunction identity = new IdentityActivationFunction();
      evaluate(identity);
   }
   
   public static void testParametricReLUActivationFunction()
   {
      System.out.println("ParametricReLUActivationFunction(3)");
      ActivationFunction prelu = new ParametricReLUActivationFunction(3);
      evaluate(prelu);
   }
   
   public static void testReLUActivationFunction()
   {
      System.out.println("ReLUActivationFunction()");
      ActivationFunction relu = new ReLUActivationFunction();
      evaluate(relu);
   }
   
   public static void testLeakyReLUActivationFunction()
   {
      System.out.println("LeakyReLUActivationFunction()");
      ActivationFunction lrelu = new LeakyReLUActivationFunction();
      evaluate(lrelu);
   }
   
   public static void testSigmoidActivationFunction()
   {
      System.out.println("SigmoidActivationFunction()");
      ActivationFunction sigmoid = new SigmoidActivationFunction();
      evaluate(sigmoid);
   }
}