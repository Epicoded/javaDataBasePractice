package com.platzi;

import java.util.Scanner;

import com.platzi.service.MessageService;

public class Main {
	public static void main(String[] args) {
		
//		Conector con = new Conector();
//		con.connect();
//		con.close();
		
		Scanner sc = new Scanner(System.in);
		
		int option = 0;
		
		do {
			System.out.println("-------------------");
			System.out.println(" Aplicación de mensajes");
			System.out.println(" 1. Crear un mensaje");
			System.out.println(" 2. Listar mensajes");
			System.out.println(" 3. Editar mensaje");
			System.out.println(" 4. Eliminar mensaje");
			System.out.println(" 5. Salir");
			
			// Leer opcion de usuario
			option = sc.nextInt();
			
			switch (option) {
			
				case 1:
					MessageService.createMessage();
					break;
				case 2:
					MessageService.readMessage();
					break;
				case 3:
					MessageService.updateMessage();
					break;
				case 4:
					MessageService.deleteMessage();
					break;
				default:
					break;
			}
			
		}while(option !=5 );
	}
}
