# Learn Scala By Example

---

## Introduction

Some examples to assist in the understanding of Scala, particularly aimed at programmers coming from the 
Python language.  


Examples hope to provide an understanding of what, how and why Scala does things the way it does them.


Any (and all) comments welcome; but please remember that these examples are designed _to demonstrate
certain features of Scala_, and are not necessarily shining examples of how to write code more generally. 


&nbsp;


All code compiles and runs.  But there are no tests.

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

After introducing `Try`, intent of the algorithms, types and logic are fairly unchanged.

NOTE: there are now _four_ print statements resulting in extra code, this is incidental and can be ignored


&nbsp;


---


&nbsp;


**6. Scala `kitchen.example-3.scala`**

_Scala Example with a Future._ 

We can extend this example to include an extra step in the tea making process - a boiling kettle!

Scala supports asynchronous processes (processes that require time to execute without blocking) 
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

The code now uses two asynchronous processes, it waits for the kettle to boil and for the milk to arrive 
from the fridge.  You can see that while this 
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

This example just shows some other features of Scala:

- Traits: abstract types used to define variables
- Sealed Traits: used to provide enumerations (a.k.a _Algebraic Data Types_)
- Case Classes: universal templates for object / variables
- Use of Pre-conditions & Post-conditions: DbC
- Passing Implicit Parameters


&nbsp;


---


&nbsp;


**9. Scala `race.racing-example.scala`**

_Bonus Example_ 

A final, more advanced example, including usage of:

- Composite Types
- Functional Composition (2 different approaches: `enterRaceMethod1` & `enterRaceMethod1`)
- Mix-ins (`with`)
- Implicit Classes (extending existing Types)
- Currying

&nbsp;


---

&nbsp;

