# Refactoring LCD Numbers to remove the dependency injection framework

This is an implementation of the [LCD Numbers Kata](http://rubyquiz.com/quiz14.html)
using outside-in development making use of a dependency injection framework.
There are (integrated) tests.

The starting point is available in different programming languages.
The production code is based on the
[LCD-Numbers-Mocking-Kata](https://github.com/codecop/LCD-Numbers-Mocking-Kata)
which contains a description of the solution in each language.

## Requirements (copied from Ruby Quiz)

The `LcdDisplay` creates an LCD string representation of an integer value using a
4x7 grid of space each, using minus and pipe characters for each digit.
Each digit is shown below:

     --      --  --      --  --  --  --  --
    |  |   |   |   ||  ||   |      ||  ||  |
    |  |   |   |   ||  ||   |      ||  ||  |
             --  --  --  --  --      --  --
    |  |   ||      |   |   ||  |   ||  |   |
    |  |   ||      |   |   ||  |   ||  |   |
     --      --  --      --  --      --  --

The bar size should be adjustable. The default value is 2 - as shown above.
Read more about it at [RubyQuiz](http://rubyquiz.com/quiz14.html).

## Your Task

Idea by [Nat Pryce](https://twitter.com/natpryce/status/1273916454317015040):
"Replace use of a dependency injection framework with plain old functions and
classes that model the application domain."

### License

This work is licensed under a [New BSD License](http://opensource.org/licenses/bsd-license.php), see `license txt` in repository.
