# MultiThread-isPrime
This repository consists of a project of a multi-thread Java program that uses 8 threads to find all the prime numbers between 1 and 10^8.

## General Information and Summary
The approach taken in this project is that it uses the sieve algorithm and splits its steps equally across the 8 threads, https://www.geeksforgeeks.org/sieve-of-eratosthenes/ is the source of the algorithm. The splitting works on this algorithm because the values do not get more costly as they increase since it only sets an array of boolean of length 10^8 to either true or false, so the steps can be split across the 8 threads.

This program is correct because it uses a very accurate aLGORITHM function and each number is only processed once which guarantees the most efficient processing possible for this specific algorithm. 

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
