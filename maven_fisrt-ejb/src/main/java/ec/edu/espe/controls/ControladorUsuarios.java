/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.controls;
import ec.edu.espe.entities.Usuario;
import ec.edu.espe.entities.facade.UsuarioFacade;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author homer
 */
@ManagedBean
@ViewScoped
public class ControladorUsuarios implements Serializable{
    @EJB
    private UsuarioFacade serUsu;
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public ControladorUsuarios() {
        usuario=new Usuario();
        usuarios=new ArrayList<Usuario>();
    }
    @PostConstruct
    public void cargarDatos() {
        usuarios = serUsu.findAll();
    }
    public void limpiar() {
        usuario = new Usuario();
    }
    public void actualizarUsuario() {
        serUsu.edit(usuario);
        limpiar();
    }
    public void eliminarUsuario() {
        try {
            serUsu.remove(usuario);
            this.usuarios = serUsu.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Eliminado", ""));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        limpiar();

    }
    public void valueChangeMethod(ValueChangeEvent e) {

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usu = usuarios.get(i);
            if (usu.getCodigo()== e.getNewValue().toString()) {
                usuario = usu;
                
            }
        }

    }
    public void ingresarUsuario() {
        try {
            //usuario.setOpcionesList(new ArrayList<>());
            
            serUsu.create(usuario);
            this.usuarios = serUsu.findAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Ingresada", ""));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
        limpiar();
    }
    public String hashMD5(String pwd) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.out.println("Error: MD5");
        }
        return null;
    }

    public UsuarioFacade getSerUsu() {
        return serUsu;
    }

    public void setSerUsu(UsuarioFacade serUsu) {
        this.serUsu = serUsu;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
