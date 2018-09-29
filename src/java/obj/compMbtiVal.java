/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pieroni
 */
@ManagedBean(name = "compMbtiVal")
@SessionScoped

public class compMbtiVal implements Serializable{
    
    private String arquitecto;
    private int valorArquitecto;
    
    private String logico;
    private int valorLogico;
    
    private String comandante;
    private int valorComandante;
    
    private String innovador;
    private int valorInnovador;

    private String abogado;
    private int valorAbogado;
    
    private String mediador;
    private int valorMediador;
    
    private String protagonista;
    private int valorProtagonista;
    
    private String activista;
    private int valorActivista;
    
    private String logista;
    private int valorLogista;
    
    private String defensor;
    private int valorDefensor;
    
    private String ejecutivo;
    private int valorEjecutivo;
    
    private String consul;
    private int valorConsul;
    
    private String virtuoso;
    private int valorVirtuoso;
    
    private String aventurero;
    private int valorAventurero;
    
    private String emprendedor;
    private int valorEmprendedor;
    
    private String animador;
    private int valorAnimador;
    
    private Competencia compSeleccionada;

    public Competencia getCompSeleccionada() {
        return compSeleccionada;
    }

    public void setCompSeleccionada(Competencia compSeleccionada) {
        this.compSeleccionada = compSeleccionada;
    }
    
    public String getArquitecto() {
        return arquitecto;
    }

    public void setArquitecto(String arquitecto) {
        this.arquitecto = arquitecto;
    }

    public int getValorArquitecto() {
        return valorArquitecto;
    }

    public void setValorArquitecto(int valorArquitecto) {
        this.valorArquitecto = valorArquitecto;
    }

    public String getLogico() {
        return logico;
    }

    public void setLogico(String logico) {
        this.logico = logico;
    }

    public int getValorLogico() {
        return valorLogico;
    }

    public void setValorLogico(int valorLogico) {
        this.valorLogico = valorLogico;
    }

    public String getComandante() {
        return comandante;
    }

    public void setComandante(String comandante) {
        this.comandante = comandante;
    }

    public int getValorComandante() {
        return valorComandante;
    }

    public void setValorComandante(int valorComandante) {
        this.valorComandante = valorComandante;
    }

    public String getInnovador() {
        return innovador;
    }

    public void setInnovador(String innovador) {
        this.innovador = innovador;
    }

    public int getValorInnovador() {
        return valorInnovador;
    }

    public void setValorInnovador(int valorInnovador) {
        this.valorInnovador = valorInnovador;
    }

    public String getAbogado() {
        return abogado;
    }

    public void setAbogado(String abogado) {
        this.abogado = abogado;
    }

    public int getValorAbogado() {
        return valorAbogado;
    }

    public void setValorAbogado(int valorAbogado) {
        this.valorAbogado = valorAbogado;
    }

    public String getMediador() {
        return mediador;
    }

    public void setMediador(String mediador) {
        this.mediador = mediador;
    }

    public int getValorMediador() {
        return valorMediador;
    }

    public void setValorMediador(int valorMediador) {
        this.valorMediador = valorMediador;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public int getValorProtagonista() {
        return valorProtagonista;
    }

    public void setValorProtagonista(int valorProtagonista) {
        this.valorProtagonista = valorProtagonista;
    }

    public String getActivista() {
        return activista;
    }

    public void setActivista(String activista) {
        this.activista = activista;
    }

    public int getValorActivista() {
        return valorActivista;
    }

    public void setValorActivista(int valorActivista) {
        this.valorActivista = valorActivista;
    }

    public String getLogista() {
        return logista;
    }

    public void setLogista(String logista) {
        this.logista = logista;
    }

    public int getValorLogista() {
        return valorLogista;
    }

    public void setValorLogista(int valorLogista) {
        this.valorLogista = valorLogista;
    }

    public String getDefensor() {
        return defensor;
    }

    public void setDefensor(String defensor) {
        this.defensor = defensor;
    }

    public int getValorDefensor() {
        return valorDefensor;
    }

    public void setValorDefensor(int valorDefensor) {
        this.valorDefensor = valorDefensor;
    }

    public String getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(String ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public int getValorEjecutivo() {
        return valorEjecutivo;
    }

    public void setValorEjecutivo(int valorEjecutivo) {
        this.valorEjecutivo = valorEjecutivo;
    }

    public String getConsul() {
        return consul;
    }

    public void setConsul(String conusul) {
        this.consul = conusul;
    }

    public int getValorConsul() {
        return valorConsul;
    }

    public void setValorConsul(int valorConsul) {
        this.valorConsul = valorConsul;
    }

    public String getVirtuoso() {
        return virtuoso;
    }

    public void setVirtuoso(String virtuoso) {
        this.virtuoso = virtuoso;
    }

    public int getValorVirtuoso() {
        return valorVirtuoso;
    }

    public void setValorVirtuoso(int valorVirtuoso) {
        this.valorVirtuoso = valorVirtuoso;
    }

    public String getAventurero() {
        return aventurero;
    }

    public void setAventurero(String aventurero) {
        this.aventurero = aventurero;
    }

    public int getValorAventurero() {
        return valorAventurero;
    }

    public void setValorAventurero(int valorAventurero) {
        this.valorAventurero = valorAventurero;
    }

    public String getEmprendedor() {
        return emprendedor;
    }

    public void setEmprendedor(String emprendedor) {
        this.emprendedor = emprendedor;
    }

    public int getValorEmprendedor() {
        return valorEmprendedor;
    }

    public void setValorEmprendedor(int valorEmprendedor) {
        this.valorEmprendedor = valorEmprendedor;
    }

    public String getAnimador() {
        return animador;
    }

    public void setAnimador(String animador) {
        this.animador = animador;
    }

    public int getValorAnimador() {
        return valorAnimador;
    }

    public void setValorAnimador(int valorAnimador) {
        this.valorAnimador = valorAnimador;
    }


    
    
    
}
