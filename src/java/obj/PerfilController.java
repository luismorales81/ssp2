package obj;

import obj.util.JsfUtil;
import obj.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@ManagedBean(name = "perfilController")
@SessionScoped
public class PerfilController implements Serializable {

    @EJB
    private obj.PerfilFacade ejbFacade;
    private List<Perfil> items;
    private Perfil selected;
    private final Date currentDate = new Date();
    private List<Competencia> listaComp;
    private List<Competencia> listaCompAux;
    private Competencia comp;
    private List<Perfilcompetencia> listaPerfComp;
    private Perfilcompetencia perfComp;
    private List<Competenciambti> listaCompMbti;
    private Competenciambti compMbti;
    private Mbti valorMbti;
    private String nombre;
    private compMbtiVal mbtiVal;
    private List<compMbtiVal> arregloMbtiVal;
    private String error;

    public List<compMbtiVal> getArregloMbtiVal() {
        return arregloMbtiVal;
    }

    public void setArregloMbtiVal(List<compMbtiVal> arregloMbtiVal) {
        this.arregloMbtiVal = arregloMbtiVal;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public compMbtiVal getMbtiVal() {
        return mbtiVal;
    }

    public void setMbtiVal(compMbtiVal mbtiVal) {
        this.mbtiVal = mbtiVal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Competencia> getListaCompAux() {
        return listaCompAux;
    }

    public void setListaCompAux(List<Competencia> listaCompAux) {
        this.listaCompAux = listaCompAux;
    }

    public Competencia getComp() {
        return comp;
    }

    public void setComp(Competencia comp) {
        this.comp = comp;
    }

    public List<Perfilcompetencia> getListaPerfComp() {
        return listaPerfComp;
    }

    public void setListaPerfComp(List<Perfilcompetencia> listaPerfComp) {
        this.listaPerfComp = listaPerfComp;
    }

    public Perfilcompetencia getPerfComp() {
        return perfComp;
    }

    public void setPerfComp(Perfilcompetencia perfComp) {
        this.perfComp = perfComp;
    }

    public List<Competenciambti> getListaCompMbti() {
        return listaCompMbti;
    }

    public void setListaCompMbti(List<Competenciambti> listaCompMbti) {
        this.listaCompMbti = listaCompMbti;
    }

    public Competenciambti getCompMbti() {
        return compMbti;
    }

    public void setCompMbti(Competenciambti compMbti) {
        this.compMbti = compMbti;
    }

    public Mbti getValorMbti() {
        return valorMbti;
    }

    public void setValorMbti(Mbti valorMbti) {
        this.valorMbti = valorMbti;
    }

    public PerfilFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(PerfilFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Competencia> getListaComp() {
        return listaComp;
    }

    public void setListaComp(List<Competencia> listaComp) {
        this.listaComp = listaComp;
    }

    public PerfilController() {
    }

    public Perfil getSelected() {
        return selected;
    }

    public void setSelected(Perfil selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PerfilFacade getFacade() {
        return ejbFacade;
    }

    public Perfil prepareCreate() {

        java.util.Date lda_fecha = null;
        java.util.Calendar fecha = java.util.Calendar.getInstance();
        lda_fecha = new java.sql.Date(fecha.getTimeInMillis());

        selected = new Perfil();
        selected.setFecha(lda_fecha);
        selected.setEstado(true);
        this.setListaComp(new ArrayList<Competencia>());
        this.setListaCompAux(new ArrayList<Competencia>());
        initializeEmbeddableKey();
        this.setValorMbti(new Mbti());
        this.setMbtiVal(new compMbtiVal());
        this.setError("");
        return selected;

    }

    public void grabarMbtiVal() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean check = false;
        //verificamos que todos tengan valores validos
        int numEntero = Integer.parseInt(this.getMbtiVal().getAbogado());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Abogado");
            //context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Abogado", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getActivista());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Activista");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Activista", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getAnimador());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Animador");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Animador", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getArquitecto());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Arquitecto");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Arquitecto", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getAventurero());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Aventurero");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Aventurro", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getComandante());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Comandante");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Comandante", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getConsul());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Consul");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Consul", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getDefensor());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Defensor");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Defensor", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getEjecutivo());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Ejecutivo");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Ejecutivo", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getEmprendedor());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Emprendedor");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Emprendedor", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getInnovador());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Innovador");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Innovador", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getLogico());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Logico");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Logico", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getLogista());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Logista");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Logista", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getMediador());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Mediador");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Mediador", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getProtagonista());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Protagonista");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Protagonista", ""));
            check = true;
        }

        numEntero = Integer.parseInt(this.getMbtiVal().getVirtuoso());
        if ((numEntero < 0) || (numEntero > 100)) {
            this.setError("Valor Erroneo Virtuoso");
//            context.addMessage("mensajesid", new FacesMessage(FacesMessage.SEVERITY_INFO, "Valor Erroneo Virtuoso", ""));
            check = true;
        }
        RequestContext rc = RequestContext.getCurrentInstance();

        //this.getMbtiVal().getCompSeleccionada().setCkeck(true);
        //verifica si hubo errores
//        if (check) {
//            this.setError("Los valores ingresados no son correctos");
//            rc.execute("PF('PerfilCompetenciaMbtiCreateForm').update()");
//        } else {
        rc.execute("PF('PerfilCompetenciaMbtiCreateDialog').hide()");
        //}

    }

    public void ponerValorNuevo(Competencia c) {
        //verificar que se halla guardado lo que tenia en el arreglo anteriormente
        
        this.setMbtiVal(new compMbtiVal());
        this.getMbtiVal().setCompSeleccionada(c);
    }

    public void añadeComp(Competencia item) {
        this.getListaCompAux().add(item);
    }

    public void eliminaComp(Competencia item) {
        this.getListaCompAux().remove(item);
    }

    public void prepareCreateComp(Competencia c) {
        this.setPerfComp(new Perfilcompetencia());
        this.getPerfComp().setIdPerfil(selected);
        //this.getPerfComp().
    }

    public void setearMbti(Mbti m) {
        this.setValorMbti(m);
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PerfilCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PerfilUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PerfilDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Perfil> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Perfil> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Perfil> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public String onFlowProcess(FlowEvent event) {
        System.out.println("Flow Event Happened :: New Step :: " + event.getNewStep() + " :: Old Step :: " + event.getOldStep());
        return event.getNewStep();

    }

    @FacesConverter(forClass = Perfil.class)
    public static class PerfilControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PerfilController controller = (PerfilController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "perfilController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Perfil) {
                Perfil o = (Perfil) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Perfil.class.getName()});
                return null;
            }
        }

    }

}
