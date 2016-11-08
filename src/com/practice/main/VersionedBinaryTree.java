package com.practice.main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class VersionNode{
    LinkedHashMap<Integer, HashMap<Character, VersionNode>> map; //parent map used for storing version specific child maps, having keys left and right(because tree is binary)
    int data; //Node value

    VersionNode(int data, Integer version){
    	map = new LinkedHashMap<Integer, HashMap<Character, VersionNode>>();
    	Map<Character, VersionNode> tempChildMap = new HashMap<Character, VersionNode>();
    	tempChildMap.put('L', null);  //L represents left child
    	tempChildMap.put('R', null);  //R represents left child
    	map.put(version, new HashMap<>(tempChildMap));
    	this.data = data;
    }
}


public class VersionedBinaryTree {

	static int versionNumber = 0;
	
	public static void main(String[] args) {
		VersionNode rootNode;
		rootNode = new VersionNode(27, versionNumber);
	}
	
	private void insertNode(int data, int versionNumber) {
		VersionNode newNode = new VersionNode(data, versionNumber);
	}
	
	private return_type name() {
		
	}

}
