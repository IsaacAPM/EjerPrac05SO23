public class Movimiento{
    private String id;
    private double monto;

    public Movimiento(String id, double monto){
	this.id = id;
	this.monto = monto;
    }

    public String getId(){
	return this.id;
    }

    public double getMonto(){
	return this.monto;
    }

    public String toString(){
	return "Id: " + this.id + " Monto: " + this.monto + "\n";
    }
}
