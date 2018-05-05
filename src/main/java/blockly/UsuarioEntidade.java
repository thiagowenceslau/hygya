package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UsuarioEntidade {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var obterLogin() throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				return login;
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
