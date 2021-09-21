# Learn Scala By Example

---

## Introduction

Some examples to assist in the understanding of techniques to manage growing complexity in code, demonstrated in Scala.


Examples hope to provide an understanding of how to deal with growing code complexity and maintain readability when dealing with increasing functional and non-functional pressures.


You won't find any examples of Scalaz, Cats or Shapeless here - it's just basic techniques and approaches included for use within the standard Scala SDK.

Please remember that these examples are designed _to demonstrate how to avoid certain problems_, and are not necessarily examples of how to write code outside that context. 


&nbsp;


All code compiles and runs.

&nbsp;


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¯\\_(ツ)\_/¯

&nbsp;


---
---

The Examples
===============

---
---


&nbsp;


**1. Python `example-1.py`**

_Basic Example of Making a Cup of Tea._ 

The idea here is to familiarise yourself with this basic example in Python 
(a language you know well?) so that you will understand later examples.

The code here makes a cup of tea in pretty much the way you would expect.

The problem is that when you add in error checking, validation, exception 
handling, conditional logic, and other such complexities, the code will begin to 
get difficult to follow and the overall intent will be lost / reduced.

NOTE: I have not actually added extra complexities here, but hopefully you get 
what is meant by this.


&nbsp;


---


&nbsp;


**2. Python `example-2.py`**

_Object-oriented Example._

Can this problem be solved by OOP? Let's look at an OO Python example (or more 
Python-esque, if you will).

So far so good. There's a lot more lines, but the intent is clear; and it might scale better.
Let's try...


&nbsp;


---


&nbsp;


**3. Python `example-3.py`**

_Object-oriented Example with Validation._

In this example, we see extra checks have been introduced to the code, to ensure that:

- Water is hot
- Milk has not gone sour
- Sugar is definitely sugar (and not salt)

We can see that just by introducing these three checks the `make_drink` code is 
getting more difficult to read and understand - _despite using Python OO techniques!_

Even the exceptions must be caught and handled somewhere.  And you can (hopefully) see how this would only get worse with time.


&nbsp;


---


&nbsp;


**4. Scala `kitchen.example-1.scala`**

_Basic Example of Making a Cup of Tea in Scala._ 

Here's the first look at our familiar tea making example in Scala.  This example contains:

- Type declarations
- Algorithm
- Supporting functions
- Print statement

This code is similar to the Python example, roughly the same number of lines, 
and the intent is reasonably clear.

&nbsp;


---


&nbsp;


**5. Scala `kitchen.example-2.scala`**

_Scala Example with Validation._ 

Let's add in the same validation as before... 

You should notice that nothing much has changed.  We've introduced 
some extra error scenario information (`BadMilk`, `ColdWater`, etc) and, to deal with the possible failures, we import 
`Try` - one of those wrappers (or monads) that Scala comes with: 


`import scala.util.{Try, Success, Failure}`


I hope you can agree, after introducing `Try`, intent of the algorithms, types and logic are fairly unchanged.

NOTE: there are now _four_ print statements resulting in extra code, this is incidental and can be ignored


&nbsp;


---


&nbsp;


**6. Scala `kitchen.example-3.scala`**

_Scala Example with a Future._ 

We can extend this example to include an extra step in the tea making process - a boiling kettle!

Although, boiling water might take some time and we'll have to wait for the kettle to finish.
For this, Scala supports _asynchronous_ processes (i.e. processes that require time to execute and are handled without blocking) 
using `Future`s (another Scala wrapper).

This provides minimal impact on the structure of the code while still allowing all the error 
handling, extra conditions, etc.

NOTE: Print statements now support the following scenarios:

- A Boiled Kettle (sunny day scenario)
- A Half-Boiled Kettle (returns wrong value)
- A Faulty Kettle (doesnt return at all)


&nbsp;


---


&nbsp;


**7. Scala `kitchen.example-4.scala`**

_Scala Example with Two Futures._ 

We can extend even more, to add another processing step - getting milk out of the fridge.

Again, this might take some time.  So, now the code uses two asynchronous processes, it 
waits for the kettle to boil and for the milk to arrive from the fridge.  
You can see that while this 
has added more code, it's still readable and the intent is still very clear.  

Contrast this with the layers of conditional logic we saw before 
(without the constructs that Scala provides).


NOTE: Print statements now support the following scenarios:

- A Boiled Kettle
- A Half-Boiled Kettle
- A Faulty Kettle
- No Milk in Fridge


&nbsp;


---


&nbsp;


**8. Scala `kitchen.example-5.scala`**

_Other Interesting Features._ 

This example just shows how you might want to extend the Tea Making process 
using some other features of Scala:

- Traits: abstract types used to define and constrain variables
- Sealed Traits: used to provide enumerations (a.k.a _Algebraic Data Types_)
- Case Classes: universal templates for objects / variables
- Use of Pre-conditions & Post-conditions: used to ensure objects are always configured correctly
- Passing Implicit Parameters: simplify code by automatically injecting state 


&nbsp;


---


&nbsp;


**9. Scala `race.racing-example.scala`**

_Bonus Example_ 

A final, more advanced example, including usage of:

- Composite Types
- Functional Composition (3 different approaches: `enterRaceMethod1`, `enterRaceMethod2` & `enterRaceMethod3`)
- Mix-ins (`with`)
- Implicit Classes (extending existing Types)
- Currying


&nbsp;


---
---

Bonus
===============

---
---

_Clojure Example of Making a Cup of Tea._ 

For those who are still reading, you will have noticed some Clojure examples 
in the repo that offer simple versions of our by-now-familiar 
_making a cup of tea_ conundrum, written in Clojure.

- Example 1: basic, readable
- Example 2: uses a threading macro (`->`))
- Example 3: introduces (basic) error handling using the `some->` threading macro.  `some->` ensures that if any step is unsuccessful, the remaining steps are shortcut (without an exception thrown or error raised).  Instead `nil` is returned, which is Clojure dialect for 'something went wrong'.


&nbsp;


Next steps would be to introduce monads into this Clojure code (as we did before with Scala)
to give more granular and flexible error reporting and asynchronous processing - but 
I leave that as an exercise for the reader!


&nbsp;


---

&nbsp;

