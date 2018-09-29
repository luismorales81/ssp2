/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Pieroni
 */
@ManagedBean(name = "perfilStep")
@SessionScoped
public class perfilStep {
    private List<Competencia> listaComp;
    private List<Competencia> listaCompAux;
    private Competencia comp;
    private compMbtiVal mbtiVal;
    private Perfil perfil;

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    

    public compMbtiVal getMbtiVal() {
        return mbtiVal;
    }

    public void setMbtiVal(compMbtiVal mbtiVal) {
        this.mbtiVal = mbtiVal;
        
    }
    public void ponerValorNuevo(){
        this.setMbtiVal(new compMbtiVal());
    }
    
    

    public List<Competencia> getListaCompAux() {
        return listaCompAux;
    }

    public void setListaCompAux(List<Competencia> listaCompAux) {
        this.listaCompAux = listaCompAux;
    }
    
    public List<Competencia> getListaComp() {
        return listaComp;
    }

    public void setListaComp(List<Competencia> listaComp) {
        this.listaComp = listaComp;
    }

    public Competencia getComp() {
        return comp;
    }

    public void setComp(Competencia comp) {
        this.comp = comp;
    }
    
    public void añadeComp(Competencia item){
        this.getListaCompAux().add(item);
    }
    
    public void eliminaComp(Competencia item){
        this.getListaCompAux().remove(item);
    }
    
    public void save(){
        
    }
    public String onFlowProcess(FlowEvent event) {
        
            return event.getNewStep();
        
    }
    
    
}
