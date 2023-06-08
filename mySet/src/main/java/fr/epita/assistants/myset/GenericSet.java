package fr.epita.assistants.myset;

import java.util.ArrayList;
import java.util.Collections;



public class GenericSet<T extends Comparable<T>> {
    private ArrayList<T> base_;
    
    public GenericSet() {
      base_ = new ArrayList<T>();
    }
    
    public void insert(T i) {
      if (!base_.contains(i)) {
        base_.add(i);
        Collections.sort(base_);
      }
    }
    
    public void remove(T i) {
      base_.remove(i);
    }
    
    public Boolean has(T i) {
      return base_.contains(i);
    }
    
    public Boolean isEmpty() {
      return base_.isEmpty();
    }
    
    public T min() {
      if (base_.isEmpty()) {
        return null;
      }
      return base_.get(0);
    }
    
    public T max() {
      if (base_.isEmpty()) {
        return null;
      }
      return base_.get(base_.size()-1);
    }
    
    public int size() {
      return base_.size();
    }
    
    public static <T extends Comparable<T>> GenericSet<T> intersection(GenericSet<T> a, GenericSet<T> b) {
      GenericSet<T> intersectSet = new GenericSet<T>();
      for (T i : a.base_) {
        if (b.base_.contains(i)) {
          intersectSet.insert(i);
        }
      }
      return intersectSet;
    }
    
    public static <T extends Comparable<T>> GenericSet<T> union(GenericSet<T> a, GenericSet<T> b) {
      GenericSet<T> unionSet = new GenericSet<T>();
      unionSet.base_.addAll(a.base_);
      for (T i : b.base_) {
        if (!unionSet.base_.contains(i)) {
          unionSet.insert(i);
        }
      }
      return unionSet;
    }
  }