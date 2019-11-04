package practica3;

public class StringDemo {

	public static void main(String[] args) {

		String str1 = "Leones y Tigres y Osos!";
		String str2 = "Leones y Tigres y Osos!";
		String str3 = str2;
		String str4 = new String("Leones y Tigres y Osos!");
		String str5 = " Y yo!";
		String str6 = "Leones y Tigres y Osos! Y yo!";
		String str7 = str1 + str5;
		System.out.println(str1 == str2); //TRUE
		System.out.println(str1 == str3); //TRUE
		System.out.println(str1 == str4); //FALSE 
		System.out.println(str2 == str3); //TRUE
		System.out.println(str2 == str4); //FALSE
		System.out.println(str3 == str4); //FALSE PORQUE COMPARA LAS DIRECCIONES Y UNO ESTA EN HEAP
		System.out.println(str6 == str7); //FALSE PORQUE?
		System.out.println(str1.equals(str4)); //TRUE PORQUE COMPARA EL CONTENIDO
		System.out.println(str6.equals(str7)); //TRUE PORQUE COMPARA EL CONTENIDO
	}
}