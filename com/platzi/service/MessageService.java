package com.platzi.service;

import java.util.Scanner;

import com.platzi.dao.MessageDAO;
import com.platzi.model.Message;

/**
*
* @author EpicGex
*/

public class MessageService {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void createMessage() {
		System.out.println("Escribe tu mensaje");
		String mensaje = sc.nextLine();
		
		System.out.println("Tu nombre");
		String nombre = sc.nextLine();
		
		Message registro = new Message();
		registro.setMessage(mensaje);
		registro.setMessageAuthor(nombre);
		
		MessageDAO.createMessageDB(registro);
	}
	
	public static void readMessage() {
		MessageDAO.readMessageDB();
	}
	

	public static void updateMessage() {
		
		System.out.println("¿Que Id de mensaje se va a editar?");
		String idMessage = sc.nextLine();
		
		System.out.println("Escribe el nuevo mensaje");
		String newMessage = sc.nextLine();
		
		System.out.println("Indica tu nombre");
		String newName = sc.nextLine();
		
		Message edit = new Message();
		edit.setIdMessage(Integer.parseInt(idMessage));
		edit.setMessage(newMessage);
		edit.setMessageAuthor(newName);
		
		MessageDAO.updateMessageDB(edit);
	}
	
	public static void deleteMessage() {
		
		System.out.println("¿Que Id de mensaje se va a eliminar?");
		String idMessage = sc.nextLine();
		
		Message delete = new Message();
		delete.setIdMessage(Integer.parseInt(idMessage));
		
		MessageDAO.deleteMessageDB(delete.getIdMessage());
	}
}
