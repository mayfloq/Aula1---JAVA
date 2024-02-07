package br.edu.infnet.domain.respostas;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Entity
@Table(name = "respostas_criterios", catalog = "sdi_m_2021", schema = "")
@NamedQueries({
    @NamedQuery(name = "RespostasCriterio.findAll", query = "SELECT r FROM RespostasCriterio r"),
    @NamedQuery(name = "RespostasCriterio.findById", query = "SELECT r FROM RespostasCriterio r WHERE r.id = :id"),
    @NamedQuery(name = "RespostasCriterio.findByResposta", query = "SELECT r FROM RespostasCriterio r WHERE r.resposta = :resposta"),
    @NamedQuery(name = "RespostasCriterio.findByIdCriterio", query = "SELECT r FROM RespostasCriterio r WHERE r.idCriterio = :idCriterio")})
public class RespostasCriterio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private int resposta;
    @Basic(optional = false)
    @Column(name = "id_criterio", nullable = false)
    private int idCriterio;
    @JsonIgnore
    @JoinColumn(name = "id_resposta", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Resposta idResposta;

    public RespostasCriterio() {
    }

    public RespostasCriterio(Integer id) {
        this.id = id;
    }

    public RespostasCriterio(Integer id, int resposta, int idCriterio) {
        this.id = id;
        this.resposta = resposta;
        this.idCriterio = idCriterio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Resposta getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Resposta idResposta) {
        this.idResposta = idResposta;
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
        if (!(object instanceof RespostasCriterio)) {
            return false;
        }
        RespostasCriterio other = (RespostasCriterio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.infnet.domain.respostas.RespostasCriterio[ id=" + id + " ]";
    }
    
}
