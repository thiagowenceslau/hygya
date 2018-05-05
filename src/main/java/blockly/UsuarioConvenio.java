package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UsuarioConvenio {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Dados
	 * @return Var
	 */
	// Descreva esta função...
	public static Var RetornaEntidadeComEmail(Var Dados) throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var email = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				email = cronapi.object.Operations.getObjectField(Dados, Var.valueOf("login"));
				cronapi.object.Operations.setObjectField(Dados, Var.valueOf("email"), email);
				return Dados;
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
			private Var usuario = Var.VAR_NULL;
			private Var convenioId = Var.VAR_NULL;

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
	 * @param Dados
	 * @return Var
	 */
	// Descreva esta função...
	public static Var inserirRole(Var Dados) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),
						Var.valueOf("id", Var.valueOf("Convenio Operador")), Var.valueOf("user", Dados));
				return Dados;
			}
		}.call();
	}

}
