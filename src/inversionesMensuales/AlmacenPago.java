package inversionesMensuales;

import java.util.Arrays;

public class AlmacenPago {
	/*DECLARACION DE VARIABLES QUE VOY A USAR*/
		private double monto;
		private double interesAnual;
		private int anios;
		private double montoDeseado;
		
		/*LOS DECLARO SEGUN METODO 1 Y 2*/

		public AlmacenPago(double monto, double interesAnual, int anios) {
			super();
			this.monto = monto;
			this.interesAnual = interesAnual;
			this.anios = anios;
		}

		public AlmacenPago(double monto, double interesAnual, double montoDeseado) {
			super();
			this.monto = monto;
			this.interesAnual = interesAnual;
			this.montoDeseado = montoDeseado;
		}
/*PRIMER METODO ESPERA RETORNAR UN ARRAY LLAMADO CALCULAR INVERSION*/
		public double [] calcularInversion() {
			int x = 1;  /*CREO UNA VARIABLE PARA QUE HAGA DE "HASTA" EN EL FOR*/
			double total [] = new double [this.anios]; /*CREO EL ARRAY PARA QUE TOME LA CANTIDAD DE AÑOS*/
			for (int i = 0; i < this.anios; i++) /*FOR PARA QUE ITERE DESDE 0 A CANTIDAD DE AÑOS DE ARRIBA*/ {
				total[i] = Math.round(this.monto * (Math.pow(1 + this.interesAnual / 12, 12*x++)) * 10000)/ 10000.0;
			} /*FORMULA PARA CALCULAR  Y QUE ACUMULE LOS TOTALES POR AÑO Y *10000/10000 ES PARA QUE MUESTRE CUANTOS DECIMALES DESPUES DE LA COMA*/
			return total; /*TIENE QUE RETORNAR EL TOTAL*/
		}

/* SEGUNDO METODO ESPERA RETORNAR SOLO UN NUMERO DE MESES QUE TARDA EN RECUPERAR LA INVERSION*/ 
		public int tiempoSaldo() {
			int meses = 0; /*CREO VARIABLE PARA QUE SUME EN MESES*/
			while (this.monto < this.montoDeseado)/*MIENTRAS QUE EL MONTON SEA MENOR AL MONTO DESEADO QUE ITERE ESTA FUNCION SIGUIENTE */{
				this.monto = this.monto * (1 + this.interesAnual / 12);
				meses++; /*suma meses*/
			}
			return meses; /*devuelve la cantidad de meses que tarda en recuperar*/
		}
/*PRUEBAS CON MAIN*/ 
		public static void main(String[] args) {
			AlmacenPago inv = new AlmacenPago(1000, 0.24, 4); /*creo nuevo objeto para 1er metodo en el syso*/
			System.out.println(Arrays.toString(inv.calcularInversion())); /*uso array to para que no tire cosas tipo sadas@1212*/
			AlmacenPago inv2 = new AlmacenPago(1000, 0.07, 2000.0); /*creo nuevo objeto para probar metodo 2 en el syso*/
			System.out.println(inv2.tiempoSaldo());
		}
	}		
	
