import java.io.*;
import java.util.ArrayList;

public class EdoCtaClientes{
    public static void main(String[] arg){
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;

	File archivo2 = null;
	FileReader fr2 = null;
	BufferedReader br2 = null;

	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	try{
	    archivo = new File("clientes.txt");
	    fr = new FileReader(archivo);
	    br = new BufferedReader(fr);

	    String linea;
	    while((linea=br.readLine())!=null){
		String[] parts = linea.split(" ");
		Cliente cliente = new Cliente(parts[1],parts[0]);
		archivo2 = new File("movimientos.txt");
		fr2 = new FileReader(archivo2);
		br2 = new BufferedReader(fr2);
		String lineaM;
		while((lineaM=br2.readLine())!=null){
		    String[] aux = lineaM.split(" ");
		    if(aux[0].equals(cliente.getId())){
			Movimiento movimiento = new Movimiento(aux[1],Double.parseDouble(aux[2]));
			cliente.agregaMovimiento(movimiento);
		    }
		}
		fr2.close();
		//System.out.println(cliente.toString());
		clientes.add(cliente);
	    }
	    
	    MovimientosCliente[] movs = new MovimientosCliente[clientes.size()];

	    for(int i=0;i<clientes.size();i++){
		MovimientosCliente aux = new MovimientosCliente(clientes.get(i));
		movs[i] = aux;
	    }

	    for(int j=0;j<clientes.size();j++){
		movs[j].start();
	    }

	    boolean band = true;

	    while(band){
		band = false;
		for(int k=0;k<clientes.size();k++){
		    band = band || movs[k].isAlive();
		}
	    }
	    System.out.println("Terminamos\n");
	}catch(Exception e){
	    e.printStackTrace();
	}finally{
	    try{
		if(null != fr){
		    fr.close();
		}
	    }catch(Exception e2){
		e2.printStackTrace();
	    }
	}
    }
}
