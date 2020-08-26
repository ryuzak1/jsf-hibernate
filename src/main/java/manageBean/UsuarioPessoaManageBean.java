package manageBean;

import dao.DaoGerenic;
import model.UsuarioPessoa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioPessoaManageBean {
    private UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
    private DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<>();

    public UsuarioPessoa getUsuarioPessoa() {
        return usuarioPessoa;
    }

    public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
        this.usuarioPessoa = usuarioPessoa;
    }
}
