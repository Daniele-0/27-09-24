import java.awt.FlowLayout; 
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame 
{ // inicio da classe checkboxframe
   private final JTextField textField; 
   private final JCheckBox boldJCheckBox;  
   private final JCheckBox italicJCheckBox; 

  
   public CheckBoxFrame() // exportando o construtor chackboxframe, que tem o mesmo nome da classe e o mesmo nome do arquivo
   {
      super("JCheckBox Test"); // titulo superior. o super define o titulo
      setLayout(new FlowLayout()); // define a saida dos elementos, o flow vai pela fila

     
      textField = new JTextField("Watch the font style change", 20); // esta atribuindo um novo obj (jtextfield) e ja envio o testo que aparece dentro dele, e o tamanho
      textField.setFont(new Font("Serif", Font.PLAIN, 15)); // invocando o setfont, que envia o new font como parametro. envia uma nova fonte, que é Serif,font.plain (texto sem formatação), size é o tamanho
      add(textField); // invocando o metodo add para adcionar tudo que esta a cima na parede que aparece ao apertar o botão play (runjava)

      boldJCheckBox = new JCheckBox("Bold"); 
      italicJCheckBox = new JCheckBox("Italic");
      add(boldJCheckBox); 
      add(italicJCheckBox); 

      
      CheckBoxHandler handler = new CheckBoxHandler();
      boldJCheckBox.addItemListener(handler);
      italicJCheckBox.addItemListener(handler);
   } 

   
   private class CheckBoxHandler implements ItemListener 
   {
     
      @Override // herdeiro
      public void itemStateChanged(ItemEvent event)
      {
         Font font = null; 

        
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
         else if (boldJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD, 14);
         else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14);
         else
            font = new Font("Serif", Font.PLAIN, 14);

         textField.setFont(font); 
      } 
   }
} 
