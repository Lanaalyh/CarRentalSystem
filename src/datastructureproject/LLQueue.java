package datastructureproject;

import java.util.Scanner;

public class LLQueue <E>{
   
 static class Node<E> {

        private E element; 
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setelement(E element) {
            this.element = element;
        }
    }
    protected Node<E> front;
    protected Node<E> rear;
    protected int size;

    public LLQueue() { 
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { 
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    public E last() { 
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest;  
        } else {
            rear.setNext(newest); 
        }
        rear = newest; 
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null; 
        }
        return answer;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("There is NO Booking in this Queue ");
            return;
        }
        int s = size();
        for (int i = 0; i < s; i++) {
            Booking B = (Booking) dequeue();
            System.out.println(B);

            enqueue((E) B);
        }
    }
    
    public void CancelBookingByID(int Booking_ID) {

        if (isEmpty()) {
            System.out.println("There is NO Booking with this id in this queue!");
        }
        int s = size;
        for (int i = 0; i < s; i++) {
            Booking booking = (Booking) dequeue();
            if (booking.getBooking_ID() == Booking_ID) {
                System.out.println("Booking with id " + Booking_ID + " Has been Cancelled");
            }
            enqueue((E) booking);
        }
    }
  
    public Booking SearchBookingByID(int id) {

        int s = size();
        Booking book = null;
        for (int i = 0; i < s; i++) {
            Booking booking = (Booking) dequeue();
            if (booking.getBooking_ID() == id) {
                book = booking;
            }
            enqueue((E) booking);
        }
        return book;
    }
  
   public void CheckNextcustomerBooking() {
    if (isEmpty()) {
        System.out.println("No bookings in the line.");
    } else {
        Booking booking = (Booking) dequeue();
        System.out.println("Processing the next booking...");
        System.out.println(booking);

        booking.setBooking_Status("Complete");
        System.out.println("\nThe booking has been marked as complete.");

       
        enqueue((E) booking);

        System.out.println("--------------------------------------------------");
    }
}


   
    
   

}