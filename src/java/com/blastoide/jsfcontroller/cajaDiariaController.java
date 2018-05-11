package com.blastoide.jsfcontroller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
@Named("cajaDiariaController")
@SessionScoped
public class cajaDiariaController implements Serializable{
    
    private Double valorInicialDiario;

    public cajaDiariaController() {
    }

    public cajaDiariaController(Double valorInicialDiario) {
        this.valorInicialDiario = valorInicialDiario;
    }
    
    public Double getValorInicialDiario() {
        return valorInicialDiario;
    }

    public void setValorInicialDiario(Double valorInicialDiario) {
        this.valorInicialDiario = valorInicialDiario;
    }
    
    public void GuardarValorInicialCaja( Double GuardarValorInicialCaja){
    
        this.valorInicialDiario = GuardarValorInicialCaja;
    }
}
