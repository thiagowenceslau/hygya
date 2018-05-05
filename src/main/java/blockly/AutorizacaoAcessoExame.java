package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AutorizacaoAcessoExame {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param cpf
	 * @return Var
	 */
	// Descreva esta função...
	public static Var inserir(Var cpf) throws Exception {
		return new Callable<Var>() {

			private Var consultaPaciente = Var.VAR_NULL;
			private Var paciente = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaPaciente = cronapi.database.Operations.query(Var.valueOf("app.entity.Paciente"),
						Var.valueOf("select p from Paciente p where p.cpf = :cpf"), Var.valueOf("cpf", cpf));
				paciente = cronapi.database.Operations.getField(consultaPaciente, Var.valueOf("this[0].id"));
				System.out.println(paciente.getObjectAsString());
				cronapi.database.Operations.insert(Var.valueOf("app.entity.AutorizacaoAcessoExame"),
						Var.valueOf("dataSolicitacao", cronapi.dateTime.Operations.getNow()),
						Var.valueOf("paciente", paciente), Var.valueOf("autorizado", Var.valueOf("Aguardando")),
						Var.valueOf("id", cronapi.util.Operations.generateUUID()),
						Var.valueOf("profissional", Var.valueOf(retornarIdProfissionalLogado())));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var listar() throws Exception {
		return new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.AutorizacaoAcessoExame"),
						Var.valueOf("select a from AutorizacaoAcessoExame a where a.profissional.id = :profissionalId"),
						Var.valueOf("profissionalId", Var.valueOf(retornarIdProfissionalLogado())));
				return consulta;
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

			private Var consultaUsuario = Var.VAR_NULL;
			private Var idUsuario = Var.VAR_NULL;
			private Var consultaProfissional = Var.VAR_NULL;
			private Var idProfissional = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaUsuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.id = :id"),
						Var.valueOf("id", blockly.UsuarioEntidade.retornarIdUsuarioLogado()));
				idUsuario = cronapi.database.Operations.getField(consultaUsuario, Var.valueOf("this[0].id"));
				consultaProfissional = cronapi.database.Operations.query(Var.valueOf("app.entity.Profissional"),
						Var.valueOf("select p from Profissional p where p.user.id = :userId"),
						Var.valueOf("userId", idUsuario));
				idProfissional = cronapi.database.Operations.getField(consultaProfissional, Var.valueOf("this[0].id"));
				return idProfissional;
			}
		}.call();
	}

}
