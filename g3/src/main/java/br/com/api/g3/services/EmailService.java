package br.com.api.g3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import br.com.api.g3.dto.ClienteDTO;
import br.com.api.g3.dto.FuncionarioDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {

	@Autowired
	JavaMailSender emailSender;
	
	public void envioEmailCadastroC(String email, ClienteDTO cliente) throws MessagingException {
		MimeMessage messageCliente = emailSender.createMimeMessage();
		MimeMessageHelper helperCliente = new MimeMessageHelper(messageCliente, true);
	
		try {
			helperCliente.setFrom("g3apiserratec@gmail.com");
			helperCliente.setTo("g3apiserratec@gmail.com");
			helperCliente.setSubject(email);
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<html>\r\n");
			stringBuilder.append("     <body>\r\n");
			stringBuilder.append("          <div align=\"center\">\r\n");
			stringBuilder.append("            <h1>Bem vindo!\r\n</h1>");
			stringBuilder.append("          </div>\r\n");
			stringBuilder.append("          <div>\r\n");
			stringBuilder.append("          <br/>\r\n");
			stringBuilder.append("        	 Nome: " + cliente.getNome());
			stringBuilder.append("           CPF:"+ cliente.getCpf());
			stringBuilder.append("          </div>\r\n");
			stringBuilder.append("          <div>\r\n");
			stringBuilder.append("          <br/>\r\n");
			stringBuilder.append("           Status: " + cliente.isAtivo());
			stringBuilder.append("          </div>\r\n");
			stringBuilder.append("     </body>\r\n");
			stringBuilder.append("</html>\r\n");
			
			helperCliente.setText(stringBuilder.toString (), true);
			emailSender.send(messageCliente);
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
	public void envioEmailCadastroF(String email, FuncionarioDTO funcionarioDTO) throws MessagingException {
		MimeMessage messageFuncionario = emailSender.createMimeMessage();
		MimeMessageHelper helperFuncionario = new MimeMessageHelper(messageFuncionario, true);
		
		try {
			helperFuncionario.setFrom("g3apiserratec@gmail.com");
			helperFuncionario.setTo("g3apiserratec@gmail.com");
			helperFuncionario.setSubject(email);
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<html>\r\n");
			stringBuilder.append("     <body>\r\n");
			stringBuilder.append("          <div align=\"center\">\r\n");
			stringBuilder.append("            <h1>Cadastro Concluido\r\n</h1>");
			stringBuilder.append("          </div>\r\n");
			stringBuilder.append("          <div>\r\n");
			stringBuilder.append("          <br/>\r\n");
			stringBuilder.append("        	 Nome: " + funcionarioDTO.getNome());
			stringBuilder.append("          </div>\r\n");
			stringBuilder.append("          <div>\r\n");
			stringBuilder.append("          <br/>\r\n");
			stringBuilder.append("           Status: " + funcionarioDTO.isAtivo());
			stringBuilder.append("          </div>\r\n");
			stringBuilder.append("     </body>\r\n");
			stringBuilder.append("</html>\r\n");
			
			helperFuncionario.setText(stringBuilder.toString (), true);
			emailSender.send(messageFuncionario);
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
}
