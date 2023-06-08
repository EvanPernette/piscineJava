package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerSet {
    private ArrayList<Integer> base_;
    
    public IntegerSet() {
      base_ = new ArrayList<Integer>();
    }
    
    public void insert(Integer i) {
      if (!base_.contains(i)) {
        base_.add(i);
        Collections.sort(base_);
      }
    }
    
    public void remove(Integer i) {
      base_.remove(i);
    }
    
    public Boolean has(Integer i) {
      return base_.contains(i);
    }
    
    public Boolean isEmpty() {
      return base_.isEmpty();
    }
    
    public Integer min() {
      if (base_.isEmpty()) {
        return null;
      }
      return base_.get(0);
    }
    
    public Integer max() {
      if (base_.isEmpty()) {
        return null;
      }
      return base_.get(base_.size()-1);
    }
    
    public int size() {
      return base_.size();
    }
    
    public static IntegerSet intersection(IntegerSet a, IntegerSet b) {
      IntegerSet intersectSet = new IntegerSet();
      for (Integer i : a.base_) {
        if (b.base_.contains(i)) {
          intersectSet.insert(i);
        }
      }
      return intersectSet;
    }
    
    public static IntegerSet union(IntegerSet a, IntegerSet b) {
      IntegerSet unionSet = new IntegerSet();
      unionSet.base_.addAll(a.base_);
      for (Integer i : b.base_) {
        if (!unionSet.base_.contains(i)) {
          unionSet.insert(i);
        }
      }
      return unionSet;
    }
  }