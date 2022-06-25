import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList implements ListIterator {
	
	private Node head= new Node("headNode",null,null);
	private Node tail=new Node(null,head,null);
	
	private int listSize=0;
	
	private Node iteratorNode = new Node("iterarorNode",head,head.next);
	private Node setNode=new Node(null,null,null);
	private boolean nextOrPreviousCalled =false;

	public void add(String element) {	
		listSize++;
		Node newNode= new Node(element,tail.previous,tail);	
		newNode.previous.next=newNode;
		tail.previous = newNode;
		tail.next = null;	
		if(listSize==1) {
			iteratorNode.next=newNode;
		}
	}
	
	public void add(int i, String string) {
		if(i>listSize+1||i<0) {
			throw new IndexOutOfBoundsException();
		}
		try {
		listSize++;
		Node newNode= new Node(string, null, null);
		if(i==0) {
			newNode.next=head.next;
			head.next=newNode;
			newNode.previous=head;
		}
		else {
			Node temp = new Node(null,null,null);
			temp=head;
			for(int j=0;j<i;j++) {
				if(temp!=null) {
					temp=temp.next;
				}
			}
			if(temp!=null) {
				newNode.next=temp.next;
				newNode.previous=temp;
				temp.next=newNode;
				if(newNode.next!=null) {
					newNode.next.previous=newNode;
				}
			}
		}
		if(getNodeIndex(newNode)==listSize) {
			tail.previous=newNode;
		}
		
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("out of bounds");
		}
	}
	
	public String toString() {
		String printedList="[";
		Node checkNode = this.head.next;
		
		for(int i =0; i<listSize;i++) {
			if(checkNode!=null) {
			if(checkNode.next!=null) {
				if(checkNode.next.value!=null) {
				printedList=printedList+(checkNode.value+ ", ");		
				}
				else if(checkNode.value!=null) {
					printedList=printedList+(checkNode.value);
				}			
			}
			else if(checkNode.value!=null) {
				printedList=printedList+(checkNode.value);
			}			
		checkNode=checkNode.next;
		}
		}	
		printedList=printedList+"]";
		return printedList;
	}

	public int size() {
		return listSize;
	}
	
	public String get(int nodeIndex) {
		Node checkNode=head.next;
		String nodeValue="";
		for(int iterIndex=0; iterIndex<=nodeIndex; iterIndex++ ) {
			if(iterIndex==nodeIndex) {
				nodeValue=checkNode.value;
				break;
			}
			checkNode=checkNode.next;
		}
		return nodeValue;		
	}
	
	public void remove(int i) {
		Node checkNode=head.next;
		for(int j=0; j<=i;j++) {
			
			if(j==i) {
				if(checkNode.previous!=null) {
			    (checkNode.previous).next=checkNode.next;
				}
			    if(checkNode.next!=null) {
				(checkNode.next).previous=checkNode.previous;
			    }			    
				listSize--;
				break;
			}
			Node temp=checkNode;
			checkNode=checkNode.next;
			checkNode.previous=temp;
		
		}
		
	}
	public void clear() {
		for(int i =0; i<listSize+i;i++) {
			listSize--;
		}
		head.next=null;		
	}
	
	public void set(int i, String string) {
		
		Node checkNode=head.next;
		for(int j=0; j<=i; j++) {
			if(i==j) {
				checkNode.value=string;
			}
			checkNode=checkNode.next;
		}
	}
	
	public int getNodeIndex(Node node){
		Node checkNode= new Node(null,null,head) ;
			for(int i=0;i<=listSize+2;i++) {
				if(checkNode==node) {
					return i-1;
				}
				else {
					checkNode=checkNode.next;
				}
			}
			return -1;
		}
	
	//LIST ITERATOR:	
	public ListIterator listIterator() {
		return this;
	}
	
	@Override
	public void add(Object value) {
		if(nextOrPreviousCalled==false){
			throw new IllegalStateException();
		}
		else {
		nextOrPreviousCalled=false;
		add(getNodeIndex(iteratorNode.previous), (String)value);
		iteratorNode.previous=iteratorNode.next.previous;
		iteratorNode.next=iteratorNode.next;
		listSize++;
		}
	}
	
	@Override
	public Object next() {
		if(hasNext()==true) {
		nextOrPreviousCalled=true;
		iteratorNode.previous=iteratorNode.next;
		iteratorNode.next=iteratorNode.next.next;
		setNode=iteratorNode.previous;
		return iteratorNode.previous.value;
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	@Override
	public Object previous() {
		if(hasPrevious()==true) {
		nextOrPreviousCalled=true;
		iteratorNode.next=iteratorNode.previous;
		iteratorNode.previous=iteratorNode.next.previous;
		//System.out.println("okok previous: "+iteratorNode.previous.value);
		//System.out.println("okok next: "+ iteratorNode.next.value);
		setNode=iteratorNode.next;
		return iteratorNode.next.value;
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	@Override
	public boolean hasNext() {
		if(iteratorNode.next.next!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean hasPrevious() {
		if(iteratorNode.previous.previous!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int nextIndex() {
		return getNodeIndex(iteratorNode.next)-1;
	}	
	@Override
	public int previousIndex() {
		return getNodeIndex(iteratorNode.previous)-1;
	}
	
	
	@Override
	public void remove() {
		if(nextOrPreviousCalled==false){
			throw new IllegalStateException();
		}
		else {
			nextOrPreviousCalled=false;
			iteratorNode.next=setNode.next;
			iteratorNode.previous=setNode.previous;
			setNode.previous.next=setNode.next;
			setNode.next.previous=setNode.previous;
		}
	}
	
	@Override
	public void set(Object element) {
		if(nextOrPreviousCalled==false){
			throw new IllegalStateException();
		}
		else {
		nextOrPreviousCalled=false;
		setNode.value=(String)element;
		}
	}
}





