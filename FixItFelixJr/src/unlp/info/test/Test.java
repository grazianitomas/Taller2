package unlp.info.test;

import unlp.info.animal.*;
import unlp.info.animalespreligrosos.*;
import unlp.info.domestico.*;

public class Test {
	public static void main(String[] args) {
		PerroDomestico gordo = new PerroPeligroso();
		gordo.ladra();
		gordo.mueveCola();
		// gordo.muerde(); No puede ejecutarse ya que no encuentra éste método en perro peligroso. 

		AnimalPeligroso rita = new PerroPeligroso();
		rita.muerde();
		//rita.ladra(); No puede ejutarlo ya que AnimalPeligroso no contiene esos métodos
		//rita.mueveCola();	De igual manera con éste método
		
	}

}
