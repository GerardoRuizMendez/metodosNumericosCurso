package unidad1;

import java.util.Iterator;

public class matriz {
	private int filas;
    private int columnas;
    private matriz P;
    private matriz L;
    private matriz U;
    
    
    float valores[][];

    
    public static void main(String[] args) {
    	
    	
    	
    	//GAUSS
    	//float[][] a={{2,1,-3},{3,-2,1},{-5,-4,2}};
    	//float[][] b= {{-2,13,4}};
    	
    	/*float[][] a={{1,1,1},{3,-2,-1},{-2,1,2}};
    	float[][] b= {{2,4,2}};
    	
		matriz A=new matriz(a);
		matriz B=new matriz(b);
		
		matriz x=matriz.metodoGauss(A, B);
		System.out.println("x");
		for(int i=0; i<x.filas; i++) {
    		for(int j=0; j<x.columnas; j++) {
        		System.out.print(x.valores[i][j] +" ");
        	}System.out.println("");
    	}*/
    	
    	//LU Y PLU
    	
    	//float[][] valores= {{2,-3,5},{6,-1,3},{-4,1,-2}};//LU
    	//float[][] valores= {{1,2,-3,1},{0,1,4,2},{5,-1,2,0},{1,1,-2,3}};//LU
    	//float[][] valores= {{5,2,4,3},{15,6,12,7},{30,15,23,15},{-25,-22,-15,-3}};//PLU
    	//float[][] valores= {{3,6,7},{-1,5,-2},{0,0,2}};//PLU?LU
    	//float[][] valores= {{0,0,2},{-1,5,-2},{3,6,7}};//PLU
    	//float[][] valores= {{0,-1,4},{2,1,1},{1,1,-2}};//PLU
    	//float[][] valores= {{2,-2,1},{-8,11,5},{4,-13,3}};//PLU dos variables
    	/*matriz a=new matriz(valores);
		
		a.PLU();
		System.out.println("a");
		for(int i=0; i<a.filas; i++) {
    		for(int j=0; j<a.filas; j++) {
        		System.out.print(a.valores[i][j] +" ");
        	}System.out.println("");
    	}
		
		System.out.println("L");
		for(int i=0; i<a.filas; i++) {
    		for(int j=0; j<a.filas; j++) {
        		System.out.print(a.L.valores[i][j] +" ");
        	}System.out.println("");
    	}
		System.out.println("u");
		for(int i=0; i<a.filas; i++) {
    		for(int j=0; j<a.filas; j++) {
        		System.out.print(a.U.valores[i][j] +" ");
        	}System.out.println("");
    	}
		System.out.println("p");
		for(int i=0; i<a.filas; i++) {
    		for(int j=0; j<a.filas; j++) {
        		System.out.print(a.P.valores[i][j] +" ");
        	}System.out.println("");
    	}*/
		
		 
		//System.out.println(m.determinante());
		/*matriz pa=a.P.multiplicacion(a);
		System.out.println("pa");
		for(int i=0; i<a.filas; i++) {
    		for(int j=0; j<a.filas; j++) {
        		System.out.print(pa.valores[i][j] +" ");
        	}System.out.println("");
    	}
		matriz lu=a.L.multiplicacion(a.U);
		System.out.println("lu");
		for(int i=0; i<a.filas; i++) {
    		for(int j=0; j<a.filas; j++) {
        		System.out.print(lu.valores[i][j] +" ");
        	}System.out.println("");
    	}*/
		//DETERMINANTE
		//float[][] valores= {{1,-2,1},{4,2,1},{3,-1,2}}; //sol=5
    	//float[][] valores= {{1,3,-2},{2,-3,4},{-1,2,5}}; //sol=-67
    	//float[][] valores= {{2,3,-1,0},{0,1,1,1},{2,3,1,-1},{4,1,2,0}}; //sol=-67
		/*
		a=new matriz(valores);
		float det=a.determinante();
		System.out.println(det);
		*/
		
    	//GAUSS SEIDEL
    	/*float[][] a={{9,2,-1},{7,8,5},{3,4,-10}};
    	float[][] b= {{-2,3,6}};
    	
		matriz A=new matriz(a);
		matriz B=new matriz(b);
    	
    	matriz respuesta=matriz.gaussSeidel(A, B,100);
    	System.out.println("respuesta");
		for(int i=0; i<respuesta.filas; i++) {
    		for(int j=0; j<respuesta.columnas; j++) {
        		System.out.print(respuesta.valores[i][j] +" ");
        	}System.out.println("");
    	}*/
    	/*float[][] a={{1,2,0},{2,3,0},{0,0,1}};
    	matriz A=new matriz(a);
    	matriz respuesta=A.matrizInversa();
    	System.out.println("respuesta");
		for(int i=0; i<respuesta.filas; i++) {
    		for(int j=0; j<respuesta.columnas; j++) {
        		System.out.print(respuesta.valores[i][j] +" ");
        	}System.out.println("");
    	}*/
		 
	}
    
    public matriz(int filas, int columnas){
        this.filas=filas;
        this.columnas=columnas;
        valores=new float[filas][columnas];
    }
    public matriz(float[][] valores){
        this.filas=valores.length;
        this.columnas=valores[0].length;
        this.valores=valores;
    }
    
    public float determinante(){
        matriz resultado=new matriz(1,1);
        if(filas==1) return valores[0][0];

        float det=0;
        float[] adjuntas=new float[filas];
        for(int i=0; i<filas; i++) {
            adjuntas[i]=cofactor(0,i);
            det+=valores[0][i]*adjuntas[i];
        }
        resultado.valores[0][0]=det;
        return det;
    }
    
    public float cofactor(int fila, int columna){
        int ii, jj;
        float arr[][]=new float[filas-1][filas-1];
        ii=0; jj=0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {

                if (!(i == fila || j == columna)) {
                    arr[ii][jj] = valores[i][j];
                    jj++;
                    if(jj==filas-1)ii++;
                }

            }
            jj=0;

        }

        matriz resultado=new matriz(arr);
        return (float) (resultado.determinante()*Math.pow(-1,fila+columna));
    }
    
    public void LU(){
    	if(filas!=columnas){
    		System.out.println("No es posible realizar la factoorizacion PLU");
    		return;
    	}

    	
    	//P=matriz.creaIdentidad(filas);
    	U=new matriz(this.valores);
    	L=matriz.creaIdentidad(filas);
    	//comprobamos que el ii de la fila a iterar sea distinto de 0
    		//intercambiar filas
    	
    	float c=0;
    	for(int k=0; k<filas; k++) {
    		if(U.valores[k][k]==0) {
    			System.out.println("No es posible completar con LU, usa PLU");
    			return;
    		}


    		//L.intercambiarFilas(0, 2);
			//U.intercambiarFilas(0, 2);
			//P.intercambiarFilas(0, 2);
    		for(int j=0; j<k; j++) {
    			//k=1;j=0;    k=2;j=0    k=2;j=1
    			//c=6/2; c=-4/2; c=-5/8;
        		//c=U.valores[1][0]/U.valores[0][0]; c=U.valores[2][0]/U.valores[0][0]; c=U.valores[2][1]/U.valores[1][1];
    			if(U.valores[k][j]!=0) {
	        		c=U.valores[k][j]/U.valores[j][j];
	        		for(int n=0; n<filas; n++) {
	        			U.valores[k][n]=U.valores[k][n]-c*U.valores[j][n];
	        		}
	        		L.valores[k][j]=c;
    			}
        		
        	}
    	
    	}
    	
 
    	
    }
    
    public void PLU(){
    	if(filas!=columnas){
    		System.out.println("No es posible realizar la factoorizacion PLU");
    		return;
    	}
    	//generar PLU inicial
    	float[][] numerosU=new float[filas][filas];
    	for (int i = 0; i<filas; i++) {
    		for (int j = 0; j<filas; j++) {
    			numerosU[i][j]=valores[i][j];
    		}
		}
    	
    	
    	P=matriz.creaIdentidad(filas);
    	U=new matriz(numerosU);
    	
    	L=matriz.zeros(filas,filas);
    	//comprobamos que el ii de la fila a iterar sea distinto de 0
    		//intercambiar filas
    	
    	float c=0;
    	
		//U.intercambiarFilas(0, 2);
		//P.intercambiarFilas(0, 2);
    	boolean flag=false;
    	for(int k=1; k<filas; k++) {
    		//System.out.println(k);
    		
    		/*flag=false;
    		for(int i=k+1;i<filas;i++) {//k=1;i=2
    			if(U.valores[k-1][k-1]!=0) {
    				flag=true;
    				break;
    			}else {
    				L.intercambiarFilas(k-1, i-1);
    				U.intercambiarFilas(k-1, i-1);
    				P.intercambiarFilas(k-1, i-1);
    				k--;
    			}
    		}*/
    		if(U.valores[k-1][k-1]==0) {
    			L.intercambiarFilas(k-1, k);
				U.intercambiarFilas(k-1, k);
				P.intercambiarFilas(k-1, k);
				k--;
    		}
    		
    		//compribar que ii no sea 0
    		//k=0;i=1
    		
    		
    		for(int j=0; j<k; j++) {
    			//k=1;j=0;    k=2;j=0    k=2;j=1     k=3;i=0
    			//c=6/2; c=-4/2; c=-5/8;
        		//c=U.valores[1][0]/U.valores[0][0]; c=U.valores[2][0]/U.valores[0][0]; c=U.valores[2][1]/U.valores[1][1];
    			if(U.valores[k][j]!=0) {
	        		c=U.valores[k][j]/U.valores[j][j];
	        		for(int n=0; n<filas; n++) {
	        			U.valores[k][n]=U.valores[k][n]-c*U.valores[j][n];
	        		}
	        		L.valores[k][j]=c;//Si c=0 entonces no se escribe para no sustituir valores
    			}
        		
        	}
    		
    		
    	
    	}
    	for(int i=0;i<filas;i++) {//investigar
			L.valores[i][i]=1;
		}
    	
    	
    	
    	/*boolean flag=false;
    	for(int i=0;i<filas-1;i++) {//cambiar a while
    		if(numerosP[i][0]!=0) {
    			flag=true;
    			break;
    		}
    		else{
    			numerosP=P.intercambiarFilas(i,i+1);//revisar
    		}
    	}
    	if(!flag) {
    		System.out.println("No es posible completar la factorización PLU");
    	}*/
    }
    private void intercambiarFilas(int n1, int n2){
    	float[] aux=new float[filas];
    	for(int i=0; i<filas; i++) {
    		for(int j=0; j<filas; j++) {
        		if(i==n1) {
        			aux[j]=valores[n2][j];
        			valores[n2][j]=valores[n1][j];
        			valores[n1][j]=aux[j];
        		}
        	}
    	}
    	
    }
    private static matriz creaIdentidad(int filas){
    	float[][] valores=new float[filas][filas];
    	
    	for(int i=0;i<filas;i++) {
    		for(int j=0;j<filas;j++) {
        		if(i==j) {
        			valores[i][j]=1;
        		}else {
        			valores[i][j]=0;
        		}
        	}
    	}
    	return new matriz(valores);
    }
    
    private static matriz zeros(int filas, int columans){
    	float[][] valores=new float[filas][columans];
    	
    	for(int i=0;i<filas;i++) {
    		for(int j=0;j<columans;j++) {
        			valores[i][j]=0;
        	}
    	}
    	return new matriz(valores);
    }
    
    public matriz multiplicacion(matriz m){
        matriz resultado=new matriz(filas, m.columnas);

        for(int i=0; i<filas; i++) {
            for (int j = 0; j < m.columnas; j++) {

                for (int k=0; k<columnas; k++){    //  1              1
                    resultado.valores[i][j]+=valores[i][k]*m.valores[k][j];
                }


            }
        }
        return resultado;
    }
    private matriz multiplicacion(float n){
        matriz resultado=new matriz(filas, columnas);

        for(int i=0; i<valores.length; i++) {
            for (int j = 0; j < valores[i].length; j++) {
                resultado.valores[i][j]=valores[i][j]*n;
            }
        }

        return resultado;
    }
    
    public static matriz metodoGauss(matriz A, matriz B) {
    	//AX=B
    	if(A.filas!=A.columnas){
    		System.out.println("La matriz A no es s");
    		return null;
    	}
    	if(B.columnas!=A.filas || B.filas!=1){
    		System.out.println("La matriz B no tiene las medidas correctas");
    		return null;
    	}
    	
    	matriz aux=new matriz(A.filas, A.columnas+1);
    	for(int i=0;i<A.filas;i++) {
    		for(int j=0; j<A.filas+1;j++) {
    			if(j>=A.filas) aux.valores[i][j]=B.valores[0][i];
    			else aux.valores[i][j]=A.valores[i][j];
    			
    		}
    	}
    	
    	float c=0;
    	
    	boolean flag=false;
    	for(int k=1; k<A.filas; k++) {
    		
    		flag=false;
    		
    		if(aux.valores[k-1][k-1]==0) {
    			aux.intercambiarFilas(k-1, k);
				k--;
    		}
    		
    		//compribar que ii no sea 0
    		//k=0;i=1
    		
    		
    		for(int j=0; j<k; j++) {
    			//k=1;j=0;    k=2;j=0    k=2;j=1     k=3;i=0
    			//c=6/2; c=-4/2; c=-5/8;
        		//c=U.valores[1][0]/U.valores[0][0]; c=U.valores[2][0]/U.valores[0][0]; c=U.valores[2][1]/U.valores[1][1];
    			if(aux.valores[k][j]!=0) {
	        		c=aux.valores[k][j]/aux.valores[j][j];
	        		for(int n=0; n<aux.columnas; n++) {
	        			aux.valores[k][n]=aux.valores[k][n]-c*aux.valores[j][n];
	        		}
	        		//L.valores[k][j]=c;//Si c=0 entonces no se escribe para no sustituir valores
    			}
        		
        	}
    		
    	}
    	matriz x=new matriz(1,aux.filas);
    	for(int i=aux.filas-1;i>=0;i--) {
    		float sum=0;//sumatoria
    		for(int j=0; j<aux.filas; j++) {
    			if(j!=i)sum=sum+x.valores[0][j]*aux.valores[i][j];
    		}
    		x.valores[0][i]=(aux.valores[i][aux.columnas-1]-sum)/aux.valores[i][i];
    	}

    	return x;
    }
    
    public static matriz gaussSeidel(matriz A, matriz B, int ite) {
    	//AX=B
    	if(A.filas!=A.columnas){
    		System.out.println("La matriz A no es s");
    		return null;
    	}
    	if(B.columnas!=A.filas || B.filas!=1){
    		System.out.println("La matriz B no tiene las medidas correctas");
    		return null;
    	}

    	for(int i=0; i<A.filas; i++) {
    		for(int j=0;j<A.filas;j++) {
    			if(j!=i && Math.abs(A.valores[i][i])<Math.abs(A.valores[i][j])) {
    				System.out.println("La matriz A no es diagonalmente dominante");
    	    		return null;
    			}	
    		}
    	}
    	
    	matriz x=matriz.zeros(ite,A.filas);
    	float sum;
    	
    	for(int k=1;k<ite;k++) {
    		
    		
    		for(int i=0; i<A.filas; i++) {
    			sum=0;
        		for(int j=0;j<A.filas;j++) {
        			if(i!=j) {
        				sum=sum+A.valores[i][j]*x.valores[k-1][j];
        			}
        		}
        		x.valores[k][i]=(B.valores[0][i]-sum)/A.valores[i][i];
        	}
    		
    		
    	}
    		
    		
    		
    	/*for(int i=1;i<ite;i++) {
    		for(int j=0;j<A.filas;j++) {
    			//x[i][j]=
    			sum=0;
    			for(int k=0;k<A.filas;k++) {
    				if(i!=j) {
    					sum=sum+A.valores[i][k]*x.valores[i-1][k];
    				}
    				x.valores[i][j]=(B.valores[0][i]-sum)/A.valores[i][j];
    			}
    		}
    	}*/
    	
    	return x;
    }
    private matriz matrizTranspuesta(){
        matriz resultado=new matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.valores[i][j]=valores[j][i];
            }
        }
        return resultado;
    }
    private matriz matrizAdjunta(){
        matriz resultado=new matriz(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.valores[i][j]=cofactor(i,j);
            }
        }
        return resultado;
    }
    
    public matriz matrizInversa(){
        /*
        float determinante=1/matriz1.determinante();
        matriz resultado=matriz1.matrizTranspuesta();
        resultado=resultado.matrizAdjunta();
        resultado=resultado.multiplicacion(determinante);
        * */
        float determinante=1/this.determinante();
        if(determinante==0){
            float[][] resultado={{0.0f}};
            return new matriz(resultado);
        }
        matriz resultado=this.matrizTranspuesta();
        resultado=resultado.matrizAdjunta();
        resultado=resultado.multiplicacion(determinante);

        return resultado;
    }
    
}
