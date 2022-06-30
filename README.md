# perceptron
Perceptron Algorithm implemeted in Java
---------
TASK
---------
The training set in perceptron.data contains the Iris dataset limited to Iris-versicolor
and Iris-virginica. perceptron.test.data contains the test set. Implement the perceptron and train it to classify the two species. Test with the test set and output the
accuracy.
The program should have the following capabilities:
 Loading any dataset in csv format, where the last column is the class. The number
of weights should be adjusted to the dataset. (!!)
 Picking the learning rate.
 Simple UI to manually input vectors to classify.
 Hints: for best results pick a small learning rage (e.g. 0.01) and repeat the learning
procedure for a larger number of iterations. Iris-versicolor and Iris-virginica
are not linearly separable (the iteration error will never be 0), but the test set can
nevertheless be classified with high accuracy.
