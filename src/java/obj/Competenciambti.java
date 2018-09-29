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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pieroni
 */
@Entity
@Table(name = "competenciambti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competenciambti.findAll", query = "SELECT c FROM Competenciambti c"),
    @NamedQuery(name = "Competenciambti.findById", query = "SELECT c FROM Competenciambti c WHERE c.id = :id"),
    @NamedQuery(name = "Competenciambti.findByIdPerfComp", query = "SELECT c FROM Competenciambti c WHERE c.idPerfComp = :idPerfComp"),
    @NamedQuery(name = "Competenciambti.findByValor", query = "SELECT c FROM Competenciambti c WHERE c.valor = :valor")})
public class Competenciambti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPerfComp")
    private int idPerfComp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "idMbti", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mbti idMbti;

    public Competenciambti() {
    }

    public Competenciambti(Integer id) {
        this.id = id;
    }

    public Competenciambti(Integer id, int idPerfComp, int valor) {
        this.id = id;
        this.idPerfComp = idPerfComp;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdPerfComp() {
        return idPerfComp;
    }

    public void setIdPerfComp(int idPerfComp) {
        this.idPerfComp = idPerfComp;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Mbti getIdMbti() {
        return idMbti;
    }

    public void setIdMbti(Mbti idMbti) {
        this.idMbti = idMbti;
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
        if (!(object instanceof Competenciambti)) {
            return false;
        }
        Competenciambti other = (Competenciambti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Competenciambti[ id=" + id + " ]";
    }
    
}
