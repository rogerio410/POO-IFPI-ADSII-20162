package domain;

import static java.lang.Math.*;

public class Rectangle {
	
	public double width;
	public double height;
	public Point pontoDeOrigem;
	
	public double area(){
		double area = this.width * this.height;
		return area;
	}
	
	public double perimeter(){
		return 2*this.width + 2*this.height;
	}

	public boolean contains(Rectangle rect2) {
		if(sqrt(pow(rect2.pontoDeOrigem.x - (this.pontoDeOrigem.x + this.width),2)) <= sqrt(pow(this.pontoDeOrigem.x - (this.pontoDeOrigem.x + this.width),2))){
            if(sqrt(pow(rect2.pontoDeOrigem.y - (this.pontoDeOrigem.y + this.height),2)) <= sqrt(pow(this.pontoDeOrigem.y - (this.pontoDeOrigem.y + this.height),2))){
                return true;
            }
        }
		
		return false;
	}

}





