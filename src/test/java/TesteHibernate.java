import dao.DaoGerenic;
import model.TelefoneUsuarios;
import model.UsuarioPessoa;
import org.junit.Test;

import java.util.List;

public class TesteHibernate {

    @Test
    public void teste() {

        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
        usuarioPessoa.setEmail("J2ose@gmail.com");
        usuarioPessoa.setLogin("Murilo3");
        usuarioPessoa.setNome("Aed");
        usuarioPessoa.setSenha("1234");
        usuarioPessoa.setSobreNome("Murilo2");

        daoGerenic.salvar(usuarioPessoa);

    }

    @Test
    public void testePequisa() {
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
        usuarioPessoa.setId(1L);

        usuarioPessoa = daoGerenic.pesquisar(usuarioPessoa);
        System.out.println(usuarioPessoa.toString());


    }

    @Test
    public void testePequisaComID() {
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();

        UsuarioPessoa usuarioPessoa = daoGerenic.pesquisarComId(3L, UsuarioPessoa.class);
        System.out.println(usuarioPessoa.toString());
    }

    @Test
    public void testeUpdate() {
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();

        UsuarioPessoa usuarioPessoa = daoGerenic.pesquisarComId(3L, UsuarioPessoa.class);

        usuarioPessoa.setSobreNome("casa");
        daoGerenic.updateMerge(usuarioPessoa);

        System.out.println(usuarioPessoa.toString());
    }

    @Test
    public void testeDeletar() {
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();

        UsuarioPessoa usuarioPessoa = daoGerenic.pesquisarComId(3L, UsuarioPessoa.class);
        daoGerenic.deleteID(usuarioPessoa);
    }

    @Test
    public void listarTeste() {
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        List<UsuarioPessoa> usuarioPessoaList = daoGerenic.listar(UsuarioPessoa.class);

        for (UsuarioPessoa a : usuarioPessoaList) {

            System.out.println(a);
            System.out.println("_______________");

        }

    }

    @Test
    public void testeQueryList() {

        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        List<UsuarioPessoa> list = daoGerenic.getEntityManager().createQuery(" from UsuarioPessoa ").getResultList();

        for (UsuarioPessoa a : list) {

            System.out.println(a);
            System.out.println("---------");

        }

    }

    @Test
    public void testeQueryListMaxList() {

        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        List<UsuarioPessoa> list = daoGerenic.getEntityManager().createQuery(" from UsuarioPessoa order by id")
                .setMaxResults(4)
                .getResultList();
        for (UsuarioPessoa a : list) {
            System.out.println(a);
            System.out.println("---------");

        }
    }

    @Test
    public void testeQueryListWithParamter() {
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        List<UsuarioPessoa> list = daoGerenic.getEntityManager().createQuery(" from UsuarioPessoa where nome = :nome or sobrenome = :sobrenome")
                .setParameter("nome", "Robson")
                .setParameter("sobrenome", "Murilo")
                .getResultList();
        for (UsuarioPessoa a : list) {
            System.out.println(a);
            System.out.println("---------");

        }
    }

    @Test
    public void testeNamedQueny1() {
        DaoGerenic<UsuarioPessoa> daoGerenic = new DaoGerenic<UsuarioPessoa>();
        List<UsuarioPessoa> list = daoGerenic.getEntityManager().createNamedQuery("consultar.todos")
                .getResultList();
        for (UsuarioPessoa a : list) {
            System.out.println(a);
            System.out.println("---------");

        }
    }

    @Test
    public void testeCadastrarTelefone(){
        DaoGerenic daoGerenic = new DaoGerenic();

        UsuarioPessoa usuarioPessoa = (UsuarioPessoa) daoGerenic.pesquisarComId(2L, UsuarioPessoa.class);
        TelefoneUsuarios telefoneUsuarios = new TelefoneUsuarios();
        telefoneUsuarios.setNumero("12434532");
        telefoneUsuarios.setTipo("casa2");
        telefoneUsuarios.setUsuarioPessoa(usuarioPessoa);
        daoGerenic.salvar(telefoneUsuarios);

    }

    @Test
    public void testeConsultarTelefone(){
        DaoGerenic daoGerenic = new DaoGerenic();
        UsuarioPessoa usuarioPessoa = (UsuarioPessoa) daoGerenic.pesquisarComId(2L, UsuarioPessoa.class);
        for (TelefoneUsuarios u: usuarioPessoa.getTelefoneUsuariosList()) {
            System.out.println(u.getNumero());
            System.out.println(u.getTipo());
            System.out.println(u.getUsuarioPessoa().getNome());
            System.out.println("-----------");

        }

    }

}
