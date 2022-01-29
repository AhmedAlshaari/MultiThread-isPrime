# MultiThread-isPrime
This repository consists of a project of a multi-thread Java program that uses 8 threads to find all the prime numbers between 1 and 10^8.

## General Information and Summary
The approach taken in this project is one where first, an isPrime function was written that checks if a singular number passed to it is prime or not, then an atomic counter is created and 8 threads are started. Then each of the 8 threads takes turns incrementing the counter and then passing the value of the counter to isPrime and completing the computation. with this approach, all 8 threads are working simultaneously and as soon as one of them is done, it just moves on to the next number that has not been computed yet.

This program is correct because it uses a very accurate isPrime function and each number is only processed once which guarantees the most efficient processing possible for this specific algorithm. 

The experimental evaluation for this project was one where smaller input values were tested to ensure accuracy and then they were increased as testing went until all the values between 1 and 10^8 have been processed. 

## To compile and run this program:
- First, navigate to the directory where you have the program saved in your command line.
- Type the following command
```
prompt> javac isPrime.java
```
- After that command executes, type the following command:
```
prompt> java isPrime
```
The program should take around 4 minutes to run, after that is done, an output file called "primes.txt" will be created which will have the output of the file in it.
