# LCD Numbers Remove DI Framework Kata

Refactoring LCD Numbers to remove the dependency injection framework.

This is an implementation of the [LCD Numbers Kata](http://rubyquiz.com/quiz14.html)
using (excessive) outside-in development and making use of a dependency injection framework.

The starting point is available in different programming languages.
The `Main` class is the entry point to the application. Run it to see the LCD Numbers working.
It prints help how to run the application using the build tool (Maven, Gradle, ...) or standalone.
The production code is based on my
[LCD Numbers Mocking Kata](https://github.com/codecop/LCD-Numbers-Mocking-Kata)
which contains a diagram and a description of the solution in each language.

## Detailed Requirements (copied from Ruby Quiz)

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

## Tests

There are (integrated) tests covering the whole application.
There are sample LCD outputs in the `src/test/resources` folder
(or similar depending on language) to be used in tests.

## Your Refactoring Task

The original idea by [Nat Pryce](https://twitter.com/natpryce/status/1273916454317015040) is to
"replace use of a dependency injection framework with plain old functions and
classes that model the application domain."

### First Steps

[Phil Webb suggests](https://twitter.com/phillip_webb/status/1274417744205606913)
a few things you could do to your app to make the dependency injection
framework a bit less invasive in the first place. (These might not apply to all
languages.)

* The first is you can use constructor injection. This will make it easier
  to create objects without the framework.
* If you use constructor injection it's possible (and often recommended) that
  you write tests without involving the framework at all. This will help with
  the migration.
* Remove classes only created to support the dependency injection mechanism, e.g.
  `ScalingArgument` or `CommandLineArguments`.

### (Spoiler) Problems of the existing solution

The code contains loads of the dysfunction I see in apps that use DI heavily.

* Needs a special test framework.
* Dependencies obscured by reflection.
* Objects that should be functions.
* Loads of pointless logging.
* Slow to start.
* DI annotations in domain classes.
* A bit of polymorphism making code navigation in the IDE more difficult.
* And even more smells. "It's like a fractal of code smells."

### License

This work is licensed under a [New BSD License](http://opensource.org/licenses/bsd-license.php), see `license txt` in repository.
