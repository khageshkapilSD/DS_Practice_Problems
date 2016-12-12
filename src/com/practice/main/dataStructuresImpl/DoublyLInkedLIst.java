package com.practice.main.dataStructuresImpl;

import java.util.Scanner;

public class DoublyLInkedLIst<Type extends Comparable<Type>> {

	 protected BinaryNode<Type> start;
	    protected BinaryNode<Type> end ;
	    public int size;
	 
	    /* Default Constructor to set start and end as zero */
	    public DoublyLInkedLIst()
	    {
	        start = null;
	        end = null;
	        size = 0;
	    }
	    /* Method to check if list is empty */
	    public boolean isEmpty()
	    {
	        return start == null;
	    }
	    /* Method to get size of list */
	    public int getSize()
	    {
	        return size;
	    }
	    /* Method to insert element at begining */
	    public void insertAtStart(Type val)
	    {
	        BinaryNode<Type> nptr = new BinaryNode<Type>(val, null, null);        
	        if(start == null)
	        {
	            start = nptr;
	            end = start;
	        }
	        else
	        {
	            start.setLeft(nptr);
	            nptr.setRight(start);
	            start = nptr;
	        }
	        size++;
	    }
	    /* Method to insert element at end */
	    public void insertAtEnd(Type val)
	    {
	    	 BinaryNode<Type> nptr = new BinaryNode<Type>(val, null, null);        
	        if(start == null)
	        {
	            start = nptr;
	            end = start;
	        }
	        else
	        {
	            nptr.setLeft(end);
	            end.setRight(nptr);
	            end = nptr;
	        }
	        size++;
	    }
	    /* Method to insert element at position */
	    public void insertAtPos(Type val , Type pos)
	    {
	        BinaryNode<Type> nptr = new BinaryNode<Type>(val, null, null);    
	        if (pos.equals("1"))
	        {
	            insertAtStart(val);
	            return;
	        }            
	        BinaryNode<Type> ptr = start;
	        for (int i = 2; i <= size; i++)
	        {
	            if (pos.equals(i))
	            {
	                BinaryNode<Type> tmp = ptr.getRight();
	                ptr.setRight(nptr);
	                nptr.setLeft(ptr);
	                nptr.setRight(tmp);
	                tmp.setLeft(nptr);
	            }
	            ptr = ptr.getRight();            
	        }
	        size++ ;
	    }
	    /* Method to delete BinaryNode at position */
	    public void deleteAtPos(int pos)
	    {        
	        if (pos == 1) 
	        {
	            if (size == 1)
	            {
	                start = null;
	                end = null;
	                size = 0;
	                return; 
	            }
	            start = start.getRight();
	            start.setLeft(null);
	            size--; 
	            return ;
	        }
	        if (pos == size)
	        {
	            end = end.getLeft();
	            end.setRight(null);
	            size-- ;
	        }
	        BinaryNode<Type> ptr = start.getRight();
	        for (int i = 2; i <= size; i++)
	        {
	            if (i == pos)
	            {
	                BinaryNode<Type> p = ptr.getLeft();
	                BinaryNode<Type> n = ptr.getRight();
	 
	                p.setRight(n);
	                n.setLeft(p);
	                size-- ;
	                return;
	            }
	            ptr = ptr.getRight();
	        }        
	    }    
	    /* Method to display status of list */
	    public void display()
	    {
	        System.out.print("\nDoubly Linked List = ");
	        if (size == 0) 
	        {
	            System.out.print("empty\n");
	            return;
	        }
	        if (start.getRight() == null) 
	        {
	            System.out.println(start.getData() );
	            return;
	        }
	        BinaryNode<Type> ptr = start;
	        System.out.print(start.getData()+ " <-> ");
	        ptr = start.getRight();
	        while (ptr.getRight() != null)
	        {
	            System.out.print(ptr.getData()+ " <-> ");
	            ptr = ptr.getRight();
	        }
	        System.out.print(ptr.getData()+ "\n");
	    }
	    
	    public static void main(String[] args)
	    {            
	        Scanner scan = new Scanner(System.in);
	        /* Creating object of linkedList */
	        DoublyLInkedLIst<Integer> list = new DoublyLInkedLIst<Integer>(); 
	        System.out.println("Doubly Linked List Test\n");          
	        char ch;
	        /*  Perform list operations  */
	        do
	        {
	            System.out.println("\nDoubly Linked List Operations\n");
	            System.out.println("1. insert at begining");
	            System.out.println("2. insert at end");
	            System.out.println("3. insert at position");
	            System.out.println("4. delete at position");
	            System.out.println("5. check empty");
	            System.out.println("6. get size");
	            System.out.println("7. Exit");
	 
	            int choice = scan.nextInt();            
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter integer element to insert");
	                list.insertAtStart( scan.nextInt() );                     
	                break;                          
	            case 2 : 
	                System.out.println("Enter integer element to insert");
	                list.insertAtEnd( scan.nextInt() );                     
	                break;                         
	            case 3 : 
	                System.out.println("Enter integer element to insert");
	                int num = scan.nextInt() ;
	                System.out.println("Enter position");
	                int pos = scan.nextInt() ;
	                if (pos < 1 || pos > list.getSize() )
	                    System.out.println("Invalid position\n");
	                else
	                    list.insertAtPos(num, pos);
	                break;                                          
	            case 4 : 
	                System.out.println("Enter position");
	                int p = scan.nextInt() ;
	                if (p < 1 || p > list.getSize() )
	                    System.out.println("Invalid position\n");
	                else
	                    list.deleteAtPos(p);
	                break;     
	            case 5 : 
	                System.out.println("Empty status = "+ list.isEmpty());
	                break;            
	            case 6 : 
	                System.out.println("Size = "+ list.getSize() +" \n");
	                break; 
	            case 7:
	            	System.out.println("Exiting ::");
	            	scan.close();
	            	System.exit(1);
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;   
	            }    
	            /*  Display List  */ 
	            list.display();

	        } while (true);               
	    }

}
