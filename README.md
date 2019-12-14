# DesignPatterns
A series of design pattern examples used in SYSC 3110.
Also a cheatsheet for the SYSC 3110 exam

# Observer

## Participants

### Subject/Observable
    - Knows its observers
    - Provides an interface fora dding and removing Observer objects
    - Provides an interface for setting state and triggering notification
### Observer
    - Defines an updating interface for objects that should be notified of changes in an observable
## Java Event Model
    - Replacement for Observer Pattern
    - Addresses the same types of needs as Observer/Observable while solving some of the latter's limitations
    - An event source can now encapsulate all relevant info in an event object that it sends to its event listeners
    - All listeners implement a common interface defined for the particular event
    - Event source maintains a  list of listeners
    - When a change occurs, event source instantiates an event objec and sends it by iterating over the list of listeners invoking one of the methods defined in the lsitener interface
# MVC
    - Model
        - **Contents of application**
        - Only has accessor/mutator interface
        - Notifies when any subscribed views when a change is made
    - View
        - Main Graphical Interface the user sees
        - **Displays of the contents**
        - Subscribes to the model and ensures the model's current state is reflected to the user
    - Controller
        - Handles the user input thereby setting the behaviour of the view
            - Updates the model according to inputs from the user
                - Update will then make the model notify it's views since they are subscribed to the model
             - Can also update the view 
# Composite
    -  You want to represent part-whole hieararchies of objects
    -  You want clients to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite structure uniformly.
    -  Usually has a client that uses an abstract parent class with a child class one being the leaf and the other being a composite
    -  Composite contains a list of it's parent sort of like a "branch"
# Strategy
    - Each concrete strategy provides a concrete implementation of the algorithm specified in the abstract/interface (usually interface) strategy
    - The conext chooses an algorithm by instantiating the corresponding concrete strategy
# Template Method
    - When you use abstract methods that haven't been initialized yet
    - IsEmpty is a function for lists that can use the size() fucntion
    - size() function is abstract and won't be implemented till you make arrays
# Decorator

# Factory
