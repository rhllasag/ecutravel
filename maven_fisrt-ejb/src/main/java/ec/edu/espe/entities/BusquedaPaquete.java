/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author homer
 */
@Entity
@Table(name = "busqueda_paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusquedaPaquete.findAll", query = "SELECT b FROM BusquedaPaquete b"),
    @NamedQuery(name = "BusquedaPaquete.findByCodigo", query = "SELECT b FROM BusquedaPaquete b WHERE b.codigo = :codigo"),
    @NamedQuery(name = "BusquedaPaquete.findByTipoBusqueda", query = "SELECT b FROM BusquedaPaquete b WHERE b.tipoBusqueda = :tipoBusqueda"),
    @NamedQuery(name = "BusquedaPaquete.findByOrigen", query = "SELECT b FROM BusquedaPaquete b WHERE b.origen = :origen"),
    @NamedQuery(name = "BusquedaPaquete.findByDestino", query = "SELECT b FROM BusquedaPaquete b WHERE b.destino = :destino"),
    @NamedQuery(name = "BusquedaPaquete.findByFechaInicio", query = "SELECT b FROM BusquedaPaquete b WHERE b.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "BusquedaPaquete.findByFechaFin", query = "SELECT b FROM BusquedaPaquete b WHERE b.fechaFin = :fechaFin"),
    @NamedQuery(name = "BusquedaPaquete.findByHabitacion", query = "SELECT b FROM BusquedaPaquete b WHERE b.habitacion = :habitacion"),
    @NamedQuery(name = "BusquedaPaquete.findByAdultos", query = "SELECT b FROM BusquedaPaquete b WHERE b.adultos = :adultos"),
    @NamedQuery(name = "BusquedaPaquete.findByMenores", query = "SELECT b FROM BusquedaPaquete b WHERE b.menores = :menores")})
public class BusquedaPaquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "TIPO_BUSQUEDA")
    private Integer tipoBusqueda;
    @Size(max = 50)
    @Column(name = "ORIGEN")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESTINO")
    private String destino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HABITACION")
    private int habitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADULTOS")
    private int adultos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MENORES")
    private int menores;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public BusquedaPaquete() {
    }

    public BusquedaPaquete(String codigo) {
        this.codigo = codigo;
    }

    public BusquedaPaquete(String codigo, String destino, Date fechaInicio, Date fechaFin, int habitacion, int adultos, int menores) {
        this.codigo = codigo;
        this.destino = destino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.habitacion = habitacion;
        this.adultos = adultos;
        this.menores = menores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(Integer tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public int getAdultos() {
        return adultos;
    }

    public void setAdultos(int adultos) {
        this.adultos = adultos;
    }

    public int getMenores() {
        return menores;
    }

    public void setMenores(int menores) {
        this.menores = menores;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusquedaPaquete)) {
            return false;
        }
        BusquedaPaquete other = (BusquedaPaquete) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.entities.BusquedaPaquete[ codigo=" + codigo + " ]";
    }
    
}
