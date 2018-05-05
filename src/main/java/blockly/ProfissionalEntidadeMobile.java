package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", execute = "Public")
public class ProfissionalEntidadeMobile {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// ProfissionalEntidade
	public static Var inserirUsuarioProfissional() throws Exception {
		return new Callable<Var>() {

			private Var validaCampos = Var.VAR_NULL;
			private Var telefone = Var.VAR_NULL;
			private Var cpf = Var.VAR_NULL;
			private Var nome = Var.VAR_NULL;
			private Var email = Var.VAR_NULL;
			private Var crm = Var.VAR_NULL;
			private Var numCrm = Var.VAR_NULL;
			private Var dtNasc = Var.VAR_NULL;
			private Var senha = Var.VAR_NULL;
			private Var idUser = Var.VAR_NULL;
			private Var exception = Var.VAR_NULL;

			public Var call() throws Exception {
				if (Var.valueOf(!cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtSenha"))
						.equals(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtConfirma"))))
						.getObjectAsBoolean()) {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("error"), Var.valueOf("A Senha não confere. Tente novamente."));
				} else {
					validaCampos = Var.valueOf("true");
					telefone = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtTelefone"));
					cpf = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCpf"));
					nome = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtNome"));
					email = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtEmail"));
					crm = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCrm"));
					numCrm = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.numCrm"));
					dtNasc = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dtNasc"));
					senha = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtSenha"));
					idUser = cronapi.util.Operations.generateUUID();
				}
				if (cronapi.logic.Operations.isNullOrEmpty(nome).getObjectAsBoolean()) {
					validaCampos = Var.valueOf("false");
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Campo Nome é obrigatório!\n"));
				}
				if (cronapi.logic.Operations.isNullOrEmpty(dtNasc).getObjectAsBoolean()) {
					validaCampos = Var.valueOf("false");
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Campo Data de Nascimento é obrigatório!\n"));
				}
				if (cronapi.logic.Operations.isNullOrEmpty(cpf).getObjectAsBoolean()) {
					validaCampos = Var.valueOf("false");
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Campo CPF é obrigatório!\n"));
				}
				if (cronapi.logic.Operations.isNullOrEmpty(crm).getObjectAsBoolean()) {
					validaCampos = Var.valueOf("false");
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Campo CRM é obrigatório!\n"));
				}
				if (cronapi.logic.Operations.isNullOrEmpty(telefone).getObjectAsBoolean()) {
					validaCampos = Var.valueOf("false");
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Campo Telefone é obrigatório!\n"));
				}
				if (cronapi.logic.Operations.isNullOrEmpty(email).getObjectAsBoolean()) {
					validaCampos = Var.valueOf("false");
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Campo E-mail é obrigatório!\n"));
				}
				if (cronapi.logic.Operations.isNullOrEmpty(numCrm).getObjectAsBoolean()) {
					validaCampos = Var.valueOf("false");
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Campo Número do CRM é obrigatório!\n"));
				}
				if (cronapi.logic.Operations.isNullOrEmpty(senha).getObjectAsBoolean()) {
					validaCampos = Var.valueOf("false");
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Campo Senha é obrigatório!\n"));
				}
				if (Var.valueOf(validaCampos.equals(Var.valueOf("true"))).getObjectAsBoolean()) {
					try {
						cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),
								Var.valueOf("password", senha), Var.valueOf("name", nome), Var.valueOf("id", idUser),
								Var.valueOf("login", email), Var.valueOf("email", email));
						cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),
								Var.valueOf("id", Var.valueOf("Profissional")), Var.valueOf("user", idUser));
						cronapi.database.Operations.insert(Var.valueOf("app.entity.Profissional"),
								Var.valueOf("numCRM", numCrm),
								Var.valueOf("dataAtivacao", cronapi.dateTime.Operations.getNowNoHour()),
								Var.valueOf("ativo", Var.valueOf("Sim")), Var.valueOf("telefone1", telefone),
								Var.valueOf("bloqueado", Var.valueOf("Não")), Var.valueOf("nome", nome),
								Var.valueOf("telefone2", Var.valueOf("  ")), Var.valueOf("cpF", cpf),
								Var.valueOf("dataInclusao", cronapi.dateTime.Operations.getNowNoHour()),
								Var.valueOf("dataNascimento", dtNasc),
								Var.valueOf("sexo",
										cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtSexo"))),
								Var.valueOf("user", idUser), Var.valueOf("crM", crm));
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("success"), Var.valueOf("Cadastro realizado com sucesso"));
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
								Var.valueOf("user.username"), email);
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
								Var.valueOf("user.password"), senha);
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.myfunctions.chamarLogin"),
								Var.valueOf("btnLogin"));
					} catch (Exception exception_exception) {
						exception = Var.valueOf(exception_exception);
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("error"),
								Var.valueOf(Var.valueOf("Erro ao realizar a operação: ").toString()
										+ exception.toString()));
					}
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// Descreva esta função...
	public static Var atualizarProfissional(Var dados) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.update(Var.valueOf("app.entity.Profissional"), dados);
				return dados;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var obterUsuarioLogado() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdProfissionalLogado() throws Exception {
		return new Callable<Var>() {

			private Var consultaProfissional = Var.VAR_NULL;
			private Var profissionalId = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaProfissional = cronapi.database.Operations.query(Var.valueOf("app.entity.Profissional"),
						Var.valueOf("select p from Profissional p where p.user.id = :userId"),
						Var.valueOf("userId", blockly.UsuarioEntidade.retornarIdUsuarioLogado()));
				profissionalId = cronapi.database.Operations.getField(consultaProfissional, Var.valueOf("this[0].id"));
				return profissionalId;
			}
		}.call();
	}

}
