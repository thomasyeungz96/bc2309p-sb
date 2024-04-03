package com.thomas.forum.tempTest;

public class TypeChecking {

  public static void main(String[] args) {


    // int i = 3;
    // byte b = i;
    int i = 129;
    byte b = (byte) i; // explicit conversion downcase -> overflow 128 to -128 becuaes of byte

    double d1 = 1.3;
    byte b2 = (byte) d1; // precision loss

    int i2 = (int) 22000000000L; // force to do might be runtime error not the complie error 

    Integer i3 = 10;  //(autobox) 
    System.out.println(i3.toString());
    int i4 = i3; // Integer to int (un-box)

    System.out.println(i);
    System.out.println(b);
    System.out.println(d1);
    System.out.println(b2);
    System.out.println(i2); 

    // Wrapper Class (class of the primitive types)


  }



}
