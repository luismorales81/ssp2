/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pieroni
 */
@Entity
@Table(name = "mbti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mbti.findAll", query = "SELECT m FROM Mbti m"),
    @NamedQuery(name = "Mbti.findById", query = "SELECT m FROM Mbti m WHERE m.id = :id"),
    @NamedQuery(name = "Mbti.findByCombinacion", query = "SELECT m FROM Mbti m WHERE m.combinacion = :combinacion")})
public class Mbti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "combinacion")
    private String combinacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMbti")
    private Collection<Convocatoriapostulantes> convocatoriapostulantesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMbti")
    private Collection<Competenciambti> competenciambtiCollection;

    public Mbti() {
    }

    public Mbti(Integer id) {
        this.id = id;
    }

    public Mbti(Integer id, String combinacion, String descripcion) {
        this.id = id;
        this.combinacion = combinacion;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCombinacion() {
        return combinacion;
    }

    public void setCombinacion(String combinacion) {
        this.combinacion = combinacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Convocatoriapostulantes> getConvocatoriapostulantesCollection() {
        return convocatoriapostulantesCollection;
    }

    public void setConvocatoriapostulantesCollection(Collection<Convocatoriapostulantes> convocatoriapostulantesCollection) {
        this.convocatoriapostulantesCollection = convocatoriapostulantesCollection;
    }

    @XmlTransient
    public Collection<Competenciambti> getCompetenciambtiCollection() {
        return competenciambtiCollection;
    }

    public void setCompetenciambtiCollection(Collection<Competenciambti> competenciambtiCollection) {
        this.competenciambtiCollection = competenciambtiCollection;
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
        if (!(object instanceof Mbti)) {
            return false;
        }
        Mbti other = (Mbti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Mbti[ id=" + id + " ]";
    }
    
}
