package com.practice.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetPermutation<E> {
    private static final int ELEMENT_LIMIT = 12;
    private List<E> inputList;
    public int N;
    private Map<Integer, List<LinkedHashSet<E>>> map = 
            new HashMap<Integer, List<LinkedHashSet<E>>>();

    public SetPermutation(List<E> list) {
        inputList = list;
        N = list.size();
        if (N > ELEMENT_LIMIT) {
            throw new RuntimeException(
                    "List with more then " + ELEMENT_LIMIT + " elements is too long...");
        }
    }

    public List<LinkedHashSet<E>> getPermutationsList(int elementCount) {
        if (elementCount < 1 || elementCount > N) {
            throw new IndexOutOfBoundsException(
                    "Can only generate permutations for a count between 1 to " + N);
        }
        if (map.containsKey(elementCount)) {
            return map.get(elementCount);
        }

        ArrayList<LinkedHashSet<E>> list = new ArrayList<LinkedHashSet<E>>();

        if (elementCount == N) {
            list.add(new LinkedHashSet<E>(inputList));
        } else if (elementCount == 1) {
            for (int i = 0 ; i < N ; i++) {
                LinkedHashSet<E> set = new LinkedHashSet<E>();
                set.add(inputList.get(i));
                list.add(set);
            }
        } else {
            list = new ArrayList<LinkedHashSet<E>>();
            for (int i = 0 ; i <= N - elementCount ; i++) {
                @SuppressWarnings("unchecked")
                ArrayList<E> subList = (ArrayList<E>)((ArrayList<E>)inputList).clone();
                for (int j = i ; j >= 0 ; j--) {
                    subList.remove(j);
                }
                SetPermutation<E> subPowerSet = 
                        new SetPermutation<E>(subList);

                List<LinkedHashSet<E>> pList = 
                        subPowerSet.getPermutationsList(elementCount-1);
                for (LinkedHashSet<E> s : pList) {
                    LinkedHashSet<E> set = new LinkedHashSet<E>();
                    set.add(inputList.get(i));
                    set.addAll(s);
                    list.add(set);
                }               
            }
        }

        map.put(elementCount, list);
        return map.get(elementCount);
    }
    
    public static void main(String[] args) {
    	List<Integer> list = new ArrayList<>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(5);
    	SetPermutation<Integer> setPermutation = new SetPermutation<>(list);
    	for(int i=1;i<=list.size();i++)
    	setPermutation.getPermutationsList(i);
    	Set<Integer> set = setPermutation.map.keySet();
    	for (Integer integer : set) {
    		System.out.println(integer+":::"+setPermutation.map.get(integer));
		}
    }
}
