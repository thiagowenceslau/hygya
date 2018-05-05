package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AgenteRegistroEstabelecimento {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// UsuarioEstabelecimento
	public static Var RetornarEstabelecimentoLogado() throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var usuario = Var.VAR_NULL;
			private Var estabelecimentoId = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				usuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				estabelecimentoId = cronapi.database.Operations.getField(usuario,
						Var.valueOf("this[0].estabelecimentoDeSaude.id"));
				return estabelecimentoId;
			}
		}.call();
	}

	/**
	 *
	 * @param Dados
	 * @return Var
	 */
	// Descreva esta função...
	public static Var inserir(Var Dados) throws Exception {
		return new Callable<Var>() {

			private Var agenteId = Var.VAR_NULL;
			private Var user = Var.VAR_NULL;
			private Var consulta = Var.VAR_NULL;
			private Var userId = Var.VAR_NULL;
			private Var consultaTeste = Var.VAR_NULL;

			public Var call() throws Exception {
				user = cronapi.screen.Operations.getValueOfField(Var.valueOf("Agente.active.user"));
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u = :u"), Var.valueOf("u", user));
				userId = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].id"));
				consultaTeste = cronapi.database.Operations.query(Var.valueOf("app.entity.Agente"),
						Var.valueOf(
								"select a.id from Agente a where a.user.id LIKE (CONCAT(\'%\', :userId, \'%\')) AND a.solicitacaoAtendida = :solicitacaoAtendida"),
						Var.valueOf("userId", userId), Var.valueOf("solicitacaoAtendida", Var.valueOf("Não")));
				agenteId = cronapi.database.Operations.getField(consultaTeste, Var.valueOf("this[0]"));
				if (Var.valueOf(agenteId.equals(Var.VAR_NULL)).getObjectAsBoolean()) {
					cronapi.database.Operations.insert(Var.valueOf("app.entity.Agente"), Dados);
				} else {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"),
							Var.valueOf("Já existe uma solicitação em aberto para esse usuário"));
				}
				return Dados;
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

			private Var listaRetorno = Var.VAR_NULL;

			public Var call() throws Exception {
				listaRetorno = cronapi.database.Operations.queryPaged(Var.valueOf("app.entity.Agente"),
						Var.valueOf(
								"select a from Agente a where a.idSolicitante = :idSolicitante AND a.ativo <> :ativo"),
						Var.valueOf(true), Var.valueOf("idSolicitante", Var.valueOf(RetornarEstabelecimentoLogado())),
						Var.valueOf("ativo", Var.valueOf("Sim")));
				return listaRetorno;
			}
		}.call();
	}

	/**
	 *
	 * @param Dados
	 * @return Var
	 */
	// Descreva esta função...
	public static Var obterEstabelecimentoId(Var Dados) throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var estabelecimentoId = Var.VAR_NULL;
			private Var usuarioLogado = Var.VAR_NULL;
			private Var nomeEstabelecimento = Var.VAR_NULL;
			private Var cnpjEstabelecimento = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				usuarioLogado = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				estabelecimentoId = cronapi.database.Operations.getField(usuarioLogado,
						Var.valueOf("this[0].estabelecimentoDeSaude.id"));
				nomeEstabelecimento = cronapi.database.Operations.getField(usuarioLogado,
						Var.valueOf("this[0].estabelecimentoDeSaude.nome"));
				cnpjEstabelecimento = cronapi.database.Operations.getField(usuarioLogado,
						Var.valueOf("this[0].estabelecimentoDeSaude.cnPJ"));
				cronapi.object.Operations.setObjectField(Dados, Var.valueOf("cnpjSolicitante"), cnpjEstabelecimento);
				cronapi.object.Operations.setObjectField(Dados, Var.valueOf("nomeSolicitante"), nomeEstabelecimento);
				cronapi.object.Operations.setObjectField(Dados, Var.valueOf("idSolicitante"), estabelecimentoId);
				cronapi.object.Operations.setObjectField(Dados, Var.valueOf("tipoSolicitante"),
						Var.valueOf("Estabelecimento"));
				cronapi.object.Operations.setObjectField(Dados, Var.valueOf("dataSolicitacao"),
						cronapi.dateTime.Operations.getNow());
				cronapi.object.Operations.setObjectField(Dados, Var.valueOf("ativo"), Var.valueOf("Esperando"));
				cronapi.object.Operations.setObjectField(Dados, Var.valueOf("solicitacaoAtendida"), Var.valueOf("Não"));
				return Dados;
			}
		}.call();
	}

	/**
	 *
	 * @param agenteId
	 */
	// Descreva esta função...
	public static void remover(Var agenteId) throws Exception {
		new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Agente"),
						Var.valueOf("delete from Agente where id = :id"), Var.valueOf("id", agenteId));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
