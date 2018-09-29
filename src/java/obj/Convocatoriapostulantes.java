/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pieroni
 */
@Entity
@Table(name = "convocatoriapostulantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convocatoriapostulantes.findAll", query = "SELECT c FROM Convocatoriapostulantes c"),
    @NamedQuery(name = "Convocatoriapostulantes.findById", query = "SELECT c FROM Convocatoriapostulantes c WHERE c.id = :id"),
    @NamedQuery(name = "Convocatoriapostulantes.findByFueSeleccionado", query = "SELECT c FROM Convocatoriapostulantes c WHERE c.fueSeleccionado = :fueSeleccionado"),
    @NamedQuery(name = "Convocatoriapostulantes.findByPresentoDocumentacion", query = "SELECT c FROM Convocatoriapostulantes c WHERE c.presentoDocumentacion = :presentoDocumentacion"),
    @NamedQuery(name = "Convocatoriapostulantes.findByPuntajeTotalObtenido", query = "SELECT c FROM Convocatoriapostulantes c WHERE c.puntajeTotalObtenido = :puntajeTotalObtenido")})
public class Convocatoriapostulantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "fueSeleccionado")
    private String fueSeleccionado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "presentoDocumentacion")
    private String presentoDocumentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntajeTotalObtenido")
    private int puntajeTotalObtenido;
    @JoinColumn(name = "idMbti", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mbti idMbti;
    @JoinColumn(name = "idConvocatoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Convocatoria idConvocatoria;
    @JoinColumn(name = "idPersona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public Convocatoriapostulantes() {
    }

    public Convocatoriapostulantes(Integer id) {
        this.id = id;
    }

    public Convocatoriapostulantes(Integer id, String fueSeleccionado, String presentoDocumentacion, int puntajeTotalObtenido) {
        this.id = id;
        this.fueSeleccionado = fueSeleccionado;
        this.presentoDocumentacion = presentoDocumentacion;
        this.puntajeTotalObtenido = puntajeTotalObtenido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFueSeleccionado() {
        return fueSeleccionado;
    }

    public void setFueSeleccionado(String fueSeleccionado) {
        this.fueSeleccionado = fueSeleccionado;
    }

    public String getPresentoDocumentacion() {
        return presentoDocumentacion;
    }

    public void setPresentoDocumentacion(String presentoDocumentacion) {
        this.presentoDocumentacion = presentoDocumentacion;
    }

    public int getPuntajeTotalObtenido() {
        return puntajeTotalObtenido;
    }

    public void setPuntajeTotalObtenido(int puntajeTotalObtenido) {
        this.puntajeTotalObtenido = puntajeTotalObtenido;
    }

    public Mbti getIdMbti() {
        return idMbti;
    }

    public void setIdMbti(Mbti idMbti) {
        this.idMbti = idMbti;
    }

    public Convocatoria getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(Convocatoria idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convocatoriapostulantes)) {
            return false;
        }
        Convocatoriapostulantes other = (Convocatoriapostulantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Convocatoriapostulantes[ id=" + id + " ]";
    }
    
}
