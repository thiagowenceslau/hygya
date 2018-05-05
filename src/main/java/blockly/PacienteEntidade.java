package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public")
public class PacienteEntidade {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// PacienteEntidade
	public static Var InserirPaciente() throws Exception {
		return new Callable<Var>() {

			private Var validaCampos = Var.VAR_NULL;
			private Var cpf = Var.VAR_NULL;
			private Var senha = Var.VAR_NULL;
			private Var email = Var.VAR_NULL;
			private Var nome = Var.VAR_NULL;
			private Var dt_nascimento = Var.VAR_NULL;
			private Var sexo = Var.VAR_NULL;
			private Var idUser = Var.VAR_NULL;

			public Var call() throws Exception {
				if (Var.valueOf(!cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.senha"))
						.equals(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.confirmar"))))
						.getObjectAsBoolean()) {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("error"), Var.valueOf("A Senha não confere. Tente Novamente!"));
				} else {
					validaCampos = Var.valueOf("true");
					cpf = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.cpf"));
					senha = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.senha"));
					email = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.email"));
					nome = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.nome"));
					dt_nascimento = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dt_nascimento"));
					sexo = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.sexo"));
					idUser = cronapi.util.Operations.generateUUID();
					if (cronapi.logic.Operations.isNullOrEmpty(nome).getObjectAsBoolean()) {
						validaCampos = Var.valueOf("false");
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("warning"), Var.valueOf("Campo Nome é obrigatório!\n"));
					}
					if (cronapi.logic.Operations.isNullOrEmpty(sexo).getObjectAsBoolean()) {
						validaCampos = Var.valueOf("false");
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("warning"), Var.valueOf("Campo Sexo é obrigatório!\n"));
					}
					if (cronapi.logic.Operations.isNullOrEmpty(cpf).getObjectAsBoolean()) {
						validaCampos = Var.valueOf("false");
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("warning"), Var.valueOf("Campo CPF é obrigatório!\n"));
					}
					if (cronapi.logic.Operations.isNullOrEmpty(dt_nascimento).getObjectAsBoolean()) {
						validaCampos = Var.valueOf("false");
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("warning"), Var.valueOf("Campo Data de Nascimento é obrigatório!\n"));
					}
					if (cronapi.logic.Operations.isNullOrEmpty(email).getObjectAsBoolean()) {
						validaCampos = Var.valueOf("false");
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("warning"), Var.valueOf("Campo E-mail é obrigatório!\n"));
					}
					if (cronapi.logic.Operations.isNullOrEmpty(senha).getObjectAsBoolean()) {
						validaCampos = Var.valueOf("false");
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("warning"), Var.valueOf("Campo Senha é obrigatório!\n"));
					}
					if (Var.valueOf(validaCampos.equals(Var.valueOf("true"))).getObjectAsBoolean()) {
						cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),
								Var.valueOf("password", senha), Var.valueOf("name", nome), Var.valueOf("id", idUser),
								Var.valueOf("login", email), Var.valueOf("email", email));
						cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),
								Var.valueOf("id", Var.valueOf("Paciente\n")), Var.valueOf("user", idUser));
						cronapi.database.Operations.insert(Var.valueOf("app.entity.Paciente"),
								Var.valueOf("ativo", Var.valueOf("Não")), Var.valueOf("cpf", cpf),
								Var.valueOf("dataInclusao", cronapi.dateTime.Operations.getNowNoHour()),
								Var.valueOf("nome", nome), Var.valueOf("dataNascimento", dt_nascimento),
								Var.valueOf("sexo", sexo), Var.valueOf("user", idUser));
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("success"), Var.valueOf("Cadastrado com sucesso!"));
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
								Var.valueOf("user.username"), email);
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
								Var.valueOf("user.password"), senha);
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.myfunctions.chamarLogin"),
								Var.valueOf("btnLogin"));
					}
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var obterCpfPaciente() throws Exception {
		return new Callable<Var>() {

			private Var consultaCpf = Var.VAR_NULL;
			private Var cpfPaciente = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaCpf = cronapi.database.Operations.query(Var.valueOf("app.entity.Paciente"),
						Var.valueOf("select p.cpf from Paciente p where p.user.id = :userId"),
						Var.valueOf("userId", blockly.UsuarioEntidade.retornarIdUsuarioLogado()));
				cpfPaciente = cronapi.database.Operations.getField(consultaCpf, Var.valueOf("this[0]"));
				return cpfPaciente;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdPacienteLogado() throws Exception {
		return new Callable<Var>() {

			private Var consultaPaciente = Var.VAR_NULL;
			private Var pacienteId = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaPaciente = cronapi.database.Operations.query(Var.valueOf("app.entity.Paciente"),
						Var.valueOf("select p from Paciente p where p.user.id = :userId"),
						Var.valueOf("userId", blockly.UsuarioEntidade.retornarIdUsuarioLogado()));
				pacienteId = cronapi.database.Operations.getField(consultaPaciente, Var.valueOf("this[0].id"));
				return pacienteId;
			}
		}.call();
	}

}
