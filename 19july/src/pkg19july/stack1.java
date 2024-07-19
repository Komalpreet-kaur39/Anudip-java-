/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg19july;

//Write a Java program that implements a Stack using an array. The Stack should have the following methods:
//
//push(int element): adds an element to the top of the stack
//pop(): removes the top element from the stack
//peek(): returns the top element from the stack without removing it
//isEmpty(): checks if the stack is empty
//size(): returns the number of elements in the stack

public class stack1 {
    private int[] array;
    private int top;

    public stack1(int capacity) {
        array = new int[capacity];
        top = -1;
    }

    public void push(int element) {
        if(top==array.length-1){
            System.out.println("Stack is overflow");}
    else{
    array[++top]=element;
            System.out.println(element+"is pushed into stack");
}
    }

    public int pop() {
        if(top<0){
            System.out.println("Stack is underflow");
            return -1;
        }
        else{
       int x= array[--top];
            System.out.println(x+"is poped from the stack");
       return x;
        }
    }
    public boolean isEmpty() {
        return top==-1;
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
      return array[top];   
    }
    }

    public int size() {
        return top+1;
    }
    public static void main(String[] args) {
        stack1 stack = new stack1(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());
        
        stack.pop();
        System.out.println("Stack size is: " + stack.size());
        
//        while (!stack.isEmpty()) {
//            stack.pop();
//        }

        System.out.println("Stack is empty: " + stack.isEmpty());
        
    }
}


