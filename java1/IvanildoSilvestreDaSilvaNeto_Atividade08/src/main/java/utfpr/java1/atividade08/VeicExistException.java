/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.java1.atividade08;

/**
 *
 * @author ivneto
 */
public class VeicExistException extends RuntimeException {

    public VeicExistException() {
        super("Veículo já cadastrado!");
    }

}
