/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Maninder Singh
 */
public class CertificationNotFoundException extends RuntimeException {
        public CertificationNotFoundException(String message) {
        super(message);
    }

}