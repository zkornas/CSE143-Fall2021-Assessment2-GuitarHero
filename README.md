# CSE143-Fall2021-Assessment2-GuitarHero
Take-home Assessment 2: Guitar Hero

## Part 1: GuitarString class
In the first part of the assignment, you will implement a class called GuitarString that models a vibrating guitar string of a given frequency. The GuitarString object will need to keep track of a ring buffer. You are to implement the ring buffer as a queue using the Queue<E> interface and the LinkedList<E> implementation. For this assignment, you are limited to the Queue<E> methods in the section materials and slide 16 of the stack/queue slides (add, remove, isEmpty, size, and peek). You are not allowed to use other data structures or other Queue<E> methods to solve this problem.

## Part 2: The Guitar37 class
In this second part of the assignment, your task is to write a different implementation of the Guitar interface known as Guitar37. It will model a guitar with 37 different strings. Unlike GuitarLite which has a separate field for each of its strings, you will want to use a data structure, specifically an array, to keep track of the strings in Guitar37.

You can read the full specification [here!](https://courses.cs.washington.edu/courses/cse143/21au/take-home-assessments/a2/a2.pdf)
