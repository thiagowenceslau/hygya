package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class DesativarAgente {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// DesativarAgente
	public static Var desativarAgenteRegistro(Var dados) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Agente"),
						Var.valueOf("update Agente set ativo = :ativo, dataRemocao = :dataRemocao where id = :id"),
						Var.valueOf("ativo", Var.valueOf("Não")),
						Var.valueOf("dataRemocao", cronapi.dateTime.Operations.getNow()), Var.valueOf("id", dados));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.User"),
						Var.valueOf("update User set habilitaAgenteRegistro = :habilitaAgenteRegistro where id = :id"),
						Var.valueOf("habilitaAgenteRegistro", Var.valueOf("Não")),
						Var.valueOf("id", Var.valueOf(retornarUserId(dados))));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
						Var.valueOf("Agente"), Var.valueOf("true"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Agente Desativado"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
						Var.valueOf("modalAgente"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param dados
	 */
	// Descreva esta função...
	public static void ativarAgenteRegistro(Var dados) throws Exception {
		new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Agente"),
						Var.valueOf(
								"update Agente set ativo = :ativo, solicitacaoAtendida = :solicitacaoAtendida, usuarioAprovador = :usuarioAprovador, dataAtivacao = :dataAtivacao where id = :id"),
						Var.valueOf("ativo", Var.valueOf("Sim")),
						Var.valueOf("solicitacaoAtendida", Var.valueOf("Sim")),
						Var.valueOf("usuarioAprovador", blockly.UsuarioEntidade.retornarIdUsuarioLogado()),
						Var.valueOf("dataAtivacao", cronapi.dateTime.Operations.getNow()), Var.valueOf("id", dados));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.User"),
						Var.valueOf("update User set habilitaAgenteRegistro = :habilitaAgenteRegistro where id = :id"),
						Var.valueOf("habilitaAgenteRegistro", Var.valueOf("Sim")),
						Var.valueOf("id", Var.valueOf(retornarUserId(dados))));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
						Var.valueOf("Agente"), Var.valueOf("true"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Agente Ativado"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
						Var.valueOf("modalAgente"));
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
	public static Var retornarUserId(Var dados) throws Exception {
		return new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;
			private Var userId = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.Agente"),
						Var.valueOf("select a from Agente a where a.id = :id"), Var.valueOf("id", dados));
				userId = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].user.id"));
				return userId;
			}
		}.call();
	}

}
