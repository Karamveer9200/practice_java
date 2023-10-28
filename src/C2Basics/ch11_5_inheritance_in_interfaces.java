package C2Basics;

// interface can only 'extend' another interface to inherit its methods and fields
// interface cannot 'implement' another interface, only classes can do that!

interface sampleInterface{ // interface 1
    int a = 40;
    void meth1();
    void meth2();
}

// interface inheriting(extend) another interface
interface childSampleInterface extends sampleInterface{ // interface 2
    void meth3();
    void meth4();
}

// only a class can 'implement' an interface.
// so every method of implemented interface must be defined
class SampleClass implements childSampleInterface{
    @Override
    public void meth1() { // from interface 1 inherited by 2
        System.out.println("METHOD 1 inherited from interface 1");
    }

    @Override
    public void meth2() { // from interface 1 inherited by 2

        System.out.println("METHOD 2 inherited from interface 1");
    }

    @Override
    public void meth3() { // from interface 2
        System.out.println("METHOD 3 from interface 2");
    }
    @Override
    public void meth4() { // from interface 2
        System.out.println("METHOD 4 from interface 2");
    }
}

public class ch11_5_inheritance_in_interfaces {
    public static void main(String[] args) {
        // you 'cannot' make an object of an interface
        //childSampleInterface ch = new childSampleInterface(); // -- error

        SampleClass c = new SampleClass();
        c.meth1();
        c.meth4();

     }
}
