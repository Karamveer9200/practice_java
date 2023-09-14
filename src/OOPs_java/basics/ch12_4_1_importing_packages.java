package OOPs_java.basics;

// Importing class harrys_Father from package HarrysRelations_ch12_3_packages

// (Package1)OOPs_java. (Package2)basics. (Package3)HarrysRelations_ch12_3_packages. (Class)harrys_Father

import OOPs_java.basics.HarrysRelations_ch12_3_packages.harrys_Father;
// import OOPs_java.basics.HarrysRelations_ch12_3_packages.*; // also works

public class ch12_4_1_importing_packages {
    public static void main(String[] args) {

        // method of imported class
        harrys_Father f = new harrys_Father();

        // method name() from harrys_Father
        f.name();
    }
}
