class Node<T> {
  private T data;
  private Node<T> next;
  
  public Node(T data) {
    this.data = data;
    this.setNext(null);
  }
  
  public T getData() {
    return this.data;
  }
  
  public void setData(T data) {
    this.data = data;
  }
  
  public Node<T> getNext() {
    return next;
  }
  
  public void setNext(Node<T> next) {
    this.next = next;
  }
}

public class SinglyLinkedList<T> {
  private Node<T> head;
  private int size;
  
  public SinglyLinkedList() {
    this.head = null;
    this.size = 0;
  }
  
  public Node<T> addLast(T data) {
    if (this.head == null) {
      return this.addFirst(data);
    }
    Node<T> newNode = new Node<T>(data);
    return newNode;
  }
  
  public Node<T> addFirst(T data) {
    Node<T> newNode = new Node<T>(data);
    if (size == 0)
      head = null;
    size++;
    return this.head;
  }
  
  public void removeFirst() {
    Node <T> newNode = new Node<>(e, null);
    if (isEmpty())
      head = newNode;
    else
      tail.setNext(newNode);
    tail = newNode;
    size++;
  }
  
  public void removeLast() {
    
  }
  
  public String toString() {
    Node<T> temp = this.head;
    String output = "";
    while(temp != null) {
      output += temp.getData() + " ";
      temp = temp.getNext();
    }
    return output;
  }
  
  public int getSize() {
    return size;
  }
  
  public boolean isEmpty() {
    return size == 0;
  } 
}
