import java.io.*;

// Thread
public class MovimientosCliente extends Thread {
    private Cliente cliente;

    public MovimientosCliente(Cliente cliente){
	this.cliente = cliente;
    }

    @Override
    public void run(){
	long ini, term, duracion;
	ini= System.currentTimeMillis();
	String nombre; 

	int numTrans;
	StringBuffer info = new StringBuffer(); 
	nombre = cliente.getNombre(); 
	
	// leer los archivos y todo eso

	numTrans = cliente.getMovimientos().size();
	info.append("ESTADO DE CUENTA\n\n");
	info.append(cliente.toString());
	// Aqui se ponen los movimientos, se saca el numero de transacciones con el length del arreglo
	
	term = System.currentTimeMillis(); 
	duracion = term - ini; 
	info.append("Tiempo de ejecución: ").append(duracion).append(" ms\n"); 

	try{
	    PrintWriter archivoo = new PrintWriter(new FileWriter("Reporte"+nombre+".txt")); 
	    archivoo.println(info); 
	
	    archivoo.close();
	}catch(Exception e){
	}
    }
}
