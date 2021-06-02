package com.video.view;

import java.util.Date;
import java.util.*;

import javax.swing.JOptionPane;

import com.video.application.VideoController;
import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.exceptions.NoVideoIncludedException;

public class AppVideo {

	private static VideoController controller = new VideoController();

	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Bienvenido!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
		String nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre", "NOMBRE",JOptionPane.QUESTION_MESSAGE);
		String apellido = JOptionPane.showInputDialog(null, "Introduce tu apellido", "APELLIDO",JOptionPane.QUESTION_MESSAGE);
		String contra = JOptionPane.showInputDialog(null, "Introduce tu contrase�a", "PASSWORD",JOptionPane.QUESTION_MESSAGE);
		
		User user = new User(nombre,apellido ,contra , new Date());
		JOptionPane.showMessageDialog(null, "Hola " + user.getName() + "!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
		
		int opcion;
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "�Qu� acci�n quieres realizar? \n1. Subir v�deo \n2. Ver tus v�deos\n3. Salir"
					, "", JOptionPane.QUESTION_MESSAGE));
			
			switch (opcion) {
			
			case 1:
				JOptionPane.showMessageDialog(null, "De acuerdo, vamos a subir un v�deo!", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "Para subir un v�deo es necesario: \n - URL del v�deo\n - T�tulo del v�deo\n - Una lista de TAGs", 
						"UPLOAD", JOptionPane.INFORMATION_MESSAGE);
				String urlVideo = JOptionPane.showInputDialog(null, "Introduce la URL: ", "URL",JOptionPane.QUESTION_MESSAGE);
				String tituloVideo = JOptionPane.showInputDialog(null, "Introduce el t�tulo: ", "T�TULO",JOptionPane.QUESTION_MESSAGE);
				int numTags = Integer.parseInt(JOptionPane.showInputDialog(null, "�Cu�ntas TAGs quieres que tenga tu v�deo?"
					, "", JOptionPane.QUESTION_MESSAGE));
				
				List<Tag> userTags = controller.addTag(numTags);
				JOptionPane.showMessageDialog(null, "Todo listo!", "", JOptionPane.INFORMATION_MESSAGE);
				try {
					controller.createVideo(urlVideo, tituloVideo, user, userTags);
				} catch (NoVideoIncludedException e) {
					JOptionPane.showMessageDialog( null, "NO VIDEO INCLUDED", "ERROR", JOptionPane.ERROR_MESSAGE );
					e.printStackTrace();
				}
				break;
			
			case 2:
				JOptionPane.showMessageDialog(null, "Veamos qu� v�deos tienes subidos...!", "FIND VIDEO", JOptionPane.INFORMATION_MESSAGE);
				
				 List<Video> videosForUser = controller.getUserVideoList(user);
				 
				 videosForUser.forEach((Video v) ->System.out.println(v.getTittle()));
				 videosForUser.forEach((Video v) -> JOptionPane.showMessageDialog(null, v.getTittle(), "YOUR VIDEOS", JOptionPane.INFORMATION_MESSAGE));
				
				//JOptionPane.showMessageDialog(null, v.getTittle, "YOUR VIDEOS", JOptionPane.INFORMATION_MESSAGE);
				
				break;
			
				
			case 3:
				int resp = JOptionPane.showConfirmDialog( null , "Est� seguro que desea cerrar?" , "Confirmaci�n" , JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) break;
				opcion = 4; //valor aleatorio para ir de nuevo al men� principal
			
			
			default:
				break;
			}
		
		}while(opcion!=3);		
	}
	
} 