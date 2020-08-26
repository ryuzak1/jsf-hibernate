package model;

import javax.persistence.*;

@Entity
public class TelefoneUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String numero;

    //Muitos telefones para uma pessoa... segue a ordem..
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private UsuarioPessoa usuarioPessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public UsuarioPessoa getUsuarioPessoa() {
        return usuarioPessoa;
    }

    public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
        this.usuarioPessoa = usuarioPessoa;
    }
}
