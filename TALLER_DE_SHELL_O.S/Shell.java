import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Shell extends JFrame{
	
	//elementos gráficos
	JTextField tComando;
	JButton bEjecutar,bBorrar,bSalir;
	JTextArea tResultado;
	JScrollPane sPane;

	//oyente de click de botón
	ActionListener alEjecutar, alBorrar,alSalir;
	String comando="cmd /c";
	String so=System.getProperty("os.name");
	public Shell(){
		setSize(700,600);
		setTitle(System.getProperty("os.name"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void graficos(){
		getContentPane().setLayout(null);
		//cuadro de texto
		tComando = new JTextField();
		tComando.setBounds(50,50,250,30);
		add(tComando);
		//botón para ejecutar comando
		bEjecutar = new JButton("Ejecutar");
		bEjecutar.setBounds(300,50,150,30);
		add(bEjecutar);
		bEjecutar.addActionListener(alEjecutar);

		bBorrar = new JButton("Borrar Resultado");
		bBorrar.setBounds(450,50,200,30);
		add(bBorrar);
		bBorrar.addActionListener(alBorrar);

		bSalir = new JButton("Salir");
		bSalir.setBounds(200,530,200,30);
		add(bSalir);
		bSalir.addActionListener(alSalir);




		//área de texto
		tResultado = new JTextArea();
		tResultado.setBounds(50,130,600,370);
		tResultado.setBackground(Color.BLACK);
		tResultado.setForeground(Color.GREEN);
		//scroll pane
		sPane = new JScrollPane(tResultado);
		sPane.setBounds(50,120,500,400);
		add(sPane);
		//
		setVisible(true);
	}

	private void acciones(){
		alEjecutar = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ejecutar();
				tComando.setText("");
			}
		};
	
		alBorrar = new ActionListener(){
			public void actionPerformed(ActionEvent a){
				
				tResultado.setText("");
			}
		};

		alSalir = new ActionListener(){
			public void actionPerformed(ActionEvent a){
				
				System.exit(0);
			}
		};





	}

	private void ejecutar(){

		Process proc; 
		InputStream is_in;
		String s_aux;
		BufferedReader br;

		
		comando=comando+" "+tComando.getText();
		if(so.equals("Linux") || so.equals("Mac")){
			try
		{
			proc = Runtime.getRuntime().exec(tComando.getText());
			is_in=proc.getInputStream();
			br=new BufferedReader (new InputStreamReader (is_in));
			s_aux = br.readLine();
            while (s_aux!=null)
            {
            	tResultado.setText(tResultado.getText()+s_aux+"\n");
                s_aux = br.readLine();
            } 
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}else
		try
		{
			proc = Runtime.getRuntime().exec(comando);
			is_in=proc.getInputStream();
			br=new BufferedReader (new InputStreamReader (is_in));
			s_aux = br.readLine();
            while (s_aux!=null)
            {
            	tResultado.setText(tResultado.getText()+s_aux+"\n");
                s_aux = br.readLine();
            } 
		}
		catch(Exception e)
		{
			e.getMessage();
		}


	}

	public static void main(String args[]){
		String soo=System.getProperty("os.name");
		Shell ventana = new Shell();
		JOptionPane.showMessageDialog(null, "esta en " + soo + ",use comandos de "+soo);
		ventana.acciones();	
		ventana.graficos();	
	}

}