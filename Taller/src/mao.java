import java.util.*;
import java.io.*;
public class mao {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> usuarios = new ArrayList<String>();
		ArrayList<String> contrasenas = new ArrayList<String>();
		ArrayList<Integer> vida = new ArrayList<Integer>();
		ArrayList<Integer> ataque = new ArrayList<Integer>();
		ArrayList<Integer> defensa = new ArrayList<Integer>();
		ArrayList<Integer> velocidad = new ArrayList<Integer>();
		ArrayList<Integer> can_hechizos = new ArrayList<Integer>();
		ArrayList<Integer> exp = new ArrayList<Integer>();
		
		ArrayList<String> mon_nombre = new ArrayList<String>();
		ArrayList<Integer> mon_vida = new ArrayList<Integer>();
		ArrayList<Integer> mon_ataque = new ArrayList<Integer>();
		ArrayList<String> mon_clase = new ArrayList<String>();
		ArrayList<Integer> mon_velocidad = new ArrayList<Integer>();
		
		ArrayList<String> spells = new ArrayList<String>();
		ArrayList<Integer> damages = new ArrayList<Integer>();

		
		ArrayList<String> caster = new ArrayList<String>();
		ArrayList<String> casteo = new ArrayList<String>();

		
		File jugadores = new File("Jugadores.txt");
		File enemigos = new File("Enemigos.txt");
		File hechizos = new File("Hechizos.txt");
		File he_jugadores = new File("HechizosJugadores.txt");
		Scanner scan1 = new Scanner(jugadores);
		while (scan1.hasNextLine()) {
			String parts[]=scan1.nextLine().split(",");
			usuarios.add(parts[0].trim());
			contrasenas.add(parts[1].trim());
			vida.add(Integer.parseInt(parts[2].trim()));
			ataque.add(Integer.parseInt(parts[3].trim()));
			defensa.add(Integer.parseInt(parts[4].trim()));
			velocidad.add(Integer.parseInt(parts[5].trim()));
			can_hechizos.add(Integer.parseInt(parts[6].trim()));
			exp.add(Integer.parseInt(parts[7].trim()));
			
		}
		Scanner scan2 = new Scanner(enemigos);
		while (scan2.hasNextLine()) {
			String parts[]=scan2.nextLine().split(",");
			mon_nombre.add(parts[0].trim());
			mon_vida.add(Integer.parseInt(parts[1].trim()));
			mon_ataque.add(Integer.parseInt(parts[2].trim()));
			mon_clase.add(parts[3].trim());
			mon_velocidad.add(Integer.parseInt(parts[4].trim()));
			
		}
		Scanner scan3 = new Scanner(hechizos);
		while (scan3.hasNextLine()) {
			String parts[]=scan3.nextLine().split(",");
			spells.add(parts[0].trim());
			damages.add(Integer.parseInt(parts[1].trim()));
			
		}
		Scanner scan4 = new Scanner(he_jugadores);
		while (scan4.hasNextLine()) {
			String parts[]=scan4.nextLine().split(",");
			caster.add(parts[0].trim());
			casteo.add(parts[1].trim());
			
		}
/*scanneres no resuletos
		Scanner scan3 = new Scanner(hechizos);
		while (scan3.hasNextLine()) {
			String parts[]=scan3.nextLine().split(",");
			usuarios.add(parts[0].trim());
			contrasenas.add(parts[1].trim());
		}
		//scanneres no resuletos
		Scanner scan4 = new Scanner(he_jugadores);
		while (scan4.hasNextLine()) {
			String parts[]=scan4.nextLine().split(",");
			usuarios.add(parts[0].trim());
			contrasenas.add(parts[1].trim());
		}
*/

		System.out.println(usuarios);
		System.out.println(contrasenas);
		boolean login=true;
		boolean menu=false;
		boolean supermenu=false;
		while (login) {
			Scanner read = new Scanner(System.in);
			System.out.println("Ingrese usuario");
			String user= read.nextLine();
			System.out.println("Ingrese contrase�a");
			String pass= read.nextLine();
			if (user.equals("Admin") && pass.equals("Patata19")) {
				supermenu=true;
				login=false;
			}
			else if (usuarios.contains(user) && pass.equals(contrasenas.get(usuarios.indexOf(user)))) {
				menu=true;
				login=false;
			}
			
			else if(usuarios.contains(user)){
				System.out.println("usuario y/o contrase�a incorrectos");
			}
			else {
				System.out.println("El usuario no existe, �desea crear otro usuario?");
				System.out.println("1. S�");
				System.out.println("2. No");
				int veri=read.nextInt();
				if (veri==1) {
					System.out.println("ingrese nuevo usuario");
					String new_user= read.nextLine();
					System.out.println("ingrese nueva contrase�a");
					String new_pass= read.nextLine();
					usuarios.add(new_user);
					contrasenas.add(new_pass);
					vida.add(100);
					ataque.add(10);
					defensa.add(10);
					velocidad.add(10);
					can_hechizos.add(0);
					exp.add(0);
				}
			}
		}
		while (menu) {
			Scanner read = new Scanner(System.in);
			System.out.println("1. Luchar");
			System.out.println("2. Aprender hechizo");
			System.out.println("3. Estadisticas Jugador");
			System.out.println("4. Estadisticas Hechizos");
			System.out.println("5. Ranking");
			System.out.println("6. Salir");
			int ingresado= read.nextInt();
			if (ingresado==1) {
				System.out.println("1. PVE");
				System.out.println("2. PVP");
				int tipo_enemigo= read.nextInt();
				if (tipo_enemigo==1) {
					Random rand = new Random();
					int prob = rand.nextInt(101);
					if (prob>=0 && prob<50) {
						int enemy=mon_clase.indexOf("F");
						System.out.println("tu enemigo:"+mon_nombre.get(enemy));
						
					}
					else if (prob>=50 && prob<76) {
						int enemy=mon_clase.indexOf("C");
						System.out.println("tu enemigo:"+mon_nombre.get(enemy));
						
					}
					else if (prob>=76 && prob<91) {
						int enemy=mon_clase.indexOf("B");
						System.out.println("tu enemigo:"+mon_nombre.get(enemy));
						
					}
					else if (prob>=91 && prob<100) {
						int enemy=mon_clase.indexOf("A");
						System.out.println("tu enemigo:"+mon_nombre.get(enemy));
						
					}
					else if (prob==100) {
						int enemy=mon_clase.indexOf("S");
						System.out.println("tu enemigo:"+mon_nombre.get(enemy));
						
					}
					
					
				}
				if (tipo_enemigo==2) {
					Random rand = new Random();
					int prob = rand.nextInt(usuarios.size()+1);
					
					
				}
			}
			else if (ingresado==2) {
				menu=false;
			}
			else if (ingresado==3) {
				menu=false;
			}
			else if (ingresado==4) {
				menu=false;
			}
			else if (ingresado==5) {
				menu=false;
			}
			else if (ingresado==6) {
				menu=false;
			}
		}
		while (supermenu) {
			Scanner read = new Scanner(System.in);
			System.out.println("1. Eliminar Jugador");
			
			System.out.println("2. Agregar enemigos");
			
			System.out.println("3. Agregar Hechizos");
			System.out.println("4. Estadisticas de Jugadores");
			System.out.println("5. Salir");
			int ingresado= read.nextInt();
			if (ingresado==1) {
				Scanner read_ju = new Scanner(System.in);
				System.out.println("Jugador a eliminar:");
				String eliminar_jugador=read_ju.nextLine();
				int indice_jugador_eliminar= usuarios.indexOf(eliminar_jugador);
				usuarios.remove(indice_jugador_eliminar);
				contrasenas.remove(indice_jugador_eliminar);
				vida.remove(indice_jugador_eliminar);
				ataque.remove(indice_jugador_eliminar);
				defensa.remove(indice_jugador_eliminar);
				velocidad.remove(indice_jugador_eliminar);
				can_hechizos.remove(indice_jugador_eliminar);
				exp.remove(indice_jugador_eliminar);
			}
			else if (ingresado==2) {
				Scanner read_ene = new Scanner(System.in);
				System.out.println("Enemigo a agregar:");
				String enemigo_nuevo=read_ene.nextLine();
				mon_nombre.add(enemigo_nuevo);
				System.out.println("Ingrese vida:");
				int vida_nuevo_enemigo=read_ene.nextInt();
				mon_vida.add(vida_nuevo_enemigo);
				System.out.println("Ingrese ataque:");
				int ataque_nuevo_enemigo=read_ene.nextInt();
				mon_ataque.add(ataque_nuevo_enemigo);
				System.out.println("Ingrese clase:");
				String clase_nuevo_enemigo=read_ene.nextLine();
				mon_clase.add(clase_nuevo_enemigo);
				System.out.println("Ingrese velocidad:");
				int velocidad_nuevo_enemigo=read_ene.nextInt();
				mon_velocidad.add(velocidad_nuevo_enemigo);
				
			}
			else if (ingresado==3) {
				Scanner read_he = new Scanner(System.in);
				System.out.println("Hechizo a agregar:");
				String hechizo_nuevo=read_he.nextLine();
				spells.add(hechizo_nuevo);
				System.out.println("da�o del nuevo hechizo:");
				int danio_nuevo=read_he.nextInt();
				damages.add(danio_nuevo);
				
			}
			else if (ingresado==4) {
				System.out.println("Estad�sticas:");

				for(int i=0;i<usuarios.size();i++){
					System.out.println(usuarios.get(i)+" "+vida.get(i)+" "+ataque.get(i)+" "+defensa.get(i)+" "+velocidad.get(i)+" "+can_hechizos.get(i)+" "+exp.get(i));
				}
			}
			else if (ingresado==5) {
				supermenu=false;
			}
		}

/*
		try {
			Scanner scanner = new Scanner(new File("Jugadores.txt"));
			while (scanner.hasNextLine()) {
			   String line = scanner.nextLine();
			   System.out.println(line);
			}
		}
		catch (FileNotFoundException ex) {
			System.out.println("a");
			}
*/
			
	}

}
