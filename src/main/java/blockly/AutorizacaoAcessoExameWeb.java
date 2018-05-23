package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AutorizacaoAcessoExameWeb {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param cpf
	 * @return Var
	 */
	// AutorizacaoAcessoExameWeb
	public static Var solicitarAcesso(Var cpf) throws Exception {
		return new Callable<Var>() {

			private Var consultaPaciente = Var.VAR_NULL;
			private Var idPaciente = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaPaciente = cronapi.database.Operations.query(Var.valueOf("app.entity.Paciente"),
						Var.valueOf("select p from Paciente p where p.cpf = :cpf"), Var.valueOf("cpf", cpf));
				idPaciente = cronapi.database.Operations.getField(consultaPaciente, Var.valueOf("this[0].id"));
				cronapi.database.Operations.insert(Var.valueOf("app.entity.AutorizacaoAcessoExame"),
						Var.valueOf("dataSolicitacao", cronapi.dateTime.Operations.getNow()),
						Var.valueOf("paciente", idPaciente), Var.valueOf("autorizado", Var.valueOf("Aguardando")),
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
	public static Var retornarIdProfissionalLogado() throws Exception {
		return new Callable<Var>() {

			private Var usuarioLogado = Var.VAR_NULL;
			private Var idProfissional = Var.VAR_NULL;

			public Var call() throws Exception {
				usuarioLogado = cronapi.database.Operations.query(Var.valueOf("app.entity.Profissional"),
						Var.valueOf("select p from Profissional p where p.user.login = :userLogin"),
						Var.valueOf("userLogin", cronapi.util.Operations.getCurrentUserName()));
				idProfissional = cronapi.database.Operations.getField(usuarioLogado, Var.valueOf("this[0].id"));
				return idProfissional;
			}
		}.call();
	}

}
