/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopead2020;

import javax.swing.JOptionPane;

/**
 *
 * @author wolfi
 */
public class Mens {
    /**
     * Permite mostrar mensagem customizadas de aviso
     * @param titulo titulo da mensagem
     * @param texto texto a ser apresentado na tela
     * @param tipo tipo de mensagem a ser exibido
     */
    private static void mensagem(String titulo, String texto, int tipo) {
        JOptionPane.showMessageDialog(null, texto, titulo, tipo);
    }
    
    /**
     * Mostra uma mensagem customizada de aviso
     * @param texto conteúdo a ser exibido na tela
     */
    public static void aviso(String texto){
        mensagem("Aviso", texto, JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Mostrar uma mensagem customizada de erro
     * @param texto conteúdo a ser exibido na tela
     */
    public static void erro(String texto){
        mensagem("Erro", texto, JOptionPane.ERROR_MESSAGE);    
    }
    
    /**
     * Mostrar uma mensagem customizada de atenção
     * @param texto conteúdo a ser exibido na tela
     */
    public static void atencao(String texto){
        mensagem("Atenção", texto, JOptionPane.WARNING_MESSAGE);    
    }
    
}
