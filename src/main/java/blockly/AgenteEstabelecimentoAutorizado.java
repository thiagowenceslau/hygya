package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AgenteEstabelecimentoAutorizado {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Dados
	 * @return Var
	 */
	// AgenteEstabelecimentoAutorizado
	public static Var retornarCondicao(Var Dados) throws Exception {
		return new Callable<Var>() {

			private Var consultaAgente = Var.VAR_NULL;
			private Var agente = Var.VAR_NULL;
			private Var agenteUserId = Var.VAR_NULL;
			private Var login = Var.VAR_NULL;
			private Var consulta = Var.VAR_NULL;
			private Var estabelecimentoId = Var.VAR_NULL;

			public Var call() throws Exception {
				return Var.valueOf("Sim");
			}
		}.call();
	}

	/**
	 *
	 * @param agente
	 */
	// Descreva esta função...
	public static void desativarAgente(Var agente) throws Exception {
		new Callable<Var>() {

			private Var consultaAgente = Var.VAR_NULL;
			private Var agenteUserId = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaAgente = cronapi.database.Operations.query(Var.valueOf("app.entity.Agente"),
						Var.valueOf("select a from Agente a where a.id = :id"), Var.valueOf("id", agente));
				agenteUserId = cronapi.database.Operations.getField(consultaAgente, Var.valueOf("this[0].user.id"));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Agente"),
						Var.valueOf("update Agente set ativo = :ativo, dataRemocao = :dataRemocao where id = :id"),
						Var.valueOf("ativo", Var.valueOf("Não")),
						Var.valueOf("dataRemocao", cronapi.dateTime.Operations.getNow()), Var.valueOf("id", agente));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.User"),
						Var.valueOf("update User set habilitaAgenteRegistro = :habilitaAgenteRegistro where id = :id"),
						Var.valueOf("habilitaAgenteRegistro", Var.valueOf("Não")), Var.valueOf("id", agenteUserId));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Agente desativado"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
						Var.valueOf("modalAgenteE"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarEstabelecimentoLogado() throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var consulta = Var.VAR_NULL;
			private Var estabelecimentoId = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				estabelecimentoId = cronapi.database.Operations.getField(consulta,
						Var.valueOf("this[0].estabelecimentoDeSaude.id"));
				return estabelecimentoId;
			}
		}.call();
	}

}
