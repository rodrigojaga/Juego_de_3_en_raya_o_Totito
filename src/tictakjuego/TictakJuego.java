package tictakjuego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TictakJuego {
    vista v;

    public TictakJuego(vista v) {
        this.v = v;
        mouseListenermetodo(v.label1);
        mouseListenermetodo(v.label2);
        mouseListenermetodo(v.label3);
        mouseListenermetodo(v.label4);
        mouseListenermetodo(v.label5);
        mouseListenermetodo(v.label6);
        mouseListenermetodo(v.label7);
        mouseListenermetodo(v.label8);
        mouseListenermetodo(v.label9);        
    }

    
    private void mouseListenermetodo(JLabel label){
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reconocerLabel(label, e);
            }
        });
    }
    
    private void reconocerLabel(JLabel label, MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            label.setText("X");
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            label.setText("O");
        }
        ganador();
    }
    
    private void ganador() {        
        if (linea(v.label1, v.label2, v.label3)) {
            colorGanador(v.label1, v.label2, v.label3);
        }else if(linea(v.label1, v.label5, v.label9)){
            colorGanador(v.label1, v.label5, v.label9);
        }else if(linea(v.label1, v.label4, v.label7)){
            colorGanador(v.label1, v.label4, v.label7);
        }else if(linea(v.label2, v.label5, v.label8)){
            colorGanador(v.label2, v.label5, v.label8);
        }else if(linea(v.label3, v.label6, v.label9)){
            colorGanador(v.label3, v.label6, v.label9);
        }else if(linea(v.label3, v.label5, v.label7)){
            colorGanador(v.label3, v.label5, v.label7);
        }else if(linea(v.label4, v.label5, v.label6)){
            colorGanador(v.label4, v.label5, v.label6);
        }else if(linea(v.label7, v.label8, v.label9)){
            colorGanador(v.label7, v.label8, v.label9);
        }
        checarTablero();
    }
    
    private void colorGanador(JLabel label1, JLabel label2, JLabel label3) {
        label1.setBackground(Color.GREEN);
        label2.setBackground(Color.GREEN);
        label3.setBackground(Color.GREEN);
        if(label1.getText().equals("X")){            
            JOptionPane.showMessageDialog(null, "FELICIDADES!!!! Gano el jugador 1");
            escribirPuntosEnLabel(v.labelPuntosJ1,v.labelPuntosJ2,"X");
            flashPoint();
        }else{
            JOptionPane.showMessageDialog(null, "FELICIDADES!!!! Gano el jugador 2");
            escribirPuntosEnLabel(v.labelPuntosJ1,v.labelPuntosJ2,"O");
            flashPoint();
        }
        
    }

    private boolean linea(JLabel label1, JLabel label2, JLabel label3) {
        String content1 = label1.getText();
        String content2 = label2.getText();
        String content3 = label3.getText();
        
        return !content1.isEmpty() && content1.equals(content2) && content2.equals(content3);
    }
    
    private void escribirPuntosEnLabel(JLabel labelJugador1, JLabel labelJugador2,String jugador){
        if(jugador.equals("X")){
            int aux = Integer.parseInt(labelJugador1.getText());
            labelJugador1.setText(String.valueOf(aux+1));
            v.labelJugadorFinal.setText("ULTIMO GANADOR: JUGADOR 1");
        }else{
            int aux = Integer.parseInt(labelJugador2.getText());
            labelJugador2.setText(String.valueOf(aux+1));
            v.labelJugadorFinal.setText("ULTIMO GANADOR: JUGADOR 2");
        }
    }
    
//    private void flashPoint(){
//        v.label1.setText("");
//        v.label2.setText("");
//        v.label3.setText("");
//        v.label4.setText("");
//        v.label5.setText("");
//        v.label6.setText("");
//        v.label7.setText("");
//        v.label8.setText("");
//        v.label9.setText("");
//        v.label1.setBackground(Color.WHITE);
//        v.label2.setBackground(Color.WHITE);
//        v.label3.setBackground(Color.WHITE);
//        v.label4.setBackground(Color.WHITE);
//        v.label5.setBackground(Color.WHITE);
//        v.label6.setBackground(Color.WHITE);
//        v.label7.setBackground(Color.WHITE);
//        v.label8.setBackground(Color.WHITE);
//        v.label9.setBackground(Color.WHITE);
//        
//    }
    
    private void flashPoint() {
    JLabel[] labels = {
        v.label1, v.label2, v.label3,
        v.label4, v.label5, v.label6,
        v.label7, v.label8, v.label9
    };

    for (JLabel label : labels) {
        label.setText("");
        label.setBackground(Color.WHITE);
    }
}

    
//    private void checarTablero(){
//        if((v.label1.getText().equals("X") || v.label1.getText().equals("O"))&&(v.label2.getText().equals("X") || v.label2.getText().equals("O"))&&
//                (v.label3.getText().equals("X") || v.label3.getText().equals("O"))&&(v.label4.getText().equals("X") || v.label4.getText().equals("O"))&&
//                (v.label5.getText().equals("X") || v.label5.getText().equals("O"))&&(v.label6.getText().equals("X") || v.label6.getText().equals("O"))&&
//                (v.label7.getText().equals("X") || v.label7.getText().equals("O"))&&(v.label8.getText().equals("X") || v.label8.getText().equals("O"))&&
//                (v.label9.getText().equals("X") || v.label9.getText().equals("O"))){
//            JOptionPane.showMessageDialog(null, "EMPATE");
//            flashPoint();
//        }
//    }
    
    private void checarTablero() {
    String[] positions = {
        v.label1.getText(), v.label2.getText(), v.label3.getText(),
        v.label4.getText(), v.label5.getText(), v.label6.getText(),
        v.label7.getText(), v.label8.getText(), v.label9.getText()
    };

    for (String position : positions) {
        if (!position.equals("X") && !position.equals("O")) {
            return; // Si encontramos una posición vacía, no hay empate aún
        }
    }

    JOptionPane.showMessageDialog(null, "EMPATE");
    flashPoint();
}

    
    public static void main(String[] args) {

        vista view = new vista();
        TictakJuego controller = new TictakJuego(view);
        view.setVisible(true);
    }

    
}
