package unidad3;
import java.util.Scanner;

public class Lagrange{
	
	public static void main(String args[]){
            Scanner entrada_teclado = new Scanner(System.in);
            int numero_puntos;
            double x,y=0;
            double array[][];
            System.out.println("INTERPOLACION LAGRANGE");
            
            do{
                try{                
                    System.out.println("Ingrese el numero de puntos (2 hasta 4)");
                    numero_puntos = Integer.parseInt(entrada_teclado.nextLine());
                    
                }catch(Exception e){
                    System.out.println("Solo numeros enteros. (2 o 3 o 4)");
                    numero_puntos=0;
                }
                
            }while(numero_puntos < 2 || numero_puntos > 4);
            
                array = new double [numero_puntos][2];
            
		System.out.println("Ingrese los pares (x, f(x))");
                
                try{
                    for(int i=0; i < numero_puntos; i++){
                        System.out.print("\nIngrese x "+i+": ");
                        array[i][0] = Double.parseDouble(entrada_teclado.nextLine());
                        System.out.print("Ingrese f(x) "+i+" :");
                        array[i][1] = Double.parseDouble(entrada_teclado.nextLine());
                    }

                    System.out.print("\nIngrese valor a interpolar:");
                    x = Double.parseDouble(entrada_teclado.nextLine());          
                
                    if(numero_puntos==2){
                        y = (((((x-array[1][0])*array[0][1]) / (array[0][0]-array[1][0]) ) + (( (x-array[0][0])*array[1][1]) / (array[1][0]-array[0][0]) )));
                    }else if(numero_puntos==3){
                        y=((x-array[1][0])*(x-array[2][0])*array[0][1]) / ((array[0][0]-array[1][0])*(array[0][0]-array[2][0])) + ((x-array[0][0])*(x-array[2][0])*array[1][1]) / ((array[1][0]-array[0][0])*(array[1][0]-array[2][0])) + ((x-array[1][0])*((x-array[0][0])*array[2][1]) / ((array[2][0]-array[0][0])*(array[2][0]-array[1][0])));
                    }else if(numero_puntos==4){
                        y=((x-array[1][0])*(x-array[3][0])*(x-array[2][0])*array[0][1])/((array[0][0]-array[1][0])*(array[0][0]-array[2][0])*(array[0][0]-array[3][0]))+((x-array[0][0])*(x-array[2][0])*(x-array[3][0])*array[1][1])/((array[1][0]-array[0][0])*(array[1][0]-array[2][0])*(array[1][0]-array[3][0]))+((x-array[0][0])*(x-array[1][0])*((x-array[3][0])*array[2][1])/((array[2][0]-array[0][0])*(array[2][0]-array[1][0])*(array[2][0]-array[3][0]))+((x-array[0][0])*(x-array[1][0])*((x-array[2][0])*array[3][1])/((array[3][0]-array[0][0])*(array[3][0]-array[1][0])*(array[3][0]-array[2][0]))));
                    }else{
                        System.out.println("No valido");
                    }

                    System.out.println("\n\nEl resultado en f(x) es: "+y);
                    
                    
                }catch(Exception e){
                    System.out.println("Error al ingresar datos, solo números enteros o flotantes.");
                }
	}
}