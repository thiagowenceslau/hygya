package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UsuarioEstabelecimento {

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
	 * @param param_user
	 */
	// Descreva esta função...
	public static void excluirRole(Var param_user) throws Exception {
		new Callable<Var>() {

			// param
			private Var user = param_user;
			// end

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Role"),
						Var.valueOf("delete from Role where user = :user"), Var.valueOf("user", user));
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
	public static Var inserirRole(Var dados) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),
						Var.valueOf("id", Var.valueOf("Estabelecimento Operador")), Var.valueOf("user", dados));
				return dados;
			}
		}.call();
	}

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarEstabelecimentoComEmail(Var dados) throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var email = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				email = cronapi.object.Operations.getObjectField(dados, Var.valueOf("login"));
				cronapi.object.Operations.setObjectField(dados, Var.valueOf("email"), email);
				return dados;
			}
		}.call();
	}

}
