/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_integrador;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author leand
 */
public class ImagemConfig extends JPanel {

    private Image backgroundImage;

    public ImagemConfig() {
        backgroundImage = new ImageIcon(getClass().getResource("/imagens/fade.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    };
    
    public Icon redimensionarIcon(String icon, int largura, int altura) {
        ImageIcon iconOriginal = new ImageIcon(getClass().getResource("/imagens/"+ icon +".png"));
        Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(
                                                        largura, altura, Image.SCALE_SMOOTH);
        
        ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
        return iconRedimensionado;
    }
}
