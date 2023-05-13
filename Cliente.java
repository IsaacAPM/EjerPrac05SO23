import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String id;
    private ArrayList<Movimiento> movimientos;

    public Cliente(String nombre, String id){
	this.nombre = nombre;
	this.id = id;
	this.movimientos = new ArrayList<Movimiento>();
    }

    public String getNombre(){
	return this.nombre;
    }

    public String getId(){
	return this.id;
    }

    public ArrayList<Movimiento> getMovimientos(){
	return this.movimientos;
    }

    public void agregaMovimiento(Movimiento movimiento){
	this.movimientos.add(movimiento);
    }

    public String toString(){
	StringBuffer sb = new StringBuffer();
	sb.append("Mi nombre es: " + this.nombre + "\n");
	sb.append("Mi id es: " + this.id + "\n");
	sb.append("Lista de movimientos:\n");
	for(int i=0;i<this.movimientos.size();i++){
	    sb.append(this.movimientos.get(i).toString());
	}
	return sb.toString();
    }
}
