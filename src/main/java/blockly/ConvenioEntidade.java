package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ConvenioEntidade {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// ConvenioEntidade
	public static Var InserirUsuario(Var dados) throws Exception {
		return new Callable<Var>() {

			private Var senha = Var.VAR_NULL;
			private Var userId = Var.VAR_NULL;
			private Var nome = Var.VAR_NULL;
			private Var email = Var.VAR_NULL;

			public Var call() throws Exception {
				senha = cronapi.screen.Operations.getValueOfField(Var.valueOf("Convenio.active.user.password"));
				userId = cronapi.util.Operations.generateUUID();
				nome = cronapi.object.Operations.getObjectField(dados, Var.valueOf("nome"));
				email = cronapi.object.Operations.getObjectField(dados, Var.valueOf("email"));
				cronapi.database.Operations.insert(Var.valueOf("app.entity.User"), Var.valueOf("password", senha),
						Var.valueOf("convenio", dados), Var.valueOf("name", nome),
						Var.valueOf("bloqueado", Var.valueOf("Não")), Var.valueOf("id", userId),
						Var.valueOf("login", email), Var.valueOf("email", email));
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),
						Var.valueOf("id", Var.valueOf("Convenio Administrativo")), Var.valueOf("user", userId));
				return dados;
			}
		}.call();
	}

	/**
	 *
	 * @param dados
	 */
	// Descreva esta função...
	public static void remove_usuarios_convenio(Var dados) throws Exception {
		new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.convenio.id = :convenioId"),
						Var.valueOf("convenioId", cronapi.object.Operations.getObjectField(dados, Var.valueOf("id"))));
				while (cronapi.database.Operations.hasElement(consulta).getObjectAsBoolean()) {
					// removendo da regra do usuario
					cronapi.database.Operations.execute(Var.valueOf("app.entity.Role"),
							Var.valueOf("delete from Role where user.id = :id"), Var.valueOf("id",
									cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].id"))));
					cronapi.database.Operations.remove(Var.valueOf("app.entity.User"),
							cronapi.database.Operations.getActiveData(consulta));
					cronapi.database.Operations.next(consulta);
				} // end while
				return Var.VAR_NULL;
			}
		}.call();
	}

}
