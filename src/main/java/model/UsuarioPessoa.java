package model;


import javax.persistence.*;
import java.util.List;

@Entity

public class UsuarioPessoa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sobreNome;
    private String email;
    private String login;
    private String senha;




    public UsuarioPessoa() {
    }
    public UsuarioPessoa(Long id,String nome,String sobreNome,String email,String login,String senha){
        this.id=id;
        this.nome=nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.login=login;
        this.senha = senha;
    }


    //adicionar o recibmento do relacionamento na tabela ligada.... o mappedBy deve conter o nome da variavel que ligas as classses
    @OneToMany(mappedBy = "usuarioPessoa",fetch = FetchType.EAGER)
    private List<TelefoneUsuarios> telefoneUsuariosList;

    public void setTelefoneUsuariosList(List<TelefoneUsuarios> telefoneUsuariosList) {
        this.telefoneUsuariosList = telefoneUsuariosList;
    }

    public List<TelefoneUsuarios> getTelefoneUsuariosList() {
        return telefoneUsuariosList;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return "UsuarioPessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
