package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AcessoExames {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param idAutorizacao
	 * @return Var
	 */
	// AcessoExames
	public static Var recusar(Var idAutorizacao) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.AutorizacaoAcessoExame"),
						Var.valueOf(
								"update AutorizacaoAcessoExame set ativo = :ativo, autorizado = :autorizado, dataAutorizacao = :dataAutorizacao, dataExpiracao = :dataExpiracao, todosExames = :todosExames where id = :id"),
						Var.valueOf("ativo", Var.valueOf("Não")), Var.valueOf("autorizado", Var.valueOf("Recusado")),
						Var.valueOf("dataAutorizacao", cronapi.dateTime.Operations.getNow()),
						Var.valueOf("dataExpiracao", cronapi.dateTime.Operations.getNow()),
						Var.valueOf("todosExames", Var.VAR_FALSE), Var.valueOf("id", idAutorizacao));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @param idDados
	 */
	// Descreva esta função...
	public static void autorizar(Var idDados) throws Exception {
		new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.AutorizacaoAcessoExame"),
						Var.valueOf(
								"update AutorizacaoAcessoExame set ativo = :ativo, autorizado = :autorizado, dataAutorizacao = :dataAutorizacao, dataExpiracao = :dataExpiracao, todosExames = :todosExames where id = :id"),
						Var.valueOf("ativo", Var.valueOf("Sim")), Var.valueOf("autorizado", Var.valueOf("Autorizado")),
						Var.valueOf("dataAutorizacao", cronapi.dateTime.Operations.getNow()),
						Var.valueOf("dataExpiracao",
								cronapi.dateTime.Operations.incDay(cronapi.dateTime.Operations.getNow(),
										Var.valueOf(20))),
						Var.valueOf("todosExames", Var.VAR_TRUE), Var.valueOf("id", idDados));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornaFiltro() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				return Var.valueOf("Aguardando");
			}
		}.call();
	}

}
