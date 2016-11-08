package com.practice.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class NodeQueue{
    String key;
    Integer value;
    NodeQueue pre;
    NodeQueue next;
 
    public NodeQueue(String key, Integer value){
        this.key = key;
        this.value = value;
    }
}

public class LeastReacentlyUsed_Cache_OS_Algo {
	
	List<Integer> inputList = new ArrayList<>();
	
    int capacity;
    HashMap<String, NodeQueue> map = new HashMap<String, NodeQueue>();
    NodeQueue head=null;
    NodeQueue end=null;
 
    public LeastReacentlyUsed_Cache_OS_Algo(int capacity) {
        this.capacity = capacity;
    }
 
    public Integer get(Integer key) {
        if(map.containsKey(key)){
            NodeQueue n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
 
    public void remove(NodeQueue n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(NodeQueue n){
        n.next = head;
        n.pre = null;
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(String key, Integer value) {
        if(map.containsKey(key)){
            NodeQueue old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            NodeQueue created = new NodeQueue(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
    
    private void process(LeastReacentlyUsed_Cache_OS_Algo lru) {
		for(int i=0;i<lru.inputList.size();i++){
			lru.set("K"+i, lru.inputList.get(i));
		}
	}
    
    public static void main(String[] arg) {
		LeastReacentlyUsed_Cache_OS_Algo lru = new LeastReacentlyUsed_Cache_OS_Algo(3);
		lru.inputList.add(2);
		lru.inputList.add(3);
		lru.inputList.add(2);
		lru.inputList.add(2);
		lru.inputList.add(4);
		lru.inputList.add(9);
		lru.inputList.add(5);
		lru.inputList.add(1);
		lru.inputList.add(2);
		lru.inputList.add(1);
		lru.process(lru);
	}
}
