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