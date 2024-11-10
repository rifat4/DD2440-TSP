public class Node {

    Node next;
    Node prev;

    int id;

    //realisation, node implementation will still have same problem as a list implementation.
    //We still have to reverse the sublist making the complexity for changing using 2-opt once O(n/2), might as well just use an array.

    Node(Node next, Node prev, int id){
        this.id = id;
        this.next = next; if(next != null) next.setPrev(this);
        this.prev = prev; if(prev != null) prev.setNext(this);
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void reverseNode(){
        Node temp = next;
        next = prev;
        prev = temp;
    }


}
