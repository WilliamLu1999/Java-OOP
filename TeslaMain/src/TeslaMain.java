
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Battery implements Cloneable
{
    int volts;
    Battery()
    {
	volts = 375;
    }
    public Object clone() throws CloneNotSupportedException {
	return super.clone();
    }
}
class Factory{
	   String location;
	   String name;
	   Factory(String loc, String n) {
	       location = loc;
	       name = n;
	   }
	   public void printFactory() {
	       System.out.println("Factory:");
	       System.out.println(" - Name: " + this.name);
	       System.out.println(" - Location: " + this.location);
	       System.out.println(" - Memory Address: " + this);
	   }
	   public Tesla produceCar() {
	       Tesla car1 = new Tesla(this);
	       return car1;
	   }
	   public List<Tesla> massProduceCars(Tesla t, int n) throws
	           CloneNotSupportedException {
		   List<Tesla> massProduce = new ArrayList<Tesla>();
		   for (int i = 0;i<n;i++) {
			  massProduce.add((Tesla)t.clone());
		   }
		   return massProduce;
	   }
	  
	}


// A test class whose objects are cloned
class Tesla implements Cloneable
{
    int price;
    int top_speed;
    Battery battery;
    Factory factory;
    Tesla(Factory f)
    {
    factory = f;
	price = 35000;
	top_speed = 160;
	battery = new Battery();
    }
    public Object clone() throws
	                   CloneNotSupportedException
    {
	Tesla t = (Tesla)super.clone();
	/* pseudo code for Object.copy()
	   (1) create new object {of same type}
	   (2) For each sub field - do a copy by value/ = 
               some_object{
	         field A;
                 field B;
	       }
	       some_object X
	       Y = X.clone();
	       some_object temp;
               for each subfield {A, B}
                  temp.A = X.A;
	*/
	t.battery = (Battery)battery.clone();
	//t.factory = (Factory)factory.clone();
			
	return t;
    }
}

// class CoolTesla extends Tesla

class TwoDArray implements Cloneable{
    int[][] arr;
    TwoDArray(int n, int m){
	arr = new int[n][m];
	
    }
    public Object clone() throws CloneNotSupportedException {
	// get dimensions
	int n = arr.length;
	int m = arr[0].length;
	int[][] newarr = new int[n][m];
	for(int i = 0; i < n; i++)
	    for(int j = 0; j < m; j++)
		newarr[i][j] = arr[i][j];
	// This is what I add for cloning TwoDArray.
	TwoDArray newarr1 = (TwoDArray)super.clone();
	return newarr1;
    }
}


public class TeslaMain{
    public static void main(String[] args) throws
	CloneNotSupportedException
    {
    Factory factory = new Factory("California","Gigafactory");
	Tesla car1 = factory.produceCar();
	List<Tesla> fleet =factory.massProduceCars(car1, 5);
	for(int i =0;i<fleet.size();i++) {
		Tesla car = fleet.get(i);
		car.factory.printFactory();
		System.out.println("Battery address"+car.battery);
		System.out.println();
	}
	// we need a second car to hit our sales goals. Let's just copy
	// the one we already have
	// Tesla car2 = (Tesla)car1.clone();

	// car2.battery.volts -= 50;
	
	// the second Tesla will be on sale
	// car2.price = 30000;

	//car1.battery = new Battery();
	//car1.battery.volts = 500;
	
	//System.out.println(car1.price + " " + car1.top_speed + " " + car1.battery.volts);
	//System.out.println(car2.price + " " + car2.top_speed + " " + car2.battery.volts);
	int n = 10;
	int m = 10;
	TwoDArray X = new TwoDArray(n,m);
	for(int i = 0; i < n; i++){
	    for(int j = 0; j < m; j++){
		X.arr[i][j] = i*n + j;
		System.out.print(X.arr[i][j] +", ");
	    }
	    System.out.println(";");
	   
	}
	TwoDArray Y  = (TwoDArray)X.clone();
	
	for(int i = 0; i < n; i++){
	    for(int j = 0; j < m; j++){
		Y.arr[i][j] = i*2 + j;
		System.out.print(Y.arr[i][j] +", ");
	    }
	    System.out.println(";");
	   
	}

	}
	
	
	
    
}