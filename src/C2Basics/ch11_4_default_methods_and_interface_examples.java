package C2Basics;

// Default method: Default methods enable us to add new functionality to
//                 existing interfaces.
//> Classes implementing interface 'need not implement' the default methods.
//> Default method must be defined inside the interface

// See notes...

// Interface example
interface Camera{
    void takeSnap();
    void recordVideo();
    default void record4kVideo(){ // default method must me defined
        System.out.println("recording 4k video...");
    }
    private void greet(){ // 'private method' not accessible
        System.out.println("Welcome");
    }
}
interface Wifi {
    String[] getNetworks();
    void connectToNetwork(String network);
}

class cellPhone{
    void callNumber(int phonenumber){
        System.out.println("calling "+phonenumber);
    }
    void pickCall(){
        System.out.println("Connecting ...");
    }
}
class SmartPhone extends cellPhone implements Wifi,Camera{
    // default method not defined (but no error)
    // if defined here, it is automatically overridden
    public void takeSnap(){
       System.out.println("Taking snap");
   }
    public void recordVideo(){
        System.out.println("Recording ...");
   }
    public String[] getNetworks() {
        return new String[]{"Connect","Netplus","JIO","Airtel"};
    }
    public void connectToNetwork(String network){
        System.out.println("Connecting to "+ network);
    }
}


public class ch11_4_default_methods_and_interface_examples {
    public static void main(String[] args) {
        SmartPhone m1 = new SmartPhone();
        String[] net = m1.getNetworks();
        for(String names:net){
            System.out.println(names);
        }
        // calling default method
        m1.record4kVideo();

        //calling private method
        //m1.greet(); // throws error
    }
}
