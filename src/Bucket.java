public class Bucket {
    private int capacity;
    private int current;

    public String toString(){
        return "The current state of the bucket: "+this.current+" of "+this.capacity+" liters";
    }

    public boolean isEmpty(){
        boolean isEmpty=false;
        if(this.current==0){
            isEmpty=true;
        }
        return isEmpty;
    }

    public boolean isFull() {
        boolean isFull = false;
        if (this.current == this.capacity) {
            isFull = true;
        }
        return isFull;
    }

    public float precent(){
        float precent;
        precent=((float)this.current/this.capacity)*100;
        return precent;
    }

    public boolean addLitre(){
        boolean addLitre=false;
        if(this.capacity<this.current){
            addLitre=true;
            current+=1;
        }
        return addLitre;
    }

    public int addLiters(int amount){
        int capacityLeft;
        int addedLiters;
        int temp;
        if(this.current+amount<=this.capacity){
            this.current=this.current+amount;
            addedLiters=0;
        }
        else{
            capacityLeft=this.capacity-this.current;
            addedLiters=amount-capacityLeft;
            this.current=this.current+capacityLeft;
        }
        return addedLiters;
    }

    public boolean spill(){
        boolean spill=true;
        if(this.current==0){
            spill=false;
        }
        else{
            this.current=0;
        }
        return spill;
    }
    public boolean spill(int amount){
        boolean spill=true;
        if(this.capacity<amount){
            spill=false;
        }
        else{
            this.current=this.current-amount;
        }
        return spill;
    }

    public void fill(){
        this.current=this.capacity;
    }

    public void fill(Bucket other){
        int litersLeft;
        litersLeft=this.capacity-this.current;
        if(other.current>=litersLeft){
            this.current=this.current+litersLeft;
            other.spill(litersLeft);
        }
        else{
            this.current=this.current+ other.current;
            other.spill();
        }
    }

    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
}
