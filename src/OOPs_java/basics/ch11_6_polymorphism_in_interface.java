package OOPs_java.basics;

// polymorphism in interfaces:
// supposes I gave you the phone and want you to use it as a camera and noting else
// to do that:
// we can give 'reference of camera interface' and create an 'object of smartphone class'
// camera hd = new smartphone();      --> to use camera feature only (polymorphism)
// smartphone a71 = new smartphone(); --> to use all features of class smartphone
// it will restrict user to only make objects of methods present in camera interface.
// by doing this we can 'restrict user' to use 'only smartphone's camera, gps, or music player etc'.

interface Camera1{
    void takeSnap();
    void recordVideo();
    void record4kVideo();

}
interface Wifi1 {
    String[] getNetworks();
    void connectToNetwork(String network);
}

class cellPhone1{
    void callNumber(int phonenumber){

        System.out.println("calling "+phonenumber);
    }
    void pickCall(){

        System.out.println("Connecting ...");
    }
}
class SmartPhone1 extends cellPhone implements Wifi1,Camera1{
    public void takeSnap(){

        System.out.println("Taking snap");
    }
    public void recordVideo()
    {
        System.out.println("Recording ...");
    }

    public void record4kVideo() {
        System.out.println("recording 4k video...");
    }

    public String[] getNetworks() {

        return new String[]{"Connect","Netplus","JIO","Airtel"};
    }
    public void connectToNetwork(String network)
    {
        System.out.println("Connecting to "+ network);
    }
}


public class ch11_6_polymorphism_in_interface {
    public static void main(String[] args) {
        // polymorphism in action:

        // using smartphone 'only as a camera'
        // reference: camera1 (interface), object: Smartphone1(class)
        Camera1 hd = new SmartPhone1();
        // hd.getNetworks(); // not allowed (method not present in camera1 interface)

        hd.takeSnap();
        hd.recordVideo();
        hd.record4kVideo();

        // using smartphone's 'Wi-Fi feature only'
        Wifi1 w = new SmartPhone1();
        //w.takeSnap(); // not allowed (method not present in Wifi1 interface)

        for(String net: w.getNetworks()){
            System.out.println(net);
        }
        w.connectToNetwork("Netplus");

        // To use 'all the features' of a smartphone
        SmartPhone1 a71 = new SmartPhone1();

        a71.callNumber(999888765);// from: cellPhone1 (class)
        a71.record4kVideo();// from: Camera1 (interface)
        a71.connectToNetwork("airtel");// from: Wifi1 (interface)



    }
}
