public abstract class fine {
    String name;
    int speed;
    int finePayable;

    public fine(String name,int speed){
        this.name=name;
        this.speed=speed;
    }

    public fine() {
        return
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }


    public void road(){
        System.out.println("Name: "+getName());
        System.out.println("Speed: "+getSpeed());
    }


}