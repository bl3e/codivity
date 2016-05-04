package com.my.javagotchas;
public final class Pair<X,Y> { 
	  private X fst;
	  private Y snd; 
	  public Pair(X fst, Y snd) {this.fst=fst; this.snd=snd;} 
	  public X getFirst() { return fst; } 
	  public Y getSecond() { return snd; }
	} 