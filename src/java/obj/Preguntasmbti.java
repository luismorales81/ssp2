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
import javax.persistence.Lob;
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
@Table(name = "preguntasmbti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntasmbti.findAll", query = "SELECT p FROM Preguntasmbti p"),
    @NamedQuery(name = "Preguntasmbti.findById", query = "SELECT p FROM Preguntasmbti p WHERE p.id = :id")})
public class Preguntasmbti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "reaccionEsperada")
    private String reaccionEsperada;
    @JoinColumn(name = "idCompetencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Competencia idCompetencia;

    public Preguntasmbti() {
    }

    public Preguntasmbti(Integer id) {
        this.id = id;
    }

    public Preguntasmbti(Integer id, String descripcion, String reaccionEsperada) {
        this.id = id;
        this.descripcion = descripcion;
        this.reaccionEsperada = reaccionEsperada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReaccionEsperada() {
        return reaccionEsperada;
    }

    public void setReaccionEsperada(String reaccionEsperada) {
        this.reaccionEsperada = reaccionEsperada;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
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
        if (!(object instanceof Preguntasmbti)) {
            return false;
        }
        Preguntasmbti other = (Preguntasmbti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "obj.Preguntasmbti[ id=" + id + " ]";
    }
    
}
