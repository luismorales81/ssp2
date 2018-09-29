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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pieroni
 */
@Entity
@Table(name = "perfilcompetencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfilcompetencia.findAll", query = "SELECT p FROM Perfilcompetencia p"),
    @NamedQuery(name = "Perfilcompetencia.findById", query = "SELECT p FROM Perfilcompetencia p WHERE p.id = :id")})
public class Perfilcompetencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idCompeten  cia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Competencia idCompetencia;
    @JoinColumn(name = "idPerfil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Perfil idPerfil;

    public Perfilcompetencia() {
    }

    public Perfilcompetencia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
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
        if (!(object instanceof Perfilcompetencia)) {
            return false;
        }
        Perfilcompetencia other = (Perfilcompetencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Perfilcompetencia[ id=" + id + " ]";
    }
    
}
