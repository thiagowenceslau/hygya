package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class SolicitacaoAgenteAdmin {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Dados
	 * @return Var
	 */
	// SolicitacaoAgenteAdmin
	public static Var retornarCondicao(Var Dados) throws Exception {
		return new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;
			private Var agente = Var.VAR_NULL;
			private Var agenteUserId = Var.VAR_NULL;

			public Var call() throws Exception {
				return Var.valueOf("Não");
			}
		}.call();
	}

	/**
	 *
	 * @param agente
	 */
	// Descreva esta função...
	public static void ativarAgente(Var agente) throws Exception {
		new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;
			private Var agenteUserId = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.Agente"),
						Var.valueOf("select a from Agente a where a.id = :id"), Var.valueOf("id", agente));
				agenteUserId = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].user.id"));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Agente"),
						Var.valueOf(
								"update Agente set ativo = :ativo, dataAtivacao = :dataAtivacao, solicitacaoAtendida = :solicitacaoAtendida, usuarioAprovador = :usuarioAprovador where id = :id"),
						Var.valueOf("ativo", Var.valueOf("Sim")),
						Var.valueOf("dataAtivacao", cronapi.dateTime.Operations.getNow()),
						Var.valueOf("solicitacaoAtendida", Var.valueOf("Sim")),
						Var.valueOf("usuarioAprovador", Var.valueOf(retornarIdUsuarioLogado())),
						Var.valueOf("id", agente));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.User"),
						Var.valueOf("update User set habilitaAgenteRegistro = :habilitaAgenteRegistro where id = :id"),
						Var.valueOf("habilitaAgenteRegistro", Var.valueOf("Sim")), Var.valueOf("id", agenteUserId));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
						Var.valueOf("Agente"), Var.valueOf("true"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Agente Ativado com Sucesso!"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
						Var.valueOf("modalSolicitar"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param agente
	 */
	// Descreva esta função...
	public static void recusarAgente(Var agente) throws Exception {
		new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Agente"),
						Var.valueOf(
								"update Agente set solicitacaoAtendida = :solicitacaoAtendida, usuarioAprovador = :usuarioAprovador, ativo = :ativo where id = :id"),
						Var.valueOf("solicitacaoAtendida", Var.valueOf("Sim")),
						Var.valueOf("usuarioAprovador", Var.valueOf(retornarIdUsuarioLogado())),
						Var.valueOf("ativo", Var.valueOf("Recusado")), Var.valueOf("id", agente));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
						Var.valueOf("Agente"), Var.valueOf("true"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Solicitação recusada!"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
						Var.valueOf("modalSolicitar"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdUsuarioLogado() throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var usuarioLogado = Var.VAR_NULL;
			private Var usuarioId = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				usuarioLogado = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				usuarioId = cronapi.database.Operations.getField(usuarioLogado, Var.valueOf("this[0].id"));
				return usuarioId;
			}
		}.call();
	}

}
