# java-neural-network
A neural network package built from scratch in Java

I'm building this package from the ground up to get my Java up and running again after completing Flatiron's Data Science program in python

The goal is to dive deeper into the internals of neural networks, to really understand how they're doing what they're doing.

## test
The `test` directory contains files for testing.

## activationfunction
Contains `ActivationFunction` interface and implementations `LinearActivationFunction`, `IdentityActivationFunction`, `ParametricReLUActivationFunction`, `ReLUActivationFunction`, `LeakyReLUActivationFunction`, `SigmoidActivationFunction`, `TanhActivationFunction`, `SwishActivationFunction`, `StepActivationFunction`

## neuron
Contains `Perceptron` class

## layer
Contains `Layer` class

As of 9/17/20:
Primary focus right now is on putting together the architecture for a Dense layer of simple Perceptrons. So far, the Layer class can hold an array of Perceptrons, and the constructor accepts the number of Perceptrons, the number of inputs for each Perceptron, and the ActivationFunction to be used.

Functionality that needs to be added to Layer includes:
- Feeding an array of inputs to each Perceptron
- Creating an array of doubles for the outputs from all Perceptrons
- Accepting an array of outputs from another Layer object

Once we get forward propagation going, we can start thinking about backprop!
