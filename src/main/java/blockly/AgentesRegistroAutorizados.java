package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AgentesRegistroAutorizados {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Dados
	 * @return Var
	 */
	// AgentesRegistroAutorizados
	public static Var retornarCondicao(Var Dados) throws Exception {
		return new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;
			private Var agente = Var.VAR_NULL;
			private Var agenteUserId = Var.VAR_NULL;

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

			private Var consulta = Var.VAR_NULL;
			private Var agenteUserId = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.Agente"),
						Var.valueOf("select a from Agente a where a.id = :id"), Var.valueOf("id", agente));
				agenteUserId = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].user.id"));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Agente"),
						Var.valueOf("update Agente set ativo = :ativo, dataRemocao = :dataRemocao where id = :id"),
						Var.valueOf("ativo", Var.valueOf("Não")),
						Var.valueOf("dataRemocao", cronapi.dateTime.Operations.getNow()), Var.valueOf("id", agente));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.User"),
						Var.valueOf("update User set habilitaAgenteRegistro = :habilitaAgenteRegistro where id = :id"),
						Var.valueOf("habilitaAgenteRegistro", Var.valueOf("Não")), Var.valueOf("id", agenteUserId));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
						Var.valueOf("Agente"), Var.valueOf("true"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Agente Desativado!"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
						Var.valueOf("modalAutorizados"));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
