package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AgenteRegistroConvenio {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// AgenteRegistroConvenio
	public static Var ObterConvenioId(Var dados) throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var usuarioLogado = Var.VAR_NULL;
			private Var convenioId = Var.VAR_NULL;
			private Var nomeConvenio = Var.VAR_NULL;
			private Var cnpjConvenio = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				usuarioLogado = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				convenioId = cronapi.database.Operations.getField(usuarioLogado, Var.valueOf("this[0].convenio.id"));
				nomeConvenio = cronapi.database.Operations.getField(usuarioLogado,
						Var.valueOf("this[0].convenio.nome"));
				cnpjConvenio = cronapi.database.Operations.getField(usuarioLogado,
						Var.valueOf("this[0].convenio.cnPJ"));
				cronapi.object.Operations.setObjectField(dados, Var.valueOf("cnpjSolicitante"), cnpjConvenio);
				cronapi.object.Operations.setObjectField(dados, Var.valueOf("nomeSolicitante"), nomeConvenio);
				cronapi.object.Operations.setObjectField(dados, Var.valueOf("idSolicitante"), convenioId);
				cronapi.object.Operations.setObjectField(dados, Var.valueOf("tipoSolicitante"),
						Var.valueOf("Convenio"));
				cronapi.object.Operations.setObjectField(dados, Var.valueOf("dataSolicitacao"),
						cronapi.dateTime.Operations.getNow());
				cronapi.object.Operations.setObjectField(dados, Var.valueOf("ativo"), Var.valueOf("Esperando"));
				cronapi.object.Operations.setObjectField(dados, Var.valueOf("solicitacaoAtendida"), Var.valueOf("Não"));
				return dados;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var RetornarConvenioLogado() throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var convenioId = Var.VAR_NULL;
			private Var usuario = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				usuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				convenioId = cronapi.database.Operations.getField(usuario, Var.valueOf("this[0].convenio.id"));
				return convenioId;
			}
		}.call();
	}

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// Descreva esta função...
	public static Var inserir(Var dados) throws Exception {
		return new Callable<Var>() {

			private Var user = Var.VAR_NULL;
			private Var consulta = Var.VAR_NULL;
			private Var userId = Var.VAR_NULL;
			private Var consultaTeste = Var.VAR_NULL;
			private Var agenteId = Var.VAR_NULL;

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
				System.out.println(agenteId.getObjectAsString());
				if (Var.valueOf(agenteId.equals(Var.VAR_NULL)).getObjectAsBoolean()) {
					cronapi.database.Operations.insert(Var.valueOf("app.entity.Agente"), dados);
				} else {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"),
							Var.valueOf("Já existe uma solicitação em aberto para esse usuário"));
				}
				return Var.valueOf(listar());
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
						Var.valueOf(true), Var.valueOf("idSolicitante", Var.valueOf(RetornarConvenioLogado())),
						Var.valueOf("ativo", Var.valueOf("Sim")));
				return listaRetorno;
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
