package unidad3;
import java.util.Scanner;

public class AjustePolinomioPorMinimosCuadrados {

    static Scanner entrada = new Scanner(System.in);
    static double [] x;
    static double [] y;
    static double [][] matriz;
    static int nDatos;
    static int grado;
    static int aux_n;

    public static void main(String[] args) {
        try{
            System.out.print("Ingrese el numero de puntos: ");
            nDatos = Integer.parseInt(entrada.nextLine());

            x= new double[nDatos];
            y= new double[nDatos];


            System.out.println("\nIntroduce los datos de x");
            for (int i = 0; i < nDatos; ++i) {
                System.out.print("x("+i+"): ");
                x[i] = Double.parseDouble(entrada.nextLine());
            }

            System.out.println("\nIngrese los datos de y(fx)");
            for (int i = 0; i < nDatos; ++i) {
                System.out.print("y("+i+"): ");
                y[i] = Double.parseDouble(entrada.nextLine());
            }

            System.out.print("\nIngrese el grado del polinomio: ");
            grado = Integer.parseInt(entrada.nextLine());

            //matriz = new double[nDatos][grado+2];



            matriz=new double[nDatos][grado+1];

            for (int i = 0; i < grado+1; ++i){
                matriz[i]=new double[grado+2];
            }
            coeficientes();
            recorrer(grado+1,false);
            imprimir(grado+1,false);
        }catch(Exception e){
            System.out.println("Rellene con valores numericos, no letras ni caracteres especiales.");
        }
    }

    static void coeficientes() {
        double[] s = new double[(2 * grado) + 1];
        double suma;
        for (int k = 0; k < 2 * grado + 1; k++) {
            suma = 0.0;
            for (int i = 0; i < nDatos; i++) {
                suma = suma + Math.pow(x[i], k);
            }
            s[k] = suma;
        }
        for (int k = 0; k < grado + 1; k++) {
            suma = 0.0;
            for (int i = 0; i < nDatos; i++) {
                suma = suma + Math.pow(x[i], k) * y[i];
            }
            matriz[k][grado + 1] = suma;
        }
        for (int i = 0; i < grado + 1; i++) {
            for (int j = 0; j < grado + 1; j++) {
                matriz[i][j] = s[i + j];
            }
        }
    }

    static void recorrer(int n, boolean op) {
        int i, j, k = 0;
        for (j = 0; j < n - 1; ++j) {
            for (i = n - 1; i > k; --i) {
                if (md(matriz, n)) {
                    rauno(matriz, n);
                }
                reducir(matriz, i, j, n);
            }
            k++;
        }
        for (j = n - 1; j > 0; j--) {
            for (i = 0; i < k; ++i) {
                if (md(matriz, n)) {
                    rauno(matriz, n);
                }
                reducir(matriz, i, j, n);
            }
            k--;
        }
        for (i = 0; i < n; ++i) {
            if (matriz[i][i] == 0) {
                op = true;
            }
        }
        if (!op && md(matriz, n)) {
            rauno(matriz, n);
        }
    }

    static void reducir(double[][] matriz, int i, int j, int n) {
        double[] ra = new double[n + 1];
        for (int k = 0; k < n + 1; ++k) {
            ra[k] = ((matriz[i][k] * matriz[j][j]) - (matriz[j][k] * matriz[i][j]));
        }
        for (int k = 0; k < n + 1; ++k) {
            matriz[i][k] = ra[k];
        }
    }

    static boolean md(double[][] matriz, int n) {
        boolean op = false;
        int i;
        for (i = 0; i < n; ++i) {
            if (matriz[i][i] != 1) {
                op = true;
            }
        }
        for (i = 0; i < n; ++i) {
            if (matriz[i][i] == 0) {
                op = false;
            }
        }
        return op;
    }

    static void rauno(double[][] matriz, int n) {
        int i, j;
        double aux;
        for (i = 0; i < n; ++i) {
            aux = matriz[i][i];
            for (j = 0; j < n + 1; ++j) {
                matriz[i][j] = (matriz[i][j] / aux);
            }
        }
    }

    static void pedirdatos() {
        
    }

    static void imprimir(int n, boolean op){
        if (op) {
            System.out.println("\nLos pares de puntos de datos introducidos no generan un sistema de ecuaciones con solucion.");
        } else {
            System.out.println("\nLos coeficientes del polinomio son:\n");
            for (int i = 0; i < n; ++i) {
                if (matriz[i][n] >= 0) {
                    System.out.println("coe"+i+"= "+matriz[i][n]);
                } else {
                    System.out.println("coe"+i+"= "+matriz[i][n]);
                }
            }
        }
    }
}