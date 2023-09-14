package OOPs_java.basics;

class rectangle{
    public int l;
    int w;
    int area;

    public void setL(int l) {
        this.l = l;
    }

    public void setW(int w) {
        this.w = w;
    }
    public int getArea() {
        return area= l * w;
    }
}
class cuboid extends rectangle{
    int h;

    public void setH(int h) {
        this.h = h;
    }
    public int getVolume(){
        return l * w * h; // lxwxh
    }
    @Override
    public int getArea() {
        return 2*((l*w) + (w*h) + (l*h));
    }

}
public class ch10_practice {
    public static void main(String[] args) {

        cuboid c = new cuboid();
        c.setL(15);
        c.setW(15);
        c.setH(2);
        System.out.println("Surface area :"+c.getArea()+" unit/square");
        System.out.println("Volume       :"+c.getVolume()+" unit/cube");
    }
}
