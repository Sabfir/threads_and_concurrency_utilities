# Tutorial: Java Threads and the Concurrency Utilities
Jeff Friesen - Java Threads and the Concurrency Utilities (The Expert's Voice in Java) - 2015

## Chapter 1. Threads and Runnables
Write an IntSleep application that creates a background thread
to repeatedly output Hello and then sleep for 100 milliseconds.
After sleeping for 2 seconds, the default main thread should
interrupt the background thread, which should break out of the
loop after outputting interrupted .

## Install. Run from the project root directory:
```shell
$ git clone https://github.com/Sabfir/threads_and_concurrency_utilities.git
$ cd threads_and_concurrency_utilities
$ cd 1-threads-and-runnables
$ mvn clean install
$ mvn exec:java -Dexec.mainClass="com.opinta.App_1"
```
or
```shell
$ git clone https://github.com/Sabfir/threads_and_concurrency_utilities.git
$ cd threads_and_concurrency_utilities
$ mvn install -pl 1-threads-and-runnables -am
$ cd 1-threads-and-runnables
$ mvn exec:java -Dexec.mainClass="com.opinta.App_1"
```

```shell
Summary
Java applications execute via threads, which are independent paths of execution through
an application’s code. Each Java application has a default main thread that executes the
main() method. The application can also create threads to perform time-intensive tasks
in the background so that it remains responsive to its users. These threads execute code
sequences encapsulated in objects that are known as runnables.
The Thread class provides a consistent interface to the underlying operating system’s
threading architecture. (The operating system is typically responsible for creating and
managing threads.) A single operating system thread is associated with a Thread object.
The Runnable interface supplies the code to be executed by the thread that’s
associated with a Thread object. This code is located in Runnable’s void run()
method—a thread receives no arguments and returns no value although it might throw
an exception.
Except for the default main thread, threads are introduced to applications by creating
the appropriate Thread and Runnable objects. Thread declares several constructors for
initializing Thread objects. Several of these constructors require a Runnable object as an
argument.
A Thread object associates state with a thread. This state consists of a name, an
indication of whether the thread is alive or dead, the execution state of the thread (is it
runnable?), the thread’s priority, and an indication of whether the thread is daemon or
nondaemon.
After creating a Thread or Thread subclass object, you start the thread associated
with this object by calling Thread’s void start() method. This method throws
IllegalThreadStateException when the thread was previously started and is running or
the thread has died.
Along with simple thread tasks for configuring a Thread object and starting the
associated thread, the Thread class supports more advanced tasks, which include
interrupting another thread, joining one thread to another thread, and causing a thread
to go to sleep.
Chapter 2 presents synchronization.
```
