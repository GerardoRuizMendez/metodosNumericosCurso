package unidad3;
import java.util.Scanner;

public class Newton{
	
	public static void main(String args[]){
            try{
                Scanner entrada_teclado = new Scanner(System.in);
                double a[][] = new double [5][2];
                double y,fx1x0,fx2x1,fx3x2,fx4x3,fx2x1x0,fx3x2x1,fx4x3x2,fx3x2x1x0,fx4x3x2x1,fx4x3x2x1x0;

                System.out.println("INTERPOLACION DE NEWTON");
                System.out.println("Ingrese los pares (x, f(x))");

                for(int i=0; i<5; i++){
                    System.out.print("\nIngrese x "+i+": ");
                    a[i][0] = Double.parseDouble(entrada_teclado.nextLine());
                    System.out.print("Ingrese f(x) "+i+" :");
                    a[i][1] = Double.parseDouble(entrada_teclado.nextLine());
                }		
                
                System.out.println("\nIngrese valor a interpolar: ");
		double x = Double.parseDouble(entrada_teclado.nextLine());
                
		fx1x0 = (a[1][1]-a[0][1]) / (a[1][0]-a[0][0]);
		fx2x1 = (a[2][1]-a[1][1]) / (a[2][0]-a[1][0]);
		fx3x2 = (a[3][1]-a[2][1]) / (a[3][0]-a[2][0]);
		fx4x3 = (a[4][1]-a[3][1]) / (a[4][0]-a[3][0]);
		fx2x1x0 = (fx2x1-fx1x0) / (a[2][0]-a[0][0]);
		fx3x2x1 = (fx3x2-fx2x1) / (a[3][0]-a[1][0]);
		fx4x3x2 = (fx4x3-fx3x2) / (a[4][0]-a[2][0]);
		fx3x2x1x0 = (fx3x2x1-fx2x1x0) / (a[3][0]-a[0][0]);
		fx4x3x2x1 = (fx4x3x2-fx3x2x1) / (a[3][0]-a[0][0]);
		fx4x3x2x1x0 =(fx4x3x2x1-fx3x2x1x0) / (a[4][0]-a[0][0]);
                
		y=a[0][1]+fx1x0*(x-a[0][0])+fx2x1x0*(x-a[0][0])*(x-a[1][0])+fx3x2x1x0*(x-a[0][0])*(x-a[1][0])*(x-a[2][0])+fx4x3x2x1x0*(x-a[0][0])*(x-a[1][0])*(x-a[2][0])*(x-a[3][0]);
	        System.out.println("\n\nEl resultado en f(x) es: "+y);
	
            }catch(Exception e){
                System.out.println("Error al ingresar datos, solo números enteros o flotantes.");
            }
        }
}
	
	
	